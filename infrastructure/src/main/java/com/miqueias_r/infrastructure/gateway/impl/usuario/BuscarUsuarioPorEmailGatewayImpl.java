package com.miqueias_r.infrastructure.gateway.impl.usuario;

import com.miqueias_r.application.gateway.usuario.BuscarUsuarioPorEmailGateway;
import com.miqueias_r.core.domain.entity.Usuario;
import com.miqueias_r.infrastructure.persistence.mapper.UsuarioMapper;
import com.miqueias_r.infrastructure.persistence.entity.UsuarioEntity;
import com.miqueias_r.infrastructure.persistence.repository.UsuarioRepository;

import java.util.Optional;

public class BuscarUsuarioPorEmailGatewayImpl implements BuscarUsuarioPorEmailGateway {
    private final UsuarioRepository usuarioRepository;

    public BuscarUsuarioPorEmailGatewayImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> executar(String email) {
        Optional<UsuarioEntity> usuario = usuarioRepository.buscarUsuarioPorEmail(email);
        return usuario.map(UsuarioMapper::toDomain);
    }
}
