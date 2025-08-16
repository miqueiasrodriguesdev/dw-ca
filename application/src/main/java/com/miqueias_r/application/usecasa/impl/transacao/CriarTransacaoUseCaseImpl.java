package com.miqueias_r.application.usecasa.impl.transacao;

import com.miqueias_r.application.gateway.transacao.CriarTransacaoGateway;
import com.miqueias_r.application.gateway.transacao.EnviarNotificacaoTransacaoGateway;
import com.miqueias_r.application.gateway.transacao.ValidarTransacaoGateway;
import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.core.domain.entity.Transacao;
import com.miqueias_r.core.exception.CarteiraException;
import com.miqueias_r.core.exception.TransacaoException;
import com.miqueias_r.core.exception.enums.message.CarteiraMessageEnum;
import com.miqueias_r.core.exception.enums.message.TransacaoMessageEnum;
import com.miqueias_r.usecase.carteira.BuscarCarteiraPorUsuarioIdUseCase;
import com.miqueias_r.usecase.transacao.CriarTransacaoUseCase;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

public class CriarTransacaoUseCaseImpl implements CriarTransacaoUseCase {
    private final CriarTransacaoGateway criarTransacaoGateway;
    private final ValidarTransacaoGateway validarTransacaoGateway;
    private final EnviarNotificacaoTransacaoGateway enviarNotificacaoTransacaoGateway;
    private final BuscarCarteiraPorUsuarioIdUseCase buscarCarteiraPorUsuarioIdUseCase;


    public CriarTransacaoUseCaseImpl(CriarTransacaoGateway criarTransacaoGateway, ValidarTransacaoGateway validarTransacaoGateway, EnviarNotificacaoTransacaoGateway enviarNotificacaoTransacaoGateway, BuscarCarteiraPorUsuarioIdUseCase buscarCarteiraPorUsuarioIdUseCase) {
        this.criarTransacaoGateway = criarTransacaoGateway;
        this.validarTransacaoGateway = validarTransacaoGateway;
        this.enviarNotificacaoTransacaoGateway = enviarNotificacaoTransacaoGateway;
        this.buscarCarteiraPorUsuarioIdUseCase = buscarCarteiraPorUsuarioIdUseCase;
    }

    @Override
    public Transacao executar(Long usuarioPagadorId, Long usuarioRecebedorId, BigDecimal valor, String pin) {
        if(usuarioPagadorId.equals(usuarioRecebedorId)){
            throw new TransacaoException(TransacaoMessageEnum.TRANSACAO_NAO_PERMITIDA);
        }

        Carteira carteiraPagador = buscarCarteiraPorUsuarioIdUseCase.executar(usuarioPagadorId);

        if(!carteiraPagador.getPin().equals(pin)){
            throw new CarteiraException(CarteiraMessageEnum.CARTEIRA_PIN_INCORRETO);
        }

        Carteira carteiraRecebedor = buscarCarteiraPorUsuarioIdUseCase.executar(usuarioRecebedorId);

        if(!validarTransacaoGateway.executar()){
            throw new TransacaoException(TransacaoMessageEnum.TRANSACAO_NAO_AUTORIZADO);
        }

        carteiraPagador.transferir(valor);
        carteiraRecebedor.receber(valor);

        Transacao transacao = new Transacao(carteiraPagador, carteiraRecebedor, valor);

        Transacao transacaoCreated = criarTransacaoGateway.executar(transacao, carteiraPagador, carteiraRecebedor);

        CompletableFuture.runAsync(() -> enviarNotificacaoTransacaoGateway.executar(transacaoCreated));

        return transacaoCreated;
    }
}
