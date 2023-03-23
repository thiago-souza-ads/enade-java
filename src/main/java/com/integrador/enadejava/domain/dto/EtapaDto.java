package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Etapa;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Etapa} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EtapaDto {
    public Long id;
    @NotBlank
    public String descricao;
    public LocalDateTime dataInicio;
    public LocalDateTime dataTermino;
}