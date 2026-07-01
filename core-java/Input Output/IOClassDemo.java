import java.text.NumberFormat;
import java.util.Locale;

/**
 * Java 25 - java.lang.IO Demo
 *
 * This program demonstrates:
 * 1. IO.print()
 * 2. IO.println()
 * 3. IO.println()
 * 4. IO.readln()
 * 5. IO.readln(String prompt)
 * 6. Reading int using Integer.parseInt()
 * 7. Reading double using Double.parseDouble()
 * 8. Number formatting using NumberFormat
 *
 * NOTE:
 * IO.readln() ALWAYS returns a String.
 */
public class IOClassDemo {

    public static void main(String[] args) {

        // ============================================================
        // Example 1 : IO.print()
        // ============================================================

        IO.print("Hello");
        IO.print(" ");
        IO.print("Java");

        /*
         Output

         Hello Java
         */

        IO.println();
        IO.println();


        // ============================================================
        // Example 2 : IO.println(Object)
        // ============================================================

        IO.println("Welcome");
        IO.println("to");
        IO.println("Java 25");

        /*
         Output

         Welcome
         to
         Java 25
         */

        IO.println();


        // ============================================================
        // Example 3 : Empty println()
        // ============================================================

        IO.println("Line 1");

        IO.println();

        IO.println("Line 2");

        /*
         Output

         Line 1

         Line 2
         */

        IO.println();


        // ============================================================
        // Example 4 : Read String
        // ============================================================

        String name = IO.readln("Enter your name : ");

        IO.println("Hello " + name);

        /*
         Enter your name :

         Gaurav

         Output

         Hello Gaurav
         */

        IO.println();


        // ============================================================
        // Example 5 : readln() without prompt
        // ============================================================

        IO.println("Enter your city :");

        String city = IO.readln();

        IO.println("City = " + city);

        /*
         Enter your city :

         Delhi

         Output

         City = Delhi
         */

        IO.println();


        // ============================================================
        // Example 6 : Reading Integer
        // ============================================================

        /*
         readln() returns String.

         Integer.parseInt() converts String into int.
         */

        int age =
                Integer.parseInt(
                        IO.readln("Enter your age : ")
                );

        IO.println("Age = " + age);

        /*
         Enter your age :

         30

         Output

         Age = 30
         */

        IO.println();


        // ============================================================
        // Example 7 : Reading Double
        // ============================================================

        /*
         readln() returns String.

         Double.parseDouble() converts String into double.
         */

        double salary =
                Double.parseDouble(
                        IO.readln("Enter salary : ")
                );

        IO.println("Salary = " + salary);

        /*
         Enter salary :

         75000.50

         Output

         Salary = 75000.5
         */

        IO.println();


        // ============================================================
        // Example 8 : Why readln() returns String
        // ============================================================

        String value =
                IO.readln("Enter any number : ");

        IO.println("Value = " + value);

        IO.println("Length = " + value.length());

        /*
         Enter any number :

         100

         Output

         Value = 100
         Length = 3
         */

        IO.println();


        // ============================================================
        // Example 9 : Convert String to Integer
        // ============================================================

        int number =
                Integer.parseInt(value);

        IO.println("Number = " + number);

        IO.println("Number + 100 = " + (number + 100));

        /*
         Output

         Number = 100
         Number + 100 = 200
         */

        IO.println();


        // ============================================================
        // Example 10 : Invalid Integer
        // ============================================================

        try {

            int marks =
                    Integer.parseInt(
                            IO.readln("Enter marks : ")
                    );

            IO.println("Marks = " + marks);

        } catch (NumberFormatException ex) {

            IO.println("Invalid Integer");

            IO.println(ex.getMessage());

        }

        /*
         Enter marks :

         abc

         Output

         Invalid Integer

         For input string: "abc"
         */

        IO.println();


        // ============================================================
        // Example 11 : Invalid Double
        // ============================================================

        try {

            double amount =
                    Double.parseDouble(
                            IO.readln("Enter amount : ")
                    );

            IO.println(amount);

        } catch (NumberFormatException ex) {

            IO.println("Invalid Double");

            IO.println(ex.getMessage());

        }

        /*
         Input

         12,345.67

         Output

         Invalid Double

         For input string: "12,345.67"
         */

        IO.println();


        // ============================================================
        // Example 12 : Default Number Output
        // ============================================================

        double money = 1234567.89;

        IO.println("Default Output");

        IO.println(money);

        /*
         Output

         Default Output
         1234567.89
         */

        IO.println();


        // ============================================================
        // Example 13 : Locale Formatting (US)
        // ============================================================

        NumberFormat us =
                NumberFormat.getNumberInstance(Locale.US);

        IO.println("US Locale");

        IO.println(us.format(money));

        /*
         Output

         US Locale
         1,234,567.89
         */

        IO.println();


        // ============================================================
        // Example 14 : Locale Formatting (Germany)
        // ============================================================

        NumberFormat germany =
                NumberFormat.getNumberInstance(Locale.GERMANY);

        IO.println("Germany Locale");

        IO.println(germany.format(money));

        /*
         Output

         Germany Locale
         1.234.567,89
         */

        IO.println();


        // ============================================================
        // Example 15 : Locale Formatting (India)
        // ============================================================

        NumberFormat india =
                NumberFormat.getNumberInstance(
                        new Locale("en", "IN")
                );

        IO.println("India Locale");

        IO.println(india.format(money));

        /*

         India Locale
         12,34,567.89
         */

        IO.println();

        // ============================================================
        // End of Demo
        // ============================================================

        IO.println("Demo Completed Successfully.");
    }
}