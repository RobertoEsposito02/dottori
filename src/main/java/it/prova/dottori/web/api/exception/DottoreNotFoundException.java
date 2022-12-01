package it.prova.dottori.web.api.exception;

public class DottoreNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DottoreNotFoundException(String message) {
		super(message);
	}
}
