package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<?> register(@RequestBody Map<String, String> request){
        Usuario usuario = usuarioService.criaUsuario(request.get("nome"),"password");
        return ResponseEntity.ok(usuario);
    }
    @GetMapping
    public ResponseEntity<?> login (@RequestBody Map<String, String> request){
        Optional<Usuario> usuario = usuarioService.buscaPorNome(request.get("nome"));
        if (usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))){
            String token = JwtUtil.generateToken("nome");
            return ResponseEntity.ok(Map.of("token", token));
        }
        return  ResponseEntity.status(401).body("Credenciais inválidas");
    }

}
