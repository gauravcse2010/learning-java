# Java 25 - java.lang.IO

## Introduction

Starting with **Java 25**, Java introduced a new utility class:

```java
java.lang.IO
```

The purpose of this class is to simplify console input and output for beginners by reducing the boilerplate code required to write simple console applications.

Before Java 25, reading input required creating a `Scanner` or `BufferedReader`. For simple programs, this added unnecessary complexity.

Since `IO` belongs to the **java.lang** package, it is imported automatically.

---

# Why was IO introduced?

Consider a beginner writing the first Java program that accepts user input.

Before Java 25:

```java
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");

        String name = scanner.nextLine();

        System.out.println("Hello " + name);
    }
}
```

The beginner must understand:

- import statements
- Scanner
- object creation
- System.in
- System.out

Java 25 simplifies the same program.

```java
void main() {

    String name = IO.readln("Enter your name: ");

    IO.println("Hello " + name);
}
```

The intent is to let beginners focus on programming rather than Java syntax.

---

# Available Methods

The `IO` class currently provides only five methods.

| Method | Description |
|---------|-------------|
| `print(Object)` | Prints without moving to the next line |
| `println(Object)` | Prints and moves to the next line |
| `println()` | Prints an empty line |
| `readln()` | Reads an entire line from the console |
| `readln(String prompt)` | Displays a prompt and reads one line |

---

# print()

Example

```java
IO.print("Hello");
IO.print(" World");
```

Output

```
Hello World
```

Unlike `println()`, the cursor remains on the same line.

---

# println(Object)

```java
IO.println("Hello");
IO.println("Java");
```

Output

```
Hello
Java
```

Moves the cursor to the next line after printing.

---

# println()

Prints an empty line.

```java
IO.println("Java");
IO.println();
IO.println("Spring");
```

Output

```
Java

Spring
```

Useful for improving console readability.

---

# readln()

Reads an entire line from the keyboard.

```java
String name = IO.readln();
```

Return type

```java
String
```

Example

```java
String city = IO.readln("Enter your city: ");
```

Console

```
Enter your city: Delhi
```

The returned value is

```java
"Delhi"
```

---

# readln() always returns String

Suppose the user enters

```
25
```

`IO.readln()` returns

```java
"25"
```

NOT

```java
25
```

Therefore conversion is required.

```java
int age =
Integer.parseInt(IO.readln("Enter age: "));
```

---

# Reading Integer

```java
int age =
Integer.parseInt(
IO.readln("Age : "));
```

Input

```
30
```

Output

```
30
```

---

# Reading Double

```java
double salary =
Double.parseDouble(
IO.readln("Salary : "));
```

Input

```
75000.50
```

Output

```
75000.5
```

---

# How readln() Works

```
User Types

       100
        │
        ▼

 IO.readln()

        │

returns

      "100"

        │

Integer.parseInt()

        │

returns

       100
```

---

# Important Caution

Suppose the user enters

```
12,345.67
```

Now

```java
Double.parseDouble(IO.readln());
```

becomes

```java
Double.parseDouble("12,345.67");
```

Result

```
NumberFormatException
```

because Java expects

```
12345.67
```

without commas.

Likewise,

```
12345,67
```

is also invalid because Java expects `.` as the decimal separator.

---

# Why?

`parseInt()` and `parseDouble()` are designed to parse **Java numeric literals**, not locale-specific user input.

Java numeric literals always use:

- decimal point = `.`
- no grouping separators

Professional applications use locale-aware parsing.

Example

```java
NumberFormat format =
NumberFormat.getNumberInstance(Locale.US);

Number number =
format.parse("12,345.67");
```

---

# IO.println() Caution

```java
double salary = 1234567.89;

IO.println(salary);
```

Output

```
1234567.89
```

Users generally expect

US

```
1,234,567.89
```

Germany

```
1.234.567,89
```

India

```
12,34,567.89
```

Therefore professional applications first format the number.

Example

```java
NumberFormat nf =
NumberFormat.getNumberInstance(Locale.US);

IO.println(nf.format(1234567.89));
```

Output

```
1,234,567.89
```

---

# IO vs Scanner

| Feature | IO | Scanner |
|----------|----|----------|
| Introduced | Java 25 | Java 5 |
| Package | java.lang | java.util |
| Import Required | No | Yes |
| Object Creation | No | Yes |
| Reads Entire Line | Yes | Yes |
| Reads Individual Tokens | No | Yes |
| Reads Files | No | Yes |
| Beginner Friendly | Excellent | Good |
| Enterprise Usage | Rare | Common |

---

# Advantages

- Very easy to learn
- Less boilerplate code
- No imports
- No Scanner object
- Cleaner syntax
- Great for beginners

---

# Limitations

- Console applications only
- Cannot read files
- Cannot tokenize input like Scanner
- Not intended for enterprise applications
- Not a replacement for Scanner or BufferedReader

---

# Common Beginner Mistakes

## Mistake 1

```java
int age = IO.readln();
```

Wrong.

`readln()` returns String.

Correct

```java
int age =
Integer.parseInt(IO.readln());
```

---

## Mistake 2

```java
Double.parseDouble("12,345.67");
```

Throws

```
NumberFormatException
```

---

## Mistake 3

Expecting formatted output.

```java
IO.println(1234567.89);
```

Output

```
1234567.89
```

NOT

```
1,234,567.89
```

---

# Interview Questions

### Why was IO introduced?

To simplify console input/output for beginners.

---

### Which package contains IO?

```
java.lang
```

---

### Does IO require import?

No.

---

### What does readln() return?

Always a String.

---

### How do you read an integer?

```java
Integer.parseInt(IO.readln());
```

---

### Why shouldn't parseDouble() be used directly for user input?

Because users may enter locale-specific numbers like

```
12,345.67
```

or

```
12345,67
```

which are not valid Java numeric literals.

---

### Is IO a replacement for Scanner?

No.

IO is designed for simple console programs.

Scanner is much more powerful.

---

# Key Takeaways

- Introduced in Java 25.
- Located in java.lang.
- No imports required.
- Simplifies console applications.
- readln() always returns String.
- parseInt() and parseDouble() convert Strings into numbers.
- IO.println() does not format numbers for end users.
- Use NumberFormat for locale-aware formatting.