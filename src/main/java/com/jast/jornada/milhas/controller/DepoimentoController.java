package com.jast.jornada.milhas.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jast.jornada.milhas.domain.depoimento.DadosCadastroDepoimento;
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
    public ResponseEntity<Depoimento> cadastrarDepoimento(@RequestBody DadosCadastroDepoimento dados, UriComponentsBuilder uriBuilder) throws IOException{
        var depoimento = new Depoimento(dados);
        depoimentoRepository.save(depoimento);
        var uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(depoimento.getId()).toUri();

        return ResponseEntity.created(uri).body(depoimento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListagemDepoimento> listarPorId(@PathVariable Long id){
        var depoimentoId = depoimentoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ListagemDepoimento(depoimentoId));
    }

    @GetMapping
    public ResponseEntity<Object> listar(@PageableDefault(size=10) Pageable paginacao){
        var depoimento = depoimentoRepository.findAll(paginacao).map(ListagemDepoimento::new);
        return ResponseEntity.ok(depoimento);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<ListagemDepoimento> atualizarDepoimento(@RequestBody ListagemDepoimento dados){
        var depoimento = depoimentoRepository.getReferenceById(dados.id());
        depoimento.atualizarDepoimento(dados);

        return ResponseEntity.ok(new ListagemDepoimento(depoimento));
    }


    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id){
        depoimentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        
    }
}
