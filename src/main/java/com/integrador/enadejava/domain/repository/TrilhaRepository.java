package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
}
