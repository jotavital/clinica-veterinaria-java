-- MySQL Script generated by MySQL Workbench
-- Sat Jun 26 17:12:58 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ClinicaVeterinariaDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ClinicaVeterinariaDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ClinicaVeterinariaDB` DEFAULT CHARACTER SET utf8 ;
USE `ClinicaVeterinariaDB` ;

-- -----------------------------------------------------
-- Table `ClinicaVeterinariaDB`.`atendente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ClinicaVeterinariaDB`.`atendente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `tipo_telefone` VARCHAR(45) NULL,
  UNIQUE INDEX (`usuario` ASC),
  UNIQUE INDEX (`cpf` ASC),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClinicaVeterinariaDB`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ClinicaVeterinariaDB`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `rua` VARCHAR(50) NOT NULL,
  `bairro` VARCHAR(50) NOT NULL,
  `numero` VARCHAR(5) NOT NULL,
  `tipo_telefone` VARCHAR(45) NOT NULL,
  UNIQUE INDEX (`cpf` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClinicaVeterinariaDB`.`animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ClinicaVeterinariaDB`.`animal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `especie` VARCHAR(50) NOT NULL,
  `raca` VARCHAR(50) NOT NULL,
  `idade` INT(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClinicaVeterinariaDB`.`veterinario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ClinicaVeterinariaDB`.`veterinario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `rua` VARCHAR(50) NOT NULL,
  `bairro` VARCHAR(50) NOT NULL,
  `numero` VARCHAR(5) NOT NULL,
  `tipo_telefone` VARCHAR(45) NULL,
  UNIQUE INDEX (`cpf` ASC),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClinicaVeterinariaDB`.`consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ClinicaVeterinariaDB`.`consulta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  `valor` DECIMAL(9,2) NOT NULL,
  `data_consulta` DATE NOT NULL,
  `data_prevista` DATE NOT NULL,
  `data_agendamento` DATE NOT NULL,
  `fk_animal` INT NOT NULL,
  `fk_atendente` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `consulta_fk0` (`fk_animal` ASC),
  INDEX `consulta_fk1` (`fk_atendente` ASC),
  CONSTRAINT `consulta_fk0`
    FOREIGN KEY (`fk_animal`)
    REFERENCES `ClinicaVeterinariaDB`.`animal` (`id`),
  CONSTRAINT `consulta_fk1`
    FOREIGN KEY (`fk_atendente`)
    REFERENCES `ClinicaVeterinariaDB`.`atendente` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClinicaVeterinariaDB`.`cliente_animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ClinicaVeterinariaDB`.`cliente_animal` (
  `fk_cliente` INT NOT NULL,
  `fk_animal` INT NOT NULL,
  PRIMARY KEY (`fk_cliente`, `fk_animal`),
  INDEX `cliente_animal_fk1` (`fk_animal` ASC),
  CONSTRAINT `cliente_animal_fk0`
    FOREIGN KEY (`fk_cliente`)
    REFERENCES `ClinicaVeterinariaDB`.`cliente` (`id`),
  CONSTRAINT `cliente_animal_fk1`
    FOREIGN KEY (`fk_animal`)
    REFERENCES `ClinicaVeterinariaDB`.`animal` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClinicaVeterinariaDB`.`veterinario_consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ClinicaVeterinariaDB`.`veterinario_consulta` (
  `fk_veterinario` INT NOT NULL,
  `fk_consulta` INT NOT NULL,
  PRIMARY KEY (`fk_veterinario`, `fk_consulta`),
  INDEX `veterinario_consulta_fk1` (`fk_consulta` ASC),
  CONSTRAINT `veterinario_consulta_fk0`
    FOREIGN KEY (`fk_veterinario`)
    REFERENCES `ClinicaVeterinariaDB`.`veterinario` (`id`),
  CONSTRAINT `veterinario_consulta_fk1`
    FOREIGN KEY (`fk_consulta`)
    REFERENCES `ClinicaVeterinariaDB`.`consulta` (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ClinicaVeterinariaDB`.`atendente`
-- -----------------------------------------------------
START TRANSACTION;
USE `ClinicaVeterinariaDB`;
INSERT INTO `ClinicaVeterinariaDB`.`atendente` (`id`, `usuario`, `senha`, `nome`, `cpf`, `telefone`, `tipo_telefone`) VALUES (1, 'admin', 'admin', 'Admin', '0', '0', NULL);

COMMIT;

