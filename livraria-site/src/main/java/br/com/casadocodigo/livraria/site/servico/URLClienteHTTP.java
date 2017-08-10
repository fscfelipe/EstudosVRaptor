package br.com.casadocodigo.livraria.site.servico;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.common.io.CharStreams;

import br.com.caelum.vraptor.ioc.Component;
import br.com.casadocodigo.livraria.site.excecoes.ServidorIndisponivelException;

@Component
public class URLClienteHTTP implements ClienteHTTP {

	/*
	 * Precisamos agora converter essa resposta de InputStream para String . Exis-
	 * tem vários jeitos de fazer isso, em várias bibliotecas diferentes. Vamos usar
	 * a classe com.google.common.io.CharStreams , da biblioteca Google Guava que já
	 * é dependência do VRaptor e contém vários utilitários que melhoram vários
	 * aspec- tos do Java. Essa classe consegue transformar um Reader numa String ,
	 * e para transformar o InputStream num Reader usamos o InputStreamReader do
	 * próprio java.
	 */

	@Override
	public String get(String url) {
		
		try {
			URL servico = new URL(url);
			InputStream resposta = servico.openStream();
			Reader reader = new InputStreamReader(resposta);
			return CharStreams.toString(reader);
		} catch (MalformedURLException e) {
			
			/*
			 * A MalformedURLException , no nosso caso, seria culpa do programador, já que
			 * as urls vão vir do código, logo podemos supor que elas só vão aconte- cer em
			 * tempo de desenvolvimento e simplesmente a lançarmos dentro de alguma
			 * RuntimeException .
			 */
			
			throw new IllegalArgumentException("A url " + url +
					" está inválida, corrija-a!", e);
			
		} catch (IOException e) {
			
			/*
			 * Já a IOException foge do nosso controle e, se faz parte do nosso processo se
			 * recuperar de alguma forma caso o servidor esteja fora do ar, precisamos
			 * deixar isso no contrato do nosso cliente http, ou seja, da interface
			 * ClienteHTTP . Lançar IOException talvez seja genérico demais — podemos optar
			 * por criar uma exceção mais específica, como ServidorIndisponivelException.
			 */
			
			throw new ServidorIndisponivelException(url, e);
			
			/*
			 * A ServidorIndisponivelException está como RuntimeException para não
			 * obrigarmos o usuário do ClienteHTTP a tratá-la. Mas deixamos a exceção
			 * declarada na interface, para que o usuário saiba que tem a opção de se
			 * recuperar desse caso específico. Se quisermos obrigar a sempre tratar esse
			 * caso, trocamos o extends para Exception , mas cuidado que isso pode gerar
			 * muitos métodos que, ou relançam essa exceção declarando o throws
			 * ServidorIndisponivelException , ou fazem um try..catch relançando a exceção
			 * dentro de uma RuntimeException , que tornam o código bem chato de manter e
			 * evoluir.
			 */
		}
	}

}
