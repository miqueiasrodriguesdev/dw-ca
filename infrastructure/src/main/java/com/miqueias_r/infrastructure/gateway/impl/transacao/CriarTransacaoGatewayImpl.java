package com.miqueias_r.infrastructure.gateway.impl.transacao;

import com.miqueias_r.application.gateway.transacao.CriarTransacaoGateway;
import com.miqueias_r.core.domain.entity.Carteira;
import com.miqueias_r.core.domain.entity.Transacao;
import com.miqueias_r.infrastructure.persistence.mapper.CarteiraMapper;
import com.miqueias_r.infrastructure.persistence.mapper.TransacaoMapper;
import com.miqueias_r.infrastructure.persistence.repository.CarteiraRepository;
import com.miqueias_r.infrastructure.persistence.repository.TransacaoRepository;
import org.springframework.transaction.annotation.Transactional;

public class CriarTransacaoGatewayImpl implements CriarTransacaoGateway {
    private final TransacaoRepository transacaoRepository;
    private final CarteiraRepository carteiraRepository;

    public CriarTransacaoGatewayImpl(TransacaoRepository transacaoRepository, CarteiraRepository carteiraRepository) {
        this.transacaoRepository = transacaoRepository;
        this.carteiraRepository = carteiraRepository;
    }

    @Transactional
    @Override
    public Transacao executar(Transacao transacao, Carteira carteiraPagador, Carteira carteiraRecebedor) {
        carteiraRepository.save(CarteiraMapper.toEntity(carteiraRecebedor));
        carteiraRepository.save(CarteiraMapper.toEntity(carteiraPagador));

        return TransacaoMapper.toDomain(transacaoRepository.save(TransacaoMapper.toEntity(transacao)));
    }
}
