package cris.PawPetCare.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements IDatabase {
    private static Database instance;
    private Connection connection;
    private String url;
    private String username;
    private String password;

    private Database() {
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    @Override
    public void configure(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection established");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection failed");
            }

        }
    }

    @Override
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection failed to close");
            }
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

}
