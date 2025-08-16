package com.miqueias_r.application.gateway.transacao;

import com.miqueias_r.core.domain.entity.Transacao;

public interface EnviarNotificacaoTransacaoGateway {
    void executar(Transacao transacao);
}
