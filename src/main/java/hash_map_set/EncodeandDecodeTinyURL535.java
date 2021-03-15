package hash_map_set;

import java.util.HashMap;
import java.util.Map;

public class EncodeandDecodeTinyURL535 {

    private static final String PREFIX = "http://tinyurl.com/";

    // Map to store 62 possible characters
    final String charString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    final char[] chars = charString.toCharArray();

    private final Map<Integer, String> longIntString = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        final int current = longIntString.size();

        final String shortUrl = intToString(current);
        longIntString.put(current, longUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return longIntString.get(stringToInt(shortUrl));
    }

    private int stringToInt(String string) {
        int result = 0;
        for (char c : string.toCharArray()) {
            result += result * 62 + charString.indexOf(c);
        }
        return result;
    }

    private String intToString(int i) {
        final StringBuilder stringBuilder = new StringBuilder();
        while (i > 0) {
            stringBuilder.insert(0, chars[i % 62]);
            i /= 62;
        }
        return stringBuilder.toString();
    }
}
