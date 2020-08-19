package list_array;

public class DistributeCandiestoPeople1103 {
    public int[] distributeCandies(int candies, int numPeople) {
        final int[] resultArray = new int[numPeople];
        int index = 0;
        int given = 1;
        while (candies > 0) {
            if (candies - given >= 0) {
                resultArray[index % numPeople] += given;
            } else {
                resultArray[index % numPeople] += candies;
            }
            candies -= given;
            ++index;
            ++given;
        }
        return resultArray;
    }
}
