package com.integrador.enadejava.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Midia {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column
    private String texto;

    @OneToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @OneToOne
    @JoinColumn(name = "midia_id")
    private Foto foto;
}
