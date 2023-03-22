package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Long> {
}
