package com.miqueias_r.infrastructure.persistence.repository;

import com.miqueias_r.infrastructure.persistence.entity.CarteiraEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteiraRepository extends CrudRepository<CarteiraEntity, Long> {
    @Query("SELECT c FROM CarteiraEntity c WHERE c.usuario.id = :usuarioId")
    Optional<CarteiraEntity> buscarCarteiraPorUsuarioId(@Param("usuarioId") Long id);
}
