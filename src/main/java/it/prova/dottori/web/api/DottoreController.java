package it.prova.dottori.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.dottori.dto.DottoreDTO;
import it.prova.dottori.model.Dottore;
import it.prova.dottori.service.DottoreService;
import it.prova.dottori.web.api.exception.DottoreNotFoundException;
import it.prova.dottori.web.api.exception.IdNotNullForInsertException;
import it.prova.dottori.web.api.exception.IdNullForUpdateException;

@RestController
@RequestMapping("/api/dottore")
public class DottoreController {
	
	@Autowired
	private DottoreService dottoreService;
	
	@GetMapping
	public List<DottoreDTO> listAll(){
		return DottoreDTO.createListDTOFromModel(dottoreService.listAll());
	}
	
	@GetMapping("/{cf}")
	public DottoreDTO cercaPerCodiceFiscale(@PathVariable(required = true) String cf) {
		Dottore result = dottoreService.cercaPerCodiceFiscale(cf);
		
		if(result == null)
			throw new DottoreNotFoundException("nessun dottore trovato che stia visitando questo paziente");
			
		return DottoreDTO.buildDottoreDTOFromModel(result);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void inserisciDottore(@RequestBody DottoreDTO dottore) {
		
		if(dottore.getId() != null)
			throw new IdNotNullForInsertException("impossibile inserire un nuovo record se contenente id");
		
		dottoreService.inserisciNuovo(dottore.buildDottoreModel());
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody DottoreDTO dottore) {
		if(dottore.getId() == null)
			throw new IdNullForUpdateException("impossibile aggiornare un record se non si inserisce l'id");
		
		dottoreService.aggiorna(dottore.buildDottoreModel());
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true) Long id) {
		Dottore dottoreDaEliminare = dottoreService.caricaSingoloElemento(id);
		
		if(dottoreDaEliminare == null)
			throw new DottoreNotFoundException("nessun dottore trovato");
		
		dottoreService.rimuovi(id);
	}
}
