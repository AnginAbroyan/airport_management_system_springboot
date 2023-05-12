package com.example.ams_springboot.model;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;


/**
 * This class represents a persistent class for Company.
 */

@Entity
@Table(name= "company")
public class Company {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;


    @Column(name = "company_name")
    private String companyName;

    @Column(name = "found_date")
    private Date foundDate;



    // Constructor with all members
    public Company(Long companyId, String companyName, Date foundDate) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.foundDate = foundDate;
    }

    //no-argument constructor
    public Company() {

    }


//getter and setter methods

    public Long getCompanyId() {
        return companyId;
    }
    public void setCompanyId(Long company_id) {
        this.companyId = company_id;
    }



    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String company_name) {
        this.companyName = company_name;
    }



    public Date getFoundDate() {
        return foundDate;
    }
    public void setFoundDate(Date found_date) {
        this.foundDate = found_date;
    }



    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", foundDate=" + foundDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return companyId.equals(company.companyId) && companyName.equals(company.companyName) && foundDate.equals(company.foundDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, foundDate);
    }
}
