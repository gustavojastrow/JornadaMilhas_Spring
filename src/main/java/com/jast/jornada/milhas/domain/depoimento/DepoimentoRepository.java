package com.jast.jornada.milhas.domain.depoimento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Long>{

    @Query("SELECT d from Depoimento d order by rand()")
    public Page<Depoimento> retornarAleatorio(Pageable paginacao);

}
