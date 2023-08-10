package com.jast.jornada.milhas.domain.destinos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DestinoRepository extends JpaRepository<Destino, Long> {

    @Query("SELECT d from Destino d WHERE d.nome LIKE :nome%")
    List<Destino> findDestinoByNome(@Param("nome") String nome);
}
