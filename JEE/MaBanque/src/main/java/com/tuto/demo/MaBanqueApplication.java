package com.tuto.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tuto.demo.dao.ClientRepository;
import com.tuto.demo.dao.CompteRepository;
import com.tuto.demo.dao.OperationRepository;
import com.tuto.demo.entities.Client;
import com.tuto.demo.entities.Compte;
import com.tuto.demo.entities.CompteCourant;
import com.tuto.demo.entities.CompteEpargne;
import com.tuto.demo.entities.Retrait;
import com.tuto.demo.entities.Versement;
import com.tuto.demo.metier.IBanqueMetier;


@SpringBootApplication
public class MaBanqueApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	public static void main(String[] args) {
		SpringApplication.run(MaBanqueApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = clientRepository.save(new Client ("Benjamin", "Ngabmen"));
		Client c2 = clientRepository.save(new Client ("Fouda", "grace@gmail.com"));

		Compte cp1 = compteRepository.save(
				new CompteCourant("c1", new Date(), 90000, c1, 6000));
		Compte cp2 = compteRepository.save(
				new CompteEpargne("c2", new Date(), 6000, c2, 5.5));
		operationRepository.save(new Versement (new Date(), 9000, cp1));
		operationRepository.save(new Versement (new Date(), 6000, cp1));
		operationRepository.save(new Versement (new Date(), 2300, cp1));
		operationRepository.save(new Retrait (new Date(), 9000, cp1));
		
		operationRepository.save(new Versement (new Date(), 5000, cp2));
		operationRepository.save(new Versement (new Date(), 7000, cp2));
		operationRepository.save(new Versement (new Date(), 2500, cp2));
		operationRepository.save(new Retrait (new Date(), 9800, cp2));
	
		banqueMetier.verser("c1", 2222222);
	}

}
