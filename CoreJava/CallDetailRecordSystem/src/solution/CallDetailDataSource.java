package solution;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CallDetailDataSource {

    ArrayList<CallDetail> details = new ArrayList<>();

    public CallDetailDataSource(){
        details.add(new CallDetail("9876543210","9123456789",
                LocalDateTime.parse("2025-05-01T10:00:00"),
                LocalDateTime.parse("2025-05-01T10:05:30"),
                "Voice"));
        details.add(new CallDetail("9876543210","9988776655",
                LocalDateTime.parse("2025-05-01T11:00:00"),
                LocalDateTime.parse("2025-05-01T11:01:00"),
                "SMS"));
        details.add(new CallDetail("9123456789","9876543210",
                LocalDateTime.parse("2025-05-01T15:30:00"),
                LocalDateTime.parse("2025-05-01T15:50:00"),
                "Voice"));
        details.add(new CallDetail("9988776655","9876543210",
                LocalDateTime.parse("2025-05-02T09:00:00"),
                LocalDateTime.parse("2025-05-02T10:00:00"),
                "Voice"));
    }

    public ArrayList<CallDetail> getDetails() {
        return details;
    }
}
