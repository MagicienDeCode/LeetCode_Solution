package list_array;

import java.util.Arrays;

/*
If we play a token face up, we might as well play the one with the smallest value. Similarly,
if we play a token face down, we might as well play the one with the largest value.
 */
public class BagofTokens948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length -1;
        int points = 0;
        int answer = 0;
        while (left<=right && (power>tokens[left] ||points>0)){
            while (left<=right && power >= tokens[left]){
                power-= tokens[left++];
                points++;
            }
            answer = Math.max(answer,points);
            if (left<=right && points >0){
                power+=tokens[right--];
                points--;
            }
        }
        return answer;
    }
}
