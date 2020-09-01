package string_integer;

public class LargestTimeforGivenDigits949 {
    private int maxTime = -1;

    public String largestTimeFromDigits(int[] nums) {
        this.maxTime = -1;
        permutate(nums, 0);
        if (this.maxTime == -1) {
            return "";
        } else {
            return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
        }
    }

    private void permutate(int[] array, int start) {
        if (start == array.length) {
            buildTime(array);
            return;
        }
        for (int i = start; i < array.length; ++i) {
            swap(array, i, start);
            permutate(array, start + 1);
            swap(array, i, start);
        }
    }

    private void buildTime(int[] permutation) {
        int hour = permutation[0] * 10 + permutation[1];
        int minute = permutation[2] * 10 + permutation[3];
        if (hour < 24 && minute < 60) {
            this.maxTime = Math.max(this.maxTime, hour * 60 + minute);
        }
    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        final LargestTimeforGivenDigits949 java =
                new LargestTimeforGivenDigits949();
        System.out.println(java.largestTimeFromDigits(
                new int[]{1, 2, 3, 4}
        ));
    }
}
