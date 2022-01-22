package com.complexivo.complexivojwt.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name="username",nullable = false)
	private String username;
	
	@Column(name="contrasenia",nullable = false)
	private String contrasenia;
	
	@Column(name="nombre_completo",nullable = false)
	private String nombreCompleto;
	
	private String token;
	
	public Usuario(long userId, String username, String contrasenia, String nombreCompleto, String token) {
		this.userId = userId;
		this.username = username;
		this.contrasenia = contrasenia;
		this.nombreCompleto = nombreCompleto;
		this.token = token;
	}

	public Usuario() {
		
	}
	
	public Usuario( String username, String contrasenia, String nombreCompleto, String token) {
		this.username = username;
		this.contrasenia = contrasenia;
		this.nombreCompleto = nombreCompleto;
		this.token = token;
	}



	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
