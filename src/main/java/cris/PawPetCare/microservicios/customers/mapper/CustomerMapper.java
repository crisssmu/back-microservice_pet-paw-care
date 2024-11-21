package cris.PawPetCare.microservicios.customers.mapper;

import cris.PawPetCare.Mapper;
import cris.PawPetCare.microservicios.customers.Customer;
import cris.PawPetCare.microservicios.customers.DTO.CustomerDTO;

public class CustomerMapper implements Mapper<Customer, CustomerDTO> {

    @Override
    public CustomerDTO toDTO(Customer entity) {
        return new CustomerDTO(entity.getDocument(), entity.getFirstName(), entity.getLastName(), entity.getEmail(), entity.getPassword());
    }

    @Override
    public Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setDocument(dto.getDocument());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        return customer;
    }

}
