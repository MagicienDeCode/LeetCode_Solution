package easy_easy;

public class RobotReturntoOrigin657 {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    ++x;
                    break;
                case 'D':
                    --x;
                    break;
                case 'L':
                    ++y;
                    break;
                case 'R':
                    --y;
                    break;
            }
        }
        return x == y && x == 0;
    }
}
