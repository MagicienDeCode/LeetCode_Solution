package binarysearch;

public class OnlineElection911 {

    // at i, time[i]'s leader
    private final int[] leaders;
    private final int[] times;

    public OnlineElection911(int[] persons, int[] times) {
        this.times = times;
        leaders = new int[times.length];
        // at i, person[i]'s count
        final int[] counts = new int[persons.length];
        leaders[0] = persons[0];
        counts[persons[0]] = 1;
        int maxPerson = persons[0];
        for (int index = 1; index < times.length; index++) {
            counts[persons[index]]++;
            if (counts[persons[index]] >= counts[maxPerson]) {
                maxPerson = persons[index];
                leaders[index] = maxPerson;
            } else {
                leaders[index] = leaders[index - 1];
            }
        }
    }

    public int q(int t) {
        int left = 0;
        int right = times.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (times[mid] == t) {
                return leaders[mid];
            } else if (times[mid] < t) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (times[right] <= t) {
            return leaders[right];
        }
        if (times[left] <= t) {
            return leaders[left];
        }
        return -1;
    }
    /*
    private final int[] times;
    // time[i], person[i]
    private final Map<Integer, Integer> leaders;

    public OnlineElection911(int[] persons, int[] times) {
        this.times = times;
        leaders = new HashMap<>();
        // person[i], count
        final Map<Integer, Integer> count = new HashMap<>();
        count.put(persons[0], 1);
        leaders.put(times[0], persons[0]);
        int max = 1;
        for (int index = 1; index < times.length; index++) {
            final int currentCount = count.computeIfAbsent(persons[index], i -> 0) + 1;
            count.put(persons[index], currentCount);
            if (currentCount >= max) {
                max = currentCount;
                leaders.put(times[index], persons[index]);
            } else {
                leaders.put(times[index], leaders.get(times[index - 1]));
            }
        }
    }

    public int q(int t) {
        int left = 0;
        int right = times.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (times[mid] == t) {
                return leaders.get(times[mid]);
            } else if (times[mid] < t) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (times[right] <= t) {
            return leaders.get(times[right]);
        }
        if (times[left] <= t) {
            return leaders.get(times[left]);
        }
        return -1;
    }
     */
}
