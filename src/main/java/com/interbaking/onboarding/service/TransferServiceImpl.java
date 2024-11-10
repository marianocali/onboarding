package com.interbaking.onboarding.service;

import com.interbaking.onboarding.model.Transfer;
import com.interbaking.onboarding.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService {

    TransferRepository transferRepository;

    public TransferServiceImpl(TransferRepository transferRepository){
        this.transferRepository = transferRepository;
    }


    @Override
    public Transfer addTransfer(Transfer transfer) {
        transferRepository.save(transfer);
        return transfer;
    }

    @Override
    public Optional<Transfer> findById(Integer id) {
        return transferRepository.findById(id);
    }
}
