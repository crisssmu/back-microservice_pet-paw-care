package cris.PawPetCare.microservicios.providers;

import cris.PawPetCare.Mapper;

public class ProviderMapper implements Mapper<Providers, ProviderDTO> {

    @Override
    public ProviderDTO toDTO(Providers entity) {
        return new ProviderDTO(entity.getName(), entity.getEmail(), entity.getDocument(), entity.getPhoneNumber(),
                entity.getGender(), entity.getRole());
    }

    @Override
    public Providers toEntity(ProviderDTO dto) {
        Providers provider = new Providers();
        provider.setName(dto.getName());
        provider.setEmail(dto.getEmail());
        provider.setDocument(dto.getDocument());
        provider.setPhoneNumber(dto.getPhoneNumber());
        provider.setGender(dto.getGender());
        provider.setRole(dto.getRole());
        return provider;
    }

}
