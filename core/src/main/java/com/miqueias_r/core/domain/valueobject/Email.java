package com.miqueias_r.core.domain.valueobject;

import com.miqueias_r.core.domain.validator.EmailValidator;
import com.miqueias_r.core.exception.UsuarioException;
import com.miqueias_r.core.exception.enums.message.UsuarioMessageEnum;

public record Email(String valor) {

    public Email(String valor){

        if (valor == null) {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_EMAIL_NULO);
        }

        if (!EmailValidator.validar(valor)) {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_EMAIL_INVALIDO);
        }

        this.valor = valor.toUpperCase();
    }
}