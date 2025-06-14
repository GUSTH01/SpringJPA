package com.example.demo.service;

import com.example.demo.exceptions.RecursoNaoEncontradoException;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {

        return produtoRepository.findAll();

    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com id "+id+" não encontrado"));
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }
 public Produto atualizaProduto(Long id, Produto produto){
        produtoRepository.findById(id);
        return produtoRepository.save(produto);
    }


    public void deletarProduto(Long id){

        if (!produtoRepository.existsById(id)) {

            throw new RecursoNaoEncontradoException("Produto com if "+id+" não encontrado.");
        }

        produtoRepository.deleteById(id);
    }



}
