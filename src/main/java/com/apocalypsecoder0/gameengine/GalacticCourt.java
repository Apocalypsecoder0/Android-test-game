package com.apocalypsecoder0.gameengine;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GalacticCourt {

    private Set<String> badWords;
    private Map<String, List<String>> bugReports;
    private Map<String, List<String>> cheatingReports;
    private Map<String, List<String>> ipLogs;
    private Map<String, String> kingdomNews;

    public GalacticCourt() {
        this.badWords = new HashSet<>(Arrays.asList("badword1", "badword2")); // Example bad words
        this.bugReports = new HashMap<>();
        this.cheatingReports = new HashMap<>();
        this.ipLogs = new HashMap<>();
        this.kingdomNews = new HashMap<>();
    }

    // Method to handle profanity
    public String handleProfanity(String message) {
        for (String badWord : badWords) {
            Pattern pattern = Pattern.compile(badWord, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                message = matcher.replaceAll("****");
                // Flag the message in the database (simulated here)
                System.out.println("Profanity detected and flagged.");
            }
        }
        return message;
    }

    // Method to add a bug report
    public void addBugReport(String user, String report) {
        bugReports.computeIfAbsent(user, k -> new ArrayList<>()).add(report);
        System.out.println("Bug report added for user: " + user);
    }

    // Method to view bug reports
    public void viewBugReports() {
        System.out.println("Viewing all bug reports:");
        for (Map.Entry<String, List<String>> entry : bugReports.entrySet()) {
            System.out.println("User: " + entry.getKey() + ", Reports: " + entry.getValue());
        }
    }

    // Method to add a cheating report
    public void addCheatingReport(String user, String report) {
        cheatingReports.computeIfAbsent(user, k -> new ArrayList<>()).add(report);
        System.out.println("Cheating report added for user: " + user);
    }

    // Method to view cheating reports
    public void viewCheatingReports() {
        System.out.println("Viewing all cheating reports:");
        for (Map.Entry<String, List<String>> entry : cheatingReports.entrySet()) {
            System.out.println("User: " + entry.getKey() + ", Reports: " + entry.getValue());
        }
    }

    // Method to log IP addresses
    public void logIpAddress(String user, String ipAddress) {
        ipLogs.computeIfAbsent(user, k -> new ArrayList<>()).add(ipAddress);
        System.out.println("IP address logged for user: " + user);
    }

    // Method to detect similar IPs
    public void detectSimilarIps() {
        System.out.println("Detecting accounts with similar IPs:");
        Map<String, Set<String>> ipToUsers = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : ipLogs.entrySet()) {
            for (String ip : entry.getValue()) {
                ipToUsers.computeIfAbsent(ip, k -> new HashSet<>()).add(entry.getKey());
            }
        }
        for (Map.Entry<String, Set<String>> entry : ipToUsers.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("IP: " + entry.getKey() + ", Users: " + entry.getValue());
            }
        }
    }

    // Method to view kingdom news
    public void viewKingdomNews(String planetName) {
        String news = kingdomNews.getOrDefault(planetName, "No news available for this planet.");
        System.out.println("Kingdom news for " + planetName + ": " + news);
    }

    // Simulate periodic cleanup of reports
    public void cleanupReports() {
        // Logic to remove reports older than 5 days
        System.out.println("Cleaning up old reports...");
    }
}
