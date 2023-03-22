package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Long> {
}
