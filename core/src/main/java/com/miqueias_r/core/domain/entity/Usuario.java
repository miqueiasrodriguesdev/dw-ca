package com.miqueias_r.core.domain.entity;

import com.miqueias_r.core.domain.enums.type.UsuarioTypeEnum;
import com.miqueias_r.core.domain.valueobject.CpfCnpj;
import com.miqueias_r.core.domain.valueobject.Email;
import com.miqueias_r.core.exception.UsuarioException;
import com.miqueias_r.core.exception.enums.message.UsuarioMessageEnum;

public class Usuario {
    private Long id;
    private String nomeCompleto;
    private CpfCnpj cpfCnpj;
    private Email email;
    private String senha;
    private UsuarioTypeEnum tipo;

    public Usuario(String cpfCnpj, String nomeCompleto, String email, String senha, String tipo) {
        setCpfCnpj(cpfCnpj);
        setNomeCompleto(nomeCompleto);
        setEmail(email);
        setSenha(senha);
        setTipo(tipo);
    }

    public Usuario(Long id, String nomeCompleto, String cpfCnpj, String email, String senha, String tipo) {
        this.id = id;
        setCpfCnpj(cpfCnpj);
        setNomeCompleto(nomeCompleto);
        setEmail(email);
        setSenha(senha);
        setTipo(tipo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        if (nomeCompleto == null) {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_NOME_COMPLETO_NULO);
        }
        this.nomeCompleto = nomeCompleto.toUpperCase();
    }

    public String getCpfCnpj() {
        return cpfCnpj.valor();
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = new CpfCnpj(cpfCnpj);
    }

    public String getEmail() {
        return email.valor();
    }

    public void setEmail(String email) {
        this.email = new Email(email);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null) {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_SENHA_NULA);
        }
        this.senha = senha;
    }

    public UsuarioTypeEnum getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null) {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_TIPO_NULO);
        }

        try {
            this.tipo = UsuarioTypeEnum.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_TIPO_NAO_EXISTE);
        }
    }
}