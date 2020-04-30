-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema bd-hibernate-uno-a-uno
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd-hibernate-uno-a-uno
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd-hibernate-uno-a-uno` DEFAULT CHARACTER SET latin1 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `precioUnitario` DOUBLE NOT NULL,
  `fechaAlta` DATE NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Stock` (
  `idStock` INT NOT NULL AUTO_INCREMENT,
  `Producto_idProducto` INT NOT NULL,
  PRIMARY KEY (`idStock`),
  INDEX `fk_Stock_Producto1_idx` (`Producto_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_Stock_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `mydb`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `mail` VARCHAR(45) NOT NULL,
  `idPersonaCliente` INT NOT NULL,
  INDEX `fk_Cliente_Persona1_idx` (`idPersonaCliente` ASC) VISIBLE,
  PRIMARY KEY (`idPersonaCliente`),
  CONSTRAINT `fk_Cliente_Persona1`
    FOREIGN KEY (`idPersonaCliente`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Locales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Locales` (
  `idLocales` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NOT NULL,
  `latitud` FLOAT NOT NULL,
  `longitud` FLOAT NOT NULL,
  `nroTelefono` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Stock_idStock` INT NOT NULL,
  `Cliente_idPersonaCliente` INT NOT NULL,
  PRIMARY KEY (`idLocales`),
  INDEX `fk_Locales_Stock1_idx` (`Stock_idStock` ASC) VISIBLE,
  INDEX `fk_Locales_Cliente1_idx` (`Cliente_idPersonaCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Locales_Stock1`
    FOREIGN KEY (`Stock_idStock`)
    REFERENCES `mydb`.`Stock` (`idStock`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locales_Cliente1`
    FOREIGN KEY (`Cliente_idPersonaCliente`)
    REFERENCES `mydb`.`Cliente` (`idPersonaCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` INT(11) NOT NULL,
  `fechaDeNacimiento` DATE NULL,
  `Locales_idLocales` INT NOT NULL,
  PRIMARY KEY (`idPersona`),
  INDEX `fk_Persona_Locales1_idx` (`Locales_idLocales` ASC) VISIBLE,
  CONSTRAINT `fk_Persona_Locales1`
    FOREIGN KEY (`Locales_idLocales`)
    REFERENCES `mydb`.`Locales` (`idLocales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empleado` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `horarioDeTrabajo` DATE NULL,
  `sueldoBasico` DOUBLE NOT NULL,
  `Empleadocol` VARCHAR(45) NULL,
  `idPersonaEmpleado` INT NOT NULL,
  `Locales_idLocales` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  INDEX `fk_Empleado_Persona1_idx` (`idPersonaEmpleado` ASC) VISIBLE,
  INDEX `fk_Empleado_Locales1_idx` (`Locales_idLocales` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_Persona1`
    FOREIGN KEY (`idPersonaEmpleado`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Locales1`
    FOREIGN KEY (`Locales_idLocales`)
    REFERENCES `mydb`.`Locales` (`idLocales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Lote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Lote` (
  `idLote` INT NOT NULL AUTO_INCREMENT,
  `cantidadInicial` INT NOT NULL,
  `cantidadActual` INT NOT NULL,
  `fechaIngreso` DATE NULL,
  `Locales_idLocales` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  PRIMARY KEY (`idLote`),
  INDEX `fk_Lote_Locales1_idx` (`Locales_idLocales` ASC) VISIBLE,
  INDEX `fk_Lote_Producto1_idx` (`Producto_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_Lote_Locales1`
    FOREIGN KEY (`Locales_idLocales`)
    REFERENCES `mydb`.`Locales` (`idLocales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lote_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `mydb`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `subTotal` FLOAT NULL,
  `aceptado` TINYINT NULL,
  `Locales_idLocales` INT NOT NULL,
  `Persona_idPersona` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Locales1_idx` (`Locales_idLocales` ASC) VISIBLE,
  INDEX `fk_Pedido_Persona1_idx` (`Persona_idPersona` ASC) VISIBLE,
  INDEX `fk_Pedido_Producto1_idx` (`Producto_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Locales1`
    FOREIGN KEY (`Locales_idLocales`)
    REFERENCES `mydb`.`Locales` (`idLocales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Persona1`
    FOREIGN KEY (`Persona_idPersona`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `mydb`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `total` FLOAT NULL,
  `Locales_idLocales` INT NOT NULL,
  `Empleado_idEmpleado` INT NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_Locales1_idx` (`Locales_idLocales` ASC) VISIBLE,
  INDEX `fk_Factura_Empleado1_idx` (`Empleado_idEmpleado` ASC) VISIBLE,
  CONSTRAINT `fk_Factura_Locales1`
    FOREIGN KEY (`Locales_idLocales`)
    REFERENCES `mydb`.`Locales` (`idLocales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `mydb`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`itemFactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`itemFactura` (
  `iditemFactura` INT NOT NULL AUTO_INCREMENT,
  `Factura_idFactura` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  PRIMARY KEY (`iditemFactura`),
  INDEX `fk_itemFactura_Factura1_idx` (`Factura_idFactura` ASC) VISIBLE,
  INDEX `fk_itemFactura_Producto1_idx` (`Producto_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_itemFactura_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `mydb`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemFactura_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `mydb`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `bd-hibernate-uno-a-uno` ;

-- -----------------------------------------------------
-- Table `bd-hibernate-uno-a-uno`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-uno-a-uno`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` INT(11) NOT NULL,
  `fechaDeNacimiento` DATE NULL DEFAULT NULL,
  `baja` BIT(1) NULL DEFAULT b'0',
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-uno-a-uno`.`contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-uno-a-uno`.`contacto` (
  `idContacto` INT(11) NOT NULL,
  `email` VARCHAR(25) NULL DEFAULT NULL,
  `movil` VARCHAR(20) NULL DEFAULT NULL,
  `fijo` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`idContacto`),
  CONSTRAINT `fk_cliente`
    FOREIGN KEY (`idContacto`)
    REFERENCES `bd-hibernate-uno-a-uno`.`cliente` (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;