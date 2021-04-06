package design;

import java.util.Arrays;

public class DesignCircularQueue622 {

    final int[] array;
    int left;
    int right;
    final int k;

    public DesignCircularQueue622(int k) {
        this.k = k;
        left = k;
        right = k;
        this.array = new int[k];
        Arrays.fill(array, -1);
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[right % k] = value;
        ++right;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        array[left % k] = -1;
        ++left;
        return true;
    }

    public int Front() {
        return array[left % k];
    }

    public int Rear() {
        return array[(right - 1) % k];
    }

    public boolean isEmpty() {
        return left == right;
    }

    public boolean isFull() {
        return (right - left) == k;
    }
}
