package com.miqueias_r.infrastructure.rest.controller;

import com.miqueias_r.core.domain.entity.Transacao;
import com.miqueias_r.infrastructure.rest.dto.request.CriarTransacaoRequest;
import com.miqueias_r.infrastructure.rest.dto.response.TransacaoResponse;
import com.miqueias_r.infrastructure.rest.mapper.TransacaoDTOMapper;
import com.miqueias_r.usecase.transacao.CriarTransacaoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {
    private final CriarTransacaoUseCase criarTransacaoUseCase;

    public TransacaoController(CriarTransacaoUseCase criarTransacaoUseCase) {
        this.criarTransacaoUseCase = criarTransacaoUseCase;
    }

    @PostMapping
    public ResponseEntity<TransacaoResponse> criar (@RequestBody CriarTransacaoRequest request){
        Transacao transacao = criarTransacaoUseCase.executar(request.payer(), request.peyee(), request.value(), request.pin());
        return ResponseEntity.status(HttpStatus.CREATED).body(TransacaoDTOMapper.toDTO(transacao));
    }
}
