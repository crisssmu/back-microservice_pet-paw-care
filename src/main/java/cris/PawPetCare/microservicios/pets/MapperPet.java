package cris.PawPetCare.microservicios.pets;

import cris.PawPetCare.Mapper;

public class MapperPet implements Mapper<Pet, PetDTO> {

    @Override
    public PetDTO toDTO(Pet entity) {
        return new PetDTO(entity.getName(), entity.getDateBirth(), entity.getGender(), entity.getSpecie(),
                entity.getIdCustomer(), entity.getDocument());
    }

    @Override
    public Pet toEntity(PetDTO dto) {
        Pet pet = new Pet();
        pet.setName(dto.getName());
        pet.setDateBirth(dto.getDateBirth());
        pet.setGender(dto.getGender());
        pet.setSpecie(dto.getSpecie());
        pet.setIdCustomer(dto.getIdCustomer());
        pet.setDocument(dto.getDocument());
        return pet;
    }

}
