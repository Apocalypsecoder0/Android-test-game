package com.apocalypsecoder0.gameengine;

/**
 * The GameStatements class provides a centralized location for managing
 * game constants and settings. This includes default values and static
 * information that needs to be accessed globally throughout the game.
 * By centralizing these constants, we improve code maintainability and
 * readability.
 */
public class GameStatements {

    // Game settings
    public static final int FRAME_RATE = 60; // Frames per second
    public static final int MAX_PLAYERS = 4; // Maximum number of players in a game
    public static final int DEFAULT_PLAYER_HEALTH = 100; // Default health for a player
    public static final int DEFAULT_PLAYER_SCORE = 0; // Default score for a player

    // Game environment settings
    public static final int WORLD_WIDTH = 800; // Width of the game world
    public static final int WORLD_HEIGHT = 600; // Height of the game world

    // Game resource paths
    public static final String TEXTURE_PATH = "assets/textures/"; // Path to texture assets
    public static final String SOUND_PATH = "assets/sounds/"; // Path to sound assets

    // Resource types
    public static final String RESOURCE_METAL = "Metal";
    public static final String RESOURCE_CRYSTAL = "Crystal";
    public static final String RESOURCE_DEUTERIUM = "Deuterium";
    public static final String RESOURCE_DARK_MATTER = "Dark Matter";
    public static final String RESOURCE_ANTIMATTER = "Antimatter";
    // Fleet actions
    public static final String FLEET_ACTION_ATTACK = "Attack";
    public static final String FLEET_ACTION_DEFEND = "Defend";
    public static final String FLEET_ACTION_TRANSPORT = "Transport";
    public static final String FLEET_ACTION_EXPLORE = "Explore";
    public static final String FLEET_ACTION_COLONIZE = "Colonize";
    // Research categories
    public static final String RESEARCH_ENERGY = "Energy";
    public static final String RESEARCH_LASER = "Laser";
    public static final String RESEARCH_PLASMA = "Plasma";
    public static final String RESEARCH_HYPERSPACE = "Hyperspace";
    public static final String RESEARCH_ASTROPHYSICS = "Astrophysics";
    // Game state constants
    public static final String GAME_STATE_INITIALIZING = "INITIALIZING";
    public static final String GAME_STATE_RUNNING = "RUNNING";
    public static final String GAME_STATE_PAUSED = "PAUSED";
    public static final String GAME_STATE_OVER = "OVER";

    // Player action types
    public static final String ACTION_MOVE = "MOVE";
    public static final String ACTION_ATTACK = "ATTACK";
    public static final String ACTION_DEFEND = "DEFEND";
    public static final String ACTION_INTERACT = "INTERACT";

    // Event types
    public static final String EVENT_START = "START";
    public static final String EVENT_PAUSE = "PAUSE";
    public static final String EVENT_RESUME = "RESUME";
    public static final String EVENT_END = "END";

    // Prevent instantiation
    private GameStatements() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}