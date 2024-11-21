package cris.PawPetCare.microservicios.providers.services;

import java.util.List;

import cris.PawPetCare.microservicios.providers.Providers;
import cris.PawPetCare.microservicios.providers.repository.ProviderRepository;

public class ProvidersService implements InProviderService {

    ProviderRepository providerRepository = new ProviderRepository();
    @Override
    public void registerProvider(Providers provider) {
        if(provider != null){
            providerRepository.registerProvider(provider);
        }
    }

    @Override
    public List<Providers> getAllProviders() {
        return providerRepository.getProviders();
    }

    @Override
    public long getProviderByDocument(long document) {
        return providerRepository.getProviderById(document);
    }

    @Override
    public void updateProvider(Providers provider, long id) {
        providerRepository.updateProvider(provider, id);
    }

    @Override
    public void deleteProvider(long id) {
        providerRepository.deleteProvider(id);
    }

}
