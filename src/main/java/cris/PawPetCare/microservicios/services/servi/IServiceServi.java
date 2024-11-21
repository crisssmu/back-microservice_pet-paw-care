package cris.PawPetCare.microservicios.services.servi;

import java.util.List;

import cris.PawPetCare.microservicios.services.Service;

public interface IServiceServi {
    void registerService(Service service);
    List<Service> getAllServices();
    long getService(long idProvider, long idCustomer);
    void updateService(Service service);
    void deleteService(long id);
}
