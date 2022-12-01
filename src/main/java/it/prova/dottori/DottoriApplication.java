package it.prova.dottori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.dottori.model.Dottore;
import it.prova.dottori.service.DottoreService;

@SpringBootApplication
public class DottoriApplication implements CommandLineRunner{

	@Autowired
	private DottoreService dottoreService;
	
	public static void main(String[] args) {
		SpringApplication.run(DottoriApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dottoreService.inserisciNuovo(Dottore.builder()
				.nome("mario")
				.cognome("rossi")
				.codiceDottore("MarioRossi1")
				.build());
		
		dottoreService.inserisciNuovo(Dottore.builder()
				.nome("Luigi")
				.cognome("Verdi")
				.codiceDottore("LuigiVerdi1")
				.build());
	}

}
