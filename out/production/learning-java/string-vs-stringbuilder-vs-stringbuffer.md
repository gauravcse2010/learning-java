# String vs StringBuilder vs StringBuffer

## Overview

Java provides three commonly used classes for handling text data:

| Class | Mutable | Thread Safe | Performance |
|---------|----------|-------------|-------------|
| String | No | Yes | Slowest for modifications |
| StringBuilder | Yes | No | Fastest |
| StringBuffer | Yes | Yes | Slower than StringBuilder |

---

# String

## What is String?

A String is an immutable sequence of characters.

Once created, its content cannot be modified.

Example:

```java
String name = "Java";

name.concat(" 21");

System.out.println(name);
```

Output:

```text
Java
```

The original String remains unchanged.

---

## How Modification Works

```java
String name = "Java";

name = name.concat(" 21");

System.out.println(name);
```

Output:

```text
Java 21
```

A new String object is created.

---

# StringBuilder

## What is StringBuilder?

A mutable sequence of characters.

Modifications occur on the same object.

Introduced in:

```text
Java 5
```

---

## Example

```java
StringBuilder sb =
        new StringBuilder("Java");

sb.append(" 21");

System.out.println(sb);
```

Output:

```text
Java 21
```

No new object is created.

---

## Characteristics

- Mutable
- Not Thread Safe
- Fastest for modifications
- Preferred in single-threaded environments

---

# StringBuffer

## What is StringBuffer?

A mutable sequence of characters.

Similar to StringBuilder but thread-safe.

---

## Example

```java
StringBuffer sb =
        new StringBuffer("Java");

sb.append(" 21");

System.out.println(sb);
```

Output:

```text
Java 21
```

---

## Characteristics

- Mutable
- Thread Safe
- Methods are synchronized
- Slower than StringBuilder

---

# Memory Behavior

## String

```java
String str = "Java";

str = str.concat(" 21");
```

Memory:

```text
Object 1 -> "Java"

Object 2 -> "Java 21"
```

New object created.

---

## StringBuilder

```java
StringBuilder sb =
        new StringBuilder("Java");

sb.append(" 21");
```

Memory:

```text
Same object modified
```

No new object created.

---

## StringBuffer

```java
StringBuffer sb =
        new StringBuffer("Java");

sb.append(" 21");
```

Memory:

```text
Same object modified
```

No new object created.

---

# How to Verify Mutability

## String

```java
String str = "Java";

System.out.println(
        System.identityHashCode(str));

str = str.concat(" 21");

System.out.println(
        System.identityHashCode(str));
```

Output:

```text
Different values
```

Different objects are created.

---

## StringBuilder

```java
StringBuilder sb =
        new StringBuilder("Java");

System.out.println(
        System.identityHashCode(sb));

        sb.append(" 21");

System.out.println(
        System.identityHashCode(sb));
```

Output:

```text
Same value
```

Same object is modified.

---

## StringBuffer

```java
StringBuffer sb =
        new StringBuffer("Java");

System.out.println(
        System.identityHashCode(sb));

        sb.append(" 21");

System.out.println(
        System.identityHashCode(sb));
```

Output:

```text
Same value
```

Same object is modified.

---

# Production Usage

## String

Used for:

- Configuration values
- URLs
- User names
- Database connection strings
- API paths

Example:

```java
String datasourceUrl;
```

---

## StringBuilder

Used for:

- Log message generation
- Report generation
- JSON construction
- Dynamic SQL generation

Example:

```java
StringBuilder query =
        new StringBuilder();
```

---

## StringBuffer

Used rarely today.

Primarily in:

- Legacy codebases
- Multi-threaded text manipulation

---

# Spring Framework Usage

## String

Used extensively:

```java
@Value("${spring.datasource.url}")
private String url;
```

---

## StringBuilder

Common in:

```java
Custom log messages
SQL builders
Batch reports
```

Example:

```java
StringBuilder log =
        new StringBuilder();
```

---

## StringBuffer

Rarely used in modern Spring applications.

Most applications prefer:

```text
StringBuilder
```

and handle synchronization separately.

---

# Performance Example

## Using String

```java
String str = "";

for(int i = 0; i < 10000; i++) {
str += i;
}
```

Very slow.

Creates thousands of String objects.

---

## Using StringBuilder

```java
StringBuilder sb =
        new StringBuilder();

for(int i = 0; i < 10000; i++) {
        sb.append(i);
}
```

Fast.

Uses a single object.

---

# Differences

| Feature | String | StringBuilder | StringBuffer |
|----------|----------|----------|----------|
| Mutable | No | Yes | Yes |
| Thread Safe | Yes | No | Yes |
| Performance | Slow | Fastest | Medium |
| Synchronization | N/A | No | Yes |
| Memory Efficient | No | Yes | Yes |
| Introduced | Java 1.0 | Java 5 | Java 1.0 |

---

# Interview Questions

## Q1. Difference between String and StringBuilder?

String is immutable.

StringBuilder is mutable.

---

## Q2. Difference between StringBuilder and StringBuffer?

StringBuilder is not synchronized.

StringBuffer is synchronized.

---

## Q3. Which is faster?

```text
StringBuilder
```

because synchronization is absent.

---

## Q4. Why is String immutable?

- Security
- Thread Safety
- String Pool Optimization
- Stable Hash Codes

---

## Q5. Which should be used in loops?

```text
StringBuilder
```

---

## Q6. Which one is thread safe?

```text
StringBuffer
```

---

# Quick Revision (30 Seconds)

| Class | Mutable | Thread Safe |
|---------|----------|-------------|
| String | No | Yes         |
| StringBuilder | Yes | No          |
| StringBuffer | Yes | Yes         |

Remember:

- String → Immutable
- StringBuilder → Mutable + Fastest
- StringBuffer → Mutable + Thread Safe