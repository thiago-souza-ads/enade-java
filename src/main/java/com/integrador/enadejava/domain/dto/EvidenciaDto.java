package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Evidencia;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

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
    public LocalDateTime dataCadastro;
    public CaminhadaDto caminhada;
}