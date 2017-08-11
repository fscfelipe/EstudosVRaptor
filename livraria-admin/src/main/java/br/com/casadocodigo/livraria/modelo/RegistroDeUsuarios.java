package br.com.casadocodigo.livraria.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class RegistroDeUsuarios {
	
	List<Usuario> lista = new ArrayList<Usuario>();
	
	public void adicionarUsuario(Usuario usuario) {
		this.lista.add(usuario);
	}
	
	public Usuario comLoginESenha(String login, String senha) {
		for(Usuario u:lista) {
			if(u.getLogin().equals(login) && u.getSenha().equals(senha))
				return u;
		}
		
		return null;
	}
	
	public void usuarioPadrao() {
		Usuario u = new Usuario();
		u.setAdmin(true);
		u.setSenha("123");
		u.setLogin("admin");
		
		lista.add(u);
	}

}
