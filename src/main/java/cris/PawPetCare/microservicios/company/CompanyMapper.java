package cris.PawPetCare.microservicios.company;

import cris.PawPetCare.Mapper;

public class CompanyMapper implements Mapper<Company ,CompanyDTO> {

    @Override
    public CompanyDTO toDTO(Company entity) {
        CompanyDTO dto = new CompanyDTO();
        dto.setName(entity.getName());
        dto.setNit(entity.getNit());
        return dto;
    }

    @Override
    public Company toEntity(CompanyDTO dto) {
        Company company = new Company();
        company.setName(dto.getName());
        company.setNit(dto.getNit());
        return company;
    }

  
}
