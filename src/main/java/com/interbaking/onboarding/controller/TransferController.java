package com.interbaking.onboarding.controller;

import com.interbaking.onboarding.model.Transfer;
import com.interbaking.onboarding.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    TransferService transferService;

    public TransferController(TransferService transferService){
        this.transferService = transferService;
    }

    @RequestMapping("/")
    public Transfer addTransfer(@Valid @RequestBody Transfer transfer){
        return transferService.addTransfer(transfer);
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
