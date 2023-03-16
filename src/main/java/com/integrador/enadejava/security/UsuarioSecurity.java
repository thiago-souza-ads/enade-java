package com.integrador.enadejava.security;

import com.integrador.enadejava.domain.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;


public class UsuarioSecurity implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private Boolean ativo;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataAtualizacao;
    private String codigoRecuperacaoUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioSecurity() {
    }

    public UsuarioSecurity(Usuario usuario) {
        super();
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.ativo = usuario.getAtivo();
        this.dataCadastro = usuario.getDataCadastro();
        this.dataAtualizacao = usuario.getDataAtualizacao();
        this.codigoRecuperacaoUsuario = usuario.getCodigoRecuperacaoUsuario();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCodigoRecuperacaoUsuario() {
        return codigoRecuperacaoUsuario;
    }

}
