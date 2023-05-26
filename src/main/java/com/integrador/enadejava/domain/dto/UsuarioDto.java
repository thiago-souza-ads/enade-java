package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Usuario;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.util.Date;

import java.util.List;

/**
 * A DTO for the {@link Usuario} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {

    public Long id;
    public String nome;
    @Email
    public String email;
    public String senha;
    public Boolean ativo;
    public Date dataCadastro;
    public Date dataAtualizacao;
    public String codigoRecuperacaoUsuario;
    public String token;
    public Date dataExpiracaoToken;
    public Date dataAlteracaoSenha;
    public Boolean requisitadoNovaSenha;
    public List<RoleDto> roles;
    public AvatarDto avatar;
}