package easy_easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        final Map<String, Integer> map = new HashMap<>();
        for (String cp : cpdomains) {
            final String[] countAndDomain = cp.split("\\s");
            final int count = Integer.parseInt(countAndDomain[0]);
            String domain = countAndDomain[1];
            map.put(domain, count + map.getOrDefault(domain, 0));
            while (domain.indexOf('.') != -1) {
                domain = domain.substring(domain.indexOf('.') + 1);
                map.put(domain, count + map.getOrDefault(domain, 0));
            }
        }
        final List<String> results = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            results.add(entry.getValue() + " " + entry.getKey());
        }
        return results;
    }
}
