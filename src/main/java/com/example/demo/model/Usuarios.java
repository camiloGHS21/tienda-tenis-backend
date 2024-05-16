package com.example.demo.model;


import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {
@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id_usuario;

 @Column(nullable = false)
 private String nombre;

 @Column(nullable = false)
 private String apellidos;

 @Column(nullable = false)
 private Long telefono;

 @Column(nullable = false)
 private Long edad;
 
 @Column(nullable = false)
 private String password;

 @Column(nullable = false)
 private String tipo_de_usuario;

 @OneToMany(mappedBy = "id_pedido", cascade = CascadeType.ALL)
 private List<Pedidos> Pedidos;


 public Long getId_usuario() {
    
    return id_usuario;
}


public void setId_usuario(Long id_usuario) {
    this.id_usuario = id_usuario;
}


public String getNombre() {
    return nombre;
}


public Usuarios() {
    super();
}







public Usuarios(Long id_usuario, String nombre, String apellidos, Long telefono, Long edad, String password,
		String tipo_de_usuario, List<Pedidos> pedidos) {
	super();
	this.id_usuario = id_usuario;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.telefono = telefono;
	this.edad = edad;
	this.password = password;
	this.tipo_de_usuario = tipo_de_usuario;
	Pedidos = pedidos;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public List<Pedidos> getPedidos() {
	return Pedidos;
}


public void setPedidos(List<Pedidos> pedidos) {
	Pedidos = pedidos;
}


public void setNombre(String nombre) {
    this.nombre = nombre;
}


public String getApelllidos() {
    return apellidos;
}


public void setApelllidos(String apelllidos) {
    this.apellidos = apelllidos;
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


public String getTipo_de_usuario() {
    return tipo_de_usuario;
}


public void setTipo_de_usuario(String tipo_de_usuario) {
    this.tipo_de_usuario = tipo_de_usuario;
}






}


