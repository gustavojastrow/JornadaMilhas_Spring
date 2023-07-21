package com.jast.jornada.milhas.domain.depoimento;

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
@Table(name = "depoimentos")
@Entity(name= "Depoimento")

public class Depoimento {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String foto;
    @NotBlank
    private String depoimento;
    @NotBlank
    private String autor;

    public Depoimento(DadosCadastro dados) {
        this.foto = dados.foto();
        this.depoimento = dados.depoimento();
        this.autor = dados.autor();
    }

    public void atualizarDepoimento(ListagemDepoimento dados) {
        if (dados.foto() != null){
            this.foto = dados.foto();
        }
        if (dados.depoimento() != null){
            this.depoimento = dados.depoimento();
        }
        if (dados.autor() != null){
            this.autor = dados.autor();
        }        
    }
}
