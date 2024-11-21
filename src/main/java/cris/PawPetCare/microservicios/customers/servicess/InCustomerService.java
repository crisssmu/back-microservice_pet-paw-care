package cris.PawPetCare.microservicios.customers.servicess;

import java.util.List;

import cris.PawPetCare.microservicios.customers.Customer;
import cris.PawPetCare.microservicios.customers.DTO.CustomerDTO;


public interface InCustomerService {
    
    void registerCustomer(CustomerDTO customer);
    List<Customer> getAllCustomers();
    long getCustomerByDocument(long document);
    void updateCustomer(Customer customer, long id);
    void deleteCustomer(long id);
    void changePassword(String email, String password);
    long findCustomerByEmail(String email);
}
