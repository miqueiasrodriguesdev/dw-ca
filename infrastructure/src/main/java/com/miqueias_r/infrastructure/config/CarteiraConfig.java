package com.miqueias_r.infrastructure.config;

import com.miqueias_r.application.gateway.carteira.BuscarCarteiraPorUsuarioIdGateway;
import com.miqueias_r.application.gateway.carteira.CriarCarteiraGateway;
import com.miqueias_r.application.usecasa.impl.carteira.BuscarCarteiraPorUsuarioIdUseCaseImpl;
import com.miqueias_r.infrastructure.gateway.impl.carteira.BuscarCarteiraPorUsuarioIdGatewayImpl;
import com.miqueias_r.infrastructure.gateway.impl.carteira.CriarCarteiraGatewayImpl;
import com.miqueias_r.infrastructure.persistence.repository.CarteiraRepository;
import com.miqueias_r.usecase.carteira.BuscarCarteiraPorUsuarioIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarteiraConfig {
    @Bean
    public BuscarCarteiraPorUsuarioIdGateway buscarCarteiraPorUsuarioIdGateway(CarteiraRepository carteiraRepository){
        return new BuscarCarteiraPorUsuarioIdGatewayImpl(carteiraRepository);
    }

    @Bean
    public BuscarCarteiraPorUsuarioIdUseCase buscarCarteiraPorUsuarioIdUseCase(BuscarCarteiraPorUsuarioIdGateway buscarCarteiraPorUsuarioIdGateway){
        return new BuscarCarteiraPorUsuarioIdUseCaseImpl(buscarCarteiraPorUsuarioIdGateway);
    }

    @Bean
    public CriarCarteiraGateway criarCarteiraGateway(CarteiraRepository carteiraRepository){
        return new CriarCarteiraGatewayImpl(carteiraRepository);
    }
}
