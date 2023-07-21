package com.jast.jornada.milhas.domain.depoimento;

public record ListagemDepoimento(Long id,String foto, String depoimento, String autor) {
    
    public ListagemDepoimento(Depoimento depoimento){
        this(depoimento.getId(), depoimento.getFoto(), depoimento.getDepoimento(), depoimento.getAutor());
    }
}

