package com.apocalypsecoder0.gameengine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class LoginManager {

    private Connection databaseConnection;

    public LoginManager(Connection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    // Method to handle secure login
    public boolean login(String username, String password) {
        String query = "SELECT password FROM users WHERE username = ?";
        try (PreparedStatement statement = databaseConnection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String storedHash = resultSet.getString("password");
                return BCrypt.checkpw(password, storedHash);
            } else {
                System.out.println("Username not found.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to register a new user with encrypted password
    public boolean register(String username, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = databaseConnection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to change a user's password
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        if (login(username, oldPassword)) {
            String hashedNewPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            String query = "UPDATE users SET password = ? WHERE username = ?";
            try (PreparedStatement statement = databaseConnection.prepareStatement(query)) {
                statement.setString(1, hashedNewPassword);
                statement.setString(2, username);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            System.out.println("Old password is incorrect.");
            return false;
        }
    }
}
