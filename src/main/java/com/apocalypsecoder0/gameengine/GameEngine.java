package com.apocalypsecoder0.gameengine;

public class GameEngine {

    private boolean isRunning;

    public GameEngine() {
        this.isRunning = false;
    }

    /**
     * Initializes the game components and sets up the initial game state.
     */
    public void initialize() {
        // Load resources, initialize game objects, etc.
        System.out.println("Game initialized.");
    }

    /**
     * Updates the game state. This method should be called repeatedly in the game loop.
     */
    public void update() {
        // Update game logic, handle user input, etc.
        System.out.println("Game state updated.");
    }

    /**
     * Renders the game state to the screen. This method should be called repeatedly in the game loop.
     */
    public void render() {
        // Draw the game state to the screen.
        System.out.println("Game state rendered.");
    }

    /**
     * The main game loop. Continuously updates and renders the game state.
     */
    public void run() {
        this.isRunning = true;
        initialize();

        while (isRunning) {
            update();
            render();

            // Simulate a frame rate by sleeping the thread for a short duration
            try {
                Thread.sleep(16); // Approximately 60 frames per second
            } catch (InterruptedException e) {
                e.printStackTrace();
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
        GameEngine gameEngine = new GameEngine();
        gameEngine.run();
    }
}
