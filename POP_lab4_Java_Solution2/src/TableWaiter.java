import java.util.concurrent.Semaphore;

class TableWaiter {
    private final Semaphore[] forks = new Semaphore[5];

    private final Semaphore waiter = new Semaphore(4);

    public TableWaiter() {
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void acquireForks(int right, int left) throws InterruptedException {
        waiter.acquire();
        forks[right].acquire();
        forks[left].acquire();
    }

    public void releaseForks(int left, int right) {
        forks[left].release();
        forks[right].release();
        waiter.release();
    }
}