package com.apocalypsecoder0.gameengine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Planet {

    private String name;
    private int size;
    private int type;
    private List<Biome> biomes;

    public Planet(String name, int size, int type, List<Biome> biomes) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.biomes = biomes;
    }

    public static Planet generateRandomPlanet(Random random) {
        String name = generateRandomName(random);
        int size = random.nextInt(1000) + 1; // Size between 1 and 1000
        int type = random.nextInt(5); // Assuming 5 different types
        List<Biome> biomes = generateRandomBiomes(random);
        return new Planet(name, size, type, biomes);
    }

    private static String generateRandomName(Random random) {
        String[] nameParts = {"Aqua", "Terra", "Luna", "Sol", "Nova"};
        return nameParts[random.nextInt(nameParts.length)] + "-" + random.nextInt(1000);
    }

    private static List<Biome> generateRandomBiomes(Random random) {
        List<Biome> biomes = new ArrayList<>();
        Biome[] allBiomes = Biome.values();
        int numberOfBiomes = random.nextInt(allBiomes.length) + 1; // At least one biome
        for (int i = 0; i < numberOfBiomes; i++) {
            biomes.add(allBiomes[random.nextInt(allBiomes.length)]);
        }
        return biomes;
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

    public List<Biome> getBiomes() {
        return biomes;
    }

    public enum Biome {
        DESERT, FOREST, OCEAN, MOUNTAIN, PLAINS
    }
}
