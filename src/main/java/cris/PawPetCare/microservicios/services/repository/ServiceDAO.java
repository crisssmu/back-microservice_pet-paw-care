package cris.PawPetCare.microservicios.services.repository;

import java.util.List;

import cris.PawPetCare.microservicios.services.Service;

public interface ServiceDAO {
    void registerService(Service service);
    List<Service> getAllServices();
    long getService(long idProvider, long idCustomer);
    void updateService(Service service);
    void deleteService(long id);
}
