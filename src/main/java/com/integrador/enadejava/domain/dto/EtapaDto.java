package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Etapa;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.util.Date;

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
    public Date dataInicio;
    public Date dataTermino;
}