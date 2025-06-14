package com.example.demo.repository;

import com.example.demo.service.MensagemService;
import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

    public String obterMensagem (){
        return "Olá repositório";
    }
}
