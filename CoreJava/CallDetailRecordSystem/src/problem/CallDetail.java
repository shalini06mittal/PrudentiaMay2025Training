package problem;

import java.time.Duration;
import java.time.LocalDateTime;


public class CallDetail  {
    String caller;
    String receiver;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String callType;

    public CallDetail(String caller, String receiver, LocalDateTime start, LocalDateTime end, String type) {
        this.caller = caller;
        this.receiver = receiver;
        this.startTime = start;
        this.endTime = end;
        this.callType = type;
    }

    public long getDurationInSeconds() {
        return Duration.between(startTime, endTime).getSeconds();
    }

    public int getStartHour() {
        return startTime.getHour();
    }

    @Override
    public String toString() {
        return caller + " -> " + receiver + " | " + callType + " | Duration: " + getDurationInSeconds() + "s";
    }

}
