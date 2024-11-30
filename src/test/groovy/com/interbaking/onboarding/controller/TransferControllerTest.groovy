package com.interbaking.onboarding.controller

import com.interbaking.onboarding.dto.TransferRequest
import com.interbaking.onboarding.error.CompanyNotFoundException
import com.interbaking.onboarding.model.Company
import com.interbaking.onboarding.model.Transfer
import com.interbaking.onboarding.service.CompanyService
import com.interbaking.onboarding.service.TransferService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate
import java.time.LocalDateTime

class TransferControllerTest extends Specification {

    TransferService transferService = Mock()
    CompanyService companyService = Mock()

    @Subject
    TransferController transferController = new TransferController(transferService, companyService)

    def "AddTransfer with valid data return ok body"() {

        given:
        def transferReq = new TransferRequest(companyId: 1L, amount: 100.0, debitAccount: "123456", creditAccount: "654321", date: LocalDateTime.now())
        def company = new Company(id: 1L, name: "Test Company")
        def transfer = new Transfer(amount: 100.0, company: company, debitAccount: "123456", creditAccount: "654321", date: LocalDateTime.now())

        when:
        companyService.findById(1) >> Optional.of(company) // Simula que la empresa existe
        transferService.addTransfer(_) >> transfer // Simula que se guarda la transferencia

        ResponseEntity<Transfer> response = transferController.addTransfer(transferReq)

        then:
        response.statusCode == HttpStatus.OK
        response.body == transfer
    }

    def "AddTransfer throws CompanyNotFoundException when company does not exist"() {
        given:
        def transferReq = new TransferRequest(companyId: 1L, amount: 100.0, debitAccount: "123456", creditAccount: "654321", date: LocalDateTime.now())

        when:
        companyService.findById(1L) >> Optional.empty() // Simula que la empresa no existe

        transferController.addTransfer(transferReq)

        then:
        def exception = thrown(CompanyNotFoundException)
        exception.errorDescription == "The company with id 1 was not found"
    }

    def "FindById with existing id return OK"() {

        given:
        def company = new Company(id: 1, name: "Company Test", cuit: "2423425234242", startDate: LocalDateTime.now())
        def transfer = new Transfer(amount: 100.0, company: company, debitAccount: "123456", creditAccount: "654321", date: LocalDateTime.now())
        when:
        transferService.findById(1) >> Optional.of(transfer)
        ResponseEntity<Transfer> response = transferController.findById(1)

        then:
        response.statusCode == HttpStatus.OK
        response.body.company == company
    }
}
