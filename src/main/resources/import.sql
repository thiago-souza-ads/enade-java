SET FOREIGN_KEY_CHECKS=0;

insert into role (id, nome) values (1, 'Administrador');
insert into role (id, nome) values (2, 'Coordenador');
insert into role (id, nome) values (3, 'Professor');
insert into role (id, nome) values (4, 'Aluno');


insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (1, 'Thiago Rodrigues de Souza', 'thiago@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (2, 'Douglas Rocha Mendes', 'douglas@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (3, 'Valmir da Silva', 'valmir@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (4, 'Juliano Maciel', 'juliano@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (5, 'Juliana Maciel', 'juliana@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (6, 'Suelen Pereira de Souza', 'suelen@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (7, 'Gabriel Rodrigues de Souza', 'gabriel@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (8, 'Felipe Toledo', 'felipe@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (9, 'Jerry Mariano', 'jerry@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (10, 'Brunno Oliveira', 'brunno@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (11, 'Rafael Duarte', 'rafael@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (12, 'Bruno Tokio', 'bruno@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (13, 'Waldeir Marcelino', 'waldeir@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (14, 'Marcelo Ferri', 'marcelo@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, login, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (15, 'Pernambuco Meu mano', 'pernambuco@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);

insert into administrador (id, nome, usuario_id) values (1, 'Analista Master', 1);

insert into coordenador (id, nome, usuario_id) values (1, 'Coordenador do Curso', 2);
insert into coordenador (id, nome, usuario_id) values (2, 'Coordenador do Curso', 4);
insert into coordenador (id, nome, usuario_id) values (3, 'Coordenador do Curso', 9);
insert into coordenador (id, nome, usuario_id) values (4, 'Coordenador do Curso', 12);

insert into curso (id, nome, coordenador_id) values (1, 'Tecnologia da Informação', 1);
insert into curso (id, nome, coordenador_id) values (2, 'Direito', 2);
insert into curso (id, nome, coordenador_id) values (3, 'Enfermagem', 3);
insert into curso (id, nome, coordenador_id) values (4, 'Educação Física', 4);

insert into usuario_role (usuario_id, role_id) values (1, 2);
insert into usuario_role (usuario_id, role_id) values (2, 2);
insert into usuario_role (usuario_id, role_id) values (3, 2);
insert into usuario_role (usuario_id, role_id) values (4, 2);
insert into usuario_role (usuario_id, role_id) values (5, 2);

SET FOREIGN_KEY_CHECKS=1;