package com.example.demo.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
     
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Productos producto;

    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long id_carrito) {
        this.id_carrito = id_carrito;
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

	


	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	

	public Carrito(long cantidad_de_productos, Long total, Productos producto) {
		super();
	
		this.cantidad_de_productos = cantidad_de_productos;
		this.total = total;
		this.producto = producto;
	}

	public Carrito() {
        super();
    }
	
}


