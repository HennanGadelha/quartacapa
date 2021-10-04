package com.quartacapa.livro.model;

public enum AnoEscolarEnum {

    NAO_SE_APLICA("Não se aplica"),
    PRIMEIRO_ANO_FUNDAMENTAL("1º ano E. Fundamental"),
    SEGUNDO_ANO_FUNDAMENTAL("2º ano E. Fundamental"),
    TERCEIRO_ANO_FUNDAMENTAL("3º ano E. Fundamental"),
    QUARTO_ANO_FUNDAMENTAL("4º ano E. Fundamental"),
    QUINTO_ANO_FUNDAMENTAL("5º ano E. Fundamental"),
    SEXTO_ANO_FUNDAMENTAL("6º ano E. Fundamental"),
    SETIMO_ANO_FUNDAMENTAL("7º ano E. Fundamental"),
    OITAVO_ANO_FUNDAMENTAL("8º ano E. Fundamental"),
    NONO_ANO_FUNDAMMENTAL("9º ano E. Fundamental"),
    PRIMEIRO_ANO_MEDIO("1º ano E. Médio"),
    SEGUNDO_ANO_MEDIO("2º ano E. Médio"),
    TERCEIRO_ANO_MEDIO("3º ano E. Médio");

    private final String status;

    AnoEscolarEnum(String status) {
        this.status = status;
    }

    public String toString() {
        return this.status;
    }

}
