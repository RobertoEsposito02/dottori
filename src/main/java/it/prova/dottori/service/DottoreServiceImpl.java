package it.prova.dottori.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.dottori.model.Dottore;
import it.prova.dottori.repository.DottoreRepository;

@Service
public class DottoreServiceImpl implements DottoreService{

	@Autowired
	private DottoreRepository dottoreRepository;
	
	@Override
	public List<Dottore> listAll() {
		return (List<Dottore>) dottoreRepository.findAll();
	}

	@Override
	public Dottore caricaSingoloElemento(Long id) {
		return dottoreRepository.findById(id).orElse(null);
	}

	@Override
	public Dottore caricaSingoloElementoEager(Long id) {
		return null;
	}

	@Override
	public void aggiorna(Dottore dottoreInstance) {
		dottoreRepository.save(dottoreInstance);
	}

	@Override
	public void inserisciNuovo(Dottore dottoreInstance) {
		dottoreInstance.setInServizio(true);
		dottoreInstance.setInVisita(false);
		dottoreRepository.save(dottoreInstance);
	}

	@Override
	public void rimuovi(Long idToRemove) {
		dottoreRepository.deleteById(idToRemove);
	}

	@Override
	public Dottore cercaPerCodiceFiscale(String codiceFiscale) {
		return dottoreRepository.findByCodFiscale(codiceFiscale);
	}

	@Override
	public Dottore verificaDisponibilita(String cd) {
		return dottoreRepository.caricaDottoreFromCodiceDottore(cd);
	}

	@Override
	public Dottore impostaDottore(Dottore dottore) {
		Dottore result = dottoreRepository.caricaDottoreFromCodiceDottore(dottore.getCodiceDottore());
		result.setCodFiscalePazienteAttualmenteInVisita(dottore.getCodFiscalePazienteAttualmenteInVisita());
		return dottoreRepository.save(result);
	}

	@Override
	public Dottore ricovera(Dottore dottore) {
		Dottore result = dottoreRepository.caricaDottoreFromCodiceDottore(dottore.getCodiceDottore());
		result.setCodFiscalePazienteAttualmenteInVisita(null);
		result.setInVisita(false);
		return dottoreRepository.save(result);
	}

}
