package com.miqueias_r.application.usecasa.impl.usuario;

import com.miqueias_r.application.gateway.usuario.BuscarUsuarioPorCpfCnpjGateway;
import com.miqueias_r.core.domain.entity.Usuario;
import com.miqueias_r.core.domain.valueobject.CpfCnpj;
import com.miqueias_r.core.exception.UsuarioException;
import com.miqueias_r.core.exception.enums.message.UsuarioMessageEnum;
import com.miqueias_r.usecase.usuario.BuscarUsuarioPorCpfCnpjUseCase;

public class BuscarUsuarioPorCpfCnpjUseCaseImpl implements BuscarUsuarioPorCpfCnpjUseCase {
    private final BuscarUsuarioPorCpfCnpjGateway buscarUsuarioPorCpfCnpjGateway;

    public BuscarUsuarioPorCpfCnpjUseCaseImpl(BuscarUsuarioPorCpfCnpjGateway buscarUsuarioPorCpfCnpjGateway) {
        this.buscarUsuarioPorCpfCnpjGateway = buscarUsuarioPorCpfCnpjGateway;
    }

    @Override
    public Usuario executar(String cpfCnpj) {
        CpfCnpj cpfCnpjValido = new CpfCnpj(cpfCnpj);

        return buscarUsuarioPorCpfCnpjGateway.executar(cpfCnpjValido.valor()).orElseThrow(
                () -> new UsuarioException(UsuarioMessageEnum.USUARIO_NAO_ENCONTRADO)
        );
    }
}
