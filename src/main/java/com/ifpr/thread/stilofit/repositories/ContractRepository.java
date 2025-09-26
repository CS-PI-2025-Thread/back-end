package com.ifpr.thread.stilofit.repositories;

import com.ifpr.thread.stilofit.models.Contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    boolean existsByName(String name);
    Page<Contract> findAllByOrderByNameAsc(Pageable pageable);
}