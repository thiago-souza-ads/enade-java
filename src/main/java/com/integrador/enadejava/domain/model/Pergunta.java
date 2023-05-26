package com.integrador.enadejava.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pergunta {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 10, max = 500)
    private String enunciado;

    @Column
    private Date dataInicio;

    @Column
    private Date dataTermino;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "questionario_id", nullable = false)
    private Questionario questionario;

    @OneToMany(mappedBy = "pergunta")
    private List<Alternativa> alternativas = new ArrayList<>();

    public void setDataTermino(Date dataTermino) {
        if (this.dataInicio != null && dataTermino.before(this.dataInicio)) {
            throw new IllegalArgumentException("A data de término não pode ser anterior à data de início");
        }
        this.dataTermino = dataTermino;
    }

    @AssertTrue(message = "A data de término não pode ser anterior à data de início")
    public boolean isDataTerminoValid() {
        if (dataInicio == null || dataTermino == null) {
            return true;
        }
        return !dataTermino.before(dataInicio);
    }
}
