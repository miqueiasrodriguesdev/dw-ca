package com.miqueias_r.infrastructure.rest.dto.response;

import com.miqueias_r.core.domain.enums.type.UsuarioTypeEnum;

public record UsuarioResponse(
        Long userId,
        String fullName,
        String email,
        UsuarioTypeEnum userType
) {
}
