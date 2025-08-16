package com.miqueias_r.infrastructure.persistence.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_carteiras")
public class CarteiraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Column(nullable = false)
    private String pin;

    public CarteiraEntity() {
    }

    public CarteiraEntity(Long id, UsuarioEntity usuario, BigDecimal saldo, String pin) {
        this.id = id;
        this.usuario = usuario;
        this.saldo = saldo;
        this.pin = pin;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
