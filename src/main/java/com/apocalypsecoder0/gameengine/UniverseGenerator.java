package com.apocalypsecoder0.gameengine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UniverseGenerator {

    private long seed;
    private Random random;
    private List<Galaxy> galaxies;

    public UniverseGenerator(long seed) {
        this.seed = seed;
        this.random = new Random(seed);
        this.galaxies = new ArrayList<>();
    }

    public void generateUniverse(int numberOfGalaxies, int planetsPerGalaxy) {
        generateGalaxies(numberOfGalaxies, planetsPerGalaxy);
    }

    private void generateGalaxies(int numberOfGalaxies, int planetsPerGalaxy) {
        for (int i = 0; i < numberOfGalaxies; i++) {
            Galaxy galaxy = new Galaxy("Galaxy-" + i);
            galaxy.generatePlanets(planetsPerGalaxy, random);
            galaxies.add(galaxy);
        }
    }

    public List<Galaxy> getGalaxies() {
        return galaxies;
    }

    // Inner class to represent a Galaxy
    class Galaxy {
        private String name;
        private List<Planet> planets;

        public Galaxy(String name) {
            this.name = name;
            this.planets = new ArrayList<>();
        }

        public void generatePlanets(int numberOfPlanets, Random random) {
            for (int i = 0; i < numberOfPlanets; i++) {
                String planetName = "Planet-" + i;
                Planet planet = new Planet(planetName, random.nextInt(1000), random.nextInt(1000));
                planets.add(planet);
            }
        }

        public List<Planet> getPlanets() {
            return planets;
        }
    }

    // Inner class to represent a Planet
    class Planet {
        private String name;
        private int size;
        private int type;

        public Planet(String name, int size, int type) {
            this.name = name;
            this.size = size;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        public int getType() {
            return type;
        }
    }
}
