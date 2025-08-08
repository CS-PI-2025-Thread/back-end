package com.ifpr.thread.stilofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpr.thread.stilofit.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {  
}
