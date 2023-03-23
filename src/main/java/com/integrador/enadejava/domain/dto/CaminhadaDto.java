package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Caminhada;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link Caminhada} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CaminhadaDto {
    public Long id;
    public Boolean finalizada;
    public LocalDateTime dataCadastro;
    public LocalDateTime dataFinalizada;
    public MapaDto mapa;
    public AlunoDto aluno;
    public List<EvidenciaDto> evidencias;
}