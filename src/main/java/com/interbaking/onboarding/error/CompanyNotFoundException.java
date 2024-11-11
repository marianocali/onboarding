package com.interbaking.onboarding.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Company Not Found")
public class CompanyNotFoundException extends RuntimeException {

    private String errorDescription;

    public CompanyNotFoundException(){
        //empty constructor
    }

    public CompanyNotFoundException(String errorDescription){
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
