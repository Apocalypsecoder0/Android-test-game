package com.apocalypsecoder0.gameengine;

public class NetWorthCalculator {

    // Constants for net worth calculation
    private static final int LAND_VALUE = 50;
    private static final int BUILDING_VALUE = 100;
    private static final int MILITARY_UNIT_VALUE = 10;
    private static final int SCIENTIST_VALUE = 20;
    private static final int POPULATION_VALUE = 1;
    private static final int MONEY_VALUE = 1;
    private static final int SPY_VALUE = 15;
    private static final int POWER_VALUE = 5;
    private static final int MISSILE_VALUE = 200;

    // Method to calculate net worth from land
    public int calculateLandNetWorth(int land) {
        return land * LAND_VALUE;
    }

    // Method to calculate net worth from buildings
    public int calculateBuildingNetWorth(int buildings) {
        return buildings * BUILDING_VALUE;
    }

    // Method to calculate net worth from military units
    public int calculateMilitaryNetWorth(int militaryUnits) {
        return militaryUnits * MILITARY_UNIT_VALUE;
    }

    // Method to calculate net worth from scientists
    public int calculateScientistNetWorth(int scientists) {
        return scientists * SCIENTIST_VALUE;
    }

    // Method to calculate net worth from population
    public int calculatePopulationNetWorth(int population) {
        return population * POPULATION_VALUE;
    }

    // Method to calculate net worth from money
    public int calculateMoneyNetWorth(int money) {
        return money * MONEY_VALUE;
    }

    // Method to calculate net worth from spies
    public int calculateSpyNetWorth(int spies) {
        return spies * SPY_VALUE;
    }

    // Method to calculate net worth from power
    public int calculatePowerNetWorth(int power) {
        return power * POWER_VALUE;
    }

    // Method to calculate net worth from missiles
    public int calculateMissileNetWorth(int missiles) {
        return missiles * MISSILE_VALUE;
    }

    // Method to calculate total net worth
    public int calculateTotalNetWorth(int land, int buildings, int militaryUnits, int scientists, int population, int money, int spies, int power, int missiles) {
        int totalNetWorth = 0;
        totalNetWorth += calculateLandNetWorth(land);
        totalNetWorth += calculateBuildingNetWorth(buildings);
        totalNetWorth += calculateMilitaryNetWorth(militaryUnits);
        totalNetWorth += calculateScientistNetWorth(scientists);
        totalNetWorth += calculatePopulationNetWorth(population);
        totalNetWorth += calculateMoneyNetWorth(money);
        totalNetWorth += calculateSpyNetWorth(spies);
        totalNetWorth += calculatePowerNetWorth(power);
        totalNetWorth += calculateMissileNetWorth(missiles);
        return totalNetWorth;
    }
}
