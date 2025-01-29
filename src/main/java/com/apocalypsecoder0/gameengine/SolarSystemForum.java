package com.apocalypsecoder0.gameengine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolarSystemForum {

    private List<Topic> topics;

    public SolarSystemForum() {
        this.topics = new ArrayList<>();
    }

    // Method to post a new topic
    public void postTopic(String topicName, String message, String kingdomName, String solarSystemPosition, boolean isSticky) {
        Topic newTopic = new Topic(topicName, message, kingdomName, solarSystemPosition, isSticky);
        topics.add(newTopic);
        System.out.println("New topic posted: " + topicName);
    }

    // Method to add a post to an existing topic
    public void addPost(int topicIndex, String message, String kingdomName, String solarSystemPosition) {
        if (topicIndex >= 0 && topicIndex < topics.size()) {
            Topic topic = topics.get(topicIndex);
            topic.addPost(message, kingdomName, solarSystemPosition);
            System.out.println("New post added to topic: " + topic.getTitle());
        } else {
            System.out.println("Invalid topic index.");
        }
    }

    // Method to view all topics
    public void viewTopics() {
        System.out.println("Topics in the forum:");
        for (Topic topic : topics) {
            System.out.println("Title: " + topic.getTitle() + ", Creator: " + topic.getOriginalPoster() +
                    ", Posts: " + topic.getNumberOfPosts() + ", Last Poster: " + topic.getLastPoster() +
                    ", Last Updated: " + topic.getLastUpdated());
        }
    }

    // Method to view details of a specific topic
    public void viewTopicDetails(int topicIndex) {
        if (topicIndex >= 0 && topicIndex < topics.size()) {
            Topic topic = topics.get(topicIndex);
            System.out.println("Viewing topic: " + topic.getTitle());
            for (Post post : topic.getPosts()) {
                System.out.println("Kingdom: " + post.getKingdomName() + ", Position: " + post.getSolarSystemPosition() +
                        ", Date: " + post.getDatePosted() + ", Message: " + post.getMessage() +
                        ", Ruler: " + post.getRulerName());
            }
        } else {
            System.out.println("Invalid topic index.");
        }
    }

    // Method to make a topic sticky
    public void makeSticky(int topicIndex) {
        if (topicIndex >= 0 && topicIndex < topics.size()) {
            Topic topic = topics.get(topicIndex);
            topic.setSticky(true);
            System.out.println("Topic made sticky: " + topic.getTitle());
        } else {
            System.out.println("Invalid topic index.");
        }
    }

    // Inner class to represent a forum topic
    private class Topic {
        private String title;
        private List<Post> posts;
        private String originalPoster;
        private String lastPoster;
        private Date lastUpdated;
        private boolean isSticky;

        public Topic(String title, String initialMessage, String kingdomName, String solarSystemPosition, boolean isSticky) {
            this.title = title;
            this.posts = new ArrayList<>();
            this.originalPoster = kingdomName;
            this.lastPoster = kingdomName;
            this.lastUpdated = new Date();
            this.isSticky = isSticky;
            addPost(initialMessage, kingdomName, solarSystemPosition);
        }

        public void addPost(String message, String kingdomName, String solarSystemPosition) {
            Post newPost = new Post(message, kingdomName, solarSystemPosition);
            posts.add(newPost);
            this.lastPoster = kingdomName;
            this.lastUpdated = new Date();
        }

        public String getTitle() {
            return title;
        }

        public String getOriginalPoster() {
            return originalPoster;
        }

        public String getLastPoster() {
            return lastPoster;
        }

        public Date getLastUpdated() {
            return lastUpdated;
        }

        public int getNumberOfPosts() {
            return posts.size();
        }

        public List<Post> getPosts() {
            return posts;
        }

        public void setSticky(boolean sticky) {
            isSticky = sticky;
        }
    }

    // Inner class to represent a post in a topic
    private class Post {
        private String message;
        private String kingdomName;
        private String solarSystemPosition;
        private Date datePosted;
        private String rulerName;

        public Post(String message, String kingdomName, String solarSystemPosition) {
            this.message = message;
            this.kingdomName = kingdomName;
            this.solarSystemPosition = solarSystemPosition;
            this.datePosted = new Date();
            this.rulerName = "Ruler"; // Placeholder for ruler name
        }

        public String getMessage() {
            return message;
        }

        public String getKingdomName() {
            return kingdomName;
        }

        public String getSolarSystemPosition() {
            return solarSystemPosition;
        }

        public Date getDatePosted() {
            return datePosted;
        }

        public String getRulerName() {
            return rulerName;
        }
    }
}
