package com.miqueias_r.infrastructure.client.dto.request;

public record NotificarRequest(Long usuarioPagadorId, Long usuarioRecebedorId, Long transacaoId) {
}
