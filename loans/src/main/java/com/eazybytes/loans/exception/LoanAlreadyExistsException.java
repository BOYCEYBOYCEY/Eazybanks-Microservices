package com.eazybytes.loans.exception;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class LoanAlreadyExistsException extends RuntimeException{

    public LoanAlreadyExistsException(String message){
        super(message);
    }

}
