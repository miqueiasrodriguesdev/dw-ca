package com.miqueias_r.core.domain.entity;

import com.miqueias_r.core.domain.validator.SequenciaCrescenteValidator;
import com.miqueias_r.core.domain.validator.SequenciaDecrescenteValidator;
import com.miqueias_r.core.exception.enums.message.CarteiraMessageEnum;
import com.miqueias_r.core.domain.enums.type.UsuarioTypeEnum;
import com.miqueias_r.core.exception.CarteiraException;

import java.math.BigDecimal;
import java.util.Objects;

public class Carteira {
    private Long id;
    private Usuario usuario;
    private BigDecimal saldo;
    private String pin;


    public Carteira(Usuario usuario, BigDecimal saldo, String pin) {
        setUsuario(usuario);
        setSaldo(saldo);
        setPin(pin);
    }

    public Carteira(Long id, Usuario usuario, BigDecimal saldo, String pin) {
        this.id = id;
        setUsuario(usuario);
        setSaldo(saldo);
        setPin(pin);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new CarteiraException(CarteiraMessageEnum.CARTEIRA_USUARIO_NULO);
        }

        this.usuario = usuario;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        if (saldo == null) {
            throw new CarteiraException(CarteiraMessageEnum.CARTEIRA_SALDO_NULO);
        }

        this.saldo = saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        validarPin(pin);

        this.pin = pin;
    }

    public void transferir(BigDecimal valor) {
        if (this.usuario.getTipo().equals(UsuarioTypeEnum.LOJISTA)) {
            throw new CarteiraException(CarteiraMessageEnum.CARTEIRA_NAO_TEM_METODO);
        }

        validarValor(valor);

        if (this.saldo.compareTo(valor) < 0) {
            throw new CarteiraException(CarteiraMessageEnum.CARTEIRA_NAO_TEM_SALDO_SUFICIENTE);
        }

        this.saldo = this.saldo.subtract(valor);
    }

    public void receber(BigDecimal valor) {
        validarValor(valor);

        this.saldo = this.saldo.add(valor);
    }

    private void validarPin(String pin) {
        if (pin == null) {
            throw new CarteiraException(CarteiraMessageEnum.CARTEIRA_PIN_NULO);
        }

        if(!pin.matches("^\\d{8}$")){
            throw new CarteiraException(CarteiraMessageEnum.CARTEIRA_PIN_INVALIDO);
        }

        if (SequenciaCrescenteValidator.validar(pin) || SequenciaDecrescenteValidator.validar(pin)) {
            throw new CarteiraException(CarteiraMessageEnum.CARTEIRA_PIN_SEQUENCIA_INVALIDA);
        }
    }

    private void validarValor(BigDecimal valor){
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new CarteiraException(CarteiraMessageEnum.CARTEIRA_VALOR_NAO_PERMITIDO);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carteira carteira = (Carteira) o;
        return Objects.equals(id, carteira.id) && Objects.equals(usuario, carteira.usuario) && Objects.equals(saldo, carteira.saldo) && Objects.equals(pin, carteira.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, saldo, pin);
    }
}
