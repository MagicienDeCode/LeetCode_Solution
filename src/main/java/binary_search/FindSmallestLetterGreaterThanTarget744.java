package binary_search;

public class FindSmallestLetterGreaterThanTarget744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (letters[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (letters[left] > target) {
            return letters[left];
        }
        if (letters[right] > target) {
            return letters[right];
        }
        return letters[0];
    }
}
