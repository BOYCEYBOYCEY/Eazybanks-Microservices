package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomersDto;
import com.eazybytes.accounts.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface IAccountsService {


    public void createAccount(CustomersDto customersDto);

    public CustomersDto fetchAccountDetails(String mobileNumber);

    public Boolean updateCustomerDetails(CustomersDto customersDto);

    public Boolean deleteCustomer(String mobileNumber);

}
