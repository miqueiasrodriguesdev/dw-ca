package com.miqueias_r.infrastructure.gateway.impl.carteira;

import com.miqueias_r.application.gateway.carteira.CriarCarteiraGateway;
import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.infrastructure.persistence.mapper.CarteiraMapper;
import com.miqueias_r.infrastructure.persistence.repository.CarteiraRepository;
import org.springframework.transaction.annotation.Transactional;

public class CriarCarteiraGatewayImpl implements CriarCarteiraGateway {
    private final CarteiraRepository carteiraRepository;

    public CriarCarteiraGatewayImpl(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    @Transactional
    @Override
    public Carteira executar(Carteira carteira) {
        return CarteiraMapper.toDomain(carteiraRepository.save(CarteiraMapper.toEntity(carteira)));
    }
}