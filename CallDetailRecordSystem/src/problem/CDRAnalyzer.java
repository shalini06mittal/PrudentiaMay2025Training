package problem;

import problem.CallDetail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    /**
     *
     * Complete all the below methods
     */


    static void printAllCalls(List<CallDetail> calls) {
        System.out.println("\n📞 All Call Records:");

    }

    static void printUserSummary(List<CallDetail> calls) {
        System.out.println("\n📊 User-wise Summary:");


    }

    static void printPeakUsageHours(List<CallDetail> calls) {
        System.out.println("\n⏰ Peak Usage Hours:");

    }

    static void printFrequentContacts(List<CallDetail> calls) {

    }

    static void detectFraud(List<CallDetail> calls) {
        System.out.println("\n🚨 Potential Fraud Detection:");

    }

}
