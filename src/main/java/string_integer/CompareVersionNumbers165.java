package string_integer;

public class CompareVersionNumbers165 {
    public int compareVersion(String version1, String version2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < version1.length() || index2 < version2.length()) {
            int temp1 = 0;
            int temp2 = 0;
            while (index1 < version1.length() && version1.charAt(index1) != '.') {
                temp1 = temp1 * 10 + (version1.charAt(index1) - '0');
                ++index1;
            }
            ++index1;
            while (index2 < version2.length() && version2.charAt(index2) != '.') {
                temp2 = temp2 * 10 + (version2.charAt(index2) - '0');
                ++index2;
            }
            ++index2;
            if (temp1 > temp2) {
                return 1;
            }
            if (temp1 < temp2) {
                return -1;
            }
        }
        return 0;
    }
}
