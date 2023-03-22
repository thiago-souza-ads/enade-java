package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenciaRepository extends JpaRepository<Evidencia, Long> {
}
