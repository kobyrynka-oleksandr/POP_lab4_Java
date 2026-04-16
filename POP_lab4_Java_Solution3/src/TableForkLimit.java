import java.util.concurrent.Semaphore;

class TableForkLimit {
    private final Semaphore[] forks = new Semaphore[5];
    private int holdingCount = 0;
    private final Object monitor = new Object();

    public TableForkLimit() {
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void acquireForks(int right, int left) throws InterruptedException {
        synchronized (monitor) {
            while (holdingCount >= 4) {
                System.out.println("  [Blocked] max fork-holders reached, waiting...");
                monitor.wait();
            }
            holdingCount++;
        }
        forks[right].acquire();
        forks[left].acquire();
    }

    public void releaseForks(int left, int right) {
        forks[left].release();
        forks[right].release();
        synchronized (monitor) {
            holdingCount--;
            monitor.notifyAll();
        }
    }
}