package com.integrador.enadejava.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caminhada {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean finalizada;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private Date dataCadastro;

    @Column(columnDefinition = "datetime")
    private Date dataFinalizada;

    @OneToOne
    @JoinColumn(name = "mapa_id", nullable = false)
    private Mapa mapa;

    @OneToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @OneToMany(mappedBy = "caminhada")
    private List<Evidencia> evidencias = new ArrayList<>();
}
