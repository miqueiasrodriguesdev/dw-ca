package com.miqueias_r.application.gateway.carteira;

import com.miqueias_r.core.domain.entity.Carteira;
import java.util.Optional;

public interface BuscarCarteiraPorUsuarioIdGateway {
    Optional<Carteira> executar(Long usuarioId);
}
