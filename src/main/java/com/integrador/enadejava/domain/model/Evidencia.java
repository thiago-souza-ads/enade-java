package com.integrador.enadejava.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Evidencia {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "caminhada_id", nullable = false)
    private Caminhada caminhada;
}
