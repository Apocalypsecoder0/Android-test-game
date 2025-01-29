package com.apocalypsecoder0.gameengine;

import java.util.HashMap;
import java.util.Map;

public class AccountControl {

    private Map<String, Account> accounts;

    public AccountControl() {
        this.accounts = new HashMap<>();
    }

    // Method to change kingdom details
    public boolean changeKingdomDetails(String accountId, String newKingdomName, String newRulerName) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.setKingdomName(newKingdomName);
            account.setRulerName(newRulerName);
            System.out.println("Kingdom details updated for account: " + accountId);
            return true;
        } else {
            System.out.println("Account not found.");
            return false;
        }
    }

    // Method to reset an account
    public boolean resetAccount(String accountId) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.reset();
            System.out.println("Account reset for account: " + accountId);
            return true;
        } else {
            System.out.println("Account not found.");
            return false;
        }
    }

    // Method to delete an account
    public boolean deleteAccount(String accountId) {
        if (accounts.containsKey(accountId)) {
            accounts.remove(accountId);
            System.out.println("Account deleted: " + accountId);
            return true;
        } else {
            System.out.println("Account not found.");
            return false;
        }
    }

    // Method to report a bug or cheater
    public void reportIssue(String accountId, String issueType, String description) {
        // Simulate reporting the issue
        System.out.println("Issue reported by account: " + accountId);
        System.out.println("Issue Type: " + issueType);
        System.out.println("Description: " + description);
        // Here you would typically log the issue or notify the relevant system
    }

    // Inner class to represent an Account
    private class Account {
        private String kingdomName;
        private String rulerName;

        public Account(String kingdomName, String rulerName) {
            this.kingdomName = kingdomName;
            this.rulerName = rulerName;
        }

        public void setKingdomName(String kingdomName) {
            this.kingdomName = kingdomName;
        }

        public void setRulerName(String rulerName) {
            this.rulerName = rulerName;
        }

        public void reset() {
            // Reset account details to default values
            this.kingdomName = "Default Kingdom";
            this.rulerName = "Default Ruler";
        }
    }
}
