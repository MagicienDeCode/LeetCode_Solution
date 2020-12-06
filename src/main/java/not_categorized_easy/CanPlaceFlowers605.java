package not_categorized_easy;

public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)
            ) {
                flowerbed[i++] = 1;
                --n;
            }
        }
        return n <= 0;
    }
}
