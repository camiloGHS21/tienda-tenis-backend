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

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins="http://localhost:5173/")
public class UsuariosController {

    @Autowired
    private UsuariosRepository repositorio;

    @GetMapping("/ver_todos")
    public List<Usuarios> verTodosLosUsuarrios() {
        return repositorio.findAll();
    }

    @PostMapping("/buscar_id")
    public ResponseEntity<Usuarios> verUsuarios(@RequestBody Long id) {
        return repositorio.findById(id)
                .map(usuario -> ResponseEntity.ok(usuario))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    @PostMapping("/guardar")
    public ResponseEntity<Usuarios> guardarUsuarios(@RequestBody Usuarios usuario) {
        try {
            Usuarios savedUsuario = repositorio.save(usuario);
            return ResponseEntity.ok(savedUsuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<String> borrarUsuarios(@RequestBody Long cedula) {
        try {
            repositorio.deleteById(cedula);
            return ResponseEntity.ok("Usuarios eliminados correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizarUsuarios(@RequestBody Usuarios usuarios) {
        try {
            repositorio.save(usuarios);
            return ResponseEntity.ok("Usuarios actualizados correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar los usuarios: " + e.getMessage());
        }
    }
}
