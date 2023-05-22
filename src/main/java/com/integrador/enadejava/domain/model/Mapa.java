package com.integrador.enadejava.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mapa {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(value = 2023, message = "O ano base deve ser maior ou igual a 2023")
    @Max(value = 2100, message = "O ano base deve ser menor ou igual a 2100")
    private Integer anoBase;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @OneToOne
    @JoinColumn(name = "coordenador_id")
    private Coordenador coordenador;

    @Column(columnDefinition = "boolean default false")
    private Boolean aprovado;
}
