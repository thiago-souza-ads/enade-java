package com.integrador.enadejava.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LoginDto implements Serializable {

    private final String email;
    private final String senha;

}
