package br.com.muralis.gerador.sequencial.core.exception;

public class DomainException extends RuntimeException {

	public DomainException(String message) {
		super(message);
	}

	public static DomainException GSQ_FORMATO_NAO_ACEITO() {
		return new DomainException(
				"Os dados passados não estão em um formato aceito, por favor verifique a informação solicitada.");
	}

	public static Exception GSQ_SEQUENCIAL_PREVIAMENTE_INFORMADO(String nome) {
		return new DomainException("O sequencial " + nome + " já foi recuperado anteriormente.");
	}

}
