package com.jast.jornada.milhas.domain.destinos;

import javax.validation.constraints.NotBlank;

import com.jast.jornada.chat.ChatGpt;

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
    private String url_1;
    @NotBlank
    private String url_2;
    @NotBlank
    private String nome;
    @NotBlank
    private String meta;
    @NotBlank
    private String texto;
    @NotBlank
    private Float preco;

    public Destino(DadosCadastroDestino dados) {
        this.url_1 = dados.url_1();
        this.url_2 = dados.url_2();
        this.meta = dados.meta();
        this.texto = dados.texto();
        this.nome = dados.nome();
        this.preco = dados.preco();
    }

    public void atualizarDestino(ListagemDestino dados) {
        if (dados.url_1() != null){
            this.url_1 = dados.url_1();
        }
        if (dados.url_2() != null){
            this.url_1 = dados.url_1();
        }
        if (dados.meta() != null){
            this.meta = dados.meta();
        }
        if (dados.texto() != null){
            this.texto = dados.texto();
        }
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.preco() != null){
            this.preco = dados.preco();
        }        
    }

    public void gerarDescricao()
    {
        texto = ChatGpt.generateAIText("Faça um resumo sobre " + nome + " enfatizando o porque este lugar é incrível. Utilize uma linguagem informal e até 100 caracteres no máximo em cada parágrafo. Crie 2 parágrafos neste resumo.");
    }

}
