package com.jast.jornada.milhas.domain.destinos;

public record ListagemDestino(Long id,  String nome, Float preco, String url_1, String url_2, String meta, String texto) {
    
    public ListagemDestino(Destino destino){
        this(destino.getId(), destino.getNome(), destino.getPreco(), destino.getUrl_1(), destino.getUrl_2(), destino.getMeta(), destino.getTexto());
    }
}

