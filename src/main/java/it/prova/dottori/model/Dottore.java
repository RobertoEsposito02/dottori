package it.prova.dottori.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "codicedottore")
	private String codiceDottore;
	@Column(name = "codfiscalepazienteattualmenteinvisita")
	private String codFiscalePazienteAttualmenteInVisita;
	@Column(name = "invisita")
	private boolean inVisita;
	@Column(name = "inservizio")
	private boolean inServizio;
}
