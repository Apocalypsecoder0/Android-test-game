package com.apocalypsecoder0.gameengine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroupManager {

    private Map<String, Group> groups = new HashMap<>();
    private boolean signupsOpen = true; // This flag indicates if signups are open

    // Method to create a new group
    public boolean createGroup(String groupName, int maxMembers) {
        if (!signupsOpen) {
            System.out.println("Group creation is closed as game signups have begun.");
            return false;
        }
        if (!groups.containsKey(groupName)) {
            groups.put(groupName, new Group(groupName, maxMembers));
            System.out.println("Group " + groupName + " created successfully.");
            return true;
        } else {
            System.out.println("Group name already exists.");
            return false;
        }
    }

    // Method to join an existing group
    public boolean joinGroup(String groupName, String memberName) {
        Group group = groups.get(groupName);
        if (group != null) {
            if (group.addMember(memberName)) {
                System.out.println("Member " + memberName + " joined group " + groupName);
                return true;
            } else {
                System.out.println("Group " + groupName + " is full or member already exists.");
            }
        } else {
            System.out.println("Group " + groupName + " does not exist.");
        }
        return false;
    }

    // Method to close signups
    public void closeSignups() {
        signupsOpen = false;
        System.out.println("Signups are now closed.");
    }

    // Inner class to represent a Group
    private class Group {
        private String name;
        private int maxMembers;
        private Set<String> members;

        public Group(String name, int maxMembers) {
            this.name = name;
            this.maxMembers = maxMembers;
            this.members = new HashSet<>();
        }

        public boolean addMember(String memberName) {
            if (members.size() < maxMembers && !members.contains(memberName)) {
                members.add(memberName);
                return true;
            }
            return false;
        }
    }
}
