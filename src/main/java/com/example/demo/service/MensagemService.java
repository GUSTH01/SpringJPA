package com.example.demo.service;

import com.example.demo.repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    public MensagemService (MensagemRepository mensagemRepository){

        this.mensagemRepository =mensagemRepository;

    }

    public String obterMensagem(){
        return mensagemRepository.obterMensagem();
    }



}
