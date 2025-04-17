package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.CustomersDto;
import com.eazybytes.accounts.entity.Customers;

public class CustomersMapper {

    public static CustomersDto mapToCustomersDto(Customers customers,CustomersDto customersDto){

        customersDto.setName(customers.getName());
        customersDto.setEmail(customers.getEmail());
        customersDto.setMobileNumber(customers.getMobileNumber());
        return customersDto;

    }

    public static Customers mapToCustomers(Customers customers,CustomersDto customersDto){

        customers.setName(customersDto.getName());
        customers.setEmail(customersDto.getEmail());
        customers.setMobileNumber(customersDto.getMobileNumber());
        return customers;
    }



}
