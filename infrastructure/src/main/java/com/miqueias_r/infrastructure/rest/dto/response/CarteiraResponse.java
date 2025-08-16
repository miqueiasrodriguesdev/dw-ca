package com.miqueias_r.infrastructure.rest.dto.response;

import com.miqueias_r.core.domain.enums.type.UsuarioTypeEnum;

import java.math.BigDecimal;

public record CarteiraResponse(
        Long userId,
        Long walletId,
        String fullName,
        String email,
        UsuarioTypeEnum userType,
        BigDecimal balance) {
}
