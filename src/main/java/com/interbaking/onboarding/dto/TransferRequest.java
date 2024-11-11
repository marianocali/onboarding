package com.interbaking.onboarding.dto;

import java.time.LocalDateTime;

public class TransferRequest {

        private Double amount;
        private Integer companyId;
        private String debitAccount;
        private String creditAccount;
        private LocalDateTime date;

    public TransferRequest() {
    }

    public TransferRequest(Double amount, Integer companyId, String debitAccount, String creditAccount, LocalDateTime date) {
        this.amount = amount;
        this.companyId = companyId;
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }

    public String getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
