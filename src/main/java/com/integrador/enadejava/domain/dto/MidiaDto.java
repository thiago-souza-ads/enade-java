package com.integrador.enadejava.domain.model;

import com.integrador.enadejava.domain.dto.EtapaDto;
import com.integrador.enadejava.domain.dto.FotoDto;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link Midia} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MidiaDto {
     public Long id;
     public String descricao;
     public String texto;
     public EtapaDto etapa;
     public FotoDto foto;
}