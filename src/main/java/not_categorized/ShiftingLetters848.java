package not_categorized;

public class ShiftingLetters848 {
    public String shiftingLetters(String s, int[] shifts) {
        final int[] timesShifts = shifts.clone();
        for (int i = timesShifts.length - 2; i >= 0; i--) {
            timesShifts[i] = (timesShifts[i] + timesShifts[i + 1]) % 26;
        }
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(
                    (char) ('a' + (s.charAt(i) - 'a' + timesShifts[i]) % 26)
            );
        }
        return stringBuilder.toString();
    }
}
