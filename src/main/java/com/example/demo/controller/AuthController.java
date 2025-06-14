package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UsuarioService usuarioService;

    public AuthController authController;

    public AuthController(UsuarioService usuarioService, AuthController authController){
        this.usuarioService = usuarioService;
        this.authController = authController;
    }
    @PostMapping
    public ResponseEntity<?> register(@RequestBody Map<String, String> Request){
        Usuario usuario = usuarioService.criaUsuario("nome","password");
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public List<Usuario> listaUsuarios(){
        return usuarioService.listaUsuarios();
    }


}
