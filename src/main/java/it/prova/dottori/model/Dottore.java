package it.prova.dottori.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "dottore")
public class Dottore {
	private String nome;
	private String cognome;
	private String codiceDottore;
	private String codFiscalePazienteAttualmenteInVisita;
	private boolean inVisita;
	private boolean inServizio;
}
