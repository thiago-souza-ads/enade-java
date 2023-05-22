package com.integrador.enadejava.domain.dto;

import com.integrador.enadejava.domain.model.Usuario;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
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
    public LocalDateTime dataCadastro;
    public LocalDateTime dataAtualizacao;
    public String codigoRecuperacaoUsuario;
    public String token;
    public LocalDateTime dataExpiracaoToken;
    public LocalDateTime dataAlteracaoSenha;
    public Boolean requisitadoNovaSenha;
    public List<RoleDto> roles;
    public AvatarDto avatar;
}