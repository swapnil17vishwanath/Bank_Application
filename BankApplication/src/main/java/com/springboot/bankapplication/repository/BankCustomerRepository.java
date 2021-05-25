package com.springboot.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bankapplication.entity.BankCustomer;
@Repository
public interface BankCustomerRepository extends JpaRepository<BankCustomer, Long> {

}
