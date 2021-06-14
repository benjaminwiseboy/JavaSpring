package com.tuto.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuto.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
