package com.integrador.enadejava.domain.dto;


import com.integrador.enadejava.domain.model.Coordenador;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * A DTO for the {@link Coordenador} entity
 */
@Data
public class CoordenadorDto {
    public Long id;
    @NotBlank
    public String nome;
    public UsuarioDto usuario;
    public CursoDto curso;
}