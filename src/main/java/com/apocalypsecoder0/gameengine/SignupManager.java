package com.apocalypsecoder0.gameengine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SignupManager {

    private int numberOfGalaxies;
    private int systemsPerGalaxy;
    private int planetsPerSystem;
    private int groupSize;
    private int allianceSizeLimit;
    private Map<String, User> users;
    private Map<String, Group> groups;
    private boolean signupsOpen;

    public SignupManager(int numberOfGalaxies, int systemsPerGalaxy, int planetsPerSystem, int groupSize, int allianceSizeLimit, boolean signupsOpen) {
        this.numberOfGalaxies = numberOfGalaxies;
        this.systemsPerGalaxy = systemsPerGalaxy;
        this.planetsPerSystem = planetsPerSystem;
        this.groupSize = groupSize;
        this.allianceSizeLimit = allianceSizeLimit;
        this.users = new HashMap<>();
        this.groups = new HashMap<>();
        this.signupsOpen = signupsOpen;
    }

    public boolean signupUser(String username, String password, String confirmPassword, String email, String confirmEmail, String kingdomName, String rulerName, String rulerTitle, String kingdomType, String personalityType, boolean agreeToRules, boolean onlyAccount, boolean inGroup, boolean randomSignup) {
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");
            return false;
        }
        if (!email.equals(confirmEmail)) {
            System.out.println("Emails do not match.");
            return false;
        }
        if (!agreeToRules) {
            System.out.println("You must agree to the rules.");
            return false;
        }
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return false;
        }
        String systemAssignment = assignSystem(email, inGroup, randomSignup);
        if (systemAssignment == null) {
            System.out.println("System assignment failed.");
            return false;
        }
        User newUser = new User(username, password, email, kingdomName, rulerName, rulerTitle, kingdomType, personalityType, systemAssignment);
        users.put(username, newUser);
        System.out.println("User signed up successfully.");
        return true;
    }

    private String assignSystem(String email, boolean inGroup, boolean randomSignup) {
        if (inGroup) {
            Group group = findGroupByEmail(email);
            if (group != null) {
                return group.getAssignedSystem();
            }
        }
        if (randomSignup) {
            return assignRandomSystem();
        }
        return null;
    }

    private Group findGroupByEmail(String email) {
        for (Group group : groups.values()) {
            if (group.hasMember(email)) {
                return group;
            }
        }
        return null;
    }

    private String assignRandomSystem() {
        Random random = new Random();
        int galaxy = random.nextInt(numberOfGalaxies) + 1;
        int system = random.nextInt(systemsPerGalaxy) + 1;
        return galaxy + ":" + system;
    }

    public void createGroup(String groupName, String[] memberEmails) {
        if (!signupsOpen) {
            System.out.println("Group creation is closed as game signups have begun.");
            return;
        }
        if (!groups.containsKey(groupName)) {
            Group newGroup = new Group(groupName, memberEmails);
            groups.put(groupName, newGroup);
            System.out.println("Group " + groupName + " created successfully.");
        } else {
            System.out.println("Group name already exists.");
        }
    }

    private class User {
        private String username;
        private String password;
        private String email;
        private String kingdomName;
        private String rulerName;
        private String rulerTitle;
        private String kingdomType;
        private String personalityType;
        private String systemAssignment;

        public User(String username, String password, String email, String kingdomName, String rulerName, String rulerTitle, String kingdomType, String personalityType, String systemAssignment) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.kingdomName = kingdomName;
            this.rulerName = rulerName;
            this.rulerTitle = rulerTitle;
            this.kingdomType = kingdomType;
            this.personalityType = personalityType;
            this.systemAssignment = systemAssignment;
        }
    }

    private class Group {
        private String name;
        private String[] memberEmails;
        private String assignedSystem;

        public Group(String name, String[] memberEmails) {
            this.name = name;
            this.memberEmails = memberEmails;
            this.assignedSystem = assignRandomSystem();
        }

        public boolean hasMember(String email) {
            for (String memberEmail : memberEmails) {
                if (memberEmail.equals(email)) {
                    return true;
                }
            }
            return false;
        }

        public String getAssignedSystem() {
            return assignedSystem;
        }
    }
}
