package hash_map_set;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem1396 {

    private final Map<Integer, StationTime> in = new HashMap<>();

    private final Map<String, int[]> times = new HashMap<>();

    public void checkIn(int id, String stationName, int t) {
        in.put(id, new StationTime(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        final StationTime stationTime = in.get(id);
        final String stations = stationTime.stationName + stationName;
        if (times.containsKey(stations)) {
            final int[] timeAndCount = times.get(stations);
            final int time = t - stationTime.time + timeAndCount[0];
            times.put(stations, new int[]{time, timeAndCount[1] + 1});
        } else {
            times.put(stations, new int[]{t - stationTime.time, 1});
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        final int[] timeAndCount = times.get(startStation + endStation);
        return timeAndCount[0] * 1.0 / timeAndCount[1];
    }


    static class StationTime {
        public String stationName;
        public int time;

        public StationTime(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
}
