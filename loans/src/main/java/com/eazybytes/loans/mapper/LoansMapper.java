package com.eazybytes.loans.mapper;

import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.entity.Loans;

public class LoansMapper {

    public static LoansDto mapToLoansDto(Loans loan, LoansDto loanDto){

        loanDto.setLoanNumber(loan.getLoanNumber());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setMobileNumber(loan.getMobileNumber());
        loanDto.setAmountPaid(loan.getAmountPaid());
        loanDto.setOutstandingAmount(loan.getOutstandingAmount());
        loanDto.setTotalLoan(loan.getTotalLoan());

        return loanDto;
    }

    public static Loans mapToLoans(Loans loan,LoansDto loanDto){

        loan.setMobileNumber(loanDto.getMobileNumber());
        loan.setLoanType(loanDto.getLoanType());
        loan.setLoanNumber(loanDto.getLoanNumber());
        loan.setAmountPaid(loanDto.getAmountPaid());
        loan.setOutstandingAmount(loanDto.getOutstandingAmount());
        loan.setTotalLoan(loanDto.getTotalLoan());


        return loan;
    }





}
