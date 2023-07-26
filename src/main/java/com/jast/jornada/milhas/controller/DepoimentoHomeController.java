package com.jast.jornada.milhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jast.jornada.milhas.domain.depoimento.DepoimentoRepository;
import com.jast.jornada.milhas.domain.depoimento.ListagemDepoimento;

@RestController
@RequestMapping("/depoimentos-home")
public class DepoimentoHomeController {
    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @GetMapping
    public ResponseEntity<Object> listarAleatorio(@PageableDefault(size=3) Pageable paginacao){
        var depoimento = depoimentoRepository.retornarAleatorio(paginacao).map(ListagemDepoimento::new);
        return ResponseEntity.ok(depoimento);
    }
}