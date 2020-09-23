package list_array;

public class GasStation134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int count = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            final int current = gas[i] - cost[i];
            if (count + current < 0) {
                start = i + 1;
                count = 0;
            } else {
                count += current;
            }
            sum += current;
        }
        return sum < 0 ? -1 : start;
    }
    /*
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1 && gas[0] >= cost[0]) {
            return 0;
        }
        final int[] temp = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            temp[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < gas.length; i++) {
            if (temp[i] > 0) {
                if (canComplete(temp, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean canComplete(int[] temp, int target) {
        final int size = temp.length;
        int count = temp[target];
        int index = (target + 1) % size;
        while (true) {
            if (index % size == target) {
                return true;
            }
            count += temp[index];
            if (count < 0) {
                return false;
            }
            index = (index + 1) % size;
        }
    }

    public static void main(String[] args) {
        final GasStation134 java = new GasStation134();
        System.out.println(java.canCompleteCircuit(
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 4, 5, 1, 2}
        ));
    }
     */
}
