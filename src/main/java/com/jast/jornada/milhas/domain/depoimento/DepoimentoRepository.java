package com.jast.jornada.milhas.domain.depoimento;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepoimentoRepository extends JpaRepository<Depoimento, Long>{

    @Query("""
         select depoimento from Depoimento depoimento order by rand()
        """) 
    public Page<Depoimento> retornarAleatorio(Pageable paginacao);
}
