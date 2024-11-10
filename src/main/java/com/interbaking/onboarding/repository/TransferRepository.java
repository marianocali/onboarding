package com.interbaking.onboarding.repository;

import com.interbaking.onboarding.model.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<Transfer,Integer> {
}
