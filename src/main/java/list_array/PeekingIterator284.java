package list_array;

import java.util.Iterator;

public class PeekingIterator284 implements Iterator<Integer> {

    private final Iterator<Integer> iterator;
    private Integer cache;

    public PeekingIterator284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cache == null) {
            cache = iterator.next();
            return cache;
        }
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cache == null) {
            return iterator.next();
        }
        final Integer next = cache;
        cache = null;
        return next;
    }

    @Override
    public boolean hasNext() {
        return cache != null || iterator.hasNext();
    }
}
