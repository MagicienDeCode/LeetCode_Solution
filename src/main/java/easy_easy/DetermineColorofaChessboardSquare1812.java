package easy_easy;

public class DetermineColorofaChessboardSquare1812 {
    public boolean squareIsWhite(String coordinates) {
        final int i = Integer.parseInt(String.valueOf(coordinates.charAt(1))) % 2;
        if ((coordinates.charAt(0)-'a')%2==0){
            return i == 0;
        }else {
            return i != 0;
        }
    }
}
