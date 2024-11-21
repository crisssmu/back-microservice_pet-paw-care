package cris.PawPetCare.microservicios.pets.repository;

import java.util.List;

import cris.PawPetCare.microservicios.pets.Pet;

public interface PetDAO {
    void registerPet(Pet pet);
    List<Pet> getAllPets();
    long getPetDocumetByOwner(long documentCus, long documentPet);
    void updatePet(Pet pet, long id);
    void deletePet(long id);
}
