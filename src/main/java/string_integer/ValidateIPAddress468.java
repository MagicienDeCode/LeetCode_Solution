package string_integer;

public class ValidateIPAddress468 {
    public String validIPAddress(String IP) {
        if (IP.isEmpty() || IP.length() < 6) {
            return "Neither";
        }
        final String str5 = IP.substring(0, 6);
        if (str5.contains(".")) {
            final String[] strArray4 = IP.split("\\.");
            if (strArray4.length == 4 && IP.charAt(IP.length() - 1) != '.') {
                for (String str : strArray4) {
                    if (!isIpV4(str)) {
                        return "Neither";
                    }
                }
                return "IPv4";
            } else {
                return "Neither";
            }
        }
        if (str5.contains(":")) {
            final String[] strArray8 = IP.split(":");
            if (strArray8.length == 8 && IP.charAt(IP.length() - 1) != ':') {
                for (String str : strArray8) {
                    if (!isIpV6(str)) {
                        return "Neither";
                    }
                }
                return "IPv6";
            } else {
                return "Neither";
            }
        }
        return "Neither";
    }

    final String validIpV6String = "0123456789abcdefABCDEF";

    private boolean isIpV6(String str) {
        if (str.length() >= 1 && str.length() <= 4) {
            for (int index = 0; index < str.length(); index++) {
                if (!validIpV6String.contains(str.charAt(index) + "")) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    final String validIpV4String = "0123456789";

    private boolean isIpV4(String str) {
        if (str.length() >= 1 && str.length() <= 3) {
            for (int index = 0; index < str.length(); index++) {
                if (!validIpV4String.contains(str.charAt(index) + "")) {
                    return false;
                }
            }
            final int strInt = Integer.parseInt(str);
            if (strInt < 0 || strInt > 255) {
                return false;
            }
            if (str.charAt(0) == '0' && str.length() > 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final String str = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(str.split(":").length);
    }
}
