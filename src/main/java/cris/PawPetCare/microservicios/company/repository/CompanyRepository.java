package cris.PawPetCare.microservicios.company.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cris.PawPetCare.database.DatabaseConfig;
import cris.PawPetCare.database.IDatabase;
import cris.PawPetCare.microservicios.company.Company;

public class CompanyRepository implements CompanyDAO {
    private IDatabase db;
    private Connection connection;

    
    public CompanyRepository() {
    }

    public CompanyRepository(IDatabase db, DatabaseConfig config) {
        this.db = db;
        this.db.configure(config.getUrl(), config.getUsername(), config.getPassword());
        this.db.connect();
        this.connection = db.getConnection();
    }

    @Override
    public void registerCompany(Company company) {
        String query = "INSERT INTO companies(name, nit) VALUES(?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, company.getName());
            pstmt.setLong(2, company.getNit());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        String query = "SELECT name, nit FROM companies";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Company company = new Company(
                    rs.getString("name"),
                    rs.getLong("nit")
                );
                companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public long findByNit(long nit) {
        String query = "SELECT idCompany FROM companies WHERE nit = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, nit);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getLong("idCompany");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void updateCompany(Company company, long id) {
        String query = "UPDATE companies SET name = ?, nit = ? WHERE idCompany = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, company.getName());
            pstmt.setLong(2, company.getNit());
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(long id) {
        String query = "DELETE FROM companies where idCompany = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

