package com.miqueias_r.infrastructure.rest.dto.response;

import java.math.BigDecimal;

public record TransacaoResponse(
        Long payer,
        Long peyee,
        BigDecimal value) {
}
