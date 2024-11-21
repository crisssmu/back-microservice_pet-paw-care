package cris.PawPetCare.microservicios.services;

import java.util.Date;

public class Service {
    long id;
    Date dateService;
    long idPet;
    long idTypeService;
    long idTransaction;
    long idProvider;
    long idCustomer;
    State state;

    public Service() {
    }

    public Service(Date dateService, long idPet, long idTransaction, long idTypeService,State state, long idProvider,
            long idCustomer) {
        this.dateService = dateService;
        this.idPet = idPet;
        this.idTypeService = idTypeService;
        this.idTransaction = idTransaction;
        this.idProvider = idProvider;
        this.idCustomer = idCustomer;
        this.state = state;
    }



    public Date getDateService() {
        return dateService;
    }

    public long getIdPet() {
        return idPet;
    }

    public long getIdTypeService() {
        return idTypeService;
    }

   
    public long getId() {
        return id;
    }

    public void setDateService(Date dateService) {
        this.dateService = dateService;
    }


    public State getState() {
        return state;
    }


    public void setState(State state) {
        this.state = state;
    }

    public void setIdPet(long idPet) {
        this.idPet = idPet;
    }

    public void setIdTypeService(long idTypeService) {
        this.idTypeService = idTypeService;
    }

    public long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(long idProvider) {
        this.idProvider = idProvider;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(long idTransaction) {
        this.idTransaction = idTransaction;
    }

    
    
}
