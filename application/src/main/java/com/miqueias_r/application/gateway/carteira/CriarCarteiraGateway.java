package com.miqueias_r.application.gateway.carteira;

import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.core.domain.entity.Usuario;

public interface CriarCarteiraGateway {
    Carteira executar(Carteira carteira);
}
