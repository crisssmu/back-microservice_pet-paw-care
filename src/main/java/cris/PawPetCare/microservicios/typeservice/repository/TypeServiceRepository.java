package cris.PawPetCare.microservicios.typeservice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cris.PawPetCare.database.DatabaseConfig;
import cris.PawPetCare.database.IDatabase;
import cris.PawPetCare.microservicios.typeservice.TypeService;
import cris.PawPetCare.microservicios.typeservice.TypeServiceFactory;


public class TypeServiceRepository implements TypeServiceDAO {
    private IDatabase db;
    private Connection connection;

    public TypeServiceRepository() {
    }

    public TypeServiceRepository(IDatabase db, DatabaseConfig config) {
        this.db = db;
        this.db.configure(config.getUrl(), config.getUsername(), config.getPassword());
        this.db.connect();
        this.connection = db.getConnection();
    }

    public void registerTypeService(TypeService typeService) {
        String query = "INSERT INTO typeServices(name, cost) VALUES(?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, typeService.getClass().getSimpleName());
            pstmt.setFloat(2, typeService.getCost());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TypeService> getAllTypeServices() {
        List<TypeService> typeServices = new ArrayList<>();
        String query = "SELECT name, cost FROM typeServices";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String type = rs.getString("name");
                float cost = rs.getFloat("cost");
                TypeService typeService = TypeServiceFactory.createTypeService(type, cost);
                typeServices.add(typeService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeServices;
    }

    @Override
    public long getTypeServiceByCode(String name) {
        String query = "SELECT idTypeService FROM typeServices WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getLong("idTypeService");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateTypeService(TypeService typeService, long id) {
       String query = "UPDATE typeServices SET name = ?, cost = ? WHERE idTypeService = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, typeService.getClass().getSimpleName());
            pstmt.setFloat(2, typeService.getCost());
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTypeService(long id) {
        String query = "DELETE FROM typeServices WHERE idTypeService = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
