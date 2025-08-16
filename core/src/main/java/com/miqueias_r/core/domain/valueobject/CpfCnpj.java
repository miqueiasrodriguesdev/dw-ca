package com.miqueias_r.core.domain.valueobject;

import com.miqueias_r.core.domain.validator.CnpjValidator;
import com.miqueias_r.core.domain.validator.CpfValidator;
import com.miqueias_r.core.exception.UsuarioException;
import com.miqueias_r.core.exception.enums.message.UsuarioMessageEnum;

import java.util.Objects;


public record CpfCnpj(String valor) {

    public CpfCnpj(String valor) {
        if (valor == null) {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_CPF_CNPJ_NULO);
        }

        String somenteDigitos = valor.replaceAll("\\D", "");

        if (somenteDigitos.length() == 11) {
            if (!CpfValidator.validar(somenteDigitos)) {
                throw new UsuarioException(UsuarioMessageEnum.USUARIO_CPF_INVALIDO);
            }
        } else if (somenteDigitos.length() == 14) {
            if (!CnpjValidator.validar(somenteDigitos)) {
                throw new UsuarioException(UsuarioMessageEnum.USUARIO_CNPJ_INVALIDO);
            }
        } else {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_CPF_CNPJ_INVALIDO);
        }

        this.valor = somenteDigitos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CpfCnpj cpfCnpj = (CpfCnpj) o;
        return Objects.equals(valor, cpfCnpj.valor);
    }

}
