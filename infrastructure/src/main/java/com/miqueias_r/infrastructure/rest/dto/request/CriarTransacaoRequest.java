package com.miqueias_r.infrastructure.rest.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CriarTransacaoRequest(
        @NotNull(message = "O ID do usuário pagador é obrigatório")
        Long payer,
        @NotNull(message = "O ID do usuário recebedor é obrigatório")
        Long peyee,
        @NotNull(message = "O valor da transação é obrigatório")
        @Positive(message = "O valor deve ser positivo")
        BigDecimal value,
        @NotNull(message = "O PIN é obrigatório")
        String pin
) {}
