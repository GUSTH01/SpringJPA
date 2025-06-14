package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario criaUsuario(String nome, String password){
        String senhaCriptografada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario (nome,senhaCriptografada);
        return usuarioRepository.save(usuario);
    }
    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscaPorID(String nome){
        return usuarioRepository.findByNome(nome);
    }

    public void deletaUsuario(long id){
     usuarioRepository.deleteById(id);
    }

}
