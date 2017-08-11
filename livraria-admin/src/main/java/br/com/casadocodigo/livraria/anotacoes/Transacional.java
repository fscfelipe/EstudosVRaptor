package br.com.casadocodigo.livraria.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*pag.126 [...] uma anotação para indicar
que o método será interceptado, nesse caso, se o método deverá ser executado den-
tro de uma transação. Podemos criar a anotação @Transacional para esse fim.
Para isso, primeiramente devemos criar a classe da anotação, usando a palavra chave
@interface*/

/*precisamos dizer em que lugares essa anotação será válida, usando
a anotação @Target . Os lugares válidos vão de parâmetros e construtores até clas-
ses e pacotes. No nosso caso, só precisamos dessa anotação para métodos, então
escolhemos esse valor na configuração do @Target*/

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
public @interface Transacional {
	
	

}
