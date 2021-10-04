package com.quartacapa.livro.model;

public enum AnoEscolarEnum {

    NAO_SE_APLICA("Não se aplica"),
    PRIMEIRO_ANO_FUNDAMENTAL("1o ano FUND"),
    SEGUNDO_ANO_FUNDAMENTAL("2o ano FUND"),
    TERCEIRO_ANO_FUNDAMENTAL("3o ano FUND"),
    QUARTO_ANO_FUNDAMENTAL("4o ano FUND"),
    QUINTO_ANO_FUNDAMENTAL("5o ano FUND"),
    SEXTO_ANO_FUNDAMENTAL("6o ano FUND"),
    SETIMO_ANO_FUNDAMENTAL("7o ano FUND"),
    OITAVO_ANO_FUNDAMENTAL("8o ano FUND"),
    NONO_ANO_FUNDAMMENTAL("9o ano FUND"),
    PRIMEIRO_ANO_MEDIO("1o ano MÉDIO"),
    SEGUNDO_ANO_MEDIO("2o ano MÉDIO"),
    TERCEIRO_ANO_MEDIO("3o ano MÉDIO");

    private final String status;

    AnoEscolarEnum(String status) {
        this.status = status;
    }

    public String toString() {
        return this.status;
    }

}
