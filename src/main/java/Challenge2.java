import java.util.HashSet;

class Challenge2 {

    private final HashSet<Integer> integers = new HashSet<>();
    private int root = -1;

    public void addNode(int child, int parent) {
        if (!integers.contains(parent)) {
            root = parent;
        }
        integers.add(child);
    }

    public int findRoot() {
        return root;
    }

}
