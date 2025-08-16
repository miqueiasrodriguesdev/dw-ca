package com.miqueias_r.application.gateway.usuario;

import com.miqueias_r.core.domain.entity.Usuario;

import java.util.Optional;

public interface BuscarUsuarioPorCpfCnpjGateway {
    Optional<Usuario> executar(String cpfCnpj);
}
