package cris.PawPetCare.microservicios.company;

import java.util.List;

import cris.PawPetCare.microservicios.providers.Providers;

public class Company {

    private long id;
    private String name;
    private long nit;
    private List<Providers> providers;

    
    public Company() {
    }

    
    public Company(String name, long nit) {
        this.name = name;
        this.nit = nit;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getNit() {
        return nit;
    }
    public void setNit(long nit) {
        this.nit = nit;
    }
    public List<Providers> getProviders() {
        return providers;
    }
    public void setProviders(List<Providers> providers) {
        this.providers = providers;
    }
    public long getId() {
        return id;
    }

    


}
