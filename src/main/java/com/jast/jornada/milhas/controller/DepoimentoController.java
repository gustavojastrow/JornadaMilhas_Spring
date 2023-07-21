package com.jast.jornada.milhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jast.jornada.milhas.domain.depoimento.DepoimentoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentoController {
    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @Transactional
    @PostMapping
    public void cadastrarDepoimento(@RequestBody DadosCadastro dados){
        depoimentoRepository.save(new Depoimento(dados));
    }
}
