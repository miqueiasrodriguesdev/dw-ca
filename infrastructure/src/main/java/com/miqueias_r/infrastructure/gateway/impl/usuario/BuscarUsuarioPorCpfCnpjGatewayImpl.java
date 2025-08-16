package com.miqueias_r.infrastructure.gateway.impl.usuario;

import com.miqueias_r.application.gateway.usuario.BuscarUsuarioPorCpfCnpjGateway;
import com.miqueias_r.core.domain.entity.Usuario;
import com.miqueias_r.infrastructure.persistence.mapper.UsuarioMapper;
import com.miqueias_r.infrastructure.persistence.entity.UsuarioEntity;
import com.miqueias_r.infrastructure.persistence.repository.UsuarioRepository;

import java.util.Optional;

public class BuscarUsuarioPorCpfCnpjGatewayImpl implements BuscarUsuarioPorCpfCnpjGateway {
    private final UsuarioRepository usuarioRepository;

    public BuscarUsuarioPorCpfCnpjGatewayImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> executar(String cpfCnpj) {
        Optional<UsuarioEntity> usuario = usuarioRepository.buscarUsuarioPorCpfCnpj(cpfCnpj);
        return usuario.map(UsuarioMapper::toDomain);
    }
}
