-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema game_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema game_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `game_db` DEFAULT CHARACTER SET utf8 ;
USE `game_db` ;

-- -----------------------------------------------------
-- Table `game_db`.`TheGioi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`TheGioi` (
  `idTheGioi` VARCHAR(8) NOT NULL,
  `nam` INT NOT NULL,
  `lanChoiCuoi` DATETIME NULL,
  PRIMARY KEY (`idTheGioi`),
  UNIQUE INDEX `idTheGioi_UNIQUE` (`idTheGioi` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`NhanVat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`NhanVat` (
  `idNhanVat` VARCHAR(8) NOT NULL,
  `idTheGioi` VARCHAR(8) NOT NULL,
  `tenNhanVat` NVARCHAR(45) NOT NULL,
  `viTri` VARCHAR(45) NOT NULL,
  `nguoiChoi` TINYINT NULL,
  PRIMARY KEY (`idNhanVat`, `idTheGioi`),
  UNIQUE INDEX `idNhanVat_UNIQUE` (`idNhanVat` ASC) VISIBLE,
  INDEX `NhanVat_TheGioi_idx` (`idTheGioi` ASC) VISIBLE,
  CONSTRAINT `NhanVat_TheGioi`
    FOREIGN KEY (`idTheGioi`)
    REFERENCES `game_db`.`TheGioi` (`idTheGioi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`BoiCanh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`BoiCanh` (
  `idBoiCanh` VARCHAR(8) NOT NULL,
  `idTheGioi` VARCHAR(8) NOT NULL,
  `tenBoiCanh` NVARCHAR(200) NOT NULL,
  `loaiBoiCanh` NVARCHAR(100) NOT NULL,
  `hoanhDo` DOUBLE NOT NULL,
  `tungDo` DOUBLE NOT NULL,
  PRIMARY KEY (`idBoiCanh`, `idTheGioi`),
  UNIQUE INDEX `idBoiCanh_UNIQUE` (`idBoiCanh` ASC) VISIBLE,
  INDEX `idTheGioi_idx` (`idTheGioi` ASC) VISIBLE,
  CONSTRAINT `BoiCanh_TheGioi`
    FOREIGN KEY (`idTheGioi`)
    REFERENCES `game_db`.`TheGioi` (`idTheGioi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`MoTa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`MoTa` (
  `idMoTa` VARCHAR(10) NOT NULL,
  `noiDung` MEDIUMTEXT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_vietnamese_ci' NOT NULL,
  `tomTat` TEXT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_vietnamese_ci' NULL,
  PRIMARY KEY (`idMoTa`),
  UNIQUE INDEX `idMoTa_UNIQUE` (`idMoTa` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`MauSuKien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`MauSuKien` (
  `idMauSuKien` VARCHAR(8) NOT NULL,
  `idMoTa` VARCHAR(10) NOT NULL,
  `tenMauSuKien` NVARCHAR(200) not null,
  `loaiSuKien` NVARCHAR(100)  NOT NULL,
  `thoiHan` INT NULL,
  `loaiDoiTuongTG` NVARCHAR(100) NULL,
  `soLuongTG` INT NULL,
  `tyLeXuatHien` DOUBLE NOT NULL,
  PRIMARY KEY (`idMauSuKien`, `idMoTa`),
  UNIQUE INDEX `idMauSuKien_UNIQUE` (`idMauSuKien` ASC) VISIBLE,
  INDEX `MSK_MoTa_idx` (`idMoTa` ASC) VISIBLE,
  CONSTRAINT `MSK_MoTa`
    FOREIGN KEY (`idMoTa`)
    REFERENCES `game_db`.`MoTa` (`idMoTa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`SuKien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`SuKien` (
  `idSuKien` VARCHAR(8) NOT NULL,
  `idTheGioi` VARCHAR(8) NOT NULL,
  `thoiDiem` INT NULL,
  `idMauSuKien` VARCHAR(8),
  `idBoiCanh` VARCHAR(8) NOT NULL,
  `moTa` MEDIUMTEXT NULL,
  `tomTat` TEXT NULL,
  `isComplete` TINYINT NOT NULL,
  PRIMARY KEY (`idSuKien`, `idTheGioi`, `idMauSuKien`, `idBoiCanh`),
  UNIQUE INDEX `idSuKien_UNIQUE` (`idSuKien` ASC) VISIBLE,
  INDEX `SuKien_TheGioi_idx` (`idTheGioi` ASC) VISIBLE,
  INDEX `SuKien_MSK_idx` (`idMauSuKien` ASC) VISIBLE,
  INDEX `SuKien_BoiCanh_idx` (`idBoiCanh` ASC) VISIBLE,
  CONSTRAINT `SuKien_TheGioi`
    FOREIGN KEY (`idTheGioi`)
    REFERENCES `game_db`.`TheGioi` (`idTheGioi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SuKien_MSK`
    FOREIGN KEY (`idMauSuKien`)
    REFERENCES `game_db`.`MauSuKien` (`idMauSuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SuKien_BoiCanh`
    FOREIGN KEY (`idBoiCanh`)
    REFERENCES `game_db`.`BoiCanh` (`idBoiCanh`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`DieuKien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`DieuKien` (
  `idDieuKien` VARCHAR(10) NOT NULL,
  `loaiDieuKien` VARCHAR(100) NOT NULL,
  `idMoTa` VARCHAR(10) NOT NULL,
  `slDungTT` INT NULL,
  PRIMARY KEY (`idDieuKien`, `idMoTa`),
  UNIQUE INDEX `idDieuKien_UNIQUE` (`idDieuKien` ASC) VISIBLE,
  INDEX `DieuKien_MoTa_idx` (`idMoTa` ASC) VISIBLE,
  CONSTRAINT `DieuKien_MoTa`
    FOREIGN KEY (`idMoTa`)
    REFERENCES `game_db`.`MoTa` (`idMoTa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`HieuUng`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`HieuUng` (
  `idHieuUng` VARCHAR(10) NOT NULL,
  `loaiSuKien` VARCHAR(100) NOT NULL,
  `idMoTa` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idHieuUng`, `idMoTa`),
  INDEX `HieuUng_MoTa_idx` (`idMoTa` ASC) VISIBLE,
  CONSTRAINT `HieuUng_MoTa`
    FOREIGN KEY (`idMoTa`)
    REFERENCES `game_db`.`MoTa` (`idMoTa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`VatPham`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`VatPham` (
  `idVatPham` VARCHAR(8) NOT NULL,
  `tenVatPham` NVARCHAR(200) NOT NULL,
  `loaiVatPham` VARCHAR(100) NOT NULL,
  `doBen` INT NULL,
  `idMoTa` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idVatPham`, `idMoTa`),
  UNIQUE INDEX `idVatPham_UNIQUE` (`idVatPham` ASC) VISIBLE,
  INDEX `VatPham_MoTa_idx` (`idMoTa` ASC) VISIBLE,
  CONSTRAINT `VatPham_MoTa`
    FOREIGN KEY (`idMoTa`)
    REFERENCES `game_db`.`MoTa` (`idMoTa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`BoiCanh_TaiNguyen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`BoiCanh_TaiNguyen` (
  `idBoiCanh` VARCHAR(8) NOT NULL,
  `idVatPham` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idBoiCanh`, `idVatPham`),
  INDEX `BoiCanh_VatPham_idx` (`idVatPham` ASC) VISIBLE,
  CONSTRAINT `BC_TN_VatPham`
    FOREIGN KEY (`idVatPham`)
    REFERENCES `game_db`.`VatPham` (`idVatPham`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `BC_TN_BoiCanh`
    FOREIGN KEY (`idBoiCanh`)
    REFERENCES `game_db`.`BoiCanh` (`idBoiCanh`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`BoiCanh_BoiCanh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`BoiCanh_BoiCanh` (
  `idBoiCanh1` VARCHAR(8) NOT NULL,
  `idBoiCanh2` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idBoiCanh1`, `idBoiCanh2`),
  CONSTRAINT `BC_BC_BoiCanh`
    FOREIGN KEY (`idBoiCanh1` , `idBoiCanh2`)
    REFERENCES `game_db`.`BoiCanh` (`idBoiCanh` , `idBoiCanh`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`NhanVat_VatPham`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`NhanVat_VatPham` (
  `idNhanVat` VARCHAR(8) NOT NULL,
  `idVatPham` VARCHAR(8) NOT NULL,
  `soLuong` INT NULL,
  PRIMARY KEY (`idNhanVat`, `idVatPham`),
  INDEX `NV_VP_VatPham_idx` (`idVatPham` ASC) VISIBLE,
  CONSTRAINT `NV_VP_NhanVat`
    FOREIGN KEY (`idNhanVat`)
    REFERENCES `game_db`.`NhanVat` (`idNhanVat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NV_VP_VatPham`
    FOREIGN KEY (`idVatPham`)
    REFERENCES `game_db`.`VatPham` (`idVatPham`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`MoiQuanHe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`MoiQuanHe` (
  `idNhanVat1` VARCHAR(8) NOT NULL,
  `idNhanVat2` VARCHAR(8) NOT NULL,
  `quanHe` NVARCHAR(100) NOT NULL,
  `thanThiet` INT NOT NULL,
  `tinTuong` INT NOT NULL,
  PRIMARY KEY (`idNhanVat1`, `idNhanVat2`),
  CONSTRAINT `MQH_NhanVat`
    FOREIGN KEY (`idNhanVat1` , `idNhanVat2`)
    REFERENCES `game_db`.`NhanVat` (`idNhanVat` , `idNhanVat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`ThuocTinh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`ThuocTinh` (
  `idThuocTinh` VARCHAR(8) NOT NULL,
  `tenThuocTinh` NVARCHAR(100)  NOT NULL,
  `idMoTa` VARCHAR(10) NOT NULL,
  `loaiThuocTinh` VARCHAR(100) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_vietnamese_ci' NOT NULL,
  `hienThi` TINYINT NULL,
  PRIMARY KEY (`idThuocTinh`, `idMoTa`),
  UNIQUE INDEX `idThuocTinh_UNIQUE` (`idThuocTinh` ASC) VISIBLE,
  INDEX `ThuocTinh_MoTa_idx` (`idMoTa` ASC) VISIBLE,
  CONSTRAINT `ThuocTinh_MoTa`
    FOREIGN KEY (`idMoTa`)
    REFERENCES `game_db`.`MoTa` (`idMoTa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`NhanVat_ThuocTinh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`NhanVat_ThuocTinh` (
  `idNhanVat` VARCHAR(8) NOT NULL,
  `idThuocTinh` VARCHAR(8) NOT NULL,
  `giaTri` INT NOT NULL,
  `tiemNang` INT NOT NULL,
  `tgHieuLuc` TIME NULL,
  PRIMARY KEY (`idNhanVat`, `idThuocTinh`),
  INDEX `NV_TT_ThuocTinh_idx` (`idThuocTinh` ASC) VISIBLE,
  CONSTRAINT `NV_TT_NhanVat`
    FOREIGN KEY (`idNhanVat`)
    REFERENCES `game_db`.`NhanVat` (`idNhanVat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NV_TT_ThuocTinh`
    FOREIGN KEY (`idThuocTinh`)
    REFERENCES `game_db`.`ThuocTinh` (`idThuocTinh`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`DauAn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`DauAn` (
  `idNhanVat` VARCHAR(8) NOT NULL,
  `idSuKien` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idNhanVat`, `idSuKien`),
  INDEX `DauAn_SuKien_idx` (`idSuKien` ASC) VISIBLE,
  CONSTRAINT `DauAn_NhanVat`
    FOREIGN KEY (`idNhanVat`)
    REFERENCES `game_db`.`NhanVat` (`idNhanVat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DauAn_SuKien`
    FOREIGN KEY (`idSuKien`)
    REFERENCES `game_db`.`SuKien` (`idSuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`ThuongMai`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`ThuongMai` (
  `idBoiCanh` VARCHAR(8) NOT NULL,
  `idVatPham` VARCHAR(8) NOT NULL,
  `giaCa` MEDIUMINT NULL,
  PRIMARY KEY (`idBoiCanh`, `idVatPham`),
  INDEX `ThuongMai_VatPham_idx` (`idVatPham` ASC) VISIBLE,
  CONSTRAINT `ThuongMai_BoiCanh`
    FOREIGN KEY (`idBoiCanh`)
    REFERENCES `game_db`.`ThuongMai` (`idBoiCanh`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ThuongMai_VatPham`
    FOREIGN KEY (`idVatPham`)
    REFERENCES `game_db`.`VatPham` (`idVatPham`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`SuKien_NhanVat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`SuKien_NhanVat` (
  `idSuKien` VARCHAR(8) NOT NULL,
  `idNhanVat` VARCHAR(8) NOT NULL,
  `thuTu` VARCHAR(8) NULL,
  PRIMARY KEY (`idSuKien`, `idNhanVat`),
  INDEX `SK_NV_NhanVat_idx` (`idNhanVat` ASC) VISIBLE,
  CONSTRAINT `SK_NV_SuKien`
    FOREIGN KEY (`idSuKien`)
    REFERENCES `game_db`.`SuKien` (`idSuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SK_NV_NhanVat`
    FOREIGN KEY (`idNhanVat`)
    REFERENCES `game_db`.`NhanVat` (`idNhanVat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`NgheNghiep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`NgheNghiep` (
  `idNgheNghiep` VARCHAR(8) NOT NULL,
  `tenNgheNghiep` NVARCHAR(200)  NOT NULL,
  `idMoTa` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idNgheNghiep`, `idMoTa`),
  UNIQUE INDEX `idNgheNghiep_UNIQUE` (`idNgheNghiep` ASC) VISIBLE,
  INDEX `NgheNghiep_MoTa_idx` (`idMoTa` ASC) VISIBLE,
  CONSTRAINT `NgheNghiep_MoTa`
    FOREIGN KEY (`idMoTa`)
    REFERENCES `game_db`.`MoTa` (`idMoTa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`ChucVu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`ChucVu` (
  `idChucVu` VARCHAR(8) NOT NULL,
  `tenChucVu` NVARCHAR(200)  NOT NULL,
  `idNgheNghiep` VARCHAR(8) NOT NULL,
  `idMoTa` VARCHAR(10) NOT NULL,
  `capBac` INT NULL,
  `luongCoBan` MEDIUMINT NULL,
  PRIMARY KEY (`idChucVu`, `idNgheNghiep`, `idMoTa`),
  UNIQUE INDEX `idMauSuKien_UNIQUE` (`idChucVu` ASC) VISIBLE,
  INDEX `ChucVu_NgheNghiep_idx` (`idNgheNghiep` ASC) VISIBLE,
  INDEX `ChucVu_MoTa_idx` (`idMoTa` ASC) VISIBLE,
  CONSTRAINT `ChucVu_NgheNghiep`
    FOREIGN KEY (`idNgheNghiep`)
    REFERENCES `game_db`.`NgheNghiep` (`idNgheNghiep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ChucVu_MoTa`
    FOREIGN KEY (`idMoTa`)
    REFERENCES `game_db`.`MoTa` (`idMoTa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`NV_NN_CV`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`NV_NN_CV` (
  `idNhanVat` VARCHAR(8) NOT NULL,
  `idNgheNghiep` VARCHAR(8) NOT NULL,
  `idChucVu` VARCHAR(8) NOT NULL,
  `thongThao` INT NOT NULL,
  `heSoLuong` DOUBLE NOT NULL,
  PRIMARY KEY (`idNhanVat`, `idNgheNghiep`, `idChucVu`),
  INDEX `NV_NN_CV_NgheNghiep_idx` (`idNgheNghiep` ASC) VISIBLE,
  INDEX `NV_NN_CV_ChucVu_idx` (`idChucVu` ASC) VISIBLE,
  CONSTRAINT `NV_NN_CV_NhanVat`
    FOREIGN KEY (`idNhanVat`)
    REFERENCES `game_db`.`NhanVat` (`idNhanVat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NV_NN_CV_NgheNghiep`
    FOREIGN KEY (`idNgheNghiep`)
    REFERENCES `game_db`.`NgheNghiep` (`idNgheNghiep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NV_NN_CV_ChucVu`
    FOREIGN KEY (`idChucVu`)
    REFERENCES `game_db`.`ChucVu` (`idChucVu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`KyNang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`KyNang` (
  `idKyNang` VARCHAR(8) NOT NULL,
  `tenKyNang` VARCHAR(200) NOT NULL,
  `idMoTa` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idKyNang`, `idMoTa`),
  UNIQUE INDEX `idKyNang_UNIQUE` (`idKyNang` ASC) VISIBLE,
  INDEX `KyNang_MoTa_idx` (`idMoTa` ASC) VISIBLE,
  CONSTRAINT `KyNang_MoTa`
    FOREIGN KEY (`idMoTa`)
    REFERENCES `game_db`.`MoTa` (`idMoTa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`NhanVat_KyNang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`NhanVat_KyNang` (
  `idNhanVat` VARCHAR(8) NOT NULL,
  `idKyNang` VARCHAR(8) NOT NULL,
  `kinhNghiem` INT NOT NULL,
  `capDo` INT NOT NULL,
  PRIMARY KEY (`idNhanVat`, `idKyNang`),
  INDEX `NV_KN_KyNang_idx` (`idKyNang` ASC) VISIBLE,
  CONSTRAINT `NV_KN_NhanVat`
    FOREIGN KEY (`idNhanVat`)
    REFERENCES `game_db`.`NhanVat` (`idNhanVat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NV_KN_KyNang`
    FOREIGN KEY (`idKyNang`)
    REFERENCES `game_db`.`KyNang` (`idKyNang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`HieuUng_VatPham`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`HieuUng_VatPham` (
  `idHieuUng` VARCHAR(10) NOT NULL,
  `idVatPham` VARCHAR(8) NOT NULL,
  `loaiVatPham` VARCHAR(200) NOT NULL,
  `soLuong` INT NOT NULL,
  `suDung` INT NOT NULL,
  PRIMARY KEY (`idHieuUng`, `idVatPham`),
  INDEX `HU_VP_VatPham_idx` (`idVatPham` ASC) VISIBLE,
  CONSTRAINT `HU_VP_HieuUng`
    FOREIGN KEY (`idHieuUng`)
    REFERENCES `game_db`.`HieuUng` (`idHieuUng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `HU_VP_VatPham`
    FOREIGN KEY (`idVatPham`)
    REFERENCES `game_db`.`VatPham` (`idVatPham`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`HieuUng_NgheNghiep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`HieuUng_NgheNghiep` (
  `idHieuUng` VARCHAR(10) NOT NULL,
  `idNgheNghiep` VARCHAR(8) NOT NULL,
  `thongThao` INT NOT NULL,
  `idChucVu` VARCHAR(8) NOT NULL,
  `heSoLuong` DOUBLE NULL,
  PRIMARY KEY (`idHieuUng`, `idNgheNghiep`, `idChucVu`),
  INDEX `HU_NN_NgheNghiep_idx` (`idNgheNghiep` ASC) VISIBLE,
  INDEX `HU_NN_ChucVu_idx` (`idChucVu` ASC) VISIBLE,
  CONSTRAINT `HU_NN_HieuUng`
    FOREIGN KEY (`idHieuUng`)
    REFERENCES `game_db`.`HieuUng` (`idHieuUng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `HU_NN_NgheNghiep`
    FOREIGN KEY (`idNgheNghiep`)
    REFERENCES `game_db`.`NgheNghiep` (`idNgheNghiep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `HU_NN_ChucVu`
    FOREIGN KEY (`idChucVu`)
    REFERENCES `game_db`.`ChucVu` (`idChucVu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`MauLuaChon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`MauLuaChon` (
  `idMauLuaChon` VARCHAR(8) NOT NULL,
  `idMoTa` VARCHAR(10) NOT NULL,
  `loaiDoiTuongTG` VARCHAR(100) NULL,
  PRIMARY KEY (`idMauLuaChon`, `idMoTa`),
  INDEX `MLC_MoTa_idx` (`idMoTa` ASC) VISIBLE,
  CONSTRAINT `MLC_MoTa`
    FOREIGN KEY (`idMoTa`)
    REFERENCES `game_db`.`MoTa` (`idMoTa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`MLC_MSK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`MLC_MSK` (
  `idMauLuaChon` VARCHAR(8) NOT NULL,
  `idMauSuKien` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idMauLuaChon`, `idMauSuKien`),
  INDEX `MLC_MSK_SuKien_idx` (`idMauSuKien` ASC) VISIBLE,
  CONSTRAINT `MLC_MSK_MLC`
    FOREIGN KEY (`idMauLuaChon`)
    REFERENCES `game_db`.`MauLuaChon` (`idMauLuaChon`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MLC_MSK_MSK`
    FOREIGN KEY (`idMauSuKien`)
    REFERENCES `game_db`.`MauSuKien` (`idMauSuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`MSK_MLC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`MSK_MLC` (
  `idMauSuKien` VARCHAR(8) NOT NULL,
  `idMauLuaChon` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idMauSuKien`, `idMauLuaChon`),
  INDEX `MSK_MLC_MLC_idx` (`idMauLuaChon` ASC) VISIBLE,
  CONSTRAINT `MSK_MLC_MSK`
    FOREIGN KEY (`idMauSuKien`)
    REFERENCES `game_db`.`MauSuKien` (`idMauSuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MSK_MLC_MLC`
    FOREIGN KEY (`idMauLuaChon`)
    REFERENCES `game_db`.`MauLuaChon` (`idMauLuaChon`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`HieuUng_KyNang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`HieuUng_KyNang` (
  `idHieuUng` VARCHAR(10) NOT NULL,
  `idKyNang` VARCHAR(8) NOT NULL,
  `kinhNghiem` INT NOT NULL,
  PRIMARY KEY (`idHieuUng`, `idKyNang`),
  INDEX `HU_KN_KyNang_idx` (`idKyNang` ASC) VISIBLE,
  CONSTRAINT `HU_KN_HieuUng`
    FOREIGN KEY (`idHieuUng`)
    REFERENCES `game_db`.`HieuUng` (`idHieuUng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `HU_KN_KyNang`
    FOREIGN KEY (`idKyNang`)
    REFERENCES `game_db`.`KyNang` (`idKyNang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`HieuUng_ThuocTinh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`HieuUng_ThuocTinh` (
  `idHieuUng` VARCHAR(10) NOT NULL,
  `idThuocTinh` VARCHAR(8) NOT NULL,
  `giaTriTang` INT NULL,
  `tiLeTang` DOUBLE NULL,
  PRIMARY KEY (`idHieuUng`, `idThuocTinh`),
  INDEX `HU_TT_ThuocTinh_idx` (`idThuocTinh` ASC) VISIBLE,
  CONSTRAINT `HU_TT_HieuUng`
    FOREIGN KEY (`idHieuUng`)
    REFERENCES `game_db`.`HieuUng` (`idHieuUng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `HU_TT_ThuocTinh`
    FOREIGN KEY (`idThuocTinh`)
    REFERENCES `game_db`.`ThuocTinh` (`idThuocTinh`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`DieuKien_VatPham`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`DieuKien_VatPham` (
  `idDieuKien` VARCHAR(10) NOT NULL,
  `idVatPham` VARCHAR(8) NOT NULL,
  `isNot` TINYINT NOT NULL,
  `loaiVatPham` VARCHAR(100) NULL,
  `loaiDoiTuong` VARCHAR(100) NULL,
  `soLuong` INT NULL,
  PRIMARY KEY (`idDieuKien`, `idVatPham`),
  INDEX `DK_VP_VatPham_idx` (`idVatPham` ASC) VISIBLE,
  CONSTRAINT `DK_VP_DieuKien`
    FOREIGN KEY (`idDieuKien`)
    REFERENCES `game_db`.`DieuKien` (`idDieuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DK_VP_VatPham`
    FOREIGN KEY (`idVatPham`)
    REFERENCES `game_db`.`VatPham` (`idVatPham`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`DieuKien_NgheNghiep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`DieuKien_NgheNghiep` (
  `idDieuKien` VARCHAR(10) NOT NULL,
  `idNgheNghiep` VARCHAR(8) NOT NULL,
  `isNot` TINYINT NULL,
  `thongThao` INT NULL,
  `capBac` INT NULL,
  PRIMARY KEY (`idDieuKien`, `idNgheNghiep`),
  INDEX `DK_NN_NgheNghiep_idx` (`idNgheNghiep` ASC) VISIBLE,
  CONSTRAINT `DK_NN_DieuKien`
    FOREIGN KEY (`idDieuKien`)
    REFERENCES `game_db`.`DieuKien` (`idDieuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DK_NN_NgheNghiep`
    FOREIGN KEY (`idNgheNghiep`)
    REFERENCES `game_db`.`NgheNghiep` (`idNgheNghiep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`DieuKien_KyNang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`DieuKien_KyNang` (
  `idDieuKien` VARCHAR(10) NOT NULL,
  `idKyNang` VARCHAR(8) NOT NULL,
  `isNot` TINYINT NULL,
  `capDo` INT NULL,
  PRIMARY KEY (`idDieuKien`, `idKyNang`),
  INDEX `DK_KN_KyNang_idx` (`idKyNang` ASC) VISIBLE,
  CONSTRAINT `DK_KN_DieuKien`
    FOREIGN KEY (`idDieuKien`)
    REFERENCES `game_db`.`DieuKien` (`idDieuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DK_KN_KyNang`
    FOREIGN KEY (`idKyNang`)
    REFERENCES `game_db`.`KyNang` (`idKyNang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`DieuKien_ThuocTinh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`DieuKien_ThuocTinh` (
  `idDieuKien` VARCHAR(10) NOT NULL,
  `idThuocTinh` VARCHAR(8) NOT NULL,
  `isNot` TINYINT NULL,
  `loaiSoSanh` VARCHAR(100) NULL,
  `loaiDoiTuong` VARCHAR(100) NULL,
  `giaTriSS` INT NULL,
  PRIMARY KEY (`idDieuKien`, `idThuocTinh`),
  INDEX `DK_TT_ThuocTinh_idx` (`idThuocTinh` ASC) VISIBLE,
  CONSTRAINT `DK_TT_DieuKien`
    FOREIGN KEY (`idDieuKien`)
    REFERENCES `game_db`.`DieuKien` (`idDieuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DK_TT_ThuocTinh`
    FOREIGN KEY (`idThuocTinh`)
    REFERENCES `game_db`.`ThuocTinh` (`idThuocTinh`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`DieuKien_QuanHe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`DieuKien_QuanHe` (
  `idDieuKien` VARCHAR(10) NOT NULL,
  `loaiQuanHe` VARCHAR(8) NOT NULL,
  `isNot` TINYINT NULL,
  `thanThiet` INT NULL,
  `tinTuong` INT NULL,
  PRIMARY KEY (`idDieuKien`),
  UNIQUE INDEX `idDieuKien_UNIQUE` (`idDieuKien` ASC) VISIBLE,
  CONSTRAINT `DK_QH_DieuKien`
    FOREIGN KEY (`idDieuKien`)
    REFERENCES `game_db`.`DieuKien` (`idDieuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`LuaChon_DieuKien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`LuaChon_DieuKien` (
  `idMauLuaChon` VARCHAR(8) NOT NULL,
  `idDieuKien` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idMauLuaChon`, `idDieuKien`),
  INDEX `LC_DK_DieuKien_idx` (`idDieuKien` ASC) VISIBLE,
  CONSTRAINT `LC_DK_LuaChon`
    FOREIGN KEY (`idMauLuaChon`)
    REFERENCES `game_db`.`MauLuaChon` (`idMauLuaChon`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `LC_DK_DieuKien`
    FOREIGN KEY (`idDieuKien`)
    REFERENCES `game_db`.`DieuKien` (`idDieuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`SuKien_DieuKien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`SuKien_DieuKien` (
  `idSuKien` VARCHAR(8) NOT NULL,
  `idDieuKien` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idSuKien`, `idDieuKien`),
  INDEX `SK_DK_DieuKien_idx` (`idDieuKien` ASC) VISIBLE,
  CONSTRAINT `SK_DK_SuKien`
    FOREIGN KEY (`idSuKien`)
    REFERENCES `game_db`.`SuKien` (`idSuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SK_DK_DieuKien`
    FOREIGN KEY (`idDieuKien`)
    REFERENCES `game_db`.`DieuKien` (`idDieuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`SuKien_HieuUng`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`SuKien_HieuUng` (
  `idSuKien` VARCHAR(8) NOT NULL,
  `idHieuUng` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idSuKien`, `idHieuUng`),
  INDEX `SK_HU_HieuUng_idx` (`idHieuUng` ASC) VISIBLE,
  CONSTRAINT `SK_HU_SuKien`
    FOREIGN KEY (`idSuKien`)
    REFERENCES `game_db`.`SuKien` (`idSuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SK_HU_HieuUng`
    FOREIGN KEY (`idHieuUng`)
    REFERENCES `game_db`.`HieuUng` (`idHieuUng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`HieuUng_QuanHe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`HieuUng_QuanHe` (
  `idHieuUng` VARCHAR(10) NOT NULL,
  `quanHe` NVARCHAR(100) NOT NULL,
  `thanThiet` INT NULL,
  `tinTuong` INT NULL,
  PRIMARY KEY (`idHieuUng`),
  UNIQUE INDEX `idHieuUng_UNIQUE` (`idHieuUng` ASC) VISIBLE,
  CONSTRAINT `HU_QH_HieuUng`
    FOREIGN KEY (`idHieuUng`)
    REFERENCES `game_db`.`HieuUng` (`idHieuUng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`VatPham_HieuUng`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`VatPham_HieuUng` (
  `idVatPham` VARCHAR(8) NOT NULL,
  `idHieuUng` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idVatPham`, `idHieuUng`),
  INDEX `VP_HU_HieuUng_idx` (`idHieuUng` ASC) VISIBLE,
  CONSTRAINT `VP_HU_VatPham`
    FOREIGN KEY (`idVatPham`)
    REFERENCES `game_db`.`VatPham` (`idVatPham`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `VP_HU_HieuUng`
    FOREIGN KEY (`idHieuUng`)
    REFERENCES `game_db`.`HieuUng` (`idHieuUng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`DieuKien_HieuUng`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`DieuKien_HieuUng` (
  `idDieuKien` VARCHAR(10) NOT NULL,
  `idHieuUng` VARCHAR(10) NOT NULL,
  `isNot` TINYINT NULL,
  PRIMARY KEY (`idDieuKien`, `idHieuUng`),
  INDEX `DK_HU_HieuUng_idx` (`idHieuUng` ASC) VISIBLE,
  CONSTRAINT `DK_HU_DieuKien`
    FOREIGN KEY (`idDieuKien`)
    REFERENCES `game_db`.`DieuKien` (`idDieuKien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DK_HU_HieuUng`
    FOREIGN KEY (`idHieuUng`)
    REFERENCES `game_db`.`HieuUng` (`idHieuUng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_db`.`VatPham_ThuocTinh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game_db`.`VatPham_ThuocTinh` (
  `idVatPham` VARCHAR(8) NOT NULL,
  `idThuocTinh` VARCHAR(8) NULL,
  `giaTri` INT NULL,
  `tiemNang` INT NULL,
  `tgTacDung` INT NULL,
  PRIMARY KEY (`idVatPham`),
  INDEX `VP_TT_ThuocTinh_idx` (`idThuocTinh` ASC) VISIBLE,
  CONSTRAINT `VP_TT_VatPham`
    FOREIGN KEY (`idVatPham`)
    REFERENCES `game_db`.`VatPham` (`idVatPham`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `VP_TT_ThuocTinh`
    FOREIGN KEY (`idThuocTinh`)
    REFERENCES `game_db`.`ThuocTinh` (`idThuocTinh`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
