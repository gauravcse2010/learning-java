public class StringThreadSafetyDemo {

    private static final int ITERATIONS = 100_000;

    public static void main(String[] args)
            throws InterruptedException {

        testStringBuilder();

        testStringBuffer();
    }

    private static void testStringBuilder()
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
                "StringBuilder Length = "
                        + sb.length());
    }

    private static void testStringBuffer()
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
                "StringBuffer Length = "
                        + sb.length());
    }
}