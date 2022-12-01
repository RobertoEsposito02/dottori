package it.prova.dottori.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.dottori.dto.DottoreDTO;
import it.prova.dottori.model.Dottore;
import it.prova.dottori.service.DottoreService;
import it.prova.dottori.web.api.exception.DottoreNotFoundException;

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
}
