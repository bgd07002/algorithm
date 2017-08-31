package Algorithms.Threads;

import org.testng.annotations.Test;

import java.util.concurrent.*;

public class ThreadTest {

    /**
     * On running this code, you should see it terminate rather quickly, after maybe 7–10 lines
     * are printed to the console. In JUnit, when the code in the main thread has completed, the test finishes.
     */
    @Test
    public void executorExample() {
        final ExecutorService executor = Executors.newCachedThreadPool();
        final Runnable threadNamePrinter = new InfiniteThreadNamePrinter();
        System.out.println("Main thread: " + Thread.currentThread().getName());
        executor.execute(threadNamePrinter);
    }
    private static class InfiniteThreadNamePrinter implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Run from thread: " + Thread.currentThread().getName());
            }
        }
    }

    /**
     * This code wait for your child thread to complete
     */
    @Test
    public void waitToComplete() throws InterruptedException {
        final ExecutorService executor = Executors.newCachedThreadPool();
        final CountDownLatch latch = new CountDownLatch(1);
        executor.execute(new FiniteThreadNamePrinterLatch(latch));
        latch.await(5, TimeUnit.SECONDS);
    }

    private static class FiniteThreadNamePrinterLatch implements Runnable {
        final CountDownLatch latch;
        private FiniteThreadNamePrinterLatch(final CountDownLatch latch) { this.latch = latch; }

        @Override
        public void run() {
            for (int i = 0; i < 25; i++)
                System.out.println("Run from thread: " + Thread.currentThread().getName());

            latch.countDown();
        }
    }

    /**
     * Alternatively, you can have your Executor to run in the same thread
     */
    @Test
    public void sameThread() {
        final Executor executor = new Executor() {
            @Override
            public void execute(final Runnable command) {
                command.run();
            }
        };
        System.out.println("Main thread: " + Thread.currentThread().getName());
        executor.execute(new FiniteThreadNamePrinter());
    }

    private static class FiniteThreadNamePrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 25; i++)
                System.out.println("Run from thread: " + Thread.currentThread().getName());

        }
    }
}
