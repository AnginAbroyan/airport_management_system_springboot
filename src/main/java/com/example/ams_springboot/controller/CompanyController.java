package com.example.ams_springboot.controller;



import com.example.ams_springboot.model.Company;
import com.example.ams_springboot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "company/get")
    public List<Company> getCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("company/get/{companyId}")
    public Optional<Company> getById(@PathVariable("companyId") Long id){
        return companyService.getById(id);
    }

    @PostMapping(path = "company/register")
    public void registerNewCompany(@RequestBody Company company) {
        companyService.saveCompany(company);
    }

    @DeleteMapping(path = "company/delete/{companyId}")
    public void deleteCompany(
            @PathVariable("companyId") Long companyId) {
        companyService.deleteById(companyId);
    }

    @PutMapping(path = "company/update/{companyId}")
    public void updateCompany(@PathVariable("companyId") Long companyId,
                                @RequestParam(required = false) String companyName,
                                @RequestParam(required = false) Date foundDate) {
        companyService.updateCompany(companyId, companyName, foundDate);
    }
}
