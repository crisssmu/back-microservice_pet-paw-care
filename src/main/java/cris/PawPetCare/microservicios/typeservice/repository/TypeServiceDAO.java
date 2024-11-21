package cris.PawPetCare.microservicios.typeservice.repository;

import java.util.List;

import cris.PawPetCare.microservicios.typeservice.TypeService;

public interface TypeServiceDAO {
    void registerTypeService(TypeService typeService);
    List<TypeService> getAllTypeServices();
    long getTypeServiceByCode(String name);
    void updateTypeService(TypeService typeService, long id);
    void deleteTypeService(long id);
}
