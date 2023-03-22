package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @NotNull
    private Boolean ativo;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataAtualizacao;

    private String codigoRecuperacaoUsuario;

    private String token;

    private LocalDateTime dataExpiracaoToken;

    private LocalDateTime dataAlteracaoSenha;

    private Boolean requisitadoNovaSenha;

    private List<Role> roles = new ArrayList<>();

}
