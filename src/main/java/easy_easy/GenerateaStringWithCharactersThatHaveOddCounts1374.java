package easy_easy;

public class GenerateaStringWithCharactersThatHaveOddCounts1374 {
    public String generateTheString(int n) {
        if (n % 2 == 0) {
            return "a".repeat(n - 1) + "x";
        } else {
            return "x".repeat(n);
        }
    }
}
