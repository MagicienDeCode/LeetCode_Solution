class Challenge4 {
    private static final String SIMILAR_1 = "0OQ";
    private static final String SIMILAR_2 = "1IT";
    private static final String SIMILAR_3 = "2Z";
    private static final String SIMILAR_4 = "5S";
    private static final String SIMILAR_5 = "8B";

    private static final char EMPTY_CHAR = ' ';

    private static boolean similar(String s1, String s2) {
        if (SIMILAR_1.contains(s1)) {
            return SIMILAR_1.contains(s2);
        } else if (SIMILAR_2.contains(s1)) {
            return SIMILAR_2.contains(s2);
        } else if (SIMILAR_3.contains(s1)) {
            return SIMILAR_3.contains(s2);
        } else if (SIMILAR_4.contains(s1)) {
            return SIMILAR_4.contains(s2);
        } else if (SIMILAR_5.contains(s1)) {
            return SIMILAR_5.contains(s2);
        } else {
            return s1.equals(s2);
        }
    }

    public static boolean similarLicensePlates(String plate1, String plate2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < plate1.length() && index2 < plate2.length()) {
            while (index1 < plate1.length() && plate1.charAt(index1) == EMPTY_CHAR) {
                ++index1;
            }
            while (index2 < plate2.length() && plate2.charAt(index2) == EMPTY_CHAR) {
                ++index2;
            }
            if (index1 < plate1.length() && index2 < plate2.length()) {
                if (!similar(String.valueOf(plate1.charAt(index1)),
                        String.valueOf(plate2.charAt(index2)))) {
                    return false;
                }
                ++index1;
                ++index2;
            }
        }
        while (index1 < plate1.length() && plate1.charAt(index1) == EMPTY_CHAR) {
            ++index1;
        }
        while (index2 < plate2.length() && plate2.charAt(index2) == EMPTY_CHAR) {
            ++index2;
        }
        return index1 == plate1.length() && index2 == plate2.length();
    }

    public static void main(String[] args) {
        // False
        System.out.println(Challenge4.similarLicensePlates("ABC", "DEF"));

        // True
        System.out.println(Challenge4.similarLicensePlates("AAA", "A A A"));
        System.out.println(Challenge4.similarLicensePlates("BOX", "B0X"));
        System.out.println(Challenge4.similarLicensePlates("BIZ", "812"));
        System.out.println(Challenge4.similarLicensePlates("BIZ", "812   "));
        System.out.println(Challenge4.similarLicensePlates(" ", "    "));
    }
}
