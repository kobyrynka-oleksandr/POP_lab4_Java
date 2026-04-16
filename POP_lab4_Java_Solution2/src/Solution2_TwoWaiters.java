public class Solution2_TwoWaiters {
    public static void start(String[] args) {
        TableTwoWaiters table = new TableTwoWaiters();
        for (int i = 0; i < 5; i++) {
            new PhilosopherTwoWaiters(i, table);
        }
    }
}