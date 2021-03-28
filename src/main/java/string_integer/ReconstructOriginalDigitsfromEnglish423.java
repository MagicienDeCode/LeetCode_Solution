package string_integer;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsfromEnglish423 {
    public String originalDigits(String s) {
        final StringBuilder stringBuilder = new StringBuilder();
        final char[] chars = s.toCharArray();
        final Map<Character, Integer> map = new HashMap<>();
        map.put('z', 0);
        map.put('w', 0);
        map.put('u', 0);
        map.put('x', 0);
        map.put('g', 0);
        map.put('h', 0);
        map.put('f', 0);
        map.put('v', 0);
        map.put('i', 0);
        map.put('o', 0);
        for (char c : chars) {
            switch (c) {
                case 'z':
                    map.put('z', map.get('z') + 1);
                    break;
                case 'w':
                    map.put('w', map.get('w') + 1);
                    break;
                case 'u':
                    map.put('u', map.get('u') + 1);
                    break;
                case 'x':
                    map.put('x', map.get('x') + 1);
                    break;
                case 'g':
                    map.put('g', map.get('g') + 1);
                    break;
                case 'h':
                    map.put('h', map.get('h') + 1);
                    break;
                case 'f':
                    map.put('f', map.get('f') + 1);
                    break;
                case 'v':
                    map.put('v', map.get('v') + 1);
                    break;
                case 'i':
                    map.put('i', map.get('i') + 1);
                    break;
                case 'o':
                    map.put('o', map.get('o') + 1);
                    break;
            }
        }
        final int[] result = new int[10];
        result[0] = map.get('z');
        result[2] = map.get('w');
        result[4] = map.get('u');
        result[6] = map.get('x');
        result[8] = map.get('g');
        result[3] = map.get('h') - map.get('g');
        result[5] = map.get('f') - map.get('u');
        result[7] = map.get('v') - map.get('f') + map.get('u');
        result[9] = map.get('i') - map.get('g') - map.get('x') - map.get('f') + map.get('u');
        result[1] = map.get('o') - map.get('z') - map.get('w') - map.get('u');
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(String.valueOf(i).repeat(result[i]));
        }
        return stringBuilder.toString();
    }
}
