package com.complexivo.complexivojwt.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.complexivo.complexivojwt.modelos.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	Usuario findByUsername(String username);
	
	Usuario findByUsernameAndContrasenia(String username,String contrasenia);
	
	Usuario findByUserId(Long id);
}
