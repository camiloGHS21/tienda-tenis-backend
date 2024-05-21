package com.example.demo.model;


import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {
	
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id_usuario;

@Email(message = "Por favor, introduce una dirección de correo electrónico válida")
@Column(nullable = false)
private String email;
 
 @Column(nullable = false)
 private String password;

 @Column(nullable = false)
 private String tipo_de_usuario;

 @OneToMany(mappedBy = "id_pedido", cascade = CascadeType.ALL)
 private List<Pedidos> Pedidos;



 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "id_usuarioInfo", referencedColumnName = "id_usuarioInfo")
 private UsuariosInfo usuariosInfo;


 public Long getId_usuario() {
    
    return id_usuario;
}


public void setId_usuario(Long id_usuario) {
    this.id_usuario = id_usuario;
}


public UsuariosInfo getUsuariosInfo() {
	return usuariosInfo;
}


public void setUsuariosInfo(UsuariosInfo usuariosInfo) {
	this.usuariosInfo = usuariosInfo;
}


public Usuarios() {
    super();
}

public Usuarios(Long id_usuario, String email, String password, String tipo_de_usuario,
		List<com.example.demo.model.Pedidos> pedidos, UsuariosInfo usuariosInfo) {
	super();
	this.id_usuario = id_usuario;
	this.email = email;
	this.password = password;
	this.tipo_de_usuario = tipo_de_usuario;
	Pedidos = pedidos;
	this.usuariosInfo = usuariosInfo;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
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




public String getTipo_de_usuario() {
    return tipo_de_usuario;
}


public void setTipo_de_usuario(String tipo_de_usuario) {
    this.tipo_de_usuario = tipo_de_usuario;
}


}


