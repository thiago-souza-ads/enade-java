package com.integrador.enadejava.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Avatar {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String topType;

    @Column
    private String accessoriesType;

    @Column
    private String hatColor;

    @Column
    private String hairColor;

    @Column
    private String facialHairType;

    @Column
    private String facialHairColor;

    @Column
    private String clotheType;

    @Column
    private String clotheColor;

    @Column
    private String graphicType;

    @Column
    private String eyeType;

    @Column
    private String eyebrowType;

    @Column
    private String mouthType;

    @Column
    private String skinColor;
}