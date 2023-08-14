package com.jast.jornada.milhas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.jast.jornada.milhas.domain.destinos.DadosCadastroDestino;
import com.jast.jornada.milhas.domain.destinos.Destino;
import com.jast.jornada.milhas.domain.destinos.DestinoRepository;
import com.jast.jornada.milhas.domain.destinos.ListagemDestino;
import com.jast.jornada.milhas.infra.Errors;
import com.jast.jornada.milhas.infra.StringValidation;


@RestController
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoRepository destinoRepository;


    @Transactional
    @PostMapping
    public ResponseEntity<Object> cadastrarDestino(@RequestBody @Valid DadosCadastroDestino dados, UriComponentsBuilder uriComponentsBuilder)
    {
        Destino destino = new Destino(dados);

        if(StringValidation.isNullEmptyOrBlank(dados.texto()))
            destino.gerarDescricao();

        destinoRepository.save(destino);
        return ResponseEntity.created(uriComponentsBuilder.path("/destinos/created/{id}").buildAndExpand(destino.getId()).toUri()).body(new ListagemDestino(destino));
    }

    @GetMapping(params = "nome")
    public ResponseEntity<Object> getDestinoByNome(@RequestParam("nome") String nome) {
        List<Destino> list = destinoRepository.findDestinoByNome(nome);
        if (list.isEmpty()) {
            return new ResponseEntity<>(new Errors("Nenhum destino foi encontrado"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDestinoById(@PathVariable Long id) {
        Destino destino = destinoRepository.findDestinoById(id);
        if (destino == null) {
            return new ResponseEntity<>(new Errors("Nenhum destino foi encontrado"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ListagemDestino(destino), HttpStatus.OK);
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
