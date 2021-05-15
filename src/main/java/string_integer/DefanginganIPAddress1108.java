package string_integer;

public class DefanginganIPAddress1108 {
    public String defangIPaddr(String address) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                stringBuilder.append("[.]");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
