package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrito;
import com.example.demo.repository.CarritoRepository;


@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173/")
public class CarritoController {

    @Autowired
    private CarritoRepository repository;

    @GetMapping("/items")
    public List<Carrito> getAllItems() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Carrito> addItem(@RequestBody Carrito item) {
        try {
        	Carrito savedItem = repository.save(item);
            return ResponseEntity.ok(savedItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateItem(@RequestBody Carrito item) {
        try {
            repository.save(item);
            return ResponseEntity.ok("Item updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating item: " + e.getMessage());
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeItem(@RequestBody Long itemId) {
        try {
            repository.deleteById(itemId);
            return ResponseEntity.ok("Item removed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing item: " + e.getMessage());
        }
    }
}
