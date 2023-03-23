package com.integrador.enadejava.domain.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CredenciaisDto {

    public String login;
    public String senha;


    public String getEmail() {
        return login;
    }

    public void setEmail(String email) {
        this.login = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
