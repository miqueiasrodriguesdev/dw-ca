package com.miqueias_r.infrastructure.persistence.repository;

import com.miqueias_r.infrastructure.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
    @Query("SELECT u FROM UsuarioEntity u WHERE u.cpfCnpj = :cpfCnpj")
    Optional<UsuarioEntity> buscarUsuarioPorCpfCnpj(@Param("cpfCnpj") String cpfCnpj);

    @Query("SELECT u FROM UsuarioEntity u WHERE u.email = :email")
    Optional<UsuarioEntity> buscarUsuarioPorEmail(@Param("email") String email);
}
