class PhilosopherForkLimit extends Thread {
    private final TableForkLimit table;
    private final int leftFork, rightFork;
    private final int id;

    public PhilosopherForkLimit(int id, TableForkLimit table) {
        this.id = id;
        this.table = table;
        rightFork = id;
        leftFork = (id + 1) % 5;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Philosopher" + id + " is thinking (" + (i + 1) + ")");
            try {
                table.acquireForks(rightFork, leftFork);
                System.out.println("Philosopher" + id + " is eating (" + (i + 1) + ")");
                table.releaseForks(leftFork, rightFork);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Philosopher" + id + " finished.");
    }
}