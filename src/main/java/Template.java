public class Template {
    public int sum(int a, int b) {
        if (Integer.MAX_VALUE - a < b) {
            return 0;
        } else {
            return a + b;
        }
    }
}
