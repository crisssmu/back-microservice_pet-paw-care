package cris.PawPetCare.microservicios.company.repository;

import java.util.List;

import cris.PawPetCare.microservicios.company.Company;

public interface CompanyDAO {
    void registerCompany(Company company);
    List<Company> getAllCompanies();
    long findByNit(long nit);
    void updateCompany(Company company, long id);
    void deleteCompany(long id);
}
