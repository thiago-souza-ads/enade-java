package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.dto.CoordenadorDto;
import com.integrador.enadejava.domain.model.Mapa;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Mapa} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MapaDto{
     public Long id;
    @Min(value = 2023, message = "O ano base deve ser maior ou igual a 2023")
    @Max(value = 2100, message = "O ano base deve ser menor ou igual a 2100")
     public Integer anoBase;
     public LocalDateTime dataCadastro;
     public LocalDateTime dataAtualizacao;
     public CoordenadorDto coordenador;
     public Boolean aprovado;
}