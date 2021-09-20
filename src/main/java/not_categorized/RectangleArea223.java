package not_categorized;

public class RectangleArea223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        final int area1 = (ax2 - ax1) * (ay2 - ay1);
        final int area2 = (bx2 - bx1) * (by2 - by1);
        if (Math.min(ax2, bx2) > Math.max(ax1, bx1) && Math.min(ay2, by2) > Math.max(ay1, by1)) {
            return area1 + area2 - (Math.min(ax2, bx2) - Math.max(ax1, bx1)) * (Math.min(ay2, by2) - Math.max(ay1, by1));
        }
        return area1 + area2;
    }
}
