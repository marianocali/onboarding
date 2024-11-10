package com.interbaking.onboarding.service;

import com.interbaking.onboarding.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    Company addCompany(Company company);

    Optional<Company> findById(Integer id);

    List<String> getCompaniesWithTransferLastMonth();
}
