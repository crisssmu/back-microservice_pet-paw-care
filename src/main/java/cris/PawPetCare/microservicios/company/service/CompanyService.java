package cris.PawPetCare.microservicios.company.service;

import java.util.List;

import cris.PawPetCare.microservicios.company.Company;
import cris.PawPetCare.microservicios.company.CompanyDTO;
import cris.PawPetCare.microservicios.company.CompanyMapper;
import cris.PawPetCare.microservicios.company.repository.CompanyRepository;

public class CompanyService implements InCompanyService {

    CompanyRepository companyRepository = new CompanyRepository();
    @Override
    public void registerCompany(CompanyDTO companyDTO) {
        if(companyDTO != null){
            CompanyMapper mapper = new CompanyMapper();
            Company company = mapper.toEntity(companyDTO);
            companyRepository.registerCompany(company);
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public long findByNit(long nit) {
        return companyRepository.findByNit(nit);
    }

    @Override
    public void updateCompany(Company company, long id) {
        companyRepository.updateCompany(company, id);
    }

    @Override
    public void deleteCompany(long id) {
        companyRepository.deleteCompany(id);
    }

}
