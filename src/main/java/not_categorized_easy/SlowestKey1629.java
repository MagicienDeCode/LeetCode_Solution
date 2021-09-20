package not_categorized_easy;

public class SlowestKey1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char resultChar = keysPressed.charAt(0);
        int resultDuration = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            final int temp = releaseTimes[i] - releaseTimes[i - 1];

            if (temp > resultDuration) {
                resultDuration = temp;
                resultChar = keysPressed.charAt(i);

            } else if (temp == resultDuration) {
                if (keysPressed.charAt(i) > resultChar) {
                    resultChar = keysPressed.charAt(i);
                }
            }
        }
        return resultChar;
    }
}
