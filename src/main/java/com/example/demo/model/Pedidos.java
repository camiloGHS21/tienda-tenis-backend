package com.example.demo.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos")
public class Pedidos {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_pedido;

	  @Column(nullable = false)
	  private Long cantidad;
	
	 @Column(nullable = false)
	  private double precio_unitario;
	 @Column(nullable = false)
	  private double precio_total;
	 
	 @OneToMany(mappedBy = "id_producto", cascade = CascadeType.ALL)
	 private List<Productos> Productos;


	public Pedidos(Long id_pedido, double precio_unitario, double precio_total) {
		super();
		this.id_pedido = id_pedido;
		this.precio_unitario = precio_unitario;
		this.precio_total = precio_total;
	
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}


	public Pedidos() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	  
	    
}
