package com.miqueias_r.infrastructure.client;

import com.miqueias_r.infrastructure.client.dto.request.NotificarRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "enviarNotificacaoTransacaoClient", url = "https://util.devi.tools/api/v1")
public interface EnviarNotificacaoTransacaoClient {

    @PostMapping("/notify")
    void notificar(NotificarRequest notificarRequest);
}
