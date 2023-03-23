package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.TipoEtapa;
import lombok.*;

/**
 * A DTO for the {@link TipoEtapa} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoEtapaDto {
    public Long id;
    public String descricao;
}