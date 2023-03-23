package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Administrador;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link Administrador} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdministradorDto {
     public Long id;
     public String nome;
     public UsuarioDto usuario;
}