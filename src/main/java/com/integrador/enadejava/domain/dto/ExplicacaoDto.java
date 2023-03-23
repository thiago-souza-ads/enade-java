package com.integrador.enadejava.domain.model;

import com.integrador.enadejava.domain.dto.AlternativaDto;
import lombok.*;

/**
 * A DTO for the {@link Explicacao} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExplicacaoDto {
     public Long id;
     public String descricao;
     public AlternativaDto alternativa;
}