-- MySQL Script generated by MySQL Workbench
-- Mon Sep 24 11:33:51 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema TicketUnla
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TicketUnla
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TicketUnla` DEFAULT CHARACTER SET utf8 ;
USE `TicketUnla` ;

-- -----------------------------------------------------
-- Table `TicketUnla`.`TipoAuditorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`TipoAuditorio` (
  `idTipoAuditorio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoAuditorio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`Auditorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`Auditorio` (
  `idAuditorio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipoAuditorio` INT NOT NULL,
  PRIMARY KEY (`idAuditorio`),
  INDEX `tipoAuditorio_idx` (`tipoAuditorio` ASC) VISIBLE,
  CONSTRAINT `tipoAuditorio`
    FOREIGN KEY (`tipoAuditorio`)
    REFERENCES `TicketUnla`.`TipoAuditorio` (`idTipoAuditorio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`Seccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`Seccion` (
  `idSeccion` INT NOT NULL AUTO_INCREMENT,
  `nombreSeccion` VARCHAR(45) NOT NULL,
  `precioSeccion` DOUBLE NOT NULL,
  `auditorio` INT NOT NULL,
  PRIMARY KEY (`idSeccion`),
  INDEX `fk_Seccion_Auditorio1_idx` (`auditorio` ASC) VISIBLE,
  CONSTRAINT `fk_Seccion_Auditorio1`
    FOREIGN KEY (`auditorio`)
    REFERENCES `TicketUnla`.`Auditorio` (`idAuditorio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`TipoUsuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`TipoUsuario` (
  `idTipoUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombreTipo` VARCHAR(45) NOT NULL,
  `auditorioUsuario` INT NULL,
  PRIMARY KEY (`idTipoUsuario`),
  INDEX `auditorio_idx` (`auditorioUsuario` ASC) VISIBLE,
  CONSTRAINT `auditorio`
    FOREIGN KEY (`auditorioUsuario`)
    REFERENCES `TicketUnla`.`Auditorio` (`idAuditorio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`TipoBeneficio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`TipoBeneficio` (
  `idTipoBeneficio` INT NOT NULL AUTO_INCREMENT,
  `beneficio` VARCHAR(45) NOT NULL,
  `descuento` DOUBLE NOT NULL,
  PRIMARY KEY (`idTipoBeneficio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `tipoUsuario` INT NOT NULL,
  `tipoBeneficio` INT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `tipoUsuario_idx` (`tipoUsuario` ASC) VISIBLE,
  INDEX `tipoBeneficio_idx` (`tipoBeneficio` ASC) VISIBLE,
  CONSTRAINT `tipoUsuario`
    FOREIGN KEY (`tipoUsuario`)
    REFERENCES `TicketUnla`.`TipoUsuario` (`idTipoUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tipoBeneficio`
    FOREIGN KEY (`tipoBeneficio`)
    REFERENCES `TicketUnla`.`TipoBeneficio` (`idTipoBeneficio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`Evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`Evento` (
  `idEvento` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `auditorioEvento` INT NOT NULL,
  PRIMARY KEY (`idEvento`),
  INDEX `auditorioEvento_idx` (`auditorioEvento` ASC) VISIBLE,
  CONSTRAINT `auditorioEvento`
    FOREIGN KEY (`auditorioEvento`)
    REFERENCES `TicketUnla`.`Auditorio` (`idAuditorio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`DiaDescuento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`DiaDescuento` (
  `idDiaDescuento` INT NOT NULL AUTO_INCREMENT,
  `dia` VARCHAR(45) NOT NULL,
  `descuento` DOUBLE NOT NULL,
  PRIMARY KEY (`idDiaDescuento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`Funcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`Funcion` (
  `idFuncion` INT NOT NULL AUTO_INCREMENT,
  `precioBase` DOUBLE NOT NULL,
  `diaHora` DATE NOT NULL,
  `evento` INT NOT NULL,
  `diaDescuento` INT NULL,
  PRIMARY KEY (`idFuncion`),
  INDEX `evento_idx` (`evento` ASC) VISIBLE,
  INDEX `fk_Funcion_DiasDescuento1_idx` (`diaDescuento` ASC) VISIBLE,
  CONSTRAINT `evento`
    FOREIGN KEY (`evento`)
    REFERENCES `TicketUnla`.`Evento` (`idEvento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcion_DiasDescuento1`
    FOREIGN KEY (`diaDescuento`)
    REFERENCES `TicketUnla`.`DiaDescuento` (`idDiaDescuento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`Butaca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`Butaca` (
  `idButaca` INT NOT NULL AUTO_INCREMENT,
  `columna` INT NOT NULL,
  `fila` INT NOT NULL,
  `seccion` INT NOT NULL,
  PRIMARY KEY (`idButaca`),
  INDEX `fk_Butaca_Seccion1_idx` (`seccion` ASC) VISIBLE,
  CONSTRAINT `fk_Butaca_Seccion1`
    FOREIGN KEY (`seccion`)
    REFERENCES `TicketUnla`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`Entrada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`Entrada` (
  `idEntrada` INT NOT NULL AUTO_INCREMENT,
  `seccion` INT NOT NULL,
  `butaca` INT NOT NULL,
  `usuario` INT NOT NULL,
  `funcion` INT NOT NULL,
  `precioFinal` DOUBLE NOT NULL,
  PRIMARY KEY (`idEntrada`),
  INDEX `seccion_idx` (`seccion` ASC) VISIBLE,
  INDEX `usuario_idx` (`usuario` ASC) VISIBLE,
  INDEX `funcion_idx` (`funcion` ASC) VISIBLE,
  INDEX `butaca_idx` (`butaca` ASC) VISIBLE,
  CONSTRAINT `seccion`
    FOREIGN KEY (`seccion`)
    REFERENCES `TicketUnla`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `usuario`
    FOREIGN KEY (`usuario`)
    REFERENCES `TicketUnla`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `funcion`
    FOREIGN KEY (`funcion`)
    REFERENCES `TicketUnla`.`Funcion` (`idFuncion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `butaca`
    FOREIGN KEY (`butaca`)
    REFERENCES `TicketUnla`.`Butaca` (`idButaca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TicketUnla`.`CodigoDescuento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TicketUnla`.`CodigoDescuento` (
  `idCodigoDescuento` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `descuento` DOUBLE NOT NULL,
  `seccionCod` INT NOT NULL,
  `funcionCod` INT NOT NULL,
  PRIMARY KEY (`idCodigoDescuento`),
  INDEX `seccionCod_idx` (`seccionCod` ASC) VISIBLE,
  INDEX `funcionCod_idx` (`funcionCod` ASC) VISIBLE,
  CONSTRAINT `seccionCod`
    FOREIGN KEY (`seccionCod`)
    REFERENCES `TicketUnla`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `funcionCod`
    FOREIGN KEY (`funcionCod`)
    REFERENCES `TicketUnla`.`Funcion` (`idFuncion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
