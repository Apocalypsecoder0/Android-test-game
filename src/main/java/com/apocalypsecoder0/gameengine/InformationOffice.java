package com.apocalypsecoder0.gameengine;

import java.util.HashMap;
import java.util.Map;

public class InformationOffice {

    private Map<String, Integer> spyOperationsBasic;
    private Map<String, Integer> attackStatsBasic;
    private Map<String, Integer> planetSummaryBasic;
    private Map<String, Integer> wonderContributionsBasic;

    private Map<String, Integer> spyOperationsAdvanced;
    private Map<String, Integer> attackStatsAdvanced;
    private Map<String, Integer> planetSummaryAdvanced;
    private Map<String, Integer> missileMissionsAdvanced;
    private Map<String, Integer> wonderContributionsAdvanced;

    public InformationOffice() {
        // Initialize basic mode data
        spyOperationsBasic = new HashMap<>();
        attackStatsBasic = new HashMap<>();
        planetSummaryBasic = new HashMap<>();
        wonderContributionsBasic = new HashMap<>();

        // Initialize advanced mode data
        spyOperationsAdvanced = new HashMap<>();
        attackStatsAdvanced = new HashMap<>();
        planetSummaryAdvanced = new HashMap<>();
        missileMissionsAdvanced = new HashMap<>();
        wonderContributionsAdvanced = new HashMap<>();
    }

    // Basic Mode Methods
    public void updateSpyOperationsBasic(int missionsLaunched, int successfulMissions, int failedMissions, int moneyStolen, int moneyLost) {
        spyOperationsBasic.put("Total Missions Launched", missionsLaunched);
        spyOperationsBasic.put("Successful Missions", successfulMissions);
        spyOperationsBasic.put("Failed Missions", failedMissions);
        spyOperationsBasic.put("Total Money Stolen", moneyStolen);
        spyOperationsBasic.put("Total Money Lost", moneyLost);
    }

    public void updateAttackStatsBasic(int attacksLaunched, int successfulAttacks, int failedAttacks, int totalDefenses, int successfulDefenses, int failedDefenses) {
        attackStatsBasic.put("Total Attacks Launched", attacksLaunched);
        attackStatsBasic.put("Successful Attacks", successfulAttacks);
        attackStatsBasic.put("Failed Attacks", failedAttacks);
        attackStatsBasic.put("Total Defenses", totalDefenses);
        attackStatsBasic.put("Successful Defenses", successfulDefenses);
        attackStatsBasic.put("Failed Defenses", failedDefenses);
    }

    public void updatePlanetSummaryBasic(int landGainedCombat, int landGainedExploring, int landLostCombat, int homelessDeaths, int militaryDesertions) {
        planetSummaryBasic.put("Land Gained in Combat", landGainedCombat);
        planetSummaryBasic.put("Land Gained Exploring", landGainedExploring);
        planetSummaryBasic.put("Land Lost in Combat", landLostCombat);
        planetSummaryBasic.put("Homeless Deaths", homelessDeaths);
        planetSummaryBasic.put("Military Desertions", militaryDesertions);
    }

    public void updateWonderContributionsBasic(int moneyContributed, int powerContributed, int populationContributed) {
        wonderContributionsBasic.put("Total Money Contributed", moneyContributed);
        wonderContributionsBasic.put("Total Power Contributed", powerContributed);
        wonderContributionsBasic.put("Total Population Contributed", populationContributed);
    }

    // Advanced Mode Methods
    public void updateSpyOperationsAdvanced(int missionsLaunched, int successfulMissions, int failedMissions, int spiesPerAcre, int moneyStolen, int populationKidnapped, int buildingsDestroyed) {
        spyOperationsAdvanced.put("Total Missions Launched", missionsLaunched);
        spyOperationsAdvanced.put("Successful Missions", successfulMissions);
        spyOperationsAdvanced.put("Failed Missions", failedMissions);
        spyOperationsAdvanced.put("Spies Per Acre", spiesPerAcre);
        spyOperationsAdvanced.put("Money Stolen", moneyStolen);
        spyOperationsAdvanced.put("Population Kidnapped", populationKidnapped);
        spyOperationsAdvanced.put("Buildings Destroyed", buildingsDestroyed);
    }

    public void updateAttackStatsAdvanced(int attacksLaunched, int successfulAttacks, int failedAttacks, int largestLandGrab, int successfulAssaults, int successfulRaids, int successfulMassacres, int averageLandRatio) {
        attackStatsAdvanced.put("Total Attacks Launched", attacksLaunched);
        attackStatsAdvanced.put("Successful Attacks", successfulAttacks);
        attackStatsAdvanced.put("Failed Attacks", failedAttacks);
        attackStatsAdvanced.put("Largest Land Grab", largestLandGrab);
        attackStatsAdvanced.put("Successful Assaults", successfulAssaults);
        attackStatsAdvanced.put("Successful Raids", successfulRaids);
        attackStatsAdvanced.put("Successful Massacres", successfulMassacres);
        attackStatsAdvanced.put("Average Land Ratio", averageLandRatio);
    }

    public void updatePlanetSummaryAdvanced(int landGainedCombat, int landGainedExploring, int landLostCombat, int highestTotalLand, int highestTotalNW, int homelessDeaths, int militaryDesertions, int defensePerAcre, int offensePerAcre, int networthPerAcre, int populationPerAcre, int incomePerAcre) {
        planetSummaryAdvanced.put("Land Gained in Combat", landGainedCombat);
        planetSummaryAdvanced.put("Land Gained Exploring", landGainedExploring);
        planetSummaryAdvanced.put("Land Lost in Combat", landLostCombat);
        planetSummaryAdvanced.put("Highest Total Land", highestTotalLand);
        planetSummaryAdvanced.put("Highest Total NW", highestTotalNW);
        planetSummaryAdvanced.put("Homeless Deaths", homelessDeaths);
        planetSummaryAdvanced.put("Military Desertions", militaryDesertions);
        planetSummaryAdvanced.put("Defense Per Acre", defensePerAcre);
        planetSummaryAdvanced.put("Offense Per Acre", offensePerAcre);
        planetSummaryAdvanced.put("Networth Per Acre", networthPerAcre);
        planetSummaryAdvanced.put("Population Per Acre", populationPerAcre);
        planetSummaryAdvanced.put("Income Per Acre", incomePerAcre);
    }

    public void updateMissileMissionsAdvanced(int launchedByUs, int blockedByEnemyShields, int hitEnemy, int launchedAtUs, int blockedByOurShields, int hitsTaken) {
        missileMissionsAdvanced.put("Launched By Us", launchedByUs);
        missileMissionsAdvanced.put("Blocked By Enemy Shields", blockedByEnemyShields);
        missileMissionsAdvanced.put("Hit Enemy", hitEnemy);
        missileMissionsAdvanced.put("Launched At Us", launchedAtUs);
        missileMissionsAdvanced.put("Blocked By Our Shields", blockedByOurShields);
        missileMissionsAdvanced.put("Hits Taken", hitsTaken);
    }

    public void updateWonderContributionsAdvanced(int moneyContributed, int powerContributed, int populationContributed) {
        wonderContributionsAdvanced.put("Total Money Contributed", moneyContributed);
        wonderContributionsAdvanced.put("Total Power Contributed", powerContributed);
        wonderContributionsAdvanced.put("Total Population Contributed", populationContributed);
    }
}
