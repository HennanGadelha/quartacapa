package com.quartacapa.anuncios;

public enum AnuncioStatusEnum {

    INDISPONIVEL("Indisponível"),
    DISPONIVEL("Disponível"),
    EM_NEGOCIACAO("Em negociação"),
    VENDIDO("Vendido");

    private final String status;

    AnuncioStatusEnum(String status) {
        this.status = status;
    }

    public String toString() {
        return this.status;
    }

}
