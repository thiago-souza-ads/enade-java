package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
