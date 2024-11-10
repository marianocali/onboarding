package com.interbaking.onboarding.controller;

import com.interbaking.onboarding.model.Company;
import com.interbaking.onboarding.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {



    private final CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping("/")
    public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company){
        company.setStartDate(LocalDateTime.now());
        return new ResponseEntity<>(companyService.addCompany(company), HttpStatus.CREATED);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompany(@PathVariable Integer companyId){
        Optional<Company> optionalCompany = companyService.findById(companyId);
        if(optionalCompany.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalCompany.get(), HttpStatus.OK);
    }

    @GetMapping("/transferLastMonth")
    public ResponseEntity<List<String>> getCompaniesWithTransferLastMonth(){
        List<String> companyNames = companyService.getCompaniesWithTransferLastMonth();
        return new ResponseEntity<>(companyNames, HttpStatus.OK);
    }

}
