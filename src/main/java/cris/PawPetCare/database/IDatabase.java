package cris.PawPetCare.database;

import java.sql.Connection;

public interface IDatabase {
    void configure(String url, String username, String password);
    void connect();
    void disconnect();
    Connection getConnection();
}
