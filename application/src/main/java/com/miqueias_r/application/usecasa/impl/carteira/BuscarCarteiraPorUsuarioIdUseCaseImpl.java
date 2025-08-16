package com.miqueias_r.application.usecasa.impl.carteira;

import com.miqueias_r.application.gateway.carteira.BuscarCarteiraPorUsuarioIdGateway;
import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.core.exception.CarteiraException;
import com.miqueias_r.core.exception.enums.message.CarteiraMessageEnum;
import com.miqueias_r.usecase.carteira.BuscarCarteiraPorUsuarioIdUseCase;

public class BuscarCarteiraPorUsuarioIdUseCaseImpl implements BuscarCarteiraPorUsuarioIdUseCase {
    private final BuscarCarteiraPorUsuarioIdGateway buscarCarteiraPorUsuarioIdGateway;

    public BuscarCarteiraPorUsuarioIdUseCaseImpl(BuscarCarteiraPorUsuarioIdGateway buscarCarteiraPorUsuarioIdGateway) {
        this.buscarCarteiraPorUsuarioIdGateway = buscarCarteiraPorUsuarioIdGateway;
    }

    @Override
    public Carteira executar(Long usuarioId) {
        return buscarCarteiraPorUsuarioIdGateway.executar(usuarioId).orElseThrow(
                () -> new CarteiraException(CarteiraMessageEnum.CARTEIRA_NAO_ENCONTRADO)
        );
    }
}
