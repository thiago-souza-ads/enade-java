package com.integrador.enadejava.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Trilha {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer anoBase;

    @Column
    private Date dataInicio;

    @Column
    private Date dataTermino;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private Date dataCadastro;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private Date dataAtualizacao;

    @OneToOne
    @JoinColumn(name = "mapa_id")
    private Mapa mapa;

    @OneToMany(mappedBy = "trilha")
    private List<Etapa> etapas = new ArrayList<>();

}