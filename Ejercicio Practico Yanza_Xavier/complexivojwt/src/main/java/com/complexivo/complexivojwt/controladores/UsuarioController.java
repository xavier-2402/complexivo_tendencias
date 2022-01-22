package com.complexivo.complexivojwt.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.complexivo.complexivojwt.auth.GenerarToken;
import com.complexivo.complexivojwt.modelos.Usuario;
import com.complexivo.complexivojwt.servicios.UsuarioService;


@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listar-usuarios")
	public List<Usuario> getUsuarios(){
		 return usuarioService.recuperarUsuarios();
	}
	
	@PostMapping("/crear-usuario")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.agregarUsuario(usuario);
	}

	
	@GetMapping("/login")
	public Usuario login(@RequestParam("username") String username, @RequestParam("contrasenia")String contrasenia){
		Usuario usuario = usuarioService.iniciarSesion(username, contrasenia);
		if(usuario !=null) {
			usuario.setToken(GenerarToken.getJwtToken(username));
			return usuario ;
		}
		return new Usuario();
	}
	
	 @GetMapping("/login/{username}/{contrasena}")
	    public Usuario IniciarSesion(@PathVariable String username,@PathVariable String contrasena){

	        Usuario usuario = usuarioService.iniciarSesion(username, contrasena);

	        if(usuario != null){

	            usuario.setToken(GenerarToken.getJwtToken(username));
	            return usuario;
	        }

	    return new Usuario();
	    }
	
	@PutMapping("/actualizar-usuario/{id}")
	public Usuario actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
		return usuarioService.actualizarUsuario(usuario, id);
		
	}
	
	@GetMapping("/crear-prueba")
    public Usuario crearUsuarioManual(){
        Usuario usuario = new Usuario();
        usuario.setUsername("usuario");
        usuario.setContrasenia("1234");
        usuario.setNombreCompleto("Usuario de Prueba");
        return usuarioService.agregarUsuario(usuario);

    }
	
	@DeleteMapping("/eliminar-usuario/{id}")
	public String eliminarUsuario(@PathVariable long id) {
		return usuarioService.elimiarUsuario(id);
	}
	
	
}
