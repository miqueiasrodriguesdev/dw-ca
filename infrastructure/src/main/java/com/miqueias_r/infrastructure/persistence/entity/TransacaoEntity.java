package com.miqueias_r.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_transacoes")
public class TransacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carteira_pagador_id", nullable = false)
    private CarteiraEntity pagador;

    @ManyToOne
    @JoinColumn(name = "carteira_recebedor_id", nullable = false)
    private CarteiraEntity recebedor;

    @Column(nullable = false)
    private BigDecimal valor;

    public TransacaoEntity() {
    }

    public TransacaoEntity(Long id, CarteiraEntity pagador, CarteiraEntity recebedor, BigDecimal valor) {
        this.id = id;
        this.pagador = pagador;
        this.recebedor = recebedor;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarteiraEntity getPagador() {
        return pagador;
    }

    public void setPagador(CarteiraEntity pagador) {
        this.pagador = pagador;
    }

    public CarteiraEntity getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(CarteiraEntity recebedor) {
        this.recebedor = recebedor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
