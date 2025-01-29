package com.apocalypsecoder0.gameengine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AdminSignup {

    private Map<String, AdminAccount> adminAccounts;
    private static final String SYSTEM_COORDINATE = "29:29"; // Example system coordinate for admins
    private boolean signupsOpen;

    public AdminSignup(boolean signupsOpen) {
        this.adminAccounts = new HashMap<>();
        this.signupsOpen = signupsOpen;
    }

    // Method to handle secure signup
    public boolean secureSignup(String username, String password, String confirmPassword, String imageVerification) {
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");
            return false;
        }
        if (!verifyImage(imageVerification)) {
            System.out.println("Image verification failed.");
            return false;
        }
        if (adminAccounts.containsKey(username)) {
            System.out.println("Username already exists.");
            return false;
        }
        createAdminAccount(username, password);
        System.out.println("Admin account created successfully.");
        return true;
    }

    // Method to verify image (simulated for demonstration)
    private boolean verifyImage(String imageVerification) {
        // Simulate image verification logic
        return imageVerification.equals("verified");
    }

    // Method to create an admin account
    private void createAdminAccount(String username, String password) {
        AdminAccount newAdmin = new AdminAccount(username, password, SYSTEM_COORDINATE);
        adminAccounts.put(username, newAdmin);
    }

    // Inner class to represent an Admin Account
    private class AdminAccount {
        private String username;
        private String password;
        private String systemCoordinate;

        public AdminAccount(String username, String password, String systemCoordinate) {
            this.username = username;
            this.password = password;
            this.systemCoordinate = systemCoordinate;
        }

        public String getUsername() {
            return username;
        }

        public String getSystemCoordinate() {
            return systemCoordinate;
        }
    }

    // Method to check if signups are open
    public boolean areSignupsOpen() {
        return signupsOpen;
    }

    // Method to toggle signups
    public void toggleSignups() {
        signupsOpen = !signupsOpen;
        System.out.println("Signups are now " + (signupsOpen ? "open." : "closed."));
    }
}
