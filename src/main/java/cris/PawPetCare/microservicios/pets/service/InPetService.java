package cris.PawPetCare.microservicios.pets.service;

import java.util.List;

import cris.PawPetCare.microservicios.pets.Pet;
import cris.PawPetCare.microservicios.pets.PetDTO;

public interface InPetService {
    void registerPet(PetDTO petDTO);
    List<Pet> getAllPets();
    long getPetByDocument(long documentCus, long documentPet);
    void updatePet(Pet pet, long id);
    void deletePet(long id);
}
