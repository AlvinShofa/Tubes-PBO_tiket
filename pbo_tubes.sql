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
CREATE SCHEMA IF NOT EXISTS `tubes` DEFAULT CHARACTER SET utf8 ;
USE `tubes` ;

-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tubes`.`customer` (
  `emailcust` VARCHAR(50) NOT NULL,
  `namacust` VARCHAR(45) NOT NULL,
  `pwd_cust` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`emailcust`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`wahana`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tubes`.`wahana` (
  `nama_wahana` VARCHAR(50) NOT NULL,
  `harga` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nama_wahana`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tubes`.`pesanan` (
  `id_pesanan` INT NOT NULL AUTO_INCREMENT,
  `customer_emailcust` VARCHAR(50) NOT NULL,
  `wahana_nama_wahana` VARCHAR(50) NOT NULL,
   `jenis_tiket` VARCHAR(45) NOT NULL,
  `diskon` FLOAT NULL,
  `total` FLOAT NOT NULL,
  `tanggal_pemesanan` DATE NOT NULL,
  PRIMARY KEY (`id_pesanan`),
  CONSTRAINT `fk_order_customer`
    FOREIGN KEY (`customer_emailcust`)
    REFERENCES `tubes`.`customer` (`emailcust`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_wahana1`
    FOREIGN KEY (`wahana_nama_wahana`)
    REFERENCES `tubes`.`wahana` (`nama_wahana`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`arsip`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tubes`.`arsip` (
  `id_arsip` INT NOT NULL AUTO_INCREMENT,
  `id_pesanan` VARCHAR(45) NOT NULL,
  `email_cust` VARCHAR(45) NOT NULL,
  `wahana` VARCHAR(45) NOT NULL,
  `jenis_tiket` VARCHAR(45) NOT NULL,
  `diskon` FLOAT NOT NULL,
  `total_harga` FLOAT NOT NULL,
  `tanggal_pemesanan` DATE NOT NULL,
  `status_tiket` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_arsip`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tubes`.`admin` (
  `email_admin` VARCHAR(45) NOT NULL,
  `nama_adm` VARCHAR(45) NOT NULL,
  `pwd_admin` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`email_admin`))
ENGINE = InnoDB;

INSERT INTO `wahana` (`nama_wahana`, `harga`) VALUES 
('Roller Coaster', '15000'), ('Bianglala', '15000'), ('Kora-kora', '10000'), 
('Komidi Putar', '10000'), ('Rumah Hantu', '20000'), ('Circus', '20000'), ('Mini Trampolin', '15000'), ('Semua Wahana', '105000');

INSERT INTO `admin` (`email_admin`, `nama_adm`, `pwd_admin`) VALUES 
('azrielsbqliverpool', 'azriel', 'alonica'), ('aasfth', 'alvin', '445fth'), ('alyadvr', 'alya', 'dvralya'), ('keziahelch', 'keziah', 'elchkeziah'), ('salsaltfh', 'salsa', 'lfthsalsa');

CREATE TRIGGER `insert_arsip` AFTER INSERT ON `pesanan` FOR EACH ROW INSERT INTO arsip VALUES 
(NULL, NEW.id_pesanan, NEW.customer_emailcust, NEW.wahana_nama_wahana, NEW.jenis_tiket, 
NEW.diskon, NEW.total, NEW.tanggal_pemesanan, "Belum Digunakan");

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
