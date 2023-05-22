package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Questionario;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

/**
 * A DTO for the {@link Questionario} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionarioDto {
    public Long id;
    @NotBlank
    public String tema;
    public EtapaDto etapa;
    public List<PerguntaDto> perguntas;
}