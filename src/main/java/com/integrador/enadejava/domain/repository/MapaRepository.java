package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Mapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapaRepository extends JpaRepository<Mapa, Long> {
}
