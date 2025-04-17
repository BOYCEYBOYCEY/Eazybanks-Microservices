package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.entity.Loans;

public interface ILoansService {


    public void createLoan(String mobileNumber);
    public LoansDto fetchLoan(String mobileNumber);
    public Boolean updateLoan(LoansDto loansDto);
    public Boolean deleteLoan(String mobileNumber);
}
