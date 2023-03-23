package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.MidiaDto;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link Foto} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FotoDto {
     public Long id;
     public String descricao;
     public String base64;
     public MidiaDto midia;
}