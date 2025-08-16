package com.miqueias_r.application.gateway.transacao;

import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.core.domain.entity.Transacao;

public interface CriarTransacaoGateway {
    Transacao executar(Transacao transacao, Carteira carteiraPagador, Carteira carteiraRecebedor);
}
