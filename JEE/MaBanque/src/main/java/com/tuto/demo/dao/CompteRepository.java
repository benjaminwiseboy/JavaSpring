package com.tuto.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tuto.demo.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
	@Query ("select c from Compte c where c.codeCompte=:x ")
	Compte find(@Param("x") String codeCpte);

}
