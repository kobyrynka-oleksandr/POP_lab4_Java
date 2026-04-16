public class Solution1_Asymmetric {
    public static void start(String[] args) {
        Table table = new Table();
        for (int i = 0; i < 5; i++) {
            new PhilosopherAsym(i, table);
        }
    }
}