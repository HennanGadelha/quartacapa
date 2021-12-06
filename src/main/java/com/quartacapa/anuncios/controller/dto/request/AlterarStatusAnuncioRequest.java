package com.quartacapa.anuncios.controller.dto.request;

import com.quartacapa.anuncios.AnuncioStatusEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AlterarStatusAnuncioRequest {

    @Enumerated(EnumType.STRING)
    private AnuncioStatusEnum anuncioStatusEnum;

    @Deprecated
    public AlterarStatusAnuncioRequest(){}

    public AlterarStatusAnuncioRequest(AnuncioStatusEnum anuncioStatusEnum ) {
        this.anuncioStatusEnum = anuncioStatusEnum;
    }


    public AnuncioStatusEnum getAnuncioStatusEnum() {
        return anuncioStatusEnum;
    }

    public void setAnuncioStatusEnum(AnuncioStatusEnum anuncioStatusEnum) {
        this.anuncioStatusEnum = anuncioStatusEnum;
    }
}
