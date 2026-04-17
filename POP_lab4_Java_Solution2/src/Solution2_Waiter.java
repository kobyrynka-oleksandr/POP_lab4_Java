public class Solution2_Waiter {
    public static void start(String[] args) {
        TableWaiter table = new TableWaiter();
        for (int i = 0; i < 5; i++) {
            new PhilosopherWaiter(i, table);
        }
    }
}