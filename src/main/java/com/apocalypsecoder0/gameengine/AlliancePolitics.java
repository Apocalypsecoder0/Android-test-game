package com.apocalypsecoder0.gameengine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AlliancePolitics {

    private Map<String, Alliance> alliances = new HashMap<>();
    private Map<String, String> systemLeaders = new HashMap<>();

    public AlliancePolitics() {
        // Initialize with some default alliances for demonstration
        alliances.put("Alpha", new Alliance("Alpha", "alpha123", 5));
        alliances.put("Beta", new Alliance("Beta", "beta123", 3));
    }

    // Method to join an alliance
    public boolean joinAlliance(String systemName, String allianceName, String alliancePassword) {
        if (systemLeaders.containsKey(systemName)) {
            System.out.println("System is already part of another alliance.");
            return false;
        }

        Alliance alliance = alliances.get(allianceName);
        if (alliance != null && alliance.getPassword().equals(alliancePassword)) {
            if (alliance.getSystems().size() < alliance.getMaxSystems()) {
                alliance.addSystem(systemName);
                systemLeaders.put(systemName, allianceName);
                System.out.println("System " + systemName + " joined alliance " + allianceName);
                return true;
            } else {
                System.out.println("Alliance is full.");
            }
        } else {
            System.out.println("Invalid alliance name or password.");
        }
        return false;
    }

    // Method to create a new alliance
    public boolean createAlliance(String allianceName, String alliancePassword, int maxSystems) {
        if (!alliances.containsKey(allianceName)) {
            alliances.put(allianceName, new Alliance(allianceName, alliancePassword, maxSystems));
            System.out.println("Alliance " + allianceName + " created successfully.");
            return true;
        } else {
            System.out.println("Alliance name already exists.");
        }
        return false;
    }

    // Method to access alliance information
    public void accessAllianceInformation() {
        System.out.println("Alliances with more than one system:");
        for (Alliance alliance : alliances.values()) {
            if (alliance.getSystems().size() > 1) {
                System.out.println("Alliance: " + alliance.getName() + ", Systems: " + alliance.getSystems());
            }
        }
    }

    // Inner class to represent an Alliance
    private class Alliance {
        private String name;
        private String password;
        private int maxSystems;
        private Set<String> systems;

        public Alliance(String name, String password, int maxSystems) {
            this.name = name;
            this.password = password;
            this.maxSystems = maxSystems;
            this.systems = new java.util.HashSet<>();
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        public int getMaxSystems() {
            return maxSystems;
        }

        public Set<String> getSystems() {
            return systems;
        }

        public void addSystem(String systemName) {
            systems.add(systemName);
        }
    }
}
