package com.integrador.enadejava.domain.repository;

import com.integrador.enadejava.domain.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
