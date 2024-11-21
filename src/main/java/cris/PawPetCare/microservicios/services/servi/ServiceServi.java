package cris.PawPetCare.microservicios.services.servi;

import java.util.List;

import cris.PawPetCare.microservicios.services.Service;
import cris.PawPetCare.microservicios.services.repository.ServiceRepository;

public class ServiceServi implements IServiceServi {
    ServiceRepository sr = new ServiceRepository();

    @Override
    public void registerService(Service service) {
        sr.registerService(service);
    }

    @Override
    public List<Service> getAllServices() {
        return sr.getAllServices();
    }

    @Override
    public long getService(long idProvider, long idCustomer) {
        return sr.getService(idProvider, idCustomer);
    }

    @Override
    public void updateService(Service service) {
        sr.updateService(service);
    }

    @Override
    public void deleteService(long id) {
        sr.deleteService(id);
    }

}
