package com.complexivo.complexivojwt.repositorios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.complexivo.complexivojwt.modelos.Usuario;

@Repository
public class UsuarioDAOImp implements UsuarioDAO {

	@Autowired
	private UsuarioRepository usuariorepository;
	@Override
	public Usuario createUsuario(Usuario usuario) {
		Usuario usuariocreado = usuariorepository.save(usuario);
		return usuariocreado;
	}

	@Override
	public Usuario recuperarPorUsername(String username) {
		Usuario usuario=usuariorepository.findByUsername(username);
		return usuario;
	}

	@Override
	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return usuariorepository.findAll();
	}

	@Override
	public Usuario iniciarSesion(String username, String contrasenia) {
		// TODO Auto-generated method stub
		return usuariorepository.findByUsernameAndContrasenia(username, contrasenia);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return usuariorepository.findByUserId(id);
	}

	@Override
	public void eliminar(Long id ) {
		// TODO Auto-generated method stub
		usuariorepository.deleteById(id);
		
	}

	
}
