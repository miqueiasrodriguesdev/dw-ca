package com.miqueias_r.infrastructure.gateway.impl.transacao;

import com.miqueias_r.application.gateway.transacao.EnviarNotificacaoTransacaoGateway;
import com.miqueias_r.core.domain.entity.Transacao;
import com.miqueias_r.infrastructure.client.EnviarNotificacaoTransacaoClient;
import com.miqueias_r.infrastructure.client.dto.request.NotificarRequest;
import com.miqueias_r.infrastructure.exception.ServicoExternoException;
import com.miqueias_r.infrastructure.exception.enums.message.ServicoExternoMessageEnum;

public class EnviarNotificacaoTransacaoGatewayImpl implements EnviarNotificacaoTransacaoGateway {
    private final EnviarNotificacaoTransacaoClient notificacaoTransacaoClient;

    public EnviarNotificacaoTransacaoGatewayImpl(EnviarNotificacaoTransacaoClient notificacaoTransacaoClient) {
        this.notificacaoTransacaoClient = notificacaoTransacaoClient;
    }

    @Override
    public void executar(Transacao transacao) {
        try{
            notificacaoTransacaoClient.notificar(new NotificarRequest(
                    transacao.getPagador().getUsuario().getId(),
                    transacao.getRecebedor().getUsuario().getId(),
                    transacao.getId()
            ));
        } catch (Exception e){
            throw new ServicoExternoException(ServicoExternoMessageEnum.SERVICO_EXTERNO_ENVIO_EMAIL_INDISPONIVEL);
        }
    }
}
