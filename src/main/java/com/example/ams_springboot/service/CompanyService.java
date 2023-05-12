package com.example.ams_springboot.service;



import com.example.ams_springboot.model.Company;
import com.example.ams_springboot.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    /**
     * Gets all companies from company table
     * @return list of companies
     */
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }


    /**
     * Gets a company from a table by given id.
     * @param id
     * @return
     */

    public Optional<Company> getById(Long id){
        boolean exists = companyRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Company with id " + id + " does not exist.");
        }
        return companyRepository.findById(id);
    }

    /**
     * Deletes a Company by given id
     * @param id
     */

    public void deleteById(Long id){
        boolean exists = companyRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Company with id " + id + " does not exist.");
        }
        companyRepository.deleteById(id);
    }


    /**
     * saves a new company into the table
     * @param company
     */
    public void saveCompany(Company company){
        companyRepository.save(company);
    }


    /**
     * Updates all the fields or only needed fields of a company
     * @param companyId
     * @param companyName
     * @param foundDate
     */
    @Transactional
    public void updateCompany(Long companyId, String companyName, Date foundDate) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalStateException("Company with id " + companyId + " does not exist."));
        if (foundDate != null  && !Objects.equals(company.getFoundDate(), foundDate)) {
            company.setFoundDate(foundDate);
        }
        if (companyName != null && companyName.length() > 0 && !Objects.equals(company.getCompanyName(), companyName)) {
            Optional<Company> companyOptional = companyRepository
                    .findCompanyByCompanyName(companyName);
            if (companyOptional.isPresent()) {
                throw new IllegalStateException("Company name already exists.");
            }
            company.setCompanyName(companyName);
        }
    }
}
