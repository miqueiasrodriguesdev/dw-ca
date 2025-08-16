package com.miqueias_r.infrastructure.persistence.repository;

import com.miqueias_r.infrastructure.persistence.entity.TransacaoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends CrudRepository<TransacaoEntity, Long> {
}
