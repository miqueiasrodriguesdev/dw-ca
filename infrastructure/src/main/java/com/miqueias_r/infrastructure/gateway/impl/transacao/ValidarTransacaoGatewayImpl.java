package com.miqueias_r.infrastructure.gateway.impl.transacao;

import com.miqueias_r.application.gateway.transacao.ValidarTransacaoGateway;
import com.miqueias_r.infrastructure.client.AutorizarTransacaoClient;
import com.miqueias_r.infrastructure.exception.ServicoExternoException;
import com.miqueias_r.infrastructure.exception.enums.message.ServicoExternoMessageEnum;

public class ValidarTransacaoGatewayImpl implements ValidarTransacaoGateway {
    private final AutorizarTransacaoClient autorizarTransacaoClient;

    public ValidarTransacaoGatewayImpl(AutorizarTransacaoClient autorizarTransacaoClient) {
        this.autorizarTransacaoClient = autorizarTransacaoClient;
    }

    @Override
    public Boolean executar() {
        try {
            var response = autorizarTransacaoClient.autorizar();
            return response.getData().getAuthorization();
        } catch (Exception e) {
            throw new ServicoExternoException(ServicoExternoMessageEnum.SERVICO_EXTERNO_AUTORIZACAO_INDISPONIVEL);
        }
    }
}
