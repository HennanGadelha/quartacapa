package com.quartacapa.livro.model;

public enum DescricaoEstadoEnum {

    USADO("Usado"),
    USADO_EM_OTIMAS_CONDICOES("Usado em ótimas condições"),
    NOVO("Novo");

    private final String estadoDeUso;

    DescricaoEstadoEnum(String estadoDeUso) {
        this.estadoDeUso = estadoDeUso;
    }

    public String toString() {
        return this.estadoDeUso;
    }

}
