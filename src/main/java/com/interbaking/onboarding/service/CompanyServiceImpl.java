package com.interbaking.onboarding.service;

import com.interbaking.onboarding.model.Company;
import com.interbaking.onboarding.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    CompanyRepository companyRepo;

    public CompanyServiceImpl(CompanyRepository companyRepo){
        this.companyRepo = companyRepo;
    }


    @Override
    public Company addCompany(Company company) {
        companyRepo.save(company);
        return company;
    }

    @Override
    public Optional<Company> findById(Integer id){
        return companyRepo.findById(id);
    }
}
