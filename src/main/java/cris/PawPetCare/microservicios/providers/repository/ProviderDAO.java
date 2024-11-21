package cris.PawPetCare.microservicios.providers.repository;


import java.util.List;

import cris.PawPetCare.microservicios.providers.Providers;

public interface ProviderDAO {
    void registerProvider(Providers provider);
    List<Providers> getProviders();
    long getProviderById(long document);
    void updateProvider(Providers provider, long id);
    void deleteProvider(long id);
}
