public class Solution3_ForkLimit {
    public static void start(String[] args) {
        TableForkLimit table = new TableForkLimit();
        for (int i = 0; i < 5; i++) {
            new PhilosopherForkLimit(i, table);
        }
    }
}