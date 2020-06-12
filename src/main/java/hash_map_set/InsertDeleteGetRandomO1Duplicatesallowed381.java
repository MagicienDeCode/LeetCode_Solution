package hash_map_set;

import java.util.*;

public class InsertDeleteGetRandomO1Duplicatesallowed381 {
    private final List<Integer> arraylist = new ArrayList<>();
    private final Map<Integer, List<Integer>> map
            = new HashMap<>();

    /**
     * Inserts a value to the set. Returns true
     * if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            map.get(val).add(arraylist.size());
            arraylist.add(val);
            return false;
        } else {
            final List<Integer> list = new ArrayList<>();
            list.add(arraylist.size());
            map.put(val, list);
            arraylist.add(val);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            final List<Integer> removeIndexList = map.get(val);
            final int removeIndex = removeIndexList.get(0);
            if (removeIndexList.size() == 1) {
                map.remove(val);
            } else {
                removeIndexList.remove(0);
            }
            if (removeIndex != arraylist.size() - 1) {
                final int exchangeVal = arraylist.get(arraylist.size() - 1);
                arraylist.remove(removeIndex);
                arraylist.add(removeIndex, exchangeVal);
                final List<Integer> exchangeList = map.get(exchangeVal);
                exchangeList.remove(Integer.valueOf(arraylist.size() - 1));
                exchangeList.add(removeIndex);
            }
            arraylist.remove(arraylist.size() - 1);
            return true;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return arraylist.get(new Random().nextInt(arraylist.size()));
    }
}
