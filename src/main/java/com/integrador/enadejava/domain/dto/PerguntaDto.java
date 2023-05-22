package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Etapa;
import com.integrador.enadejava.domain.model.Pergunta;
import com.integrador.enadejava.domain.model.Questionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link Pergunta} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerguntaDto {
    public Long id;
    @Size(min = 10, max = 500)
    public String enunciado;
    public LocalDateTime dataInicio;
    public LocalDateTime dataTermino;
    public QuestionarioDto questionario;
    public List<AlternativaDto> alternativas;

    /**
     * A DTO for the {@link Questionario} entity
     */
    @Data
    public static class QuestionarioDto implements Serializable {
        public Long id;
        @NotBlank
        public String tema;
        public EtapaDto etapa;

        /**
         * A DTO for the {@link Etapa} entity
         */
        @Data
        public static class EtapaDto implements Serializable {
            public Long id;
            @NotBlank
            public String descricao;
            public LocalDateTime dataInicio;
            public LocalDateTime dataTermino;
        }
    }
}