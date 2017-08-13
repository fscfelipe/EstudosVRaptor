package br.com.casadocodigo.livraria.conversores;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import com.google.common.base.Strings;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.casadocodigo.livraria.modelo.Dinheiro;
import br.com.casadocodigo.livraria.utils.Moeda;

@Convert(Dinheiro.class)
@ApplicationScoped
public class DinheiroConverter implements Converter<Dinheiro> {

	@Override
	public Dinheiro convert(String value, Class<? extends Dinheiro> type, ResourceBundle bundle) {

		if (Strings.isNullOrEmpty(value)) { return null;}
		
		for (Moeda moeda : Moeda.values()) {
			if (value.startsWith(moeda.getSimbolo())) {
				return new Dinheiro(moeda, criaMontante(value, moeda, bundle));
			}
		}

		throw new ConversionError(MessageFormat.format(bundle.getString("dinheiro_invalido"), value));
	}

	private BigDecimal criaMontante(String value, Moeda moeda, ResourceBundle bundle) {
		try {
			return new BigDecimal(value.replace(moeda.getSimbolo(), "").replace(',', '.').trim());
		} catch (NumberFormatException e) {
			throw new ConversionError(MessageFormat.format(bundle.getString("dinheiro_invalido"), value));
		}
	}

}
