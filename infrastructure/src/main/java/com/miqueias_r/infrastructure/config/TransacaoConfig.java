package com.miqueias_r.infrastructure.config;

import com.miqueias_r.application.gateway.transacao.CriarTransacaoGateway;
import com.miqueias_r.application.gateway.transacao.EnviarNotificacaoTransacaoGateway;
import com.miqueias_r.application.gateway.transacao.ValidarTransacaoGateway;
import com.miqueias_r.application.usecasa.impl.transacao.CriarTransacaoUseCaseImpl;
import com.miqueias_r.infrastructure.client.AutorizarTransacaoClient;
import com.miqueias_r.infrastructure.client.EnviarNotificacaoTransacaoClient;
import com.miqueias_r.infrastructure.gateway.impl.transacao.CriarTransacaoGatewayImpl;
import com.miqueias_r.infrastructure.gateway.impl.transacao.EnviarNotificacaoTransacaoGatewayImpl;
import com.miqueias_r.infrastructure.gateway.impl.transacao.ValidarTransacaoGatewayImpl;
import com.miqueias_r.infrastructure.persistence.repository.CarteiraRepository;
import com.miqueias_r.infrastructure.persistence.repository.TransacaoRepository;
import com.miqueias_r.usecase.carteira.BuscarCarteiraPorUsuarioIdUseCase;
import com.miqueias_r.usecase.transacao.CriarTransacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransacaoConfig {
    @Bean
    public CriarTransacaoGateway criarTransacaoGateway(TransacaoRepository transacaoRepository, CarteiraRepository carteiraRepository) {
        return new CriarTransacaoGatewayImpl(transacaoRepository, carteiraRepository);
    }

    @Bean
    public EnviarNotificacaoTransacaoGateway enviarNotificacaoTransacaoGateway(EnviarNotificacaoTransacaoClient notificacaoTransacaoClient) {
        return new EnviarNotificacaoTransacaoGatewayImpl(notificacaoTransacaoClient);
    }

    @Bean
    public ValidarTransacaoGateway validarTransacaoGateway(AutorizarTransacaoClient autorizarTransacaoClient) {
        return new ValidarTransacaoGatewayImpl(autorizarTransacaoClient);
    }

    @Bean
    public CriarTransacaoUseCase criarTransacaoUseCase(
            CriarTransacaoGateway criarTransacaoGateway,
            ValidarTransacaoGateway validarTransacaoGateway,
            EnviarNotificacaoTransacaoGateway enviarNotificacaoTransacaoGateway,
            BuscarCarteiraPorUsuarioIdUseCase buscarCarteiraPorUsuarioIdUseCase) {
        return new CriarTransacaoUseCaseImpl(criarTransacaoGateway, validarTransacaoGateway, enviarNotificacaoTransacaoGateway, buscarCarteiraPorUsuarioIdUseCase);
    }
}
