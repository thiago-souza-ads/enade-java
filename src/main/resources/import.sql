SET FOREIGN_KEY_CHECKS=0;

insert into role (id, nome) values (1, 'Administrador');
insert into role (id, nome) values (2, 'Coordenador');
insert into role (id, nome) values (3, 'Professor');
insert into role (id, nome) values (4, 'Aluno');

insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (1, 'Thiago Rodrigues de Souza', 'thiago@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (2, 'Douglas Rocha Mendes', 'douglas@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (3, 'Valmir da Silva', 'valmir@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (4, 'Juliano Maciel', 'juliano@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (5, 'Juliana Maciel', 'juliana@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (6, 'Suelen Pereira de Souza', 'suelen@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (7, 'Gabriel Rodrigues de Souza', 'gabriel@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (8, 'Felipe Toledo', 'felipe@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (9, 'Jerry Mariano', 'jerry@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (10, 'Brunno Oliveira', 'brunno@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (11, 'Rafael Duarte', 'rafael@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (12, 'Bruno Tokio', 'bruno@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (13, 'Waldeir Marcelino', 'waldeir@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (14, 'Marcelo Ferri', 'marcelo@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (15, 'Pernambuco Meu mano', 'pernambuco@teste.com', '123', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);
insert into usuario (id, nome, email, senha, ativo, data_cadastro, data_atualizacao, token, data_expiracao_token, data_alteracao_senha, requisitado_nova_senha) values (16, 'Enade User', 'user@enade.com', 'user', true, utc_timestamp, utc_timestamp, 'token', utc_timestamp, utc_timestamp, false);

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

insert into questionario (id, tema) values (1, 'Tecnologia');
insert into pergunta (id, enunciado, questionario_id) VALUES (1, 'Qual a diferença entre Inteligência Artificial e Aprendizado de Máquina?', 1);
insert into alternativa (id, descricao, correta, pergunta_id) values (1, 'Não há diferença entre os dois conceitos', false, 1);
insert into alternativa (id, descricao, correta, pergunta_id) values (2, 'Inteligência Artificial é um subconjunto do Aprendizado de Máquina', false, 1);
insert into alternativa (id, descricao, correta, pergunta_id) values (3, 'Aprendizado de Máquina é um subconjunto da Inteligência Artificial', true, 1);
insert into alternativa (id, descricao, correta, pergunta_id) values (4, 'Inteligência Artificial é uma técnica utilizada apenas em jogos de computador', false, 1);
insert into alternativa (id, descricao, correta, pergunta_id) values (5, 'Aprendizado de Máquina é uma técnica utilizada apenas em reconhecimento de voz', false, 1);
insert into explicacao (id, descricao, alternativa_id) values (1, 'A Está incorreta, pois não representam a diferença entre as duas técnicas', 1);
insert into explicacao (id, descricao, alternativa_id) values (2, 'Alternativa B está errada ao afirmar que a Inteligência Artificial é um subconjunto do Aprendizado de Máquina.', 2);
insert into explicacao (id, descricao, alternativa_id) values (3, 'Parabéns, Aprendizado de Máquina é uma das técnicas que compõem a Inteligência Artificial, assim como outras técnicas, como Redes Neurais, Lógica Fuzzy, etc. ', 3);
insert into explicacao (id, descricao, alternativa_id) values (4, 'D incorreta por tal motivo', 4);
insert into explicacao (id, descricao, alternativa_id) values (5, 'E está incorreta por tal motivo', 5);

SET FOREIGN_KEY_CHECKS=1;