package com.miqueias_r.infrastructure.rest.controller;

import com.miqueias_r.infrastructure.rest.mapper.UsuarioDTOMapper;
import com.miqueias_r.infrastructure.rest.dto.response.UsuarioResponse;

import com.miqueias_r.core.domain.entity.Usuario;
import com.miqueias_r.usecase.usuario.BuscarUsuarioPorCpfCnpjUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final BuscarUsuarioPorCpfCnpjUseCase buscarUsuarioPorCpfCnpjUseCase;

    public UsuarioController(BuscarUsuarioPorCpfCnpjUseCase buscarUsuarioPorCpfCnpjUseCase) {
        this.buscarUsuarioPorCpfCnpjUseCase = buscarUsuarioPorCpfCnpjUseCase;
    }

    @GetMapping("/busca-cpf-cnpj/{cpfCnpj}")
    public ResponseEntity<UsuarioResponse> buscarPorCpfCnpj(@PathVariable("cpfCnpj") String cpfCnpj){
        Usuario usuario = buscarUsuarioPorCpfCnpjUseCase.executar(cpfCnpj);
        return ResponseEntity.ok(UsuarioDTOMapper.toDTO(usuario));
    }
}
