import java.util.concurrent.Semaphore;

class TableTwoWaiters {
    private final Semaphore[] forks = new Semaphore[5];

    private final Semaphore waiters = new Semaphore(2);

    public TableTwoWaiters() {
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void acquireForks(int right, int left) throws InterruptedException {
        waiters.acquire();
        forks[right].acquire();
        forks[left].acquire();
    }

    public void releaseForks(int left, int right) {
        forks[left].release();
        forks[right].release();
        waiters.release();
    }
}