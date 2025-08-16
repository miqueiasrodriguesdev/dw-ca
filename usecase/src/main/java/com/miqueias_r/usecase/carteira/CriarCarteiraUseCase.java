package com.miqueias_r.usecase.carteira;

import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.core.domain.entity.Usuario;

public interface CriarCarteiraUseCase {
    Carteira executar(Usuario usuario, String pin);
}
