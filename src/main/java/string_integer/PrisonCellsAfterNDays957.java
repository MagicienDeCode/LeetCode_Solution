package string_integer;

public class PrisonCellsAfterNDays957 {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] result = cells;
        for (int time = 0; time <= ((n - 1) % 14); time++) {
            final int[] newCells = new int[cells.length];
            for (int index = 1; index <= cells.length - 2; index++) {
                if (result[index - 1] == result[index + 1]) {
                    newCells[index] = 1;
                } else {
                    newCells[index] = 0;
                }
            }
            result = newCells;
        }
        return result;
    }
}
