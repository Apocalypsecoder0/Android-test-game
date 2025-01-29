package com.apocalypsecoder0.gameengine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllianceControlCenter {

    private String alliancePassword;
    private String allianceLeader;
    private Map<String, String> systemRoles = new HashMap<>();
    private Map<String, Boolean> bannedUsers = new HashMap<>();

    public AllianceControlCenter(String allianceLeader, String alliancePassword) {
        this.allianceLeader = allianceLeader;
        this.alliancePassword = alliancePassword;
    }

    // Method to assign roles within the alliance
    public void assignRole(String system, String kingdom, String role) {
        if (!systemRoles.containsKey(system)) {
            systemRoles.put(system, kingdom + ":" + role);
            System.out.println("Assigned " + role + " to " + kingdom + " in system " + system);
        } else {
            System.out.println("Role already assigned in this system.");
        }
    }

    // Method to remove a system from the alliance
    public void removeSystem(String system) {
        if (systemRoles.containsKey(system)) {
            systemRoles.remove(system);
            System.out.println("System " + system + " removed from the alliance.");
        } else {
            System.out.println("System not found in the alliance.");
        }
    }

    // Method to change the alliance password
    public boolean changePassword(String oldPassword, String newPassword, String confirmPassword) {
        if (alliancePassword.equals(oldPassword) && newPassword.equals(confirmPassword)) {
            alliancePassword = newPassword;
            System.out.println("Alliance password changed successfully.");
            return true;
        } else {
            System.out.println("Password change failed. Please check the entered passwords.");
            return false;
        }
    }

    // Method to delete the alliance
    public boolean deleteAlliance(String password) {
        if (alliancePassword.equals(password)) {
            System.out.println("Alliance deleted successfully.");
            return true;
        } else {
            System.out.println("Failed to delete alliance. Incorrect password.");
            return false;
        }
    }

    // Method to transfer alliance leadership
    public boolean transferLeadership(String currentPassword, String newLeader) {
        if (alliancePassword.equals(currentPassword)) {
            allianceLeader = newLeader;
            System.out.println("Alliance leadership transferred to " + newLeader);
            return true;
        } else {
            System.out.println("Leadership transfer failed. Incorrect password.");
            return false;
        }
    }

    // Method to view solar system news
    public void viewSolarSystemNews(List<String> solarSystems) {
        System.out.println("Viewing solar system news for the following systems:");
        for (String system : solarSystems) {
            System.out.println("News for system: " + system);
        }
    }

    // Method to ban users from posting in the alliance forum
    public void banUser(String username, int hours) {
        if (hours <= 72) {
            bannedUsers.put(username, true);
            System.out.println("User " + username + " banned for " + hours + " hours.");
        } else {
            System.out.println("Ban duration exceeds maximum allowed time.");
        }
    }

    // Method to unban users
    public void unbanUser(String username) {
        if (bannedUsers.containsKey(username)) {
            bannedUsers.remove(username);
            System.out.println("User " + username + " has been unbanned.");
        } else {
            System.out.println("User " + username + " is not currently banned.");
        }
    }
}
