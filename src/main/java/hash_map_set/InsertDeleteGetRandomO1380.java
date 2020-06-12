package hash_map_set;

import java.util.*;

public class InsertDeleteGetRandomO1380 {
    private final List<Integer> arraylist = new ArrayList<>();
    private final Map<Integer, Integer> map = new HashMap<>();

    /**
     * Inserts a value to the set. Returns true
     * if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, arraylist.size());
        arraylist.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        final int removeIndex = map.get(val);
        if (removeIndex != arraylist.size() - 1) {
            map.put(arraylist.get(arraylist.size() - 1), removeIndex);
            arraylist.remove(removeIndex);
            arraylist.add(removeIndex, arraylist.get(arraylist.size() - 1));
        }
        arraylist.remove(arraylist.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return arraylist.get(new Random().nextInt(arraylist.size()));
    }
}
