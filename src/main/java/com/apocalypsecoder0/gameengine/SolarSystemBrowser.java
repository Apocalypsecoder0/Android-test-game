package com.apocalypsecoder0.gameengine;

import java.util.HashMap;
import java.util.Map;

public class SolarSystemBrowser {

    private int currentGalaxy;
    private int currentSolarSystem;
    private Map<String, SolarSystem> universe;

    public SolarSystemBrowser() {
        this.universe = new HashMap<>();
        // Initialize with some default data for demonstration
        universe.put("1:1", new SolarSystem("Alpha", "Alliance A", "Peace Treaty", "Welcome to Alpha System"));
        universe.put("1:2", new SolarSystem("Beta", "Alliance B", "Trade Agreement", "Welcome to Beta System"));
    }

    // Method to set the current galaxy and solar system
    public void setCurrentLocation(int galaxy, int solarSystem) {
        this.currentGalaxy = galaxy;
        this.currentSolarSystem = solarSystem;
        System.out.println("Current location set to Galaxy: " + galaxy + ", Solar System: " + solarSystem);
    }

    // Method to get the current galaxy and solar system
    public String getCurrentLocation() {
        return currentGalaxy + ":" + currentSolarSystem;
    }

    // Method to view details of the current solar system
    public void viewSystemDetails() {
        String location = getCurrentLocation();
        SolarSystem system = universe.get(location);
        if (system != null) {
            System.out.println("Solar System Name: " + system.getName());
            System.out.println("Alliance: " + system.getAlliance());
            System.out.println("Announcements: " + system.getAnnouncements());
            System.out.println("Treaties: " + system.getTreaties());
        } else {
            System.out.println("No details available for the current location.");
        }
    }

    // Method to interact with kingdoms in the current solar system
    public void interactWithKingdom(String kingdomName, String action) {
        // Simulate interaction logic
        System.out.println("Performing action: " + action + " on kingdom: " + kingdomName);
    }

    // Inner class to represent a Solar System
    private class SolarSystem {
        private String name;
        private String alliance;
        private String treaties;
        private String announcements;

        public SolarSystem(String name, String alliance, String treaties, String announcements) {
            this.name = name;
            this.alliance = alliance;
            this.treaties = treaties;
            this.announcements = announcements;
        }

        public String getName() {
            return name;
        }

        public String getAlliance() {
            return alliance;
        }

        public String getTreaties() {
            return treaties;
        }

        public String getAnnouncements() {
            return announcements;
        }
    }

    public static void main(String[] args) {
        SolarSystemBrowser browser = new SolarSystemBrowser();
        browser.setCurrentLocation(1, 1);
        browser.viewSystemDetails();
        browser.interactWithKingdom("Kingdom1", "Message");
    }
}
