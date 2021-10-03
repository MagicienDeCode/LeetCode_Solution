package not_categorized_easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses929 {
    public int numUniqueEmails(String[] emails) {
        final Set<String> normalized = new HashSet<>();
        for (String mail : emails) {
            final String[] splits = mail.split("@");
            final String local = splits[0].split("\\+")[0].replace(".", "");
            normalized.add(local + "@" + splits[1]);
        }
        return normalized.size();
    }
}
