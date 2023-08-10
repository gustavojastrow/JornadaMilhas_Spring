package com.jast.jornada.milhas.domain.destinos;

public record ListagemDestino(Long id,String foto, String nome, Float preco) {
    
    public ListagemDestino(Destino destino){
        this(destino.getId(), destino.getFoto(), destino.getNome(), destino.getPreco());
    }
}

