package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Alternativa;
import com.integrador.enadejava.domain.model.ExplicacaoDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import java.util.Date;


/**
 * A DTO for the {@link Alternativa} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlternativaDto {
    public Long id;
    public String descricao;
    @Min(1)
    @Max(5)
    public Integer ordem;
    public Boolean correta;
    public Boolean acertou;
    public Boolean escolhidaUsuario;
    public Date dataEscolha;
    public PerguntaDto pergunta;
    public ExplicacaoDto explicacao;
}