# StringBuilder vs StringBuffer Thread Safety Demo

## Objective

This demo demonstrates why:

- `StringBuilder` is **not thread-safe**
- `StringBuffer` is **thread-safe**

Both classes are mutable, but only `StringBuffer` synchronizes its methods.

---

# Problem Statement

We have:

- 2 threads
- Each thread appends `"A"` 100,000 times

Expected result:

```text
2 × 100000 = 200000
```

The final length should be:

```text
200000
```

---

# StringBuilder Example

## Code

```java
public class StringBuilderThreadSafetyDemo {

    private static final int ITERATIONS = 100_000;

    public static void main(String[] args)
            throws InterruptedException {

        StringBuilder sb = new StringBuilder();

        Runnable task = () -> {
            for (int i = 0; i < ITERATIONS; i++) {
                sb.append("A");
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
                "Length = " + sb.length());
    }
}
```

---

## Expected Output

```text
Length = 200000
```

---

## Actual Output (Typical)

```text
Length = 187654
```

or

```text
Length = 193421
```

or

```text
Length = 198765
```

The value changes between executions.

Sometimes you may even encounter exceptions if the internal character array becomes corrupted under heavy contention.

---

# Why Does StringBuilder Fail?

`StringBuilder` does not synchronize its methods.

Internally:

```java
sb.append("A");
```

is executed concurrently by both threads.

Example:

Current length:

```text
100
```

Thread 1:

```text
Reads length = 100
```

Thread 2:

```text
Reads length = 100
```

Both attempt to write at index:

```text
100
```

This leads to:

- Lost updates
- Data corruption
- Race conditions

---

# Race Condition

A race condition occurs when:

Multiple threads read and modify shared data simultaneously and the final result depends on thread execution order.

Example:

```text
Thread 1 -> Read length = 100

Thread 2 -> Read length = 100

Thread 1 -> Write at index 100

Thread 2 -> Write at index 100
```

One update overwrites the other.

---

# StringBuffer Example

## Code

```java
public class StringBufferThreadSafetyDemo {

    private static final int ITERATIONS = 100_000;

    public static void main(String[] args)
            throws InterruptedException {

        StringBuffer sb = new StringBuffer();

        Runnable task = () -> {
            for (int i = 0; i < ITERATIONS; i++) {
                sb.append("A");
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
                "Length = " + sb.length());
    }
}
```

---

## Output

```text
Length = 200000
```

Every execution should produce:

```text
200000
```

---

# Why Does StringBuffer Work?

Most methods are synchronized.

Example:

```java
public synchronized StringBuffer append(String str)
```

Only one thread can execute the method at a time.

Execution becomes:

```text
Thread 1 enters append()

Thread 2 waits

Thread 1 exits append()

Thread 2 enters append()
```

This prevents race conditions.

---

# Internal View

## StringBuilder

```text
Thread 1 ---> append()
Thread 2 ---> append()

Both execute simultaneously
```

Result:

```text
Unsafe
```

---

## StringBuffer

```text
Thread 1 ---> append()

Thread 2 ---> WAIT

Thread 1 completes

Thread 2 enters append()
```

Result:

```text
Safe
```

---

# Performance Trade-Off

| Class | Thread Safe | Performance |
|---------|----------|----------|
| StringBuilder | No | Fastest |
| StringBuffer | Yes | Slower |

Reason:

```text
Synchronization introduces locking overhead.
```

---

# Real-World Usage

## StringBuilder

Used in:

- REST APIs
- Spring Boot Services
- Report Generation
- SQL Construction
- JSON Construction

Example:

```java
public String buildResponse() {

    StringBuilder sb = new StringBuilder();

    sb.append("OrderId=");
    sb.append(orderId);

    return sb.toString();
}
```

Safe because each request gets its own object.

---

## StringBuffer

Used in:

- Legacy applications
- Shared mutable string state
- Rare multi-threaded text manipulation

Modern applications generally avoid sharing mutable objects across threads.

---

# Spring Framework Usage

Most Spring applications prefer:

```java
StringBuilder
```

because:

- Objects are method-local
- Requests are isolated
- Shared mutable state is discouraged

Example:

```java
@Service
public class OrderService {

    public String generateMessage(Long orderId) {

        StringBuilder sb =
                new StringBuilder();

        sb.append("Order ");
        sb.append(orderId);

        return sb.toString();
    }
}
```

---

# Interview Questions

## Q1. Is StringBuilder thread-safe?

No.

---

## Q2. Is StringBuffer thread-safe?

Yes.

Methods are synchronized.

---

## Q3. Why is StringBuilder faster?

No synchronization overhead.

---

## Q4. What problem occurs with StringBuilder in multithreading?

Race Conditions.

---

## Q5. Which one should be used in Spring Boot applications?

Usually:

```text
StringBuilder
```

because objects are typically method-local.

---

## Q6. Can StringBuilder produce incorrect results?

Yes.

When multiple threads modify the same instance concurrently.

---

# Quick Revision (30 Seconds)

```text
StringBuilder
    Mutable
    Fastest
    Not Thread Safe

StringBuffer
    Mutable
    Thread Safe
    Slower
```

### Remember

- Shared object + multiple threads + StringBuilder = Race Condition
- Shared object + multiple threads + StringBuffer = Safe
- Modern applications typically use StringBuilder and avoid shared mutable state