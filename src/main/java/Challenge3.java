import java.util.List;

class Challenge3 {
    public static Integer sjf(List<Integer> jobs, Integer index) {
        final int target = jobs.get(index);
        int currentIndex = 0;
        int count = 0;
        while (currentIndex <= index) {
            final int job = jobs.get(currentIndex);
            count += job <= target ? job : 0;
            ++currentIndex;
        }
        while (currentIndex < jobs.size()) {
            final int job = jobs.get(currentIndex);
            count += job < target ? job : 0;
            ++currentIndex;
        }
        return count;
    }

    public static void main(String[] args) {
        // 6
        System.out.println(Challenge3.sjf(List.of(3, 10, 20, 1, 2), 0));
        // 26
        System.out.println(Challenge3.sjf(List.of(3, 10, 10, 20, 1, 2), 2));
        // 16
        System.out.println(Challenge3.sjf(List.of(3, 10, 10, 20, 1, 2), 1));
    }
}