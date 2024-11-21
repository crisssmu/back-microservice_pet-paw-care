package cris.PawPetCare.microservicios.customers.repository;

import java.util.List;

import cris.PawPetCare.microservicios.customers.Customer;

public interface CustomerDAO {
    void registerCustomer(Customer customer);
    List<Customer> getAllCustomers();
    long getCustomerByDocument(long document);
    void updateCustomer(Customer customer, long id);
    void deleteCustomer(long id);
    void changePassword(String email, String password);
    long findCustomerByEmail(String email);
}
