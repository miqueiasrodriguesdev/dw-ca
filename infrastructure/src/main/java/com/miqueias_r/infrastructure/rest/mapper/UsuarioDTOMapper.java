package com.miqueias_r.infrastructure.rest.mapper;

import com.miqueias_r.core.domain.entity.Usuario;
import com.miqueias_r.infrastructure.rest.dto.request.CriarCarteiraRequest;
import com.miqueias_r.infrastructure.rest.dto.response.UsuarioResponse;

public class UsuarioDTOMapper {

    public static Usuario toDomain(CriarCarteiraRequest request) {
        if (request == null) return null;

        return new Usuario(
                request.cpfCnpj(),
                request.fullName(),
                request.email(),
                request.password(),
                request.userType());
    }


    public static UsuarioResponse toDTO(Usuario usuario) {
        if (usuario == null) return null;

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNomeCompleto(),
                usuario.getEmail(),
                usuario.getTipo());

    }
}
