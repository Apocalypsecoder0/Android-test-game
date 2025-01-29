package com.apocalypsecoder0.gameengine;

import java.util.Random;

public class InterstellarObject {

    private String name;
    private double size; // Size in kilometers
    private String composition; // Composition of the object, e.g., "rocky", "icy"
    private String trajectory; // Trajectory description, e.g., "elliptical", "parabolic"

    public InterstellarObject(String name, double size, String composition, String trajectory) {
        this.name = name;
        this.size = size;
        this.composition = composition;
        this.trajectory = trajectory;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public String getComposition() {
        return composition;
    }

    public String getTrajectory() {
        return trajectory;
    }

    public static InterstellarObject generateRandomInterstellarObject(Random random) {
        String[] names = {"Asteroid", "Comet", "Meteor", "Planetesimal"};
        String[] compositions = {"rocky", "icy", "metallic"};
        String[] trajectories = {"elliptical", "parabolic", "hyperbolic"};

        String name = names[random.nextInt(names.length)];
        double size = 0.1 + (1000 - 0.1) * random.nextDouble(); // Size between 0.1 and 1000 km
        String composition = compositions[random.nextInt(compositions.length)];
        String trajectory = trajectories[random.nextInt(trajectories.length)];

        return new InterstellarObject(name, size, composition, trajectory);
    }
}
