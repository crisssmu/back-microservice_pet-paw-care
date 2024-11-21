package cris.PawPetCare.microservicios.customers.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cris.PawPetCare.database.DatabaseConfig;
import cris.PawPetCare.database.IDatabase;
import cris.PawPetCare.microservicios.customers.Customer;

public class CustomerRepositoryMySQL implements CustomerDAO {
    private IDatabase db;
    private Connection connection;

    public CustomerRepositoryMySQL() {
    }

    public CustomerRepositoryMySQL(IDatabase db, DatabaseConfig config) {
        this.db = db;
        this.db.configure(config.getUrl(), config.getUsername(), config.getPassword());
        this.db.connect();
        this.connection = this.db.getConnection();
    }

    @Override
    public void registerCustomer(Customer customer) {
        String query = "INSERT INTO customers(document, name, lastName, gender, phoneNumber, email, address) VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, customer.getDocument());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getGender());
            pstmt.setLong(5, customer.getPhoneNumber());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getAddress());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT document, name, lastname, gender, phoneNumber, email, address FROM customers";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getLong("document"),
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getLong("phoneNumber"));

                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public long getCustomerByDocument(long document) {
        String query = "SELECT idCustomer FROM customers WHERE document = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, document);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getLong("idCustomer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void updateCustomer(Customer customer, long id) {
        String query = "UPDATE customers SET document = ?, name = ?, lastName = ?, gender = ?, phoneNumber = ?, email = ?, address = ? WHERE idCustomer = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, customer.getDocument());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getGender());
            pstmt.setLong(5, customer.getPhoneNumber());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getAddress());
            pstmt.setLong(8, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(long id) {
        String query = "DELETE FROM customers where idCustomer = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changePassword(String email, String password) {
        String query = "UPDATE customers SET password = ? WHERE email = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, password);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public long findCustomerByEmail(String email) {
        String query = "SELECT idCustomer FROM customers WHERE email = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getLong("idCustomer");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

}
