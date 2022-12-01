package it.prova.dottori.web.api.exception;

public class DottoreNonDisponibileEsception extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DottoreNonDisponibileEsception(String message) {
		super(message);
	}
}
