package solution;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class CDRAnalyzer {
    public static void main(String[] args) throws FileNotFoundException {

        CallDetailDataSource detailDataSource = new CallDetailDataSource();
        List<CallDetail> callLogs = detailDataSource.getDetails();//readCallDetails(filePath);
        printAllCalls(callLogs);
        printUserSummary(callLogs);
        printPeakUsageHours(callLogs);
        printFrequentContacts(callLogs);
        detectFraud(callLogs);
    }


    static void printAllCalls(List<CallDetail> calls) {
        System.out.println("\n📞 All Call Records:");
        for (CallDetail c : calls) {
            System.out.println(c);
        }

    }

    static void printUserSummary(List<CallDetail> calls) {
        System.out.println("\n📊 User-wise Summary:");
        Map<String, Map<String, Integer>> userStats = new HashMap<>();

        for (CallDetail c : calls) {
            userStats.putIfAbsent(c.caller, new HashMap<>());
            Map<String, Integer> stat = userStats.get(c.caller);
            stat.put(c.callType, stat.getOrDefault(c.callType, 0) + 1);
        }

        for (String user : userStats.keySet()) {
            System.out.println("User: " + user + " -> " + userStats.get(user));
        }
    }

    static void printPeakUsageHours(List<CallDetail> calls) {
        System.out.println("\n⏰ Peak Usage Hours:");
        Map<Integer, Integer> hourCount = new TreeMap<>();

        for (CallDetail c : calls) {
            int hour = c.getStartHour();
            hourCount.put(hour, hourCount.getOrDefault(hour, 0) + 1);
        }

        int peakHour = Collections.max(hourCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most active hour: " + peakHour + ":00 - " + (peakHour + 1) + ":00");
    }

    static void printFrequentContacts(List<CallDetail> calls) {
        System.out.println("\n👥 Frequent Contacts per User:");
        Map<String, Map<String, Integer>> contactMap = new HashMap<>();

        for (CallDetail c : calls) {
            contactMap.putIfAbsent(c.caller, new HashMap<>());
            Map<String, Integer> freqMap = contactMap.get(c.caller);
            freqMap.put(c.receiver, freqMap.getOrDefault(c.receiver, 0) + 1);
        }

        for (String user : contactMap.keySet()) {
            Map.Entry<String, Integer> topContact = Collections.max(
                    contactMap.get(user).entrySet(),
                    Map.Entry.comparingByValue()
            );
            System.out.println("User: " + user + " → Most Contacted: " + topContact.getKey() + " (" + topContact.getValue() + " times)");
        }
    }

    static void detectFraud(List<CallDetail> calls) {
        System.out.println("\n🚨 Potential Fraud Detection:");
        for (CallDetail c : calls) {
            if (c.getDurationInSeconds() > 3600) {
                System.out.println("⚠️ Long Call Detected: " + c);
            }
        }

        // Detect rapid-fire calls (e.g., > 3 calls in same minute)
        Map<String, List<LocalDateTime>> userCallTimes = new HashMap<>();
        for (CallDetail c : calls) {
            userCallTimes.putIfAbsent(c.caller, new ArrayList<>());
            userCallTimes.get(c.caller).add(c.startTime);
        }

        for (String user : userCallTimes.keySet()) {
            List<LocalDateTime> times = userCallTimes.get(user);
            Collections.sort(times);

            for (int i = 0; i < times.size() - 3; i++) {
                long seconds = Duration.between(times.get(i), times.get(i + 3)).getSeconds();
                if (seconds <= 60) {
                    System.out.println("⚠️ Rapid-fire calls by " + user + " between " + times.get(i) + " and " + times.get(i + 3));
                    break;
                }
            }
        }
    }

}
