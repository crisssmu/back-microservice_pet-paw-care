package cris.PawPetCare.microservicios.providers.services;

import java.util.List;


import cris.PawPetCare.microservicios.providers.Providers;

public interface InProviderService {
    void registerProvider(Providers provider);
    List<Providers> getAllProviders();
    long getProviderByDocument(long document);
    void updateProvider(Providers provider, long id);
    void deleteProvider(long id);
}
