package com.apocalypsecoder0.gameengine;

import java.util.logging.Logger;

public class GameEngine {

    private static final Logger logger = Logger.getLogger(GameEngine.class.getName());
    private boolean isRunning;
    private UniverseGenerator universeGenerator;
    private GameGUI gameGUI;

    public GameEngine() {
        logger.info("Stopping the game loop...");
        this.isRunning = false;
    }

    /**
     * Initializes the game components and sets up the initial game state.
     */
    public void initialize() {
        // Load resources, initialize game objects, etc.
        logger.info("Initializing game components...");
        universeGenerator = new UniverseGenerator(System.currentTimeMillis());
        gameGUI = new GameGUI();
        logger.info("Game initialized with Universe and GUI.");
    }

    /**
     * Updates the game state. This method should be called repeatedly in the game loop.
     */
    public void update() {
        // Update game logic, handle user input, etc.
        logger.fine("Updating game state...");
        logger.info("Game state updated.");
    }

    /**
     * Renders the game state to the screen. This method should be called repeatedly in the game loop.
     */
    public void render() {
        // Draw the game state to the screen.
        logger.fine("Rendering game state...");
        logger.info("Game state rendered.");
    }

    /**
     * The main game loop. Continuously updates and renders the game state.
     */
    public void run() {
        logger.info("Starting the game loop...");
        this.isRunning = true;
        initialize();
        gameGUI.main(new String[]{}); // Launch the GUI

        while (isRunning) {
            logger.fine("Running game loop iteration...");
            update();
            render();

            // Simulate a frame rate by sleeping the thread for a short duration
            try {
                Thread.sleep(16); // Approximately 60 frames per second
            } catch (InterruptedException e) {
                logger.severe("Game loop interrupted: " + e.getMessage());
            }
        }
    }

    /**
     * Stops the game loop.
     */
    public void stop() {
        this.isRunning = false;
    }

    public static void main(String[] args) {
        logger.info("GameEngine starting...");
        GameEngine gameEngine = new GameEngine();
        gameEngine.run();
    }
}