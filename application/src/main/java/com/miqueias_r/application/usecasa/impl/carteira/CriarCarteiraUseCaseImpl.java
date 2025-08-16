package com.miqueias_r.application.usecasa.impl.carteira;

import com.miqueias_r.application.gateway.usuario.BuscarUsuarioPorCpfCnpjGateway;
import com.miqueias_r.application.gateway.usuario.BuscarUsuarioPorEmailGateway;
import com.miqueias_r.application.gateway.carteira.CriarCarteiraGateway;
import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.core.domain.entity.Usuario;
import com.miqueias_r.core.exception.UsuarioException;
import com.miqueias_r.core.exception.enums.message.UsuarioMessageEnum;
import com.miqueias_r.usecase.carteira.CriarCarteiraUseCase;

import java.math.BigDecimal;

public class CriarCarteiraUseCaseImpl implements CriarCarteiraUseCase {
    private final BuscarUsuarioPorCpfCnpjGateway buscarUsuarioPorCpfCnpjGateway;
    private final BuscarUsuarioPorEmailGateway buscarUsuarioPorEmailGateway;
    private final CriarCarteiraGateway criarCarteiraGateway;

    public CriarCarteiraUseCaseImpl(BuscarUsuarioPorCpfCnpjGateway buscarUsuarioPorCpfCnpjGateway, BuscarUsuarioPorEmailGateway buscarUsuarioPorEmailGateway, CriarCarteiraGateway criarCarteiraGateway) {
        this.buscarUsuarioPorCpfCnpjGateway = buscarUsuarioPorCpfCnpjGateway;
        this.buscarUsuarioPorEmailGateway = buscarUsuarioPorEmailGateway;
        this.criarCarteiraGateway = criarCarteiraGateway;
    }

    @Override
    public Carteira executar(Usuario usuario, String pin) {
        var cpfCnpjExists = buscarUsuarioPorCpfCnpjGateway.executar(usuario.getCpfCnpj());

        if (cpfCnpjExists.isPresent()) {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_EM_USO);
        }

        var emailExists = buscarUsuarioPorEmailGateway.executar(usuario.getEmail());

        if (emailExists.isPresent()) {
            throw new UsuarioException(UsuarioMessageEnum.USUARIO_EMAIL_EM_USO);
        }

        return criarCarteiraGateway.executar(new Carteira(usuario, BigDecimal.ZERO, pin));
    }
}
