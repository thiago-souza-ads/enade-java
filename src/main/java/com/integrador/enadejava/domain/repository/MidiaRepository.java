package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MidiaRepository extends JpaRepository<Midia, Long> {
}
