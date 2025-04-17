package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customers,Long> {

    Optional<Customers> findByMobileNumber(String mobileNumber);

}
