package com.interbaking.onboarding.repository;

import com.interbaking.onboarding.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

   @Query(" SELECT DISTINCT c.name " +
        " FROM Company c " +
        " JOIN Transfer t " +
        " ON c.id = t.company.id " +
        " WHERE MONTH (t.date) = MONTH (CURRENT_DATE)"
    )
   List<String> getCompaniesWithTransferLastMonth();

    @Query(" SELECT  c.name " +
            " FROM Company c " +
            " WHERE MONTH (c.startDate) = MONTH (CURRENT_DATE)"
    )
    List<String> getCompaniesAddedLastMonth();

}
