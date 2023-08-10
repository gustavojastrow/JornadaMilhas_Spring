package com.jast.jornada.milhas.domain.destinos;

public record ListagemDestino(Long id,String url_1, String url_2, String meta, String texto, String nome, Float preco) {
    
    public ListagemDestino(Destino destino){
        this(destino.getId(), destino.getUrl_1(), destino.getUrl_2(), destino.getMeta(), destino.getTexto(), destino.getNome(), destino.getPreco());
    }
}

