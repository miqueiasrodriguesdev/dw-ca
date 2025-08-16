package com.miqueias_r.core.exception;

import com.miqueias_r.core.exception.enums.message.TransacaoMessageEnum;

public class TransacaoException extends RuntimeException {
    private final int statusCode;

    public TransacaoException(TransacaoMessageEnum transacaoMessageEnum) {
        super(transacaoMessageEnum.getMessage());
        this.statusCode = transacaoMessageEnum.getStatusCode();
    }

    public int getStatusCode() {
        return statusCode;
    }
}
