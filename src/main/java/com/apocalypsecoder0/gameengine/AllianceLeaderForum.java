package com.apocalypsecoder0.gameengine;

import java.util.ArrayList;
import java.util.List;

public class AllianceLeaderForum {

    private String allianceName;
    private List<Topic> topics;
    private String adminAccount = "Forum Mod";

    public AllianceLeaderForum(String allianceName) {
        this.allianceName = allianceName;
        this.topics = new ArrayList<>();
    }

    // Method to post a new topic
    public void postTopic(String title, String message, String poster, boolean isLeader) {
        String posterRole = isLeader ? "[ALLIANCE_NAME] AL" : "[ALLIANCE_NAME] AAL";
        Topic newTopic = new Topic(title, message, posterRole);
        topics.add(newTopic);
        System.out.println("New topic posted by " + posterRole + ": " + title);
    }

    // Method to manage posts within a topic
    public void managePost(int topicIndex, int postIndex, String newMessage, boolean isAdmin) {
        if (isAdmin) {
            Topic topic = topics.get(topicIndex);
            topic.editPost(postIndex, newMessage);
            System.out.println("Post edited by admin.");
        } else {
            System.out.println("Only admin can edit posts.");
        }
    }

    // Method to delete a post
    public void deletePost(int topicIndex, int postIndex, boolean isAdmin) {
        if (isAdmin) {
            Topic topic = topics.get(topicIndex);
            topic.deletePost(postIndex);
            System.out.println("Post deleted by admin.");
        } else {
            System.out.println("Only admin can delete posts.");
        }
    }

    // Inner class to represent a forum topic
    private class Topic {
        private String title;
        private List<Post> posts;

        public Topic(String title, String initialMessage, String poster) {
            this.title = title;
            this.posts = new ArrayList<>();
            this.posts.add(new Post(initialMessage, poster));
        }

        public void editPost(int index, String newMessage) {
            if (index >= 0 && index < posts.size()) {
                posts.get(index).setMessage(newMessage);
            }
        }

        public void deletePost(int index) {
            if (index >= 0 && index < posts.size()) {
                posts.remove(index);
            }
        }
    }

    // Inner class to represent a post in a topic
    private class Post {
        private String message;
        private String poster;

        public Post(String message, String poster) {
            this.message = message;
            this.poster = poster;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
