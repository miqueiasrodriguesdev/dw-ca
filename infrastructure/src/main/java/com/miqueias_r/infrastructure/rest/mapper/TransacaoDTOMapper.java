package com.miqueias_r.infrastructure.rest.mapper;


import com.miqueias_r.core.domain.entity.Transacao;
import com.miqueias_r.infrastructure.rest.dto.response.TransacaoResponse;

public class TransacaoDTOMapper {

    public static TransacaoResponse toDTO(Transacao domain) {
        if (domain == null) return null;

        return new TransacaoResponse(
                domain.getPagador().getUsuario().getId(),
                domain.getRecebedor().getUsuario().getId(),
                domain.getValor()
        );
    }
}
