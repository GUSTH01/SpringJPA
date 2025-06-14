package com.example.demo.controller;

import com.example.demo.exceptions.RecursoNaoEncontradoException;
import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return  produtoService.listarProdutos();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
            Produto produto = produtoService.buscarPorId(id);
            return ResponseEntity.ok(produto);

    }

    @PostMapping
    public Produto criarProduto (@RequestBody Produto produto){
    return produtoService.salvarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@RequestBody Long id, Produto produto){
        return produtoService.atualizaProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }


}
