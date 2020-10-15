package list_array;

import java.util.LinkedList;

public class NumberofRecentCalls933 {

    private final LinkedList<Integer> list = new LinkedList<>();

    public int ping(int t) {
        list.add(t);
        while (list.size() > 0) {
            if (list.getFirst() < t - 3000) {
                list.removeFirst();
            } else {
                break;
            }
        }
        return list.size();
    }

    /*
    Since the elements in our sliding window are strictly ordered, due to the condition of the problem, one might argue that it might be more efficient to use binary search to locate the most recent outdated calls and then starting from that point truncate all the previous calls.
In terms of search, binary search is seemingly more efficient than our linear search. When the elements are held in the array data structure, it is true that binary search is more efficient.
However, it is not the case for the linked list, since there is no way to locate an element in the middle of a linked list instantly, which is a critical condition for binary search algorithm.
As a result, in order to apply binary search, we might have to opt for the Array data structure. On the other hand, once we use the array as the container, we might have to keep all the historical elements, which in the long run is not space-efficient neither time-efficient later. Or we have to find a way to efficiently remove the elements from array without frequently reallocating memory.
To conclude, it is doable to have a binary search solution. Yet, it would complicate the design, and at the end the final solution is not necessarily more efficient than the above simple LinkedList-based sliding window.
Finally, if one is interested in such a problem, there is another rather similar problem called logger rate limiter.
     */
}
