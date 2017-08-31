package Algorithms.Threads;

import org.testng.annotations.Test;
import org.junit.Assert;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockedSharedState {
    @Test
    public void lockedSharedState() {
        final ExecutorService executorService =  Executors.newCachedThreadPool();
        final SharingState.SimpleCounter c = new SharingState().new SimpleCounter();
        executorService.execute(new CounterSetter(c));

        synchronized (c) {
            c.setNumber(200);
            Assert.assertEquals(200, c.getNumber());
        }
    }
    private static class CounterSetter implements Runnable {
        private final SharingState.SimpleCounter counter;
        private CounterSetter(SharingState.SimpleCounter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            while(true) {
                synchronized (counter) {
                    counter.setNumber(100);
                }
            }
        }
    }

}
