package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuariosInfo")
public class UsuariosInfo {
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 private Long id_usuarioInfo;
	 
	 @Column(nullable = false)
	 private String nombre;

	 @Column(nullable = false)
	 private String apellidos;

	 @Column(nullable = false)
	 private Long telefono;

	 @Column(nullable = false)
	 private Long edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public UsuariosInfo(String nombre, String apellidos, Long telefono, Long edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.edad = edad;
	}

	public UsuariosInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
