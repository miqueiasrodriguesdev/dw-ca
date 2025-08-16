package com.miqueias_r.infrastructure.client.dto.request;

import java.math.BigDecimal;

public record AutorizarRequest(Long carteiraPagadorId, Long carteiraRecebedorId, BigDecimal valor) {
}
