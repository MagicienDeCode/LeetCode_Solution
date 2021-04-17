package list_array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class FlattenNestedListIterator341 implements Iterator<Integer> {

    private final Queue<Integer> queue;

    public FlattenNestedListIterator341(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> items) {
        items.forEach(it -> {
            if (it.isInteger()) {
                queue.offer(it.getInteger());
            } else {
                dfs(it.getList());
            }
        });
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return queue.size() != 0;
    }
}