package br.com.casadocodigo.livraria.dao.validacao;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.casadocodigo.livraria.dao.controlador.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

public class LivroValidator {

	private Validator validator;
	private Estante estante;

	public LivroValidator(Validator validator, Estante estante) {
		this.validator = validator;
		this.estante = estante;
	}

	public void validate(Livro livro) {

	}

	// gere os delegate methods do Validator usando a sua IDE!
	public <T> T onErrorRedirectTo(T controller) {
		return validator.onErrorRedirectTo(controller);
	}

}
