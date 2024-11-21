package cris.PawPetCare.microservicios.customers.repository;



public class CustomerRepositoryFactory {
    public static CustomerDAO createCustomerRepository(String type){
        if(type.equals("postgres")){
            return new CustomerRepositoryPostgres();
        }else if(type.equals("mysql")){
            return new CustomerRepositoryMySQL();
        }
        throw new IllegalArgumentException("Invalid repository type" + type);
    }
}
