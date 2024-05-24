package com.example.demo.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class PedidosTests {

    private Pedidos pedido;

    @Before
    public void setUp() {
        pedido = new Pedidos();
    }

    @Test
    public void testSetAndGetIdPedido() {
        Long idPedido = 1L;
        pedido.setId_pedido(idPedido);

        assertEquals(idPedido, pedido.getId_pedido());
    }

    @Test
    public void testSetAndGetCantidad() {
        Long cantidad = 5L;
        pedido.setCantidad(cantidad);

        assertEquals(cantidad, pedido.getCantidad());
    }

    @Test
    public void testSetAndGetPrecioTotal() {
        double precioTotal = 99.99;
        pedido.setPrecio_total(precioTotal);

        assertEquals(precioTotal, pedido.getPrecio_total(), 0.001);
    }

    @Test
    public void testSetAndGetUsuario() {
        Usuarios usuario = new Usuarios();
        pedido.setUsuario(usuario);

        assertNotNull(pedido.getUsuario());
    }

    @Test
    public void testSetAndGetProductos() {
        List<Productos> productos = new ArrayList<>();
        Productos producto = new Productos();
        productos.add(producto);
        pedido.setProductos(productos);

        assertNotNull(pedido.getProductos());
        assertEquals(1, pedido.getProductos().size());
    }

    @Test
    public void testConstructorWithParameters() {
        Long cantidad = 5L;
        double precioTotal = 99.99;
        Usuarios usuario = new Usuarios();
        List<Productos> productos = new ArrayList<>();
        Productos producto = new Productos();
        productos.add(producto);

        Pedidos pedidoConParametros = new Pedidos(cantidad, precioTotal, usuario);
        pedidoConParametros.setProductos(productos);

        assertEquals(cantidad, pedidoConParametros.getCantidad());
        assertEquals(precioTotal, pedidoConParametros.getPrecio_total(), 0.001);
        assertNotNull(pedidoConParametros.getUsuario());
        assertNotNull(pedidoConParametros.getProductos());
        assertEquals(1, pedidoConParametros.getProductos().size());
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(pedido);
    }
}
