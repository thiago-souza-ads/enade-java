package com.integrador.enadejava.domain.model;


import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Foto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column
    private String base64;

    @OneToOne
    @JoinColumn(name = "midia_id")
    private Midia midia;
}
