# String.join() vs String.repeat()

## Overview

Both `String.join()` and `String.repeat()` are utility methods provided by the `String` class.

| Method | Purpose |
|----------|----------|
| String.join() | Combines multiple strings using a delimiter |
| String.repeat() | Repeats the same string multiple times |

---

# String.join()

## Purpose

Used to combine multiple strings into a single string using a specified delimiter.

## Java Version

```text
Java 8
```

## Syntax

```java
String.join(CharSequence delimiter, CharSequence... elements)
```

## Example

```java
String result =
        String.join(", ",
                "Java",
                "Spring",
                "Hibernate");

System.out.println(result);
```

Output:

```text
Java, Spring, Hibernate
```

---

## Common Use Cases

### Creating CSV Data

```java
String csv =
        String.join(",",
                "101",
                "John",
                "Developer");

System.out.println(csv);
```

Output:

```text
101,John,Developer
```

### Building URL Paths

```java
String path =
        String.join("/",
                "api",
                "users",
                "101");

System.out.println(path);
```

Output:

```text
api/users/101
```

---

# Production Usage

## CSV Export

Many enterprise applications provide downloadable reports:

- Employee Reports
- Order Reports
- Transaction Reports
- Customer Reports

Example:

```java
public String convertToCsv(Employee employee) {

    return String.join(",",
            employee.getId().toString(),
            employee.getName(),
            employee.getDepartment());
}
```

Output:

```text
101,John,Engineering
```

---

## Log Message Construction

Without join:

```java
log.info(userId + "," + requestId + "," + status);
```

With join:

```java
String message =
        String.join(",",
                userId,
                requestId,
                status);

log.info(message);
```

Output:

```text
U101,R456,SUCCESS
```

---

## File Path Generation

```java
String path =
        String.join("/",
                "documents",
                "users",
                userId,
                "resume.pdf");
```

Output:

```text
documents/users/101/resume.pdf
```

---

## Dynamic SQL Construction

```java
List<String> columns =
        List.of("id", "name", "salary");

String selectColumns =
        String.join(", ", columns);

String sql =
        "SELECT " + selectColumns +
        " FROM employee";
```

Output:

```sql
SELECT id, name, salary FROM employee
```

---

## REST API Endpoint Construction

```java
String endpoint =
        String.join("/",
                "api",
                "v1",
                "users",
                userId);
```

Output:

```text
api/v1/users/101
```

---

# Spring Framework Usage

Although Spring itself rarely calls `String.join()` directly in user-facing APIs, developers frequently use it for:

- Building REST endpoints
- Constructing log messages
- Generating file paths
- Creating CSV exports
- Building dynamic request parameters

Example:

```java
String endpoint =
        String.join("/",
                "api",
                "v1",
                "orders",
                orderId);
```

Used with:

```java
RestTemplate
WebClient
Feign Client
```

---

# String.repeat()

## Purpose

Used to repeat the same string multiple times.

## Java Version

```text
Java 11
```

## Syntax

```java
String repeat(int count)
```

## Example

```java
String stars = "*".repeat(5);

System.out.println(stars);
```

Output:

```text
*****
```

---

## Common Use Cases

### Separator Generation

```java
String separator =
        "-".repeat(50);

System.out.println(separator);
```

Output:

```text
--------------------------------------------------
```

---

### Padding

```java
String padded =
        "0".repeat(4) + "123";

System.out.println(padded);
```

Output:

```text
0000123
```

---

# Production Usage

## Credit Card Masking

```java
String cardNumber =
        "1234567812345678";

String masked =
        "*".repeat(12)
        + cardNumber.substring(12);

System.out.println(masked);
```

Output:

```text
************5678
```

---

## Password Masking

```java
String password = "springboot";

String hidden =
        "*".repeat(password.length());

System.out.println(hidden);
```

Output:

```text
**********
```

---

## Batch Job Report Formatting

```java
System.out.println("=".repeat(50));
System.out.println("Employee Report");
System.out.println("=".repeat(50));
```

Output:

```text
==================================================
Employee Report
==================================================
```

---

## Test Data Generation

```java
String largePayload =
        "A".repeat(10000);
```

Useful for:

- Performance Testing
- Load Testing
- API Stress Testing

---

# Spring Framework Usage

Commonly used in:

- Spring Batch reports
- Log formatting
- Debug output
- Test utilities
- Mock data generation

Example:

```java
log.info("-".repeat(80));
log.info("Order Processed");
log.info("-".repeat(80));
```

---

# Differences

| Feature | String.join() | String.repeat() |
|----------|----------|----------|
| Purpose | Combine strings | Repeat string |
| Java Version | Java 8 | Java 11 |
| Input | Delimiter + Multiple Strings | Count |
| Output | Joined String | Repeated String |
| Typical Usage | CSV, Paths, Logs | Masking, Formatting, Testing |

---

# Interview Questions

## Q1. What is String.join()?

Used to combine multiple strings using a delimiter.

Example:

```java
String.join(",", "A", "B", "C");
```

Output:

```text
A,B,C
```

---

## Q2. What is String.repeat()?

Used to repeat the same string multiple times.

Example:

```java
"A".repeat(5);
```

Output:

```text
AAAAA
```

---

## Q3. Which Java version introduced String.join()?

```text
Java 8
```

---

## Q4. Which Java version introduced String.repeat()?

```text
Java 11
```

---

## Q5. Have you used these methods in production?

Yes.

### String.join()

- CSV exports
- REST endpoints
- Log messages
- File paths

### String.repeat()

- Sensitive data masking
- Report formatting
- Test data generation
- Log separators

---

# Quick Revision (30 Seconds)

```java
// Java 8
String.join(", ", "A", "B", "C");
// Output: A, B, C

// Java 11
"A".repeat(5);
// Output: AAAAA
```

### Remember

- `String.join()` → Many Strings → One Delimiter
- `String.repeat()` → One String → Many Copies
- `join()` introduced in Java 8
- `repeat()` introduced in Java 11
- Frequently used in logs, reports, CSV exports, REST APIs, and test utilities