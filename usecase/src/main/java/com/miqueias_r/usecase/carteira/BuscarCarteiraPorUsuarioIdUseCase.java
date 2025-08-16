package com.miqueias_r.usecase.carteira;

import com.miqueias_r.core.domain.entity.Carteira;

public interface BuscarCarteiraPorUsuarioIdUseCase {
    Carteira executar(Long usuarioId);
}
