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
		Usuario u1 = new Usuario();
		u1.setAdmin(true);
		u1.setSenha("123");
		u1.setLogin("admin");
		
		lista.add(u1);
		
		Usuario u2 = new Usuario();
		u2.setAdmin(false);
		u2.setSenha("123");
		u2.setLogin("noAdmin");
		
		lista.add(u2);
	}

}
