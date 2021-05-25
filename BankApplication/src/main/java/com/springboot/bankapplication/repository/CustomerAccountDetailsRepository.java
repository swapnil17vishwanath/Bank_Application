package com.springboot.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bankapplication.entity.CustomerAccountDetails;
@Repository
public interface CustomerAccountDetailsRepository extends JpaRepository<CustomerAccountDetails, Long> {

	CustomerAccountDetails findByAccountNumber(Long fromAccountNo);

}
