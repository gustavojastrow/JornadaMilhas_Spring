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

import com.jast.jornada.milhas.domain.destinos.DadosCadastroDestino;
import com.jast.jornada.milhas.domain.destinos.Destino;
import com.jast.jornada.milhas.domain.destinos.DestinoRepository;
import com.jast.jornada.milhas.domain.destinos.ListagemDestino;


@RestController
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoRepository destinoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<Destino> cadastrarDepoimento(@RequestBody DadosCadastroDestino dados, UriComponentsBuilder uriBuilder) throws IOException{
        var destino = new Destino(dados);
        destinoRepository.save(destino);
        var uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(destino.getId()).toUri();

        return ResponseEntity.created(uri).body(destino);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListagemDestino> listarPorId(@PathVariable Long id){
        var destinoId = destinoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ListagemDestino(destinoId));
    }

    @GetMapping
    public ResponseEntity<Object> listar(@PageableDefault(size=10) Pageable paginacao){
        var destino = destinoRepository.findAll(paginacao).map(ListagemDestino::new);
        return ResponseEntity.ok(destino);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<ListagemDestino> atualizarDestino(@RequestBody ListagemDestino dados){
        var destino = destinoRepository.getReferenceById(dados.id());
        destino.atualizarDestino(dados);

        return ResponseEntity.ok(new ListagemDestino(destino));
    }


    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id){
        destinoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        
    }
}
