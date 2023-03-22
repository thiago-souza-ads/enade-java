package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.TipoEtapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEtapaRepository extends JpaRepository<TipoEtapa, Long> {
}
