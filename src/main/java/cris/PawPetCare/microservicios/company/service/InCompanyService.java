package cris.PawPetCare.microservicios.company.service;

import java.util.List;

import cris.PawPetCare.microservicios.company.Company;
import cris.PawPetCare.microservicios.company.CompanyDTO;

public interface InCompanyService {
    void registerCompany(CompanyDTO companyDTO);
    List<Company> getAllCompanies();
    long findByNit(long nit);
    void updateCompany(Company company, long id);
    void deleteCompany(long id);
}
