package com.miqueias_r.usecase.transacao;

import com.miqueias_r.core.domain.entity.Transacao;

import java.math.BigDecimal;

public interface CriarTransacaoUseCase {
    Transacao executar(Long usuarioPagadorId, Long usuarioRecebedorId, BigDecimal valor, String pin);
}