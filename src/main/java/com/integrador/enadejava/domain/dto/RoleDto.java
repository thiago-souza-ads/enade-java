package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Role;
import lombok.*;

/**
 * A DTO for the {@link Role} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDto {
    public Long id;
    public String nome;
}