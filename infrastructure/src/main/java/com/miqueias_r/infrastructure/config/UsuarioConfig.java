package com.miqueias_r.infrastructure.config;

import com.miqueias_r.application.gateway.usuario.BuscarUsuarioPorCpfCnpjGateway;
import com.miqueias_r.application.gateway.usuario.BuscarUsuarioPorEmailGateway;
import com.miqueias_r.application.gateway.carteira.CriarCarteiraGateway;
import com.miqueias_r.application.usecasa.impl.usuario.BuscarUsuarioPorCpfCnpjUseCaseImpl;
import com.miqueias_r.application.usecasa.impl.carteira.CriarCarteiraUseCaseImpl;
import com.miqueias_r.infrastructure.gateway.impl.usuario.BuscarUsuarioPorEmailGatewayImpl;
import com.miqueias_r.infrastructure.gateway.impl.usuario.BuscarUsuarioPorCpfCnpjGatewayImpl;
import com.miqueias_r.infrastructure.gateway.impl.carteira.CriarCarteiraGatewayImpl;
import com.miqueias_r.infrastructure.persistence.repository.CarteiraRepository;
import com.miqueias_r.infrastructure.persistence.repository.UsuarioRepository;
import com.miqueias_r.usecase.usuario.BuscarUsuarioPorCpfCnpjUseCase;
import com.miqueias_r.usecase.carteira.CriarCarteiraUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    public BuscarUsuarioPorCpfCnpjGateway buscarUsuarioPorCpfCnpjGateway(UsuarioRepository usuarioRepository){
        return new BuscarUsuarioPorCpfCnpjGatewayImpl(usuarioRepository);
    }

    @Bean
    public BuscarUsuarioPorEmailGateway buscarUsuarioPorEmailGateway(UsuarioRepository usuarioRepository){
        return new BuscarUsuarioPorEmailGatewayImpl(usuarioRepository);
    }

    @Bean
    public BuscarUsuarioPorCpfCnpjUseCase buscarUsuarioPorCpfCnpjUseCase(BuscarUsuarioPorCpfCnpjGateway buscarUsuarioPorCpfCnpjGateway) {
        return new BuscarUsuarioPorCpfCnpjUseCaseImpl(buscarUsuarioPorCpfCnpjGateway);
    }

    @Bean
    public CriarCarteiraUseCase criarUsuarioUseCase(
            BuscarUsuarioPorCpfCnpjGateway buscarUsuarioPorCpfCnpjGateway,
            BuscarUsuarioPorEmailGateway buscarUsuarioPorEmailGateway,
            CriarCarteiraGateway criarCarteiraGateway) {
        return new CriarCarteiraUseCaseImpl(buscarUsuarioPorCpfCnpjGateway, buscarUsuarioPorEmailGateway, criarCarteiraGateway);
    }
}
