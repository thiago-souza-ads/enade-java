package com.integrador.enadejava.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Alternativa {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Min(1)
    @Max(5)
    @Column
    private Integer ordem;

    @Column(columnDefinition = "boolean default false")
    private Boolean correta;

    @Column(columnDefinition = "boolean default false")
    private Boolean acertou;

    @Column(columnDefinition = "boolean default false")
    @Setter
    private Boolean escolhidaUsuario;

    @Column
    private LocalDateTime dataEscolha;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pergunta_id", nullable = false)
    private Pergunta pergunta;

    @OneToOne
    @JoinColumn(name = "alternativa_id")
    private Explicacao explicacao;

    public void setAcertou() {
        this.acertou = this.correta && this.escolhidaUsuario;
    }
}
