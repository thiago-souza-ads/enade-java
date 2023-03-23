package com.integrador.enadejava.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FotoInputDTO {

    @NotBlank
     public String descricao;

    @NotBlank
     public String base64;

    @NotNull
     public Long midiaId;

}