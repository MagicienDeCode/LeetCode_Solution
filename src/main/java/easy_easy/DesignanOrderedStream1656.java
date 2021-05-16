package easy_easy;

import java.util.LinkedList;
import java.util.List;

public class DesignanOrderedStream1656 {

    final String[] array;
    int lastReturnIndex = 0;

    public DesignanOrderedStream1656(int n) {
        array = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        array[idKey - 1] = value;
        final List<String> results = new LinkedList<>();
        while (lastReturnIndex < array.length && array[lastReturnIndex] != null) {
            results.add(array[lastReturnIndex]);
            ++lastReturnIndex;
        }
        return results;
    }
}
