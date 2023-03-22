package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
}
