package Algorithms.Threads;

import org.testng.annotations.Test;
import org.junit.Assert;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharingState {

    /**
     * If you run this test a few times, you will find that sometimes it passes, and sometimes it doesn’t.
     * Again, this is because of allowing the JVM to schedule when threads are run. If the main thread
     * does the set and get on the counter object before the JVM interrupts that thread to allow the
     * CounterSetter to run, the value will still be set to 100.
     */
    @Test
    public void sharedState() {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final SimpleCounter c = new SimpleCounter();
        executorService.execute(new CounterSetter(c));
        c.setNumber(200);
        Assert.assertEquals(200, c.getNumber());
    }

    private static class CounterSetter implements Runnable {
        private final SimpleCounter counter;
        private CounterSetter(SimpleCounter counter) { this.counter = counter; }

        @Override
        public void run() {
            while(true) {
                counter.setNumber(100);
            }
        }
    }

    public class SimpleCounter {
        private int number = 0;

        public void setNumber(int number) {
            this.number = number;
        }
        public int getNumber() {
            return number;
        }
    }
}
