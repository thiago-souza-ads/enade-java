package com.integrador.enadejava.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * Classe que representa um Coordenador no sistema.
 * Um Coordenador é responsável por gerenciar as atividades da trilha de aprendizado.
 * Cada Coordenador possui um nome e um usuário associado.
 */
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Coordenador {

    /**
     * Identificador único do Coordenador.
     */
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do Coordenador.
     */
    @NotBlank
    @Column(nullable = false)
    private String nome;

    /**
     * Referência ao usuário associado ao Coordenador.
     */
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
