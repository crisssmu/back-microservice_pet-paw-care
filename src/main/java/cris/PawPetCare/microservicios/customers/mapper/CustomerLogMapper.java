package cris.PawPetCare.microservicios.customers.mapper;

import cris.PawPetCare.Mapper;
import cris.PawPetCare.microservicios.customers.Customer;
import cris.PawPetCare.microservicios.customers.DTO.CustomerLogDTO;

public class CustomerLogMapper implements Mapper<Customer, CustomerLogDTO> {

    @Override
    public CustomerLogDTO toDTO(Customer entity) {
        return new CustomerLogDTO(entity.getEmail(), entity.getPassword());
    }

    @Override
    public Customer toEntity(CustomerLogDTO dto) {
        Customer customer = new Customer();
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        return customer;
    }

}
