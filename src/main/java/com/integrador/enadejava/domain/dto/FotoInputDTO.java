package com.integrador.enadejava.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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