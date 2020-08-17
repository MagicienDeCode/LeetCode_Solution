package list_array;

public class DistributeCandiestoPeople1103 {
    public int[] distributeCandies(int candies, int num_people) {
        final int[] resultArray = new int[num_people];
        int index = 0;
        int given = 1;
        while (candies > 0) {
            if (candies - given >= 0) {
                resultArray[index % num_people] += given;
            } else {
                resultArray[index % num_people] += candies;
            }
            candies -= given;
            ++index;
            ++given;
        }
        return resultArray;
    }
}
