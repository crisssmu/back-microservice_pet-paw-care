package cris.PawPetCare.microservicios.typeservice.service;


import java.util.List;

import cris.PawPetCare.microservicios.typeservice.TypeService;
import cris.PawPetCare.microservicios.typeservice.repository.TypeServiceRepository;

public class TypeServiceService implements InTypeService {
    TypeServiceRepository tsr = new TypeServiceRepository();
    @Override
    public void registerTypeService(TypeService typeService) {
        tsr.registerTypeService(typeService);
    }

    @Override
    public List<TypeService> getAllTypeServices() {
        return tsr.getAllTypeServices();
    }

    @Override
    public long getTypeServiceByCode(String name) {
        return tsr.getTypeServiceByCode(name);
    }

    @Override
    public void updateTypeService(TypeService typeService, long id) {
        tsr.updateTypeService(typeService, id);
    }

    @Override
    public void deleteTypeService(long id) {
        tsr.deleteTypeService(id);
    }

}
