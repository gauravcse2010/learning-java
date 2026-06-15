public class StringComparisonDemo {

    private static final int ITERATIONS = 100_000;

    public static void main(String[] args) {

        System.out.println("========== STRING ==========");
        demonstrateString();

        System.out.println("\n========== STRINGBUILDER ==========");
        demonstrateStringBuilder();

        System.out.println("\n========== STRINGBUFFER ==========");
        demonstrateStringBuffer();

        System.out.println("\n========== PERFORMANCE ==========");
        testString();
        testStringBuilder();
        testStringBuffer();
    }

    private static void demonstrateString() {

        String str = "Java";

        int before =
                System.identityHashCode(str);

        str = str.concat(" 21");

        int after =
                System.identityHashCode(str);

        System.out.println("Value  : " + str);
        System.out.println("Before : " + before);
        System.out.println("After  : " + after);
        System.out.println("Same Object ? "
                + (before == after));
    }

    private static void demonstrateStringBuilder() {

        StringBuilder sb =
                new StringBuilder("Java");

        int before =
                System.identityHashCode(sb);

        sb.append(" 21");

        int after =
                System.identityHashCode(sb);

        System.out.println("Value  : " + sb);
        System.out.println("Before : " + before);
        System.out.println("After  : " + after);
        System.out.println("Same Object ? "
                + (before == after));
    }

    private static void demonstrateStringBuffer() {

        StringBuffer sb =
                new StringBuffer("Java");

        int before =
                System.identityHashCode(sb);

        sb.append(" 21");

        int after =
                System.identityHashCode(sb);

        System.out.println("Value  : " + sb);
        System.out.println("Before : " + before);
        System.out.println("After  : " + after);
        System.out.println("Same Object ? "
                + (before == after));
    }

    private static void testString() {

        long start = System.currentTimeMillis();

        String str = "";

        for (int i = 0; i < ITERATIONS; i++) {
            str += i;
        }

        long end = System.currentTimeMillis();

        System.out.println("String Time       : "
                + (end - start) + " ms");
    }

    private static void testStringBuilder() {

        long start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(i);
        }

        long end = System.currentTimeMillis();

        System.out.println("StringBuilder Time: "
                + (end - start) + " ms");
    }

    private static void testStringBuffer() {

        long start = System.currentTimeMillis();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(i);
        }

        long end = System.currentTimeMillis();

        System.out.println("StringBuffer Time : "
                + (end - start) + " ms");
    }
}