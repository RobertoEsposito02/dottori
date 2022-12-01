package it.prova.dottori.dto;

import it.prova.dottori.model.Dottore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class DottorePazienteDTO {
	private String codiceDottore;
	private String codFiscalePazienteAttualmenteInVisita;
	
	public static DottorePazienteDTO buildDottoreDTOFromModel(Dottore dottoreModel) {
		DottorePazienteDTO result = DottorePazienteDTO.builder()
				.codiceDottore(dottoreModel.getCodiceDottore())
				.codFiscalePazienteAttualmenteInVisita(dottoreModel.getCodFiscalePazienteAttualmenteInVisita())
				.build();
		return result;
	}
	
}
