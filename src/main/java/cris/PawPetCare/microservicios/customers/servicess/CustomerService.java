package cris.PawPetCare.microservicios.customers.servicess;

import java.util.List;

import cris.PawPetCare.microservicios.customers.Customer;
import cris.PawPetCare.microservicios.customers.DTO.CustomerDTO;
import cris.PawPetCare.microservicios.customers.mapper.CustomerMapper;
import cris.PawPetCare.microservicios.customers.repository.CustomerRepositoryPostgres;

public class CustomerService implements InCustomerService {

    CustomerRepositoryPostgres cr = new CustomerRepositoryPostgres();
    CustomerDTO customerDTO = new CustomerDTO();
    CustomerMapper mapper = new CustomerMapper();


    @Override
    public void registerCustomer(CustomerDTO customer) {
        try {
            Customer cus = mapper.toEntity(customer);
            cr.registerCustomer(cus);
        } catch (Exception e) {
            System.out.println("No se pudo registrar el cliente");
        }
    }

    @Override
    public long getCustomerByDocument(long document) {
        return cr.getCustomerByDocument(document);
    }

    @Override
    public void updateCustomer(Customer customer, long id) {
        cr.updateCustomer(customer, id);
    }

    @Override
    public void deleteCustomer(long id) {
        cr.deleteCustomer(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return cr.getAllCustomers();
    }

    @Override
    public void changePassword(String email, String password) {
        cr.changePassword(email, password);
    }

    @Override
    public long findCustomerByEmail(String email) {
        try {
            if(email != null){
                return cr.findCustomerByEmail(email);
            }
            return -1;
        } catch (Exception e) {
            System.out.println("No se encontro el cliente");
            return -1;
        }
    }
    
}
