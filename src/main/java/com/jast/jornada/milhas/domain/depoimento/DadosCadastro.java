package com.jast.jornada.milhas.domain.depoimento;

import javax.validation.constraints.NotBlank;

public record DadosCadastro(
    @NotBlank
    String foto,
    @NotBlank
    String depoimento, 
    @NotBlank
    String autor) {
}
