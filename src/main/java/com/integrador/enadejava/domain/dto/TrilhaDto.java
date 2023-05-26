package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Trilha;
import lombok.*;
import java.util.Date;
import java.io.Serializable;

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
     public Date dataInicio;
     public Date dataTermino;
     public AlunoDto aluno;
     public Date dataCadastro;
     public Date dataAtualizacao;
     public MapaDto mapa;
     public List<EtapaDto> etapas;
}