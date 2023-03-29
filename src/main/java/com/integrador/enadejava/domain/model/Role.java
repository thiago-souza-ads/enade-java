package com.integrador.enadejava.domain.model;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.annotation.Id;


@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
}