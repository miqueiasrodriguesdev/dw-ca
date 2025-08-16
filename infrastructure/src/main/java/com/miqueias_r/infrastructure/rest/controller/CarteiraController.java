package com.miqueias_r.infrastructure.rest.controller;

import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.infrastructure.rest.dto.request.CriarCarteiraRequest;
import com.miqueias_r.infrastructure.rest.dto.response.CarteiraResponse;
import com.miqueias_r.infrastructure.rest.dto.response.UsuarioResponse;
import com.miqueias_r.infrastructure.rest.mapper.CarteiraDTOMapper;
import com.miqueias_r.infrastructure.rest.mapper.UsuarioDTOMapper;
import com.miqueias_r.usecase.carteira.BuscarCarteiraPorUsuarioIdUseCase;
import com.miqueias_r.usecase.carteira.CriarCarteiraUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carteira")
public class CarteiraController {
    private final BuscarCarteiraPorUsuarioIdUseCase buscarCarteiraPorUsuarioIdUseCase;
    private final CriarCarteiraUseCase criarCarteiraUseCase;

    public CarteiraController(BuscarCarteiraPorUsuarioIdUseCase buscarCarteiraPorUsuarioIdUseCase, CriarCarteiraUseCase criarCarteiraUseCase) {
        this.buscarCarteiraPorUsuarioIdUseCase = buscarCarteiraPorUsuarioIdUseCase;
        this.criarCarteiraUseCase = criarCarteiraUseCase;
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<CarteiraResponse> buscarPorUsuarioId(@PathVariable("usuarioId") Long usuarioId){
        Carteira carteira = buscarCarteiraPorUsuarioIdUseCase.executar(usuarioId);
        return ResponseEntity.ok(CarteiraDTOMapper.toDTO(carteira));
    }

    @PostMapping
    public ResponseEntity<CarteiraResponse> criar(@RequestBody CriarCarteiraRequest request){
        Carteira carteira = criarCarteiraUseCase.executar(UsuarioDTOMapper.toDomain(request), request.pin());
        return ResponseEntity.status(HttpStatus.CREATED).body(CarteiraDTOMapper.toDTO(carteira));
    }
}
