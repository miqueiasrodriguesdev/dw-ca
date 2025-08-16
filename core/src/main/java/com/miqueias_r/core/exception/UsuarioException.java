package com.miqueias_r.core.exception;

import com.miqueias_r.core.exception.enums.message.UsuarioMessageEnum;

public class UsuarioException extends RuntimeException {
    private final int statusCode;

    public UsuarioException(UsuarioMessageEnum usuarioMessageEnum) {
        super(usuarioMessageEnum.getMessage());
        this.statusCode = usuarioMessageEnum.getStatusCode();
    }

    public int getStatusCode() {
        return statusCode;
    }
}
