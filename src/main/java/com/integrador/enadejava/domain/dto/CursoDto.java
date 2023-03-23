package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Curso;
import lombok.*;

import java.util.List;

/**
 * A DTO for the {@link Curso} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CursoDto {
    public Long id;
    public String nome;
    public CoordenadorDto coordenador;
    public List<ProfessorDto> professores;
    public List<AlunoDto> alunos;
}