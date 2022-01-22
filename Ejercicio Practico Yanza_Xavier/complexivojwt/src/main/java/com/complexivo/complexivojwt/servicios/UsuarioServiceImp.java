package com.complexivo.complexivojwt.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complexivo.complexivojwt.modelos.Usuario;
import com.complexivo.complexivojwt.repositorios.UsuarioDAO;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDao;
	@Override
	public Usuario agregarUsuario(Usuario usuario) {
		if(usuarioDao.recuperarPorUsername(usuario.getUsername())==null) {
			return usuarioDao.createUsuario(usuario);
		}
		return null;
	}

	@Override
	public List<Usuario> recuperarUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.getUsuarios();
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.recuperarPorUsername(username);
	}

	@Override
	public Usuario iniciarSesion(String username, String contrasenia) {
		// TODO Auto-generated method stub
		return usuarioDao.iniciarSesion(username, contrasenia);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario,Long id) {
		
		if(usuarioDao.buscarPorId(id) !=null) {
			usuario.setUserId(id);
			return usuarioDao.createUsuario(usuario);
		}else {
			return usuarioDao.createUsuario(usuario);
		}
		
	}

	@Override
	public String elimiarUsuario(Long id) {
		if(usuarioDao.buscarPorId(id)!=null) {
			usuarioDao.eliminar(id);
			return "Usuario con id: "+id+" ha sido eliminado";
		}
		return "No existe el usuario ingresado";
	}
	
	

}
