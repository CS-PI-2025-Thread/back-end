package com.ifpr.thread.stilofit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifpr.thread.stilofit.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);

    @Query("SELECT c FROM Client c ORDER BY c.name ASC")
    Page<Client> findAll(Pageable pageable);

    @Query("SELECT c FROM Client c WHERE LOWER(c.name) LIKE CONCAT('%', LOWER(:name), '%') ORDER BY c.name ASC")
    Page<Client> findByName(Pageable pageable, @Param("name") String name);
}
