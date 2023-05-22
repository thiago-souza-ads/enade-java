package com.integrador.enadejava.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Questionario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String tema;

    @OneToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @OneToMany(mappedBy = "questionario", fetch = FetchType.LAZY)
    private List<Pergunta> perguntas = new ArrayList<>();

}
