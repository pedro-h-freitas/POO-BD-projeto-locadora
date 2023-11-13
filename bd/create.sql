-- MySQL Script generated by MySQL Workbench
-- Mon Nov 13 20:26:12 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema locadora_bd
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `locadora_bd` ;

-- -----------------------------------------------------
-- Schema locadora_bd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `locadora_bd` DEFAULT CHARACTER SET utf8 ;
USE `locadora_bd` ;

-- -----------------------------------------------------
-- Table `funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `salario` INT NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `id_locadora` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_funcionario_locadora_idx` (`id_locadora` ASC) INVISIBLE,
  CONSTRAINT `fk_funcionario_locadora`
    FOREIGN KEY (`id_locadora`)
    REFERENCES `locadora` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gerente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerente` (
  `id_funcionario` INT NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE INDEX `id_funcionario_UNIQUE` (`id_funcionario` ASC) VISIBLE,
  CONSTRAINT `fk_gerente_funcionario`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `funcionario` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `id_gerente` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE,
  INDEX `fk_locadora_gerente_idx` (`id_gerente` ASC) INVISIBLE,
  CONSTRAINT `fk_locadora_gerente`
    FOREIGN KEY (`id_gerente`)
    REFERENCES `gerente` (`id_funcionario`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `info_filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `info_filme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `ano_lancamento` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `generos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `generos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `id_info_filme` INT NOT NULL,
  INDEX `fk_generos_info_filme_idx` (`id_info_filme` ASC) INVISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_generos_info_filme`
    FOREIGN KEY (`id_info_filme`)
    REFERENCES `info_filme` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(13) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(100) NULL,
  `telefone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aluguel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aluguel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_locacao` DATE NOT NULL,
  `data_devolucao` DATE NULL,
  `status` ENUM("entregue", "atrasado", "no prazo") NULL DEFAULT 'no prazo',
  `multa` INT NULL,
  `id_cliente` INT NOT NULL,
  `id_locadora` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alguel_cliente_idx` (`id_cliente` ASC) INVISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) INVISIBLE,
  INDEX `fk_aluguel_locadora_idx` (`id_locadora` ASC) VISIBLE,
  CONSTRAINT `fk_alguel_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `cliente` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_aluguel_locadora`
    FOREIGN KEY (`id_locadora`)
    REFERENCES `locadora` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `n_copias` INT NOT NULL,
  `n_disponiveis` INT NULL DEFAULT NULL,
  `id_locadora` INT NULL,
  `id_info_filme` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_locadora_filme_filme_idx` (`id_info_filme` ASC) INVISIBLE,
  UNIQUE INDEX `id_filme_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_filme_locadora_idx` (`id_locadora` ASC) VISIBLE,
  CONSTRAINT `fk_filme_locadora`
    FOREIGN KEY (`id_locadora`)
    REFERENCES `locadora` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_filme_info_filme`
    FOREIGN KEY (`id_info_filme`)
    REFERENCES `info_filme` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filme_alugado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filme_alugado` (
  `id_aluguel` INT NOT NULL,
  `id_filme` INT NOT NULL,
  PRIMARY KEY (`id_aluguel`, `id_filme`),
  INDEX `fk_filme_alugado_aluguel_idx` (`id_aluguel` ASC) INVISIBLE,
  INDEX `fk_filme_alugado_filme_idx` (`id_filme` ASC) VISIBLE,
  CONSTRAINT `fk_filme_alugado_aluguel`
    FOREIGN KEY (`id_aluguel`)
    REFERENCES `aluguel` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_filme_alugado_filme`
    FOREIGN KEY (`id_filme`)
    REFERENCES `filme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `locadora_bd`;

DELIMITER $$
USE `locadora_bd`$$
CREATE TRIGGER cliente_BEFORE_INSERT 
BEFORE INSERT ON cliente
FOR EACH ROW
BEGIN
	IF (NEW.endereco IS NULL) AND (NEW.telefone IS NULL) AND (NEW.email IS NULL) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'CAMPOS (endereco, telefone, email) NULOS, PELO MENOS UM DEVE SER PREENCHIDO';
    END IF;
END;$$

USE `locadora_bd`$$
CREATE TRIGGER aluguel_BEFORE_UPDATE 
BEFORE UPDATE ON aluguel
FOR EACH ROW
BEGIN
	IF NEW.status = "entregue" THEN
		DELETE FROM filme_alugado WHERE filme_alugado.id_aluguel = NEW.id;
		SET NEW.data_devolucao = CURDATE();
	END IF;
END;$$

USE `locadora_bd`$$
CREATE TRIGGER filme_BEFORE_INSERT
BEFORE INSERT ON filme
FOR EACH ROW
BEGIN
	SET NEW.n_disponiveis = NEW.n_copias;
    SET NEW.id = CONCAT(NEW.id_locadora, NEW.id_info_filme);
END;$$

USE `locadora_bd`$$
CREATE TRIGGER filme_BEFORE_UPDATE 
BEFORE UPDATE ON filme
FOR EACH ROW
BEGIN
    SET NEW.id = CONCAT(NEW.id_locadora, NEW.id_info_filme);
END;$$

USE `locadora_bd`$$
CREATE TRIGGER filme_alugado_BEFORE_INSERT 
BEFORE INSERT ON filme_alugado
FOR EACH ROW
BEGIN
	IF (SELECT n_disponiveis FROM filme WHERE filme.id = NEW.id_filme) = 0 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Não há o filme no estoque da locadora';
    ELSEIF (SELECT aluguel.id_locadora from aluguel WHERE aluguel.id = NEW.id_aluguel) != (SELECT filme.id_locadora from filme WHERE filme.id = NEW.id_filme) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'id_locadora do "aluguel" e do "filme" não são iguais';
    END IF;
END;$$

USE `locadora_bd`$$
CREATE TRIGGER filme_alugado_AFTER_INSERT 
AFTER INSERT ON filme_alugado
FOR EACH ROW
BEGIN
	UPDATE filme
    SET n_disponiveis = n_disponiveis - 1
    WHERE filme.id = NEW.id_filme;
END;$$

USE `locadora_bd`$$
CREATE TRIGGER filme_alugado_AFTER_DELETE 
AFTER DELETE ON filme_alugado
FOR EACH ROW
BEGIN
	UPDATE filme
    SET n_disponiveis = n_disponiveis + 1
    WHERE filme.id = OLD.id_filme;
END;$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
