package string_integer;

public class AngleBetweenHandsofaClock1344 {
    public double angleClock(int hour, int minutes) {
        final int baseHour = hour == 12 ? 0 : 30 * hour;
        final double hourVal = minutes / 2.0 + baseHour;
        final double minuteVal = minutes * 6.0;
        final double result = Math.abs(hourVal - minuteVal);
        return result > 180 ? 360 - result : result;
    }
}
