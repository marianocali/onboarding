package com.interbaking.onboarding.service;

import com.interbaking.onboarding.model.Transfer;

import java.util.Optional;

public interface TransferService {

    Transfer addTransfer(Transfer transfer);

    Optional<Transfer> findById(Integer id);


}
