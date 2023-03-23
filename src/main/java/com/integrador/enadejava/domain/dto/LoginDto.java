package com.integrador.enadejava.domain.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDto {

    public String email;
    public String senha;

}
