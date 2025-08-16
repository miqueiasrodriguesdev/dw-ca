package com.miqueias_r.infrastructure.exception;

import com.miqueias_r.infrastructure.exception.enums.message.ServicoExternoMessageEnum;

public class ServicoExternoException extends RuntimeException{
    private final int statusCode;

    public ServicoExternoException(ServicoExternoMessageEnum servicoExternoMessageEnum) {
        super(servicoExternoMessageEnum.getMessage());
        this.statusCode = servicoExternoMessageEnum.getStatusCode();
    }

    public int getStatusCode() {
        return statusCode;
    }
}
