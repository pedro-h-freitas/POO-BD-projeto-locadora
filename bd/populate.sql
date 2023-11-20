-- Script to initializate the databse 

-- ------------------------------------------------------------
-- gerando funcionarios
-- ------------------------------------------------------------
INSERT INTO funcionario(nome, telefone, salario, senha)
VALUES ("funcionario", "35999999999", 130000, "funcionario"),
("gerente", "358888888888", 300000, "gerente"),
("Pedro Freitas", "35999999", 100000, "senha123"),
("Vincius Souza", "3599001234", 150000, "lucasgadgp"),
("Lucas Gadben", "35999690569", 100000, "40028922"), 
("Alexandre Calazans", "35991819603", 130000, "246971"),
("Alexandre Ribeiro", "3599190135", 200000, "242424");

-- ------------------------------------------------------------
-- gerando gerentes
-- ------------------------------------------------------------
INSERT INTO gerente(id_funcionario)
VALUES (102), (103);

-- ------------------------------------------------------------
-- gerando locadoras
-- ------------------------------------------------------------
INSERT INTO locadora(nome, endereco, id_gerente) 
VALUES ("filial_1", "Rua José Benedito Coelho, n71, Monte Belo, Santa Rita, MG, BR", 102),
("filial_2", "Rua Vicente Manoel dos Santo, n40, Vila Industrial, Conceição dos Ouros, MG, BR", 103);

-- ------------------------------------------------------------
-- registrando funcionario em uma locadora
-- ------------------------------------------------------------
UPDATE funcionario
SET id_locadora = 1
WHERE id IN (101, 102, 103);

UPDATE funcionario
SET id_locadora = 2
WHERE id IN (104, 105, 106, 107);

-- ------------------------------------------------------------
-- gerando filmes
-- ------------------------------------------------------------
INSERT INTO info_filme(nome, ano_lancamento) 
VALUES ("Brilho eterno de uma mente sem lembranças", 2004);
INSERT INTO generos(id_info_filme, nome)
VALUES (1, "Ficção Científica"),(1, "Drama"), (1, "Comédia");

INSERT INTO info_filme(nome, ano_lancamento) 
VALUES ("Clube da Luta", 1999);
INSERT INTO generos(id_info_filme, nome)
VALUES (2, "Suspense"), (2, "Drama");

INSERT INTO info_filme(nome, ano_lancamento) 
VALUES ("Five nights at freddy's", 2023);
INSERT INTO generos(id_info_filme, nome)
VALUES (3, "Terror");

INSERT INTO info_filme(nome, ano_lancamento) 
VALUES ("Homem-Aranha: Através do Aranhaverso", 2023);
INSERT INTO generos(id_info_filme, nome)
VALUES (4, "Animação"), (4, " Ação"), (4, " Fantasia"), (4, " Aventura");

INSERT INTO info_filme(nome, ano_lancamento) 
VALUES ("Sonic 2", 2022);
INSERT INTO generos(id_info_filme, nome)
VALUES (5, "Aventura"), (5, "Família");

INSERT INTO info_filme(nome, ano_lancamento) 
VALUES ("Morbius", 2022);
INSERT INTO generos(id_info_filme, nome)
VALUES (6, "Ação"), (6, "Fantasia"), (6, "Aventura");

INSERT INTO info_filme(nome, ano_lancamento) 
VALUES ("John Carter", 2012);
INSERT INTO generos(id_info_filme, nome)
VALUES (7, "Ficção Científica"), (7, "Aventura"), (7, "Ação");

-- ------------------------------------------------------------
-- cadastrando filmes em locadoras
-- ------------------------------------------------------------
INSERT INTO filme(id_info_filme, id_locadora, n_copias)
VALUES (1, 1, 2), (2, 1, 4), (3, 1, 5), (4, 1, 4), (5, 1, 4), (6, 1, 4), (7, 1, 6); 

INSERT INTO filme(id_info_filme, id_locadora, n_copias)
VALUES (1, 2, 6), (2, 2, 2), (3, 2, 5), (4, 2, 4), (5, 2, 2), (7, 2, 6); 

-- ------------------------------------------------------------
-- gerando clientes
-- ------------------------------------------------------------
INSERT INTO cliente(nome, cpf, senha, telefone)
VALUES ('Yasmin', '00145720258', 'yasminlinda', '(35)99271-2929'),
('Julia Helena', '12345678910', 'pedroehumlindo', '(35)90000-0000'),
('Jose Alfredo', '10784381734', 'alfanumerica', '(35)9999-9999'),
('Silvana Almeida de Freitas', '79865412385', 'senha', '(35)91234-3214'),
('cliente', '00000000001', 'cliente', '358888888888');

-- ------------------------------------------------------------
-- gerando alugueis
-- ------------------------------------------------------------
INSERT INTO aluguel(data_locacao, id_cliente, id_locadora)
VALUES ('2023-11-10', 201, 1);
INSERT INTO filme_alugado(id_aluguel, id_filme)
VALUES (1201, 13), (1201, 12);

INSERT INTO aluguel(data_locacao, id_cliente, id_locadora)
VALUES ('2023-11-10', 202, 1);
INSERT INTO filme_alugado(id_aluguel, id_filme)
VALUES (1202, 15);

INSERT INTO aluguel(data_locacao, id_cliente, id_locadora)
VALUES ('2023-11-10', 203, 1);
INSERT INTO filme_alugado(id_aluguel, id_filme)
VALUES (1203, 12), (1203, 13), (1203, 14);

INSERT INTO aluguel(data_locacao, id_cliente, id_locadora)
VALUES ('2023-11-10', 204, 2);
INSERT INTO filme_alugado(id_aluguel, id_filme)
VALUES (2204, 27);

INSERT INTO aluguel(data_locacao, id_cliente, id_locadora)
VALUES ('2023-05-10', 205, 1);
INSERT INTO filme_alugado(id_aluguel, id_filme)
VALUES (1205, 16);

UPDATE aluguel
SET status = 'entregue'
WHERE id = 1205;

select * from aluguel;