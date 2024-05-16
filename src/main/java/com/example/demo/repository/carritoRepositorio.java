package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.demo.model.Carrito;



@RepositoryRestResource
public interface carritoRepositorio extends JpaRepository<Carrito,Long>{



}
