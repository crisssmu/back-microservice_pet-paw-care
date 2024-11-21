package cris.PawPetCare.microservicios.services.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cris.PawPetCare.database.DatabaseConfig;
import cris.PawPetCare.database.IDatabase;
import cris.PawPetCare.microservicios.services.Service;
import cris.PawPetCare.microservicios.services.State;

public class ServiceRepository implements ServiceDAO {
    private IDatabase db;
    private Connection connection;

    public ServiceRepository() {
    }
    
    public ServiceRepository(IDatabase db, DatabaseConfig config) {
        this.db = db;
        this.db.configure(config.getUrl(), config.getUsername(), config.getPassword());
        this.db.connect();
        this.connection = db.getConnection();
    }

    @Override
    public void registerService(Service service) {
        String query = "INSERT INTO services(dateservice, idpet, idtransaction, idtypeservice, state, idprovider, idcustomer) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setDate(1, (Date)service.getDateService());
            pstmt.setLong(2, service.getIdPet());
            pstmt.setLong(3, service.getIdTransaction());
            pstmt.setLong(4, service.getIdTypeService());
            pstmt.setString(5, service.getState().name());
            pstmt.setLong(6, service.getIdProvider());
            pstmt.setLong(7, service.getIdCustomer());
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String query ="SELECT idpet, idcustomer, idprovider, idtypeservice, dateservice, idtransaction, state FROM services";
        try(PreparedStatement pstmt = connection.prepareStatement(query)){
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Service service = new Service();
                service.setIdPet(rs.getLong("idpet"));
                service.setIdCustomer(rs.getLong("idcustomer"));
                service.setIdProvider(rs.getLong("idprovider"));
                service.setIdTypeService(rs.getLong("idtypeservice"));
                service.setDateService(rs.getDate("dateservice"));
                service.setIdTransaction(rs.getLong("idtransaction"));
                service.setState(State.valueOf(rs.getString("state")));
                services.add(service);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return services;
    }

    @Override
    public long getService(long idProvider, long idCustomer) {
        String query = "SELECT id FROM services WHERE idprovider = ? AND idcustomer = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setLong(1, idProvider);
            pstmt.setLong(2, idCustomer);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getLong("id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateService(Service service) {
        String query = "UPDATE services SET dateservice = ?, idpet = ?, idtransaction = ?, idtypeservice = ?, state = ?, idprovider = ?, idcustomer = ? WHERE id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setDate(1, (Date)service.getDateService());
            pstmt.setLong(2, service.getIdPet());
            pstmt.setLong(3, service.getIdTransaction());
            pstmt.setLong(4, service.getIdTypeService());
            pstmt.setString(5, service.getState().name());
            pstmt.setLong(6, service.getIdProvider());
            pstmt.setLong(7, service.getIdCustomer());
            pstmt.setLong(8, service.getId());
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteService(long id) {
        String query = "DELETE FROM services WHERE id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
