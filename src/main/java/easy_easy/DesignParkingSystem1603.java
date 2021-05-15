package easy_easy;

public class DesignParkingSystem1603 {

    private final int[] parking = new int[3];

    public DesignParkingSystem1603(int big, int medium, int small) {
        parking[0] = big;
        parking[1] = medium;
        parking[2] = small;
    }

    public boolean addCar(int carType) {
        if (parking[carType - 1] > 0) {
            parking[carType - 1]--;
            return true;
        } else {
            return false;
        }
    }

    /*
    private int big;
    private int medium;
    private int small;

    public DesignParkingSystem1603(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big > 0) {
                    big--;
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (medium > 0) {
                    medium--;
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (small > 0) {
                    small--;
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
     */
}
