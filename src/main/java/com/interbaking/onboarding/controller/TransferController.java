package com.interbaking.onboarding.controller;

import com.interbaking.onboarding.dto.TransferRequest;
import com.interbaking.onboarding.error.CompanyNotFoundException;
import com.interbaking.onboarding.model.Company;
import com.interbaking.onboarding.model.Transfer;
import com.interbaking.onboarding.service.CompanyService;
import com.interbaking.onboarding.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService transferService;
    private final CompanyService companyService;

    public TransferController(TransferService transferService, CompanyService companyService){
        this.transferService = transferService;
        this.companyService = companyService;
    }

    @PostMapping("/")
    public ResponseEntity<Transfer> addTransfer(@Valid @RequestBody TransferRequest transferReq) {
        // Validate company exists
        Company company = companyService.findById(transferReq.getCompanyId())
                .orElseThrow(() -> new CompanyNotFoundException("The company with id " + transferReq.getCompanyId() + " was not found"));

        // create new transfer
        Transfer transfer = new Transfer();
        transfer.setAmount(transferReq.getAmount());
        transfer.setCompany(company);
        transfer.setDebitAccount(transferReq.getDebitAccount());
        transfer.setCreditAccount(transferReq.getCreditAccount());
        transfer.setDate(transferReq.getDate());

        // save transfer
        Transfer savedTransfer = transferService.addTransfer(transfer);
        return ResponseEntity.ok(savedTransfer);
    }

    @GetMapping("/{transferId}")
    public ResponseEntity<Transfer> findById(@PathVariable Integer transferId){
        Optional<Transfer> optTransfer = transferService.findById(transferId);
        if(optTransfer.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optTransfer.get(), HttpStatus.OK);
    }

}
