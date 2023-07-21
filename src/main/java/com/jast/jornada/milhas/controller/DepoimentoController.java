package com.jast.jornada.milhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jast.jornada.milhas.domain.depoimento.DadosCadastro;
import com.jast.jornada.milhas.domain.depoimento.Depoimento;
import com.jast.jornada.milhas.domain.depoimento.DepoimentoRepository;
import com.jast.jornada.milhas.domain.depoimento.ListagemDepoimento;


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

    @GetMapping
    public List<ListagemDepoimento> listar(){
        return depoimentoRepository.findAll().stream().map(ListagemDepoimento::new).toList();
    }


    @Transactional
    @PutMapping
    public void atualizarDepoimento(@RequestBody ListagemDepoimento dados){
        var depoimento = depoimentoRepository.getReferenceById(dados.id());
        depoimento.atualizarDepoimento(dados);
    }


    @Transactional
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        depoimentoRepository.deleteById(id);
    }
}
