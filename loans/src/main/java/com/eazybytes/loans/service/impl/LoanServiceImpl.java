package com.eazybytes.loans.service.impl;

import com.eazybytes.loans.constants.LoansConstants;
import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.entity.Loans;
import com.eazybytes.loans.exception.LoanAlreadyExistsException;
import com.eazybytes.loans.exception.ResourceNotFoundException;
import com.eazybytes.loans.mapper.LoansMapper;
import com.eazybytes.loans.repository.LoansRepository;
import com.eazybytes.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loans> loan=loansRepository.findByMobileNumber(mobileNumber);

        if(loan.isPresent()){
         throw new LoanAlreadyExistsException("Loan Already Exist with the given mobile number "+ mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));


    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loan=loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new  ResourceNotFoundException("Loan","MobileNumber",mobileNumber)
        );


        return LoansMapper.mapToLoansDto(loan,new LoansDto());
    }

    @Override
    public Boolean updateLoan(LoansDto loansDto) {
        boolean isUpdated=false;
        Loans loans=loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                ()->new ResourceNotFoundException("Loan","Loan Number", loansDto.getLoanNumber())
        );

        LoansMapper.mapToLoans(loans,loansDto);

        loansRepository.save(loans);

        return true;

    }

    @Override
    public Boolean deleteLoan(String mobileNumber) {

        Loans loan=loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Loan","Mobile Number",mobileNumber)
        );

        Long id= loan.getLoanId();

        loansRepository.deleteById(id);

        return true;
    }

    public Loans createNewLoan(String mobileNumber){

        Loans loan=new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        loan.setLoanNumber(Long.toString(randomLoanNumber));
        loan.setLoanType(LoansConstants.HOME_LOAN);
        loan.setMobileNumber(mobileNumber);
        loan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return loan;

    }

}
