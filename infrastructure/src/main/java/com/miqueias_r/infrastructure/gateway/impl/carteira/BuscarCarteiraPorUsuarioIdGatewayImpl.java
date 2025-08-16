package com.miqueias_r.infrastructure.gateway.impl.carteira;

import com.miqueias_r.application.gateway.carteira.BuscarCarteiraPorUsuarioIdGateway;
import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.infrastructure.persistence.mapper.CarteiraMapper;
import com.miqueias_r.infrastructure.persistence.entity.CarteiraEntity;
import com.miqueias_r.infrastructure.persistence.repository.CarteiraRepository;

import java.util.Optional;

public class BuscarCarteiraPorUsuarioIdGatewayImpl implements BuscarCarteiraPorUsuarioIdGateway {
    private final CarteiraRepository carteiraRepository;

    public BuscarCarteiraPorUsuarioIdGatewayImpl(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    @Override
    public Optional<Carteira> executar(Long usuarioId) {
        Optional<CarteiraEntity> carteira = carteiraRepository.buscarCarteiraPorUsuarioId(usuarioId);
        return carteira.map(CarteiraMapper::toDomain);
    }
}
