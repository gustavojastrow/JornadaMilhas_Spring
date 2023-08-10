package com.jast.jornada.milhas.domain.destinos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record DadosCadastroDestino(
        @NotBlank
        String url_1,
        @NotBlank
        String url_2,
        @NotBlank
        String nome,
        @NotBlank
        @Size(max = 160)
        String meta,
        String texto,
        @NotNull
        Float preco
) {
    
}
