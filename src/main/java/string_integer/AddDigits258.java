package string_integer;

public class AddDigits258 {
    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
