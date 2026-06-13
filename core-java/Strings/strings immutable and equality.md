# How to Verify String Immutability

## Test 1 - Compare Object References

```java
String original = "Gaurav";

String modified =
        original.concat(" Kumar");

System.out.println(original);
System.out.println(modified);

System.out.println(original == modified);
```

Output:

```text
Gaurav
Gaurav Kumar
false
```

Explanation:

```text
original -----> "Gaurav"

modified -----> "Gaurav Kumar"
```

A new object is created instead of modifying the existing object.

---

## Test 2 - Compare Identity Hash Codes

```java
String name = "Gaurav";

System.out.println(
        System.identityHashCode(name));

name = name.concat(" Kumar");

System.out.println(
        System.identityHashCode(name));
```

Output:

```text
1510467688
1995265320
```

(Different values on every execution)

Explanation:

Different identity hash codes indicate different objects.

This proves that String modification operations create a new object rather than changing the existing one.

---

## Interview Proof

If Strings were mutable:

```java
String s1 = "Java";
String s2 = "Java";
```

Both references would point to the same String Pool object.

Modifying `s1` would unexpectedly modify `s2`.

Since this never happens, Java Strings must be immutable.
```