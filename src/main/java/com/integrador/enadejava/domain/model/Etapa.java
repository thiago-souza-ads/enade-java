package com.integrador.enadejava.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Etapa {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @Column
    private LocalDateTime dataInicio;

    @Column
    private LocalDateTime dataTermino;

    @OneToOne
    @JoinColumn(name = "tipo_etapa_id", nullable = false)
    private TipoEtapa tipoEtapa;

    @ManyToOne
    @JoinColumn(name = "trilha_id", nullable = false)
    private Trilha trilha;

    @OneToOne
    @JoinColumn(name = "questionario_id", nullable = true)
    private Questionario questionario;

    @OneToOne
    @JoinColumn(name = "midia_id", nullable = true)
    private Midia midia;

    public void setDataTermino(LocalDateTime dataTermino) {
        if (dataInicio != null && dataTermino != null && dataTermino.isBefore(dataInicio)) {
            throw new IllegalArgumentException("Data de término não pode ser anterior à data de início");
        }
        this.dataTermino = dataTermino;
    }
}
