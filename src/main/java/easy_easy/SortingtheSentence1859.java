package easy_easy;

public class SortingtheSentence1859 {
    public String sortSentence(String s) {
        final StringBuilder sb = new StringBuilder();
        final String[] strings = s.split("\\s");
        final String[] results = new String[strings.length + 1];
        for (String str : strings) {
            removeAndPut(str, results);
        }
        for (int i = 1; i < results.length; i++) {
            if (i == results.length - 1) {
                sb.append(results[i]);
            } else {
                sb.append(results[i]).append(" ");
            }
        }
        return sb.toString();
    }

    private void removeAndPut(String str, String[] results) {
        int index = 0;
        while (index < str.length()) {
            final char c = str.charAt(index);
            if (c >= 48 && c <= 57) {
                break;
            }
            ++index;
        }
        final String word = str.substring(0, index);
        final int position = Integer.parseInt(str.substring(index));
        results[position] = word;
    }
}
