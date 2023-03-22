package com.integrador.enadejava.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Boolean ativo;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @Column()
    private String codigoRecuperacaoUsuario;
    // CONTROLE DE ACESSO
    @Column()
    private String token;

    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataExpiracaoToken;

    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataAlteracaoSenha;

    @Column()
    private Boolean requisitadoNovaSenha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    public void setSenhaCriptografada(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.senha = encoder.encode(senha);
    }
}
