package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Explicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplicacaoRepository extends JpaRepository<Explicacao, Long> {
}
