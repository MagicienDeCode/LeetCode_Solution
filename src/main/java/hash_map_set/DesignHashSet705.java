package hash_map_set;

public class DesignHashSet705 {

    private final boolean[] table = new boolean[1000001];

    public void add(int key) {
        table[key] = true;
    }

    public void remove(int key) {
        table[key] = false;
    }

    /**
     * Returns true if this set contains the specified element.
     */
    public boolean contains(int key) {
        return table[key];
    }
}
