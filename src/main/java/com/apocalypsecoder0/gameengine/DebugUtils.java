package com.apocalypsecoder0.gameengine;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for logging and debugging game state changes, errors, and performance metrics.
 */
public class DebugUtils {

    private static final Logger logger = Logger.getLogger(DebugUtils.class.getName());

    /**
     * Logs an informational message.
     *
     * @param message The message to log.
     */
    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    /**
     * Logs a warning message.
     *
     * @param message The message to log.
     */
    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    /**
     * Logs a severe error message.
     *
     * @param message The message to log.
     */
    public static void logSevere(String message) {
        logger.log(Level.SEVERE, message);
    }

    /**
     * Logs performance metrics.
     *
     * @param metricName The name of the metric.
     * @param value      The value of the metric.
     */
    public static void logPerformanceMetric(String metricName, double value) {
        logger.log(Level.INFO, "Performance Metric - {0}: {1}", new Object[]{metricName, value});
    }

    /**
     * Logs an exception with a custom message.
     *
     * @param message   The custom message.
     * @param exception The exception to log.
     */
    public static void logException(String message, Exception exception) {
        logger.log(Level.SEVERE, message, exception);
    }
}
