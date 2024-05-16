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
@Table(name = "carrito")
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_carrito;

	@Column(nullable = false)
	private long cantidad_de_productos;

	@Column(nullable = false)
	private Long total;
    
    @OneToMany(mappedBy = "id_producto", cascade = CascadeType.ALL)
    private List<Productos> productos;

	public Long getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(Long id_carritp) {
		this.id_carrito = id_carritp;
	}

	public long getCantidad_de_productos() {
		return cantidad_de_productos;
	}

	public void setCantidad_de_productos(long cantidad_de_productos) {
		this.cantidad_de_productos = cantidad_de_productos;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}



	public Carrito(Long id_carrito, long cantidad_de_productos, Long total) {
		this.id_carrito = id_carrito;
		this.cantidad_de_productos = cantidad_de_productos;
		this.total = total;

	}

	public Carrito() {
		super();
	}

}
