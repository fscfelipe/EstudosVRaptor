package br.com.casadocodigo.livraria.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioLogado {
	
	private Usuario usuario;
	
	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado() {
		return this.usuario != null;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void desloga() {
		this.usuario = null;
	}

}
