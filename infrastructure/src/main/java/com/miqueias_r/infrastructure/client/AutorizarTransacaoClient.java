package com.miqueias_r.infrastructure.client;

import com.miqueias_r.infrastructure.client.dto.response.AutorizarResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "autorizarTransacaoClient", url = "https://util.devi.tools/api/v2")
public interface AutorizarTransacaoClient {

    @GetMapping("/authorize")
    AutorizarResponse autorizar();
}
