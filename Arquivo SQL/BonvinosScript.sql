SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DROP SCHEMA IF EXISTS pi;
CREATE SCHEMA IF NOT EXISTS `pi` DEFAULT CHARACTER SET utf8 ;
USE `pi` ;

-- -----------------------------------------------------
-- Tabela Cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pi`.`Cliente` (
  `CPF` VARCHAR(14) NOT NULL,
  `nomeCliente` VARCHAR(100) NOT NULL,
  `telefoneCliente` VARCHAR(20) NOT NULL,
  `emailCliente` VARCHAR(100) NOT NULL,
  `senhaCliente` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`CPF`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela Proprietario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pi`.`Proprietario` (
  `CNPJ` BIGINT NOT NULL,
  `nomeProprietario` VARCHAR(100) NOT NULL,
  `telefoneProprietario` BIGINT NOT NULL,
  `emailProprietario` VARCHAR(100) NOT NULL,
  `senhaProprietario` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`CNPJ`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela Restaurante
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pi`.`Restaurante` (
  `codRestaurante` INT NOT NULL AUTO_INCREMENT,
  `nomeRestaurante` VARCHAR(50) NOT NULL,
  `descricaoRestaurante` VARCHAR(1000) NULL,
  `enderecoRuaRestaurante` VARCHAR(100) NOT NULL,
  `enderecoNumeroRestaurante` VARCHAR(100) NOT NULL,
  `enderecoCEPRestaurante` VARCHAR(100) NOT NULL,
  `telefoneRestaurante` VARCHAR(20) NULL,
  `Proprietario_CNPJ` BIGINT NOT NULL,
  `Latitude` VARCHAR(100),
  `Longitude` VARCHAR(100),
  PRIMARY KEY (`codRestaurante`),
  INDEX `fk_Restaurante_Proprietario1_idx` (`Proprietario_CNPJ` ASC) VISIBLE,
  CONSTRAINT `fk_Restaurante_Proprietario1`
    FOREIGN KEY (`Proprietario_CNPJ`)
    REFERENCES `pi`.`Proprietario` (`CNPJ`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela Mesa
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pi`.`Mesa` (
  `codMesa` INT NOT NULL AUTO_INCREMENT,
  `capacidadeMesa` INT NOT NULL,
  `Restaurante_codRestaurante` INT NOT NULL,
  `disponibilidade` BOOLEAN DEFAULT '1' NOT NULL,
  PRIMARY KEY (`codMesa`, `Restaurante_codRestaurante`),
  INDEX `fk_Mesa_Restaurante_idx` (`Restaurante_codRestaurante` ASC) VISIBLE,
  CONSTRAINT `fk_Mesa_Restaurante`
    FOREIGN KEY (`Restaurante_codRestaurante`)
    REFERENCES `pi`.`Restaurante` (`codRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabela Reserva
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pi`.`Reserva` (
  `codReserva` INT NOT NULL AUTO_INCREMENT,
  `dt_hora_inicio` DATETIME NULL,
  `dt_hora_termino` DATETIME NULL,
  `Mesa_codMesa` INT NOT NULL,
  `Mesa_Restaurante_codRestaurante` INT NOT NULL,
  `Cliente_CPF` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`codReserva`),
  INDEX `fk_Reserva_Mesa1_idx` (`Mesa_codMesa` ASC, `Mesa_Restaurante_codRestaurante` ASC) VISIBLE,
  INDEX `fk_Reserva_Cliente1_idx` (`Cliente_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_Reserva_Mesa1`
    FOREIGN KEY (`Mesa_codMesa` , `Mesa_Restaurante_codRestaurante`)
    REFERENCES `pi`.`Mesa` (`codMesa` , `Restaurante_codRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Cliente1`
    FOREIGN KEY (`Cliente_CPF`)
    REFERENCES `pi`.`Cliente` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;