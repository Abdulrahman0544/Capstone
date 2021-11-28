package com.saib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saib.models.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Long>{

}
