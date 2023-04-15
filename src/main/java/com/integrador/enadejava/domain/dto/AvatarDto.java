package com.integrador.enadejava.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Avatar} entity
 */
@Data
public class AvatarDto implements Serializable {
    private final Long id;
    private final String topType;
    private final String accessoriesType;
    private final String hatColor;
    private final String hairColor;
    private final String facialHairType;
    private final String facialHairColor;
    private final String clotheType;
    private final String clotheColor;
    private final String graphicType;
    private final String eyeType;
    private final String eyebrowType;
    private final String mouthType;
    private final String skinColor;
}