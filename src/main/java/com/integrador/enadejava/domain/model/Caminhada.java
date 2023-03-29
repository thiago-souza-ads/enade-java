package com.integrador.enadejava.domain.model;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private LocalDateTime dataCadastro;

    @Column(columnDefinition = "datetime")
    private LocalDateTime dataFinalizada;

    @OneToOne
    @JoinColumn(name = "mapa_id", nullable = false)
    private Mapa mapa;

    @OneToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @OneToMany(mappedBy = "caminhada")
    private List<Evidencia> evidencias = new ArrayList<>();
}
