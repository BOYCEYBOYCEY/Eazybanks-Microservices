package com.eazybytes.accounts.service.Impl;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.CustomersDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customers;
import com.eazybytes.accounts.exception.CustomerAlreadyExistException;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomersMapper;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomersRepository;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomersRepository customersRepository;

    @Override
    public void createAccount(CustomersDto customersDto) {
        Customers customer= CustomersMapper.mapToCustomers(new Customers(),customersDto);

        Optional<Customers> optionalCustomer=customersRepository.findByMobileNumber(customer.getMobileNumber());

        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistException("Customer Already exists with given mobile number "+customer.getMobileNumber());
        }

        Customers savedCustomer=customersRepository.save(customer);
        Accounts account=accountsRepository.save(createAccount(savedCustomer));
    }

    @Override
    public CustomersDto fetchAccountDetails(String mobileNumber) {

        Customers customer=customersRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","mobile number",mobileNumber)
        );

        Accounts account=accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundException("Account","customer id",customer.getCustomerId().toString())
        );

        CustomersDto customersDto=CustomersMapper.mapToCustomersDto(customer,new CustomersDto());
        customersDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account,new AccountsDto()));

        return  customersDto;

    }

    @Override
    public Boolean updateCustomerDetails(CustomersDto customersDto) {
        boolean isUpdate=false;

        AccountsDto accountsDto=customersDto.getAccountsDto();

        if(accountsDto!=null){

            Accounts account=accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    ()->new ResourceNotFoundException("Account","Account Number",accountsDto.getAccountNumber().toString())
                    );

            AccountsMapper.mapToAccounts(account,accountsDto);
            accountsRepository.save(account);


            Long id= account.getCustomerId();

            Customers customer=customersRepository.findById(id).orElseThrow(
                    ()->new ResourceNotFoundException("Customer" ,"Customer ID",account.getCustomerId().toString())
            );

            CustomersMapper.mapToCustomers(customer,customersDto);
            customersRepository.save(customer);
            isUpdate=true;
        }


        return isUpdate;





    }

    @Override
    public Boolean deleteCustomer(String mobileNumber) {

        Customers customer= customersRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Customer","Mobile Number ",mobileNumber)
        );

        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customersRepository.deleteById(customer.getCustomerId());
        return true;

    }


    private Accounts createAccount(Customers savedCustomer){
        Accounts newAccount=new Accounts();
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setCustomerId(savedCustomer.getCustomerId());
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }



}
