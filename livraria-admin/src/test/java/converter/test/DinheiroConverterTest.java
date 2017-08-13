package converter.test;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.casadocodigo.livraria.conversores.DinheiroConverter;
import br.com.casadocodigo.livraria.modelo.Dinheiro;
import br.com.casadocodigo.livraria.utils.Moeda;

public class DinheiroConverterTest {

	@Test
	public void converteUmValorEmReais() {
		Converter<Dinheiro> converter = new DinheiroConverter();

		assertEquals(converter.convert("R$ 1,00", null, null), new Dinheiro(Moeda.REAL, new BigDecimal("1.00")));

	}

	@Test
	public void converteUmValorEmDolares() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		assertThat(converter.convert("US$ 49,95", null, null), is(new Dinheiro(Moeda.DOLAR, new BigDecimal("49.95"))));
	}

	@Test(expected = ConversionError.class)
	public void lancaErroDeConversaoQuandoOValorEhInvalido() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		converter.convert("noventa pratas!", null, ResourceBundle.getBundle("messages"));
	}

	@Test(expected = ConversionError.class)
	public void lancaErroDeConversaoQuandoOMontanteEhInvalido() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		converter.convert("R$ mil", null, ResourceBundle.getBundle("messages"));
	}

	@Test
	public void converteStringVaziaEmNull() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		ResourceBundle bundle = ResourceBundle.getBundle("messages");
		assertThat(converter.convert("", null, bundle), is(nullValue()));
	}

}
