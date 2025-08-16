package com.miqueias_r.infrastructure.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarCarteiraRequest(
        @NotBlank(message = "O nome completo é obrigatório")
        String fullName,
        @NotBlank(message = "O CPF ou CNPJ é obrigatório")
        String cpfCnpj,
        @NotBlank(message = "O e-mail é obrigatório")
        String email,
        @NotBlank(message = "A senha é obrigatória")
        String password,
        @NotNull(message = "O tipo de usuário é obrigatório")
        String userType,
        @NotBlank(message = "O PIN é obrigatório")
        String pin
) {
}
