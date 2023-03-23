package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Professor;
import lombok.*;

/**
 * A DTO for the {@link Professor} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfessorDto {
     public Long id;
     public String nome;
     public UsuarioDto usuario;
     public CursoDto curso;
}