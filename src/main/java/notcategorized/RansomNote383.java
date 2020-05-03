package notcategorized;

public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // a 97
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        final int offset = 97;
        final int[] intMagazine = new int[26];
        for (char m : magazine.toCharArray()) {
            intMagazine[m - offset]++;
        }
        for (char r : ransomNote.toCharArray()) {
            if (--intMagazine[r - offset] < 0) {
                return false;
            }
        }
        return true;
        /*
        final int[] intMagazine = new int[128];
        for (char m : magazine.toCharArray()) {
            intMagazine[m]++;
        }
        for (char r : ransomNote.toCharArray()) {
            if (--intMagazine[r] < 0) {
                return false;
            }
        }
        return true;
         */
    }
}
