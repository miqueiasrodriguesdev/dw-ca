package com.miqueias_r.infrastructure.persistence.mapper;

import com.miqueias_r.core.domain.entity.Usuario;
import com.miqueias_r.infrastructure.persistence.entity.UsuarioEntity;

public class UsuarioMapper {

    public static Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) return null;

        return new Usuario(
                entity.getId(),
                entity.getNomeCompleto(),
                entity.getCpfCnpj(),
                entity.getEmail(),
                entity.getSenha(),
                entity.getTipo());

    }

    public static UsuarioEntity toEntity(Usuario domain) {
        if (domain == null) return null;

        return new UsuarioEntity(
                domain.getId(),
                domain.getNomeCompleto(),
                domain.getCpfCnpj(),
                domain.getEmail(),
                domain.getSenha(),
                domain.getTipo().name());

    }
}
