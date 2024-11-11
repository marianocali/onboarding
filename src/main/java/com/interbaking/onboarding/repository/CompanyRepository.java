package com.interbaking.onboarding.repository;

import com.interbaking.onboarding.model.Company;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

   @Query(" SELECT c.name " +
        " FROM Company c " +
        " JOIN Transfer t " +
        " ON c.id = t.company.id " +
        " WHERE MONTH (t.date) = MONTH (CURRENT_DATE)"
    )
   List<String> getCompaniesWithTransferLastMonth();

    @Query(" SELECT c.name " +
            " FROM Company c " +
            " WHERE MONTH (c.startDate) = MONTH (CURRENT_DATE)"
    )
    List<String> getCompaniesAddedLastMonth();

}
