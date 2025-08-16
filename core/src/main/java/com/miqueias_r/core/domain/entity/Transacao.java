package com.miqueias_r.core.domain.entity;

import com.miqueias_r.core.exception.TransacaoException;
import com.miqueias_r.core.exception.enums.message.TransacaoMessageEnum;

import java.math.BigDecimal;

public class Transacao {
    private Long id;
    private Carteira pagador;
    private Carteira recebedor;
    private BigDecimal valor;

    public Transacao(Carteira pagador, Carteira recebedor, BigDecimal valor) {
        setPagador(pagador);
        setRecebedor(recebedor);
        setValor(valor);
    }

    public Transacao(Long id, Carteira pagador, Carteira recebedor, BigDecimal valor) {
        this.id = id;
        setPagador(pagador);
        setRecebedor(recebedor);
        setValor(valor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carteira getPagador() {
        return pagador;
    }

    public void setPagador(Carteira pagador) {
        if (pagador == null) {
            throw new TransacaoException(TransacaoMessageEnum.TRANSACAO_CARTEIRA_PAGADOR_NULA);
        }
        this.pagador = pagador;
    }

    public Carteira getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Carteira recebedor) {
        if (recebedor == null) {
            throw new TransacaoException(TransacaoMessageEnum.TRANSACAO_CARTEIRA_RECEBEDOR_NULA);
        }

        this.recebedor = recebedor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        validarValor(valor);
        this.valor = valor;
    }

    private void validarValor(BigDecimal valor){
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new TransacaoException(TransacaoMessageEnum.TRANSACAO_VALOR_NAO_PERMITIDO);
        }
    }
}
