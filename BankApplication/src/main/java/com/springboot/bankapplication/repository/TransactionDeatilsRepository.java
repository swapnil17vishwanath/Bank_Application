package com.springboot.bankapplication.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.bankapplication.entity.TransactionDetails;

public interface TransactionDeatilsRepository extends JpaRepository<TransactionDetails, Long> {


	List<TransactionDetails> findByTransactionDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
