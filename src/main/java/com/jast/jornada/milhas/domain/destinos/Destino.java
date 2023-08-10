package com.jast.jornada.milhas.domain.destinos;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
@Table(name = "destinos")
@Entity(name= "Destino")

public class Destino {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String foto;
    @NotBlank
    private String nome;
    @NotBlank
    private Float preco;

    public Destino(DadosCadastroDestino dados) {
        this.foto = dados.foto();
        this.nome = dados.nome();
        this.preco = dados.preco();
    }

    public void atualizarDestino(ListagemDestino dados) {
        if (dados.foto() != null){
            this.foto = dados.foto();
        }
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.preco() != null){
            this.preco = dados.preco();
        }        
    }
}
