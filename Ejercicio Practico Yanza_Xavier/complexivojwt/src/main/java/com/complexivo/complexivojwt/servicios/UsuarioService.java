package com.complexivo.complexivojwt.servicios;

import java.util.List;

import com.complexivo.complexivojwt.modelos.Usuario;

public interface UsuarioService {
	
	Usuario agregarUsuario(Usuario usuario);
	List<Usuario> recuperarUsuarios();
	Usuario buscarPorUsername(String username);
	Usuario iniciarSesion(String username,String contrasenia);
	Usuario actualizarUsuario(Usuario usuario, Long id);
	String elimiarUsuario(Long id);

}
