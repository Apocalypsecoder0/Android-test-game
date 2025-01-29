package com.apocalypsecoder0.gameengine;

import java.util.Random;

public class Biome {

    private String name;
    private String temperatureRange;
    private String precipitationLevel;
    private String dominantFlora;

    public Biome(String name, String temperatureRange, String precipitationLevel, String dominantFlora) {
        this.name = name;
        this.temperatureRange = temperatureRange;
        this.precipitationLevel = precipitationLevel;
        this.dominantFlora = dominantFlora;
    }

    public String getName() {
        return name;
    }

    public String getTemperatureRange() {
        return temperatureRange;
    }

    public String getPrecipitationLevel() {
        return precipitationLevel;
    }

    public String getDominantFlora() {
        return dominantFlora;
    }

    public static Biome generateRandomBiome(Random random) {
        String[] names = {"Desert", "Forest", "Ocean", "Mountain", "Plains"};
        String[] temperatureRanges = {"Hot", "Temperate", "Cold"};
        String[] precipitationLevels = {"Low", "Moderate", "High"};
        String[] dominantFloras = {"Cacti", "Trees", "Seaweed", "Shrubs", "Grass"};

        String name = names[random.nextInt(names.length)];
        String temperatureRange = temperatureRanges[random.nextInt(temperatureRanges.length)];
        String precipitationLevel = precipitationLevels[random.nextInt(precipitationLevels.length)];
        String dominantFlora = dominantFloras[random.nextInt(dominantFloras.length)];

        return new Biome(name, temperatureRange, precipitationLevel, dominantFlora);
    }
}
