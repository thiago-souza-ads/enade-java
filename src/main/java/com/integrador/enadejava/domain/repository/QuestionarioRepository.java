package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Questionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
}
