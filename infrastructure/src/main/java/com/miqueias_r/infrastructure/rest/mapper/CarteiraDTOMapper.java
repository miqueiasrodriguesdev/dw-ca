package com.miqueias_r.infrastructure.rest.mapper;

import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.infrastructure.rest.dto.response.CarteiraResponse;

public class CarteiraDTOMapper {

    public static CarteiraResponse toDTO(Carteira domain) {
        if (domain == null) return null;

        return new CarteiraResponse(
                domain.getUsuario().getId(),
                domain.getId(),
                domain.getUsuario().getNomeCompleto(),
                domain.getUsuario().getEmail(),
                domain.getUsuario().getTipo(),
                domain.getSaldo()
        );
    }
}
