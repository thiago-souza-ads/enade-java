package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Trilha;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link Trilha} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrilhaDto {
     public Long id;
     public Integer anoBase;
     public LocalDateTime dataInicio;
     public LocalDateTime dataTermino;
     public AlunoDto aluno;
     public LocalDateTime dataCadastro;
     public LocalDateTime dataAtualizacao;
     public MapaDto mapa;
     public List<EtapaDto> etapas;
}