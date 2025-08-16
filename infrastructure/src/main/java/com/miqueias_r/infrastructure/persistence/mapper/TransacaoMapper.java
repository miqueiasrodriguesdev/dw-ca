package com.miqueias_r.infrastructure.persistence.mapper;

import com.miqueias_r.core.domain.entity.Transacao;
import com.miqueias_r.infrastructure.persistence.entity.TransacaoEntity;

public class TransacaoMapper {

    public static Transacao toDomain(TransacaoEntity entity) {
        if (entity == null) return null;

        return new Transacao(
                entity.getId(),
                CarteiraMapper.toDomain(entity.getPagador()),
                CarteiraMapper.toDomain(entity.getRecebedor()),
                entity.getValor());

    }

    public static TransacaoEntity toEntity(Transacao domain) {
        if (domain == null) return null;

        return new TransacaoEntity(
                domain.getId(),
                CarteiraMapper.toEntity(domain.getPagador()),
                CarteiraMapper.toEntity(domain.getRecebedor()),
                domain.getValor()
        );

    }
}
