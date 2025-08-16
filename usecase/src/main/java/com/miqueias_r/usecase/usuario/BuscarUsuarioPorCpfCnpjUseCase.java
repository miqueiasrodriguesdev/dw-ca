package com.miqueias_r.usecase.usuario;

import com.miqueias_r.core.domain.entity.Usuario;

public interface BuscarUsuarioPorCpfCnpjUseCase {
    Usuario executar(String cpfCnpj);
}
