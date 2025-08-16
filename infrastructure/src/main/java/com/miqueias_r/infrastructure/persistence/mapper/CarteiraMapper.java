package com.miqueias_r.infrastructure.persistence.mapper;

import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.infrastructure.persistence.entity.CarteiraEntity;

public class CarteiraMapper {

    public static Carteira toDomain(CarteiraEntity entity) {
        if (entity == null) return null;

        return new Carteira(
                entity.getId(),
                UsuarioMapper.toDomain(entity.getUsuario()),
                entity.getSaldo(),
                entity.getPin()
        );
    }

    public static CarteiraEntity toEntity(Carteira domain) {
        if (domain == null) return null;

        return new CarteiraEntity(
                domain.getId(),
                UsuarioMapper.toEntity(domain.getUsuario()),
                domain.getSaldo(),
                domain.getPin()
        );

    }
}
