package design;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII731 {

    final List<int[]> calendars = new ArrayList<>();
    final List<int[]> overlaps = new ArrayList<>();

    public boolean book(int start, int end) {
        final int[] current = new int[]{start, end};
        for (int[] ov : overlaps) {
            if (isOverlap(current, ov)) {
                return false;
            }
        }
        for (int[] ca : calendars) {
            if (isOverlap(current, ca)) {
                overlaps.add(getOverlap(current, ca));
            }
        }
        calendars.add(current);
        return true;
    }

    private int[] getOverlap(int[] a, int[] b) {
        return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }

    private boolean isOverlap(int[] a, int[] b) {
        return !(a[1] <= b[0] || a[0] >= b[1]);
    }
}
