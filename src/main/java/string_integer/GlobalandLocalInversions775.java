package string_integer;

public class GlobalandLocalInversions775 {
    public boolean isIdealPermutation(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != i) {
                if (a[i + 1] == i && a[i] == i + 1) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
