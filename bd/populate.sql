-- ------------------------------------------------------------
-- gerando funcionarios
-- ------------------------------------------------------------
INSERT INTO funcionario(nome, telefone, salario, senha)
VALUES ("Pedro Freitas", "35999999", 100000, "senha123"),
("Vincius Souza", "3599001234", 150000, "lucasgadgp"),
("Lucas Gadben", "35999690569", 100000, "40028922"), 
("Alexandre Calazans", "35991819603", 130000, "246971"),
("funcionario", "35999999999", 130000, "funcionario"),
("gerente", "358888888888", 300000, "gerente");

-- ------------------------------------------------------------
-- gerando gerentes
-- ------------------------------------------------------------
INSERT INTO gerente(id_funcionario)
VALUES (1, 6);

-- ------------------------------------------------------------
-- gerando locadoras
-- ------------------------------------------------------------
INSERT INTO locadora(nome, endereco, gerente) 
VALUES ("filial_1", "Rua José Benedito Coelho, n71, Monte Belo, Santa Rita, MG, BR", 1),
("filial_2", "Rua Vicente Manoel dos Santo, n40, Vila Industrial, Conceição dos Ouros, MG, BR" ,6);

-- ------------------------------------------------------------
-- gerando filmes
-- ------------------------------------------------------------
INSERT INTO filme(nome, ano_lancamento) 
VALUES ("Brilho eterno de uma mente sem lembranças", 2004);
INSERT INTO generos(id_filme, nome)
VALUES (1, "Ficção Científica"),(1, "Drama"), (1, "Comédia");

INSERT INTO filme(nome, ano_lancamento) 
VALUES ("Clube da Luta", 1999);
INSERT INTO generos(id_filme, nome)
VALUES (2, "Suspense"), (2, "Drama");

INSERT INTO filme(nome, ano_lancamento) 
VALUES ("Five nights at freddy's", 2023);
INSERT INTO generos(id_filme, nome)
VALUES (3, "Terror");

INSERT INTO filme(nome, ano_lancamento) 
VALUES ("Homem-Aranha: Através do Aranhaverso", 2023);
INSERT INTO generos(id_filme, nome)
VALUES (4, "Animação"), (4, " Ação"), (4, " Fantasia"), (4, " Aventura");

INSERT INTO filme(nome, ano_lancamento) 
VALUES ("Sonic 2", 2022);
INSERT INTO generos(id_filme, nome)
VALUES (5, "Aventura"), (5, "Família");

INSERT INTO filme(nome, ano_lancamento) 
VALUES ("Morbius", 2022);
INSERT INTO generos(id_filme, nome)
VALUES (6, "Ação"), (6, "Fantasia"), (7, "Aventura");

INSERT INTO filme(nome, ano_lancamento) 
VALUES ("John Carter", 2012);
INSERT INTO generos(id_filme, nome)
VALUES (7, "Ficção Científica"), (7, "Aventura"), (8, "Ação");

-- ------------------------------------------------------------
-- cadastrando filmes em locadoras
-- ------------------------------------------------------------

-- ------------------------------------------------------------
-- gerando clientes
-- ------------------------------------------------------------

-- ------------------------------------------------------------
-- gerando alugueis
-- ------------------------------------------------------------
