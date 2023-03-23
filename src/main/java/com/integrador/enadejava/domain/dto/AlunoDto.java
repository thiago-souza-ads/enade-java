package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Aluno;
import lombok.*;

/**
 * A DTO for the {@link Aluno} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlunoDto {
    public Long id;
    public String nome;
    public UsuarioDto usuario;
    public CursoDto curso;
}