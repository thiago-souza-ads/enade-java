package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Evidencia;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Evidencia} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EvidenciaDto{
    public Long id;
    public String descricao;
    public Date dataCadastro;
    public CaminhadaDto caminhada;
}