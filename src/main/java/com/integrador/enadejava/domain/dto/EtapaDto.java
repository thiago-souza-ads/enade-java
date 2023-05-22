package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Etapa;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


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