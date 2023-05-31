CREATE DATABASE  IF NOT EXISTS `game_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `game_db`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: game_db
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `boicanh`
--

DROP TABLE IF EXISTS `boicanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boicanh` (
  `idBoiCanh` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idTheGioi` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tenBoiCanh` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `loaiBoiCanh` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `hoanhDo` double NOT NULL,
  `tungDo` double NOT NULL,
  PRIMARY KEY (`idBoiCanh`,`idTheGioi`),
  KEY `idTheGioi_idx` (`idTheGioi`),
  CONSTRAINT `BoiCanh_TheGioi` FOREIGN KEY (`idTheGioi`) REFERENCES `thegioi` (`idTheGioi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boicanh`
--

LOCK TABLES `boicanh` WRITE;
/*!40000 ALTER TABLE `boicanh` DISABLE KEYS */;
/*!40000 ALTER TABLE `boicanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boicanh_boicanh`
--

DROP TABLE IF EXISTS `boicanh_boicanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boicanh_boicanh` (
  `idBoiCanh1` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idBoiCanh2` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idBoiCanh2`,`idBoiCanh1`),
  KEY `BC_BC_BoiCanh2_idx` (`idBoiCanh2`),
  KEY `BC_BC_BoiCanh1_idx` (`idBoiCanh1`),
  CONSTRAINT `BC_BoiCanh1` FOREIGN KEY (`idBoiCanh1`) REFERENCES `boicanh` (`idBoiCanh`),
  CONSTRAINT `BC_BoiCanh2` FOREIGN KEY (`idBoiCanh2`) REFERENCES `boicanh` (`idBoiCanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boicanh_boicanh`
--

LOCK TABLES `boicanh_boicanh` WRITE;
/*!40000 ALTER TABLE `boicanh_boicanh` DISABLE KEYS */;
/*!40000 ALTER TABLE `boicanh_boicanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boicanh_tainguyen`
--

DROP TABLE IF EXISTS `boicanh_tainguyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boicanh_tainguyen` (
  `idBoiCanh` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idVatPham` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idBoiCanh`,`idVatPham`),
  KEY `BoiCanh_VatPham_idx` (`idVatPham`),
  CONSTRAINT `BC_TN_BoiCanh` FOREIGN KEY (`idBoiCanh`) REFERENCES `boicanh` (`idBoiCanh`),
  CONSTRAINT `BC_TN_VatPham` FOREIGN KEY (`idVatPham`) REFERENCES `vatpham` (`idVatPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boicanh_tainguyen`
--

LOCK TABLES `boicanh_tainguyen` WRITE;
/*!40000 ALTER TABLE `boicanh_tainguyen` DISABLE KEYS */;
/*!40000 ALTER TABLE `boicanh_tainguyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucvu` (
  `idChucVu` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tenChucVu` text CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idNgheNghiep` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `capBac` int DEFAULT NULL,
  `luongCoBan` mediumint DEFAULT NULL,
  PRIMARY KEY (`idChucVu`,`idNgheNghiep`,`idMoTa`),
  KEY `ChucVu_NgheNghiep_idx` (`idNgheNghiep`),
  KEY `ChucVu_MoTa_idx` (`idMoTa`),
  CONSTRAINT `ChucVu_MoTa` FOREIGN KEY (`idMoTa`) REFERENCES `mota` (`idMoTa`),
  CONSTRAINT `ChucVu_NgheNghiep` FOREIGN KEY (`idNgheNghiep`) REFERENCES `nghenghiep` (`idNgheNghiep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES ('CVJOB010','Nông dân','JOB00002','CVJOB01000',1,3000),('CVJOB011','Nông dân chuyên nghiệp','JOB00002','CVJOB01100',2,8000),('CVJOB012','Thợ săn','JOB00001','CVJOB01200',1,3000),('CVJOB013','Thợ săn chuyên nghiệp','JOB00001','CVJOB01300',2,8000),('CVJOB105','Kỵ sĩ tập sự','JOB10002','CVJOB10500',5,3000),('CVJOB106','Kỵ sĩ chính quy','JOB10002','CVJOB10600',1,8000),('CVJOB107','Kỵ sĩ trưởng','JOB10002','CVJOB10700',2,10000),('CVJOB108','Kị sĩ chỉ huy','JOB10002','CVJOB10800',3,15000),('CVJOB109','Thánh kỵ sĩ','JOB10002','CVJOB10900',4,20000),('CVJOB110','Kiếm sĩ','JOB10001','CVJOB11000',1,2000),('CVJOB111','Kiếm khách','JOB10001','CVJOB11100',2,6000),('CVJOB112','Kiếm sư bậc thầy','JOB10001','CVJOB11200',3,12000),('CVJOB113','Kiếm thánh','JOB10001','CVJOB11300',4,20000),('CVJOB114','Pháp sư tập sự','JOB10003','CVJOB11400',1,6000),('CVJOB115','Pháp sư sơ cấp','JOB10003','CVJOB11500',2,10000),('CVJOB116','Pháp sư cao cấp','JOB10003','CVJOB11600',3,15000),('CVJOB117','Hiền giả','JOB10003','CVJOB11700',4,20000),('CVJOB201','Thương nhân tập sự','JOB20001','CVJOB20100',1,2000),('CVJOB202','Thương nhân mới','JOB20001','CVJOB20200',2,4000),('CVJOB203','Thương nhân','JOB20001','CVJOB20300',3,7500),('CVJOB204','Chủ thương hội','JOB20001','CVJOB20400',4,12000),('CVJOB318','Giả kim sư tập sự','JOB30001','CVJOB31800',1,6000),('CVJOB319','Giả kim sư sơ cấp','JOB30001','CVJOB31900',2,8000),('CVJOB320','Giả kim sư cao cấp','JOB30001','CVJOB32000',3,12000),('CVJOB321','Dược sĩ tập sự','JOB30002','CVJOB32100',1,3000),('CVJOB322','Dược sư sơ cấp','JOB30002','CVJOB32200',2,8000),('CVJOB323','Dược sư cao cấp','JOB30002','CVJOB32300',3,12000),('CVJOB324','Trị liệu sư tập sự','JOB30003','CVJOB32400',1,3000),('CVJOB325','Trị liệu sư sơ cấp','JOB30003','CVJOB32500',2,5000),('CVJOB326','Trị liệu sư cao cấp','JOB30003','CVJOB32600',3,10000),('CVJOB327','Thánh thuật sư','JOB30003','CVJOB32700',4,20000);
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dauan`
--

DROP TABLE IF EXISTS `dauan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dauan` (
  `idNhanVat` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idSuKien` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idNhanVat`,`idSuKien`),
  KEY `DauAn_SuKien_idx` (`idSuKien`),
  CONSTRAINT `DauAn_NhanVat` FOREIGN KEY (`idNhanVat`) REFERENCES `nhanvat` (`idNhanVat`),
  CONSTRAINT `DauAn_SuKien` FOREIGN KEY (`idSuKien`) REFERENCES `sukien` (`idSuKien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dauan`
--

LOCK TABLES `dauan` WRITE;
/*!40000 ALTER TABLE `dauan` DISABLE KEYS */;
/*!40000 ALTER TABLE `dauan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieukien`
--

DROP TABLE IF EXISTS `dieukien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieukien` (
  `idDieuKien` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `loaiDieuKien` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `slDungTT` int DEFAULT NULL,
  PRIMARY KEY (`idDieuKien`,`idMoTa`),
  KEY `DieuKien_MoTa_idx` (`idMoTa`),
  CONSTRAINT `DieuKien_MoTa` FOREIGN KEY (`idMoTa`) REFERENCES `mota` (`idMoTa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieukien`
--

LOCK TABLES `dieukien` WRITE;
/*!40000 ALTER TABLE `dieukien` DISABLE KEYS */;
INSERT INTO `dieukien` VALUES ('DK1MLC0007','THUOCTINH','DK1MLC0007',NULL),('DK1MLC0008','THUOCTINH','DK1MLC0008',NULL),('DK1MLC0009','THUOCTINH','DK1MLC0009',NULL),('DK1MLC0010','THUOCTINH','DK1MLC0010',NULL),('DK1MLC0011','THUOCTINH','DK1MLC0011',NULL),('DK1MLC0012','THUOCTINH','DK1MLC0012',NULL),('DK1MLC0014','THUOCTINH','DK1MLC0014',NULL),('DK1MLC0015','THUOCTINH','DK1MLC0015',NULL),('DK1MLC0035','THUOCTINH','DK1MLC0035',NULL),('DK1SK00001','THUOCTINH','DK1SK00001',NULL),('DK1SK00002','THUOCTINH','DK1SK00002',NULL),('DK1SK00006','NGHENGHIEP','DK1SK00006',NULL),('DK1SK00007','CONTRAI','DK1SK00007',NULL),('DK1SK00008','DIADANH','DK1SK00008',NULL),('DK1SK10002','THUOCTINH','DK1SK10002',NULL),('DK1SK10003','THUOCTINH','DK1SK10003',NULL),('DK1SK10006','THUOCTINH','DK1SK10006',NULL),('DK1SK10007','BANBE','DK1SK10007',NULL),('DK1SK10008','CHONG','DK1SK10008',NULL),('DK1SK10009','NGHENGHIEP','DK1SK10009',NULL),('DK1SK20001','TINH','DK1SK20001',NULL),('DK1SK20003','THUOCTINH','DK1SK20003',NULL),('DK1SK20006','THUOCTINH','DK1SK20006',NULL),('DK1SK20007','THUOCTINH','DK1SK20007',NULL),('DK1SK20008','THUOCTINH','DK1SK20008',NULL),('DK1SK20009','THUOCTINH','DK1SK20009',NULL),('DK2MLC0009','THUOCTINH','DK2MLC0009',NULL),('DK2MLC0010','THUOCTINH','DK2MLC0010',NULL),('DK2MLC0011','THUOCTINH','DK2MLC0011',NULL),('DK2MLC0014','THUOCTINH','DK2MLC0014',NULL),('DK2MLC0015','THUOCTINH','DK2MLC0015',NULL),('DK2SK00007','CONGAI','DK2SK00007',NULL),('DK2SK00008','VO','DK2SK00008',NULL),('DK3MLC0009','THUOCTINH','DK3MLC0009',NULL),('DK3MLC0015','THUOCTINH','DK3MLC0015',NULL);
/*!40000 ALTER TABLE `dieukien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieukien_hieuung`
--

DROP TABLE IF EXISTS `dieukien_hieuung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieukien_hieuung` (
  `idDieuKien` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idHieuUng` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `isNot` tinyint DEFAULT NULL,
  PRIMARY KEY (`idDieuKien`,`idHieuUng`),
  KEY `DK_HU_HieuUng` (`idHieuUng`),
  CONSTRAINT `DK_HU_DieuKien` FOREIGN KEY (`idDieuKien`) REFERENCES `dieukien` (`idDieuKien`),
  CONSTRAINT `DK_HU_HieuUng` FOREIGN KEY (`idHieuUng`) REFERENCES `hieuung` (`idHieuUng`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieukien_hieuung`
--

LOCK TABLES `dieukien_hieuung` WRITE;
/*!40000 ALTER TABLE `dieukien_hieuung` DISABLE KEYS */;
/*!40000 ALTER TABLE `dieukien_hieuung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieukien_kynang`
--

DROP TABLE IF EXISTS `dieukien_kynang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieukien_kynang` (
  `idDieuKien` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idKyNang` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `isNot` tinyint DEFAULT NULL,
  `capDo` int DEFAULT NULL,
  PRIMARY KEY (`idDieuKien`,`idKyNang`),
  KEY `DK_KN_KyNang_idx` (`idKyNang`),
  CONSTRAINT `DK_KN_DieuKien` FOREIGN KEY (`idDieuKien`) REFERENCES `dieukien` (`idDieuKien`),
  CONSTRAINT `DK_KN_KyNang` FOREIGN KEY (`idKyNang`) REFERENCES `kynang` (`idKyNang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieukien_kynang`
--

LOCK TABLES `dieukien_kynang` WRITE;
/*!40000 ALTER TABLE `dieukien_kynang` DISABLE KEYS */;
/*!40000 ALTER TABLE `dieukien_kynang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieukien_nghenghiep`
--

DROP TABLE IF EXISTS `dieukien_nghenghiep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieukien_nghenghiep` (
  `idDieuKien` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idNgheNghiep` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `isNot` tinyint DEFAULT NULL,
  `thongThao` int DEFAULT NULL,
  `capBac` int DEFAULT NULL,
  PRIMARY KEY (`idDieuKien`,`idNgheNghiep`),
  KEY `DK_NN_NgheNghiep_idx` (`idNgheNghiep`),
  CONSTRAINT `DK_NN_DieuKien` FOREIGN KEY (`idDieuKien`) REFERENCES `dieukien` (`idDieuKien`),
  CONSTRAINT `DK_NN_NgheNghiep` FOREIGN KEY (`idNgheNghiep`) REFERENCES `nghenghiep` (`idNgheNghiep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieukien_nghenghiep`
--

LOCK TABLES `dieukien_nghenghiep` WRITE;
/*!40000 ALTER TABLE `dieukien_nghenghiep` DISABLE KEYS */;
/*!40000 ALTER TABLE `dieukien_nghenghiep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieukien_quanhe`
--

DROP TABLE IF EXISTS `dieukien_quanhe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieukien_quanhe` (
  `idDieuKien` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `loaiQuanHe` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `isNot` tinyint DEFAULT NULL,
  `thanThiet` int DEFAULT NULL,
  `tinTuong` int DEFAULT NULL,
  PRIMARY KEY (`idDieuKien`),
  CONSTRAINT `DK_QH_DieuKien` FOREIGN KEY (`idDieuKien`) REFERENCES `dieukien` (`idDieuKien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieukien_quanhe`
--

LOCK TABLES `dieukien_quanhe` WRITE;
/*!40000 ALTER TABLE `dieukien_quanhe` DISABLE KEYS */;
/*!40000 ALTER TABLE `dieukien_quanhe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieukien_thuoctinh`
--

DROP TABLE IF EXISTS `dieukien_thuoctinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieukien_thuoctinh` (
  `idDieuKien` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idThuocTinh` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `isNot` tinyint DEFAULT NULL,
  `loaiSoSanh` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `loaiDoiTuong` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `giaTriSS` int DEFAULT NULL,
  PRIMARY KEY (`idDieuKien`,`idThuocTinh`),
  KEY `DK_TT_ThuocTinh_idx` (`idThuocTinh`),
  CONSTRAINT `DK_TT_DieuKien` FOREIGN KEY (`idDieuKien`) REFERENCES `dieukien` (`idDieuKien`),
  CONSTRAINT `DK_TT_ThuocTinh` FOREIGN KEY (`idThuocTinh`) REFERENCES `thuoctinh` (`idThuocTinh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieukien_thuoctinh`
--

LOCK TABLES `dieukien_thuoctinh` WRITE;
/*!40000 ALTER TABLE `dieukien_thuoctinh` DISABLE KEYS */;
/*!40000 ALTER TABLE `dieukien_thuoctinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieukien_vatpham`
--

DROP TABLE IF EXISTS `dieukien_vatpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieukien_vatpham` (
  `idDieuKien` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idVatPham` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `isNot` tinyint NOT NULL,
  `loaiVatPham` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `loaiDoiTuong` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  PRIMARY KEY (`idDieuKien`,`idVatPham`),
  KEY `DK_VP_VatPham_idx` (`idVatPham`),
  CONSTRAINT `DK_VP_DieuKien` FOREIGN KEY (`idDieuKien`) REFERENCES `dieukien` (`idDieuKien`),
  CONSTRAINT `DK_VP_VatPham` FOREIGN KEY (`idVatPham`) REFERENCES `vatpham` (`idVatPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieukien_vatpham`
--

LOCK TABLES `dieukien_vatpham` WRITE;
/*!40000 ALTER TABLE `dieukien_vatpham` DISABLE KEYS */;
/*!40000 ALTER TABLE `dieukien_vatpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hieuung`
--

DROP TABLE IF EXISTS `hieuung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hieuung` (
  `idHieuUng` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `loaiSuKien` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idHieuUng`,`idMoTa`),
  KEY `HieuUng_MoTa_idx` (`idMoTa`),
  CONSTRAINT `HieuUng_MoTa` FOREIGN KEY (`idMoTa`) REFERENCES `mota` (`idMoTa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hieuung`
--

LOCK TABLES `hieuung` WRITE;
/*!40000 ALTER TABLE `hieuung` DISABLE KEYS */;
INSERT INTO `hieuung` VALUES ('HU10000004','ALL','HU10000004'),('HU10000005','ALL','HU10000005'),('HU10000006','ALL','HU10000006'),('HU20000001','ALL','HU20000001'),('HU20000002','ALL','HU20000002'),('HU20000003','TINH','HU20000003');
/*!40000 ALTER TABLE `hieuung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hieuung_kynang`
--

DROP TABLE IF EXISTS `hieuung_kynang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hieuung_kynang` (
  `idHieuUng` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idKyNang` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `kinhNghiem` int NOT NULL,
  PRIMARY KEY (`idHieuUng`,`idKyNang`),
  KEY `HU_KN_KyNang_idx` (`idKyNang`),
  CONSTRAINT `HU_KN_HieuUng` FOREIGN KEY (`idHieuUng`) REFERENCES `hieuung` (`idHieuUng`),
  CONSTRAINT `HU_KN_KyNang` FOREIGN KEY (`idKyNang`) REFERENCES `kynang` (`idKyNang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hieuung_kynang`
--

LOCK TABLES `hieuung_kynang` WRITE;
/*!40000 ALTER TABLE `hieuung_kynang` DISABLE KEYS */;
/*!40000 ALTER TABLE `hieuung_kynang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hieuung_nghenghiep`
--

DROP TABLE IF EXISTS `hieuung_nghenghiep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hieuung_nghenghiep` (
  `idHieuUng` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idNgheNghiep` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `thongThao` int NOT NULL,
  `idChucVu` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `heSoLuong` double DEFAULT NULL,
  PRIMARY KEY (`idHieuUng`,`idNgheNghiep`,`idChucVu`),
  KEY `HU_NN_NgheNghiep_idx` (`idNgheNghiep`),
  KEY `HU_NN_ChucVu_idx` (`idChucVu`),
  CONSTRAINT `HU_NN_ChucVu` FOREIGN KEY (`idChucVu`) REFERENCES `chucvu` (`idChucVu`),
  CONSTRAINT `HU_NN_HieuUng` FOREIGN KEY (`idHieuUng`) REFERENCES `hieuung` (`idHieuUng`),
  CONSTRAINT `HU_NN_NgheNghiep` FOREIGN KEY (`idNgheNghiep`) REFERENCES `nghenghiep` (`idNgheNghiep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hieuung_nghenghiep`
--

LOCK TABLES `hieuung_nghenghiep` WRITE;
/*!40000 ALTER TABLE `hieuung_nghenghiep` DISABLE KEYS */;
/*!40000 ALTER TABLE `hieuung_nghenghiep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hieuung_quanhe`
--

DROP TABLE IF EXISTS `hieuung_quanhe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hieuung_quanhe` (
  `idHieuUng` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `quanHe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `thanThiet` int DEFAULT NULL,
  `tinTuong` int DEFAULT NULL,
  PRIMARY KEY (`idHieuUng`),
  CONSTRAINT `HU_QH_HieuUng` FOREIGN KEY (`idHieuUng`) REFERENCES `hieuung` (`idHieuUng`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hieuung_quanhe`
--

LOCK TABLES `hieuung_quanhe` WRITE;
/*!40000 ALTER TABLE `hieuung_quanhe` DISABLE KEYS */;
/*!40000 ALTER TABLE `hieuung_quanhe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hieuung_thuoctinh`
--

DROP TABLE IF EXISTS `hieuung_thuoctinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hieuung_thuoctinh` (
  `idHieuUng` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idThuocTinh` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `giaTriTang` int DEFAULT NULL,
  `tiLeTang` double DEFAULT NULL,
  PRIMARY KEY (`idHieuUng`,`idThuocTinh`),
  KEY `HU_TT_ThuocTinh_idx` (`idThuocTinh`),
  CONSTRAINT `HU_TT_HieuUng` FOREIGN KEY (`idHieuUng`) REFERENCES `hieuung` (`idHieuUng`),
  CONSTRAINT `HU_TT_ThuocTinh` FOREIGN KEY (`idThuocTinh`) REFERENCES `thuoctinh` (`idThuocTinh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hieuung_thuoctinh`
--

LOCK TABLES `hieuung_thuoctinh` WRITE;
/*!40000 ALTER TABLE `hieuung_thuoctinh` DISABLE KEYS */;
/*!40000 ALTER TABLE `hieuung_thuoctinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hieuung_vatpham`
--

DROP TABLE IF EXISTS `hieuung_vatpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hieuung_vatpham` (
  `idHieuUng` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idVatPham` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `loaiVatPham` varchar(200) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `soLuong` int NOT NULL,
  `suDung` int NOT NULL,
  PRIMARY KEY (`idHieuUng`,`idVatPham`),
  KEY `HU_VP_VatPham_idx` (`idVatPham`),
  CONSTRAINT `HU_VP_HieuUng` FOREIGN KEY (`idHieuUng`) REFERENCES `hieuung` (`idHieuUng`),
  CONSTRAINT `HU_VP_VatPham` FOREIGN KEY (`idVatPham`) REFERENCES `vatpham` (`idVatPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hieuung_vatpham`
--

LOCK TABLES `hieuung_vatpham` WRITE;
/*!40000 ALTER TABLE `hieuung_vatpham` DISABLE KEYS */;
/*!40000 ALTER TABLE `hieuung_vatpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kynang`
--

DROP TABLE IF EXISTS `kynang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kynang` (
  `idKyNang` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tenKyNang` varchar(200) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idKyNang`,`idMoTa`),
  KEY `KyNang_MoTa_idx` (`idMoTa`),
  CONSTRAINT `KyNang_MoTa` FOREIGN KEY (`idMoTa`) REFERENCES `mota` (`idMoTa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kynang`
--

LOCK TABLES `kynang` WRITE;
/*!40000 ALTER TABLE `kynang` DISABLE KEYS */;
/*!40000 ALTER TABLE `kynang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luachon_dieukien`
--

DROP TABLE IF EXISTS `luachon_dieukien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luachon_dieukien` (
  `idMauLuaChon` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idDieuKien` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idMauLuaChon`,`idDieuKien`),
  KEY `LC_DK_DieuKien_idx` (`idDieuKien`),
  CONSTRAINT `LC_DK_DieuKien` FOREIGN KEY (`idDieuKien`) REFERENCES `dieukien` (`idDieuKien`),
  CONSTRAINT `LC_DK_LuaChon` FOREIGN KEY (`idMauLuaChon`) REFERENCES `mauluachon` (`idMauLuaChon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luachon_dieukien`
--

LOCK TABLES `luachon_dieukien` WRITE;
/*!40000 ALTER TABLE `luachon_dieukien` DISABLE KEYS */;
/*!40000 ALTER TABLE `luachon_dieukien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mauluachon`
--

DROP TABLE IF EXISTS `mauluachon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mauluachon` (
  `idMauLuaChon` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `loaiDoiTuongTG` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`idMauLuaChon`,`idMoTa`),
  KEY `MLC_MoTa_idx` (`idMoTa`),
  CONSTRAINT `MLC_MoTa` FOREIGN KEY (`idMoTa`) REFERENCES `mota` (`idMoTa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mauluachon`
--

LOCK TABLES `mauluachon` WRITE;
/*!40000 ALTER TABLE `mauluachon` DISABLE KEYS */;
INSERT INTO `mauluachon` VALUES ('MLC00001','MLC0000100',NULL),('MLC00002','MLC0000200',NULL),('MLC00003','MLC0000300',NULL),('MLC00004','MLC0000400',NULL),('MLC00005','MLC0000500',NULL),('MLC00006','MLC0000600',NULL),('MLC00007','MLC0000700',NULL),('MLC00008','MLC0000800',NULL),('MLC00009','MLC0000900',NULL),('MLC00010','MLC0001000',NULL),('MLC00011','MLC0001100',NULL),('MLC00012','MLC0001200',NULL),('MLC00013','MLC0001300',NULL),('MLC00014','MLC0001400',NULL),('MLC00015','MLC0001500',NULL),('MLC00016','MLC0001600',NULL),('MLC00017','MLC0001700',NULL),('MLC00018','MLC0001800',NULL),('MLC00019','MLC0001900',NULL),('MLC00020','MLC0002000',NULL),('MLC00021','MLC0002100',NULL),('MLC00022','MLC0002200',NULL),('MLC00023','MLC0002300',NULL),('MLC00024','MLC0002400',NULL),('MLC00025','MLC0002500',NULL),('MLC00026','MLC0002600','_NPC_'),('MLC00027','MLC0002700','_NPC_'),('MLC00028','MLC0002800','_NPC_'),('MLC00029','MLC0002900','_NPC_'),('MLC00030','MLC0003000','_NPC_'),('MLC00031','MLC0003100',NULL),('MLC00032','MLC0003200',NULL),('MLC00033','MLC0003300',NULL),('MLC00034','MLC0003400',NULL),('MLC00035','MLC0003500',NULL),('MLC00036','MLC0003600',NULL);
/*!40000 ALTER TABLE `mauluachon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mausukien`
--

DROP TABLE IF EXISTS `mausukien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mausukien` (
  `idMauSuKien` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tenMauSuKien` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `loaiSuKien` text CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `thoiHan` int DEFAULT NULL,
  `loaiDoiTuongTG` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `soLuongTG` int DEFAULT NULL,
  `tyLeXuatHien` double NOT NULL,
  PRIMARY KEY (`idMauSuKien`,`idMoTa`),
  KEY `MSK_MoTa_idx` (`idMoTa`),
  CONSTRAINT `MSK_MoTa` FOREIGN KEY (`idMoTa`) REFERENCES `mota` (`idMoTa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mausukien`
--

LOCK TABLES `mausukien` WRITE;
/*!40000 ALTER TABLE `mausukien` DISABLE KEYS */;
INSERT INTO `mausukien` VALUES ('MSK00001','MSK0000100','Luyện tập hằng ngày','HANGNAM',1,'MC',1,100),('MSK00002','MSK0000200','Chọn nghề nghiệp','BOICANH',0,'MC',1,100),('MSK00003','MSK0000300','Bất ngờ trên đường đi','BOICANH',0,'MC',1,5),('MSK00004','MSK0000400','Bất ngờ trên đường đi','BOICANH',0,'MC_RANDOMFNPC',2,5),('MSK00005','MSK0000500','Bất ngờ trên đường đi','BOICANH',0,'MC',1,5),('MSK00006','MSK0000600','Đi săn','HANGNAM',0,'MC',1,5),('MSK00007','MSK0000700','Chăm con','HANGNAM',1,'MC_CON',2,0),('MSK00008','MSK0000800','Khám phá di chỉ','DIADANH',0,'MC',1,15),('MSK10001','MSK1000100','Kết bạn','BOICANH',0,'MC_NGUOILA',2,80),('MSK10002','MSK1000200','Nhập học học viện kỵ sĩ','BOICANH',5,'MC',1,10),('MSK10003','MSK1000300','Nhập học học viện ma pháp','BOICANH',5,'MC',1,10),('MSK10004','MSK1000400','Nhận được vật phẩm','BOICANH',0,'MC',1,10),('MSK10005','MSK1000500','Lễ trưởng thành','HANGNAM',0,'MC',1,80),('MSK10006','MSK1000600','Phát triển mối quan hệ','BOICANH',1,'MC_BANBE',1,20),('MSK10007','MSK1000700','Sinh con','BOICANH',1,'MC_GIADINH',1,0),('MSK10008','MSK1000800','Đi săn trong rừng sâu','BOICANH',0,'MC',1,80),('MSK10009','MSK1000900','Tốt nghiệp học viện','BOICANH',0,'MC',1,100),('MSK10010','MSK1001000','Một năm bình an','THEGIOI',1,'MC',1,60),('MSK20001','MSK2000100','Dịch bệnh bùng phát','TINH',0,'MC',1,20),('MSK20002','MSK2000200','Người thân ra đi','BOICANH',0,'MC',1,5),('MSK20003','MSK2000300','Thảm họa tự nhiên','DIADANH',0,'MC',1,5),('MSK20004','MSK2000400','Chiến tranh xảy ra','THEGIOI',2,'MC',1,8),('MSK20005','MSK2000500','Xung đột với người lạ','DIADANH',0,'MC_NGUOILA',2,5),('MSK20006','MSK2000600','Toán cướp tấn công','TINH',0,'MC',1,5),('MSK20007','MSK2000700','Quan hệ tan vỡ','BOICANH',0,'MC_BANBE',2,5),('MSK20008','MSK2000800','Rơi vào trạng thái tiêu cực','BOICANH',0,'MC',1,5),('MSK20009','MSK2000900','Đột tử','BOICANH',0,'MC',1,50);
/*!40000 ALTER TABLE `mausukien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mlc_msk`
--

DROP TABLE IF EXISTS `mlc_msk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mlc_msk` (
  `idMauLuaChon` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMauSuKien` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idMauLuaChon`,`idMauSuKien`),
  KEY `MLC_MSK_SuKien_idx` (`idMauSuKien`),
  CONSTRAINT `MLC_MSK_MLC` FOREIGN KEY (`idMauLuaChon`) REFERENCES `mauluachon` (`idMauLuaChon`),
  CONSTRAINT `MLC_MSK_MSK` FOREIGN KEY (`idMauSuKien`) REFERENCES `mausukien` (`idMauSuKien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mlc_msk`
--

LOCK TABLES `mlc_msk` WRITE;
/*!40000 ALTER TABLE `mlc_msk` DISABLE KEYS */;
INSERT INTO `mlc_msk` VALUES ('MLC00021','MSK00005'),('MLC00020','MSK10008'),('MLC00017','MSK20008');
/*!40000 ALTER TABLE `mlc_msk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moiquanhe`
--

DROP TABLE IF EXISTS `moiquanhe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moiquanhe` (
  `idNhanVat1` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idNhanVat2` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `quanHe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `thanThiet` int NOT NULL,
  `tinTuong` int NOT NULL,
  PRIMARY KEY (`idNhanVat1`,`idNhanVat2`),
  KEY `MQH_NhanVat2` (`idNhanVat2`),
  CONSTRAINT `MQH_NhanVat1` FOREIGN KEY (`idNhanVat1`) REFERENCES `nhanvat` (`idNhanVat`),
  CONSTRAINT `MQH_NhanVat2` FOREIGN KEY (`idNhanVat2`) REFERENCES `nhanvat` (`idNhanVat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moiquanhe`
--

LOCK TABLES `moiquanhe` WRITE;
/*!40000 ALTER TABLE `moiquanhe` DISABLE KEYS */;
/*!40000 ALTER TABLE `moiquanhe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mota`
--

DROP TABLE IF EXISTS `mota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mota` (
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `noiDung` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tomTat` text CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci,
  PRIMARY KEY (`idMoTa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mota`
--

LOCK TABLES `mota` WRITE;
/*!40000 ALTER TABLE `mota` DISABLE KEYS */;
INSERT INTO `mota` VALUES ('1','1',NULL),('AGE','Tuổi của nhân vật, khi càng tiệm cận max thì giảm các chỉ số cơ bản, max thì kết thúc',NULL),('ATK','Khả năng tấn công',NULL),('CHA','Vẻ ngoài nhân vật',NULL),('CLS','Mức độ băng hoại của thế giới',NULL),('CVJOB01000','Cấp bậc kỹ năng sản xuất khởi đầu',NULL),('CVJOB01100','Cấp bậc kỹ năng sản xuất cao',NULL),('CVJOB01200','Cấp bậc kỹ năng săn bắn khởi đầu',NULL),('CVJOB01300','Cấp bậc kỹ năng săn bắn cao',NULL),('CVJOB01500','Cấp bậc kỹ năng sản xuất cao',NULL),('CVJOB10500','Cấp bậc kỹ năng chiến đấu khởi đầu',NULL),('CVJOB10600','Cấp bậc kỹ năng chiến đấu thấp',NULL),('CVJOB10700','Cấp bậc kỹ năng chiến đấu trung bình',NULL),('CVJOB10800','Cấp bậc kĩ năng chiến đấu cao',NULL),('CVJOB10900','Cấp bậc kỹ năng chiến đấu thần thánh',NULL),('CVJOB11000','Cấp bậc kỹ năng kiếm kỹ khởi đầu',NULL),('CVJOB11100','Cấp bậc kỹ năng kiếm kỹ thấp',NULL),('CVJOB11200','Cấp bậc kỹ năng kiếm kỹ cao',NULL),('CVJOB11300','Cấp bậc kỹ năng kiếm kỹ thần thánh',NULL),('CVJOB11400','Cấp bậc kỹ năng ma pháp khởi đầu',NULL),('CVJOB11500','Cấp bậc kỹ năng ma pháp thấp',NULL),('CVJOB11600','Cấp bậc kỹ năng ma pháp cao',NULL),('CVJOB11700','Cấp bậc kỹ năng ma pháp thần thánh',NULL),('CVJOB20100','Cấp bậc kỹ năng buôn bán khởi đầu',NULL),('CVJOB20200','Cấp bậc kỹ năng buôn bán thấp',NULL),('CVJOB20300','Cấp bậc kỹ năng buôn bán trung bình',NULL),('CVJOB20400','Cấp bậc kỹ năng buôn bán cao',NULL),('CVJOB31800','Cấp bậc kỹ năng chế tạo khởi đầu',NULL),('CVJOB31900','Cấp bậc kỹ năng chế tạo thấp',NULL),('CVJOB32000','Cấp bậc kỹ năng chế tạo cao',NULL),('CVJOB32100','Cấp bậc kỹ năng chế thuốc khởi đầu',NULL),('CVJOB32200','Cấp bậc kỹ năng chế thuốc thấp',NULL),('CVJOB32300','Cấp bậc kỹ năng chế thuốc cao',NULL),('CVJOB32400','Cấp bậc kỹ năng trị liệu khởi đầu',NULL),('CVJOB32500','Cấp bậc kỹ năng trị liệu thấp',NULL),('CVJOB32600','Cấp bậc kỹ năng trị liệu cao',NULL),('CVJOB32700','Cấp bậc kỹ năng trị liệu thần thánh',NULL),('DEX','Khả năng xử lý những thứ tinh vi và độ chính xác',NULL),('DK1MLC0007','Chỉ số trí lực',NULL),('DK1MLC0008','Chỉ số sức khỏe',NULL),('DK1MLC0009','Chỉ số sức khỏe',NULL),('DK1MLC0010','Chỉ số máu',NULL),('DK1MLC0011','Chỉ số phòng thủ',NULL),('DK1MLC0012','Chỉ số trí lực',NULL),('DK1MLC0014','Chỉ số trí lực',NULL),('DK1MLC0015','Chỉ số ma lực',NULL),('DK1MLC0035','Chỉ số tâm lý cao',NULL),('DK1SK00001','Lớn hơn 3 tuổi',NULL),('DK1SK00002','Lớn hơn 15 tuổi',NULL),('DK1SK00006','Là thợ săn',NULL),('DK1SK00007','Có con trai',NULL),('DK1SK00008','Địa danh nhất định',NULL),('DK1SK10002','Lúc 10 tuổi',NULL),('DK1SK10003','Lúc 10 tuổi',NULL),('DK1SK10006','Lúc 15 tuổi',NULL),('DK1SK10007','Là bạn bè',NULL),('DK1SK10008','Là chồng',NULL),('DK1SK10009','Thợ săn',NULL),('DK1SK20001','Địa danh nhất định',NULL),('DK1SK20003','Chỉ số băng hoại',NULL),('DK1SK20006','Chỉ số băng hoại',NULL),('DK1SK20007','Là bạn',NULL),('DK1SK20008','Chỉ số tâm lý thấp',NULL),('DK1SK20009','Chỉ số sức khỏe thấp',NULL),('DK2MLC0009','Chỉ số nhanh nhẹn',NULL),('DK2MLC0010','Chỉ số tấn công',NULL),('DK2MLC0011','Chỉ số tấn công',NULL),('DK2MLC0012','Chỉ số ma lực',NULL),('DK2MLC0014','Chỉ số khéo léo',NULL),('DK2MLC0015','Chỉ số trí lực',NULL),('DK2SK00007','Có con gái',NULL),('DK2SK00008','Là vợ',NULL),('DK3MLC0009','Chỉ số khéo léo',NULL),('DK3MLC0015','Chỉ số khéo léo',NULL),('EPM','Trình độ phát triển của kinh tế - chính trị - quân sự',NULL),('EXP','Điểm chỉ số đạt 1 mức nhất định sẽ tăng LV',NULL),('HP','Thuộc tính này về 0 tương đượng với trò chơi kết thúc',NULL),('HU10000004','Vui vẻ','Bạn đang vui vẻ'),('HU10000005','Sợ hãi','Bạn đang sợ hãi'),('HU10000006','Buồn bã','Bạn đang buồn bã'),('HU20000001','Trầm cảm','Bạn bị trầm cảm'),('HU20000002','Tinh thần sụp đổ','Bạn bị tinh thần sụp đổ'),('HU20000003','Bệnh tật','Bạn đang bị bệnh'),('INT','Trí thông minh và khả năng hiểu sự việc',NULL),('JOB0000100','Nghề nghiệp sản xuất',NULL),('JOB0000200','Nghề nghiệp sản xuất',NULL),('JOB1000100','Nghề nghiệp chiến đấu',NULL),('JOB1000200','Nghề nghiệp chiến đấu',NULL),('JOB1000300','Nghề nghiệp chiến đấu',NULL),('JOB2000100','Nghề nghiệp buôn bán',NULL),('JOB3000100','Nghề nghiệp hậu cần',NULL),('JOB3000200','Nghề nghiệp hậu cần',NULL),('JOB3000300','Nghề nghiệp hậu cần',NULL),('LUK','Tăng xác suất kích hoạt sự kiện có lợi',NULL),('LVL','Tăng sát thương kĩ năng và chỉ số, giảm tiêu hao',NULL),('MLC0000100','Có','Bạn chọn có.'),('MLC0000200','Không','Bạn chọn không.'),('MLC0000300','Đọc sách','Bạn luyện tập đọc sách.'),('MLC0000400','Luyện kiếm, tập thể lực','Bạn luyện kiếm, tập thể lực.'),('MLC0000500','Luyện thể lực','Bạn luyện tập thể lực.'),('MLC0000600','Rèn luyện ma lực, luyện tập pháp thuật','Bạn luyện tập ma lục và pháp thuật.'),('MLC0000700','Trở thành thương nhân','Bạn trở thành thương nhân.'),('MLC0000800','Trở thành nông dân','Bạn trở thành nông dân.'),('MLC0000900','Trở thành thợ săn','Ban trở thành thợ săn.'),('MLC0001000','Trở thành kiếm sư','Bạn trở thành kiếm sư.'),('MLC0001100','Trở thành kỵ sĩ','Bạn trở thành kỵ sĩ.'),('MLC0001200','Trở thành pháp sư','Bạn trở thành pháp sư.'),('MLC0001300','Trở thành giả kim sư','Bạn trở thành giả kim sư.'),('MLC0001400','Trở thành dược sư','Bạn trở thành dược sư.'),('MLC0001500','Trở thành trị liệu sư','Bạn trở thành trị liệu sư.'),('MLC0001600','Cứu giúp','Bạn chọn cứu giúp họ.'),('MLC0001700','Bỏ chạy','Bạn chọn bỏ chạy.'),('MLC0001800','Bỏ mặc không quan tâm','Bạn chọn bỏ mặc không quan tâm.'),('MLC0001900','Đưa về nhà chăm sóc','Bạn chọn đưa họ về chăm sóc.'),('MLC0002000','Tiếp tục vào sâu trong rừng','Bạn chọn tiến vào sâu trong rừng.'),('MLC0002100','Từ bỏ và trở về','Bạn chọn từ bỏ và trở về nhà.'),('MLC0002200','Chăm sóc tận tình','Bạn chọn chăm sóc tận tình.'),('MLC0002300','Dạy dỗ nghiêm khắc','Bạn chọn dạy dỗ nghiêm khắc.'),('MLC0002400','Dạy bảo nhẹ nhàng','Bạn chọn dạy bảo nhẹ nhàng.'),('MLC0002500','Thăm dò di tích','Bạn chọn thăm dò di tích'),('MLC0002600','Trở thành bạn thân','Bạn chọn trở thành bạn thân với _NPC_'),('MLC0002700','Trở thành tri kỷ','Bạn chọn trở thành tri kỷ với _NPC_'),('MLC0002800','Trở thành người yêu','Bạn chọn trở thành người yêu với _NPC_'),('MLC0002900','Trở thành gia đình','Bạn chọn trở thành gia đình với _NPC_'),('MLC0003000','Giữ mối quan hệ như cũ','Bạn chọn giữ quan hệ như cũ với _NPC_'),('MLC0003100','Dời đi cùng với làng','Bạn chọn dời đi với làng'),('MLC0003200','Tham gia chiến tranh','Bạn chọn tham gia chiến tranh'),('MLC0003300','Tác động vật lý với người ấy','Bạn chọn tác động vật lý với người ấy'),('MLC0003400','Giảng hòa với người ấy','Bạn chọn giảng hòa với người ấy'),('MLC0003500','Tấn công đám cướp, giải cứu làng','Bạn chọn tấn công đám cướp, giải cứu làng'),('MLC0003600','Níu kéo quan hệ','Bạn chọn níu kéo quan hệ'),('MNA','Trình độ phát triển của ma thuật - giả kim',NULL),('MNE','Trình độ phát triển của y tế - giáo dục',NULL),('MNT','Chỉ số cao sẽ cho nhưng buff có lợi, khi thấp thì mang lại các debuff không có lợi',NULL),('MP','Năng lượng của bản thân khi dùng kĩ năng',NULL),('MSK0000100','Luyện tập để mạnh hơn, có những sự chuẩn bị tốt nhất cho những sự kiện trong tương lai.','Luyện tập để trở nên mạnh hơn.'),('MSK0000200','Chọn định hướng cho bản thân, có nghề nghiệp phù hợp để làm việc và tồn tại trong thế giới này.','Bạn chọn nghề nghiệp của mình.'),('MSK0000300','Bạn gặp phải đoàn thương nhân đang bị đám cướp tấn công, đoàn thương nhân đã có người bị thương bởi đám cướp hung hăng.','Bạn gặp đám cướp tấn công đoàn thương nhân.'),('MSK0000400','Bạn gặp phải người phụ nữ đang bị đám cướp tấn công, cô ấy bị thương và trong tình trạng bất ổn. Bạn sẽ làm gì?','Bạn gặp đám cướp tấn công người phụ nữ.'),('MSK0000500','Bạn gặp phải người mặc áo choàng kín người ngất bên đường. Bạn sẽ ?','Bạn gặp người thần bí ngất bên đường.'),('MSK0000600','Bạn vào rừng đi săn thú rừng để kiếm nguồn thịt cho nhà của bạn. Nhưng bạn không săn được bất kỳ con thú nào.','Bạn đi săn nhưng không được con thú nào.'),('MSK0000700','Hãy chăm sóc con của bạn, tùy vào cách bạn chăm sóc, đứa trẻ sẽ có những hướng phát triển khác nhau.','Bạn chăm sóc con của bạn.'),('MSK0000800','Bạn bắt gặp một di chỉ cổ đại, nguy hiểm kèm phần thưởng tương ứng, bạn sẽ ?','Bạn vô tình phát hiện ra một tòa chi tích cổ đại.'),('MSK1000100','Bạn có muốn trở thành bạn với _NPC_ không?','Trở thành bạn với _NPC_.'),('MSK1000200','Bạn đủ tuổi để vào học viện kỵ sĩ, bạn có muốn nhập học không?','Bạn đủ tuổi nhập học học viện kỵ sĩ.'),('MSK1000300','Bạn đủ tuổi để vào học viện ma pháp, bạn có muốn nhập học không?','Bạn đủ tuổi nhập học học viện ma pháp.'),('MSK1000400','Bạn nhận được _VATPHAM_.','Bạn nhận được _VATPHAM_.'),('MSK1000500','Năm tháng thoi đưa, bạn đã đến thế giới này được 15 năm, gia đình và bạn bè tổ chức cho bạn một bữa tiệc nhỏ','Bạn được mọi người tổ chức lễ trưởng thành.'),('MSK1000600','Mối quan hệ giữa bạn và _NPC_ đã phát triển rất tốt, bạn muốn trở thành mối quan hệ gì với _NPC_?','Quan hệ giữa bạn và _NPC_ đã có bước phát triển mới.'),('MSK1000700','Tình cảm giữa bạn và _NPC_ rất tốt, bạn muốn có con với _NPC_ không?','_NPC_ muốn có con với bạn.'),('MSK1000800','Bạn đi vào trong rừng sâu, may mắn săn được một con thú rừng lớn. Thịt bạn giữ lại làm lương thực, da với một số bộ phận quý bạn đã đổi lấy tiền.','Bạn săn được môn cón thú lớn, kiếm được thịt và tiền.'),('MSK1000900','Bạn đã tốt nghiệp học viện, giờ đây hãy bắt đầu cuộc sống mới của bạn.','Bạn tốt nghiệp học viện.'),('MSK1001000','Môt năm không có sự kiện gì xảy ra, thế giới yên bình',NULL),('MSK2000100','Dịch bệnh đột nhiên bùng phát, đã lan rất nhanh tới chỗ bạn sinh sống.','Dịch bệnh bùng phát.'),('MSK2000200','_NPC_ của bạn đã ra đi, bạn đau buồn cho sự ra đi của _NPC_.','_NPC_ của bạn ra đi.'),('MSK2000300','Nơi bạn ở xảy ra động đất rất mạnh.','Nơi bạn ở xảy ra động đất.'),('MSK2000400','Chiến tranh giữa các quốc gia đã diễn ra, làng của bạn quyết định dời đi nơi khác, bạn sẽ làm gì?','Chiến tranh đã nổ ra.'),('MSK2000500','Đang đi trên đường, một người lạ bỗng lại gần bạn và gây hấn với bạn.','Bạn gặp người lạ trên đường và có xung đột xảy ra.'),('MSK2000600','Một toán cướp tấn công làng của bạn, chúng ra sức cướp bóc, bắt phụ nữ. Bạn sẽ?','Toán cướp từ đâu xuất hiện tấn công làng của bạn.'),('MSK2000700','Giữa _NPC_ và bạn bất hòa, quan hệ bắt đầu tan vỡ.','Quan hệ giữa _NPC và bạn xấu đi.'),('MSK2000800','Sau sự kiện đó, bạn rơi vào trạng thái tiêu cực','Bạn rơi vào trạng thái tiêu cực.'),('MSK2000900','Cái chết đột ngột đến, hậu quả của tâm lý và sức khỏe của bạn không tốt',NULL),('PHY','',NULL),('RSC','Mức độ giàu tài nguyên',NULL),('SEX','ĐIều kiện cho 1 số sự kiện đặc biệt hoặc độ phù hợp',NULL),('SLM','Khả năng xảy ra thời tiết có lợi',NULL),('SNT','Trình độ phát triển của khoa học - kỹ thuật',NULL),('SPD','Tốc độ di chuyển và phản xạ của cơ thể',NULL),('STR','Sức mạnh thể chất của nhân vật',NULL),('VIT','Khả năng chống chịu',NULL);
/*!40000 ALTER TABLE `mota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msk_mlc`
--

DROP TABLE IF EXISTS `msk_mlc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `msk_mlc` (
  `idMauSuKien` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMauLuaChon` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idMauSuKien`,`idMauLuaChon`),
  KEY `MSK_MLC_MLC_idx` (`idMauLuaChon`),
  CONSTRAINT `MSK_MLC_MLC` FOREIGN KEY (`idMauLuaChon`) REFERENCES `mauluachon` (`idMauLuaChon`),
  CONSTRAINT `MSK_MLC_MSK` FOREIGN KEY (`idMauSuKien`) REFERENCES `mausukien` (`idMauSuKien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msk_mlc`
--

LOCK TABLES `msk_mlc` WRITE;
/*!40000 ALTER TABLE `msk_mlc` DISABLE KEYS */;
INSERT INTO `msk_mlc` VALUES ('MSK10001','MLC00001'),('MSK10002','MLC00001'),('MSK10003','MLC00001'),('MSK10007','MLC00001'),('MSK10001','MLC00002'),('MSK10002','MLC00002'),('MSK10003','MLC00002'),('MSK10007','MLC00002'),('MSK00001','MLC00003'),('MSK00001','MLC00004'),('MSK00001','MLC00005'),('MSK00001','MLC00006'),('MSK00002','MLC00007'),('MSK00002','MLC00008'),('MSK00002','MLC00009'),('MSK00002','MLC00010'),('MSK00002','MLC00011'),('MSK00002','MLC00012'),('MSK00002','MLC00013'),('MSK00002','MLC00014'),('MSK00002','MLC00015'),('MSK00003','MLC00016'),('MSK00004','MLC00016'),('MSK00003','MLC00017'),('MSK00004','MLC00017'),('MSK20006','MLC00017'),('MSK00003','MLC00018'),('MSK00004','MLC00018'),('MSK00005','MLC00018'),('MSK00007','MLC00018'),('MSK20005','MLC00018'),('MSK20007','MLC00018'),('MSK00005','MLC00019'),('MSK00006','MLC00020'),('MSK00006','MLC00021'),('MSK00008','MLC00021'),('MSK00007','MLC00022'),('MSK00007','MLC00023'),('MSK00007','MLC00024'),('MSK00008','MLC00025'),('MSK10006','MLC00026'),('MSK10006','MLC00027'),('MSK10006','MLC00028'),('MSK10006','MLC00029'),('MSK10007','MLC00030'),('MSK20004','MLC00031'),('MSK20004','MLC00032'),('MSK20005','MLC00033'),('MSK20005','MLC00034'),('MSK20006','MLC00035'),('MSK20007','MLC00036');
/*!40000 ALTER TABLE `msk_mlc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nghenghiep`
--

DROP TABLE IF EXISTS `nghenghiep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nghenghiep` (
  `idNgheNghiep` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tenNgheNghiep` text CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idNgheNghiep`,`idMoTa`),
  KEY `NgheNghiep_MoTa_idx` (`idMoTa`),
  CONSTRAINT `NgheNghiep_MoTa` FOREIGN KEY (`idMoTa`) REFERENCES `mota` (`idMoTa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nghenghiep`
--

LOCK TABLES `nghenghiep` WRITE;
/*!40000 ALTER TABLE `nghenghiep` DISABLE KEYS */;
INSERT INTO `nghenghiep` VALUES ('JOB00001','Thợ săn','JOB0000100'),('JOB00002','Nông dân','JOB0000200'),('JOB10001','Kiếm sĩ','JOB1000100'),('JOB10002','Kỵ sĩ','JOB1000200'),('JOB10003','Pháp sư','JOB1000300'),('JOB20001','Thương Nhân','JOB2000100'),('JOB30001','Giả kim sư','JOB3000100'),('JOB30002','Dược sư','JOB3000200'),('JOB30003','Trị liệu sư','JOB3000300');
/*!40000 ALTER TABLE `nghenghiep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvat`
--

DROP TABLE IF EXISTS `nhanvat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvat` (
  `idNhanVat` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idTheGioi` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tenNhanVat` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `viTri` varchar(45) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `nguoiChoi` tinyint DEFAULT NULL,
  PRIMARY KEY (`idNhanVat`,`idTheGioi`),
  KEY `NhanVat_TheGioi_idx` (`idTheGioi`),
  CONSTRAINT `NhanVat_TheGioi` FOREIGN KEY (`idTheGioi`) REFERENCES `thegioi` (`idTheGioi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvat`
--

LOCK TABLES `nhanvat` WRITE;
/*!40000 ALTER TABLE `nhanvat` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhanvat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvat_kynang`
--

DROP TABLE IF EXISTS `nhanvat_kynang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvat_kynang` (
  `idNhanVat` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idKyNang` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `kinhNghiem` int NOT NULL,
  `capDo` int NOT NULL,
  PRIMARY KEY (`idNhanVat`,`idKyNang`),
  KEY `NV_KN_KyNang_idx` (`idKyNang`),
  CONSTRAINT `NV_KN_KyNang` FOREIGN KEY (`idKyNang`) REFERENCES `kynang` (`idKyNang`),
  CONSTRAINT `NV_KN_NhanVat` FOREIGN KEY (`idNhanVat`) REFERENCES `nhanvat` (`idNhanVat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvat_kynang`
--

LOCK TABLES `nhanvat_kynang` WRITE;
/*!40000 ALTER TABLE `nhanvat_kynang` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhanvat_kynang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvat_thuoctinh`
--

DROP TABLE IF EXISTS `nhanvat_thuoctinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvat_thuoctinh` (
  `idNhanVat` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idThuocTinh` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `giaTri` int NOT NULL,
  `tiemNang` int NOT NULL,
  `tgHieuLuc` time DEFAULT NULL,
  PRIMARY KEY (`idNhanVat`,`idThuocTinh`),
  KEY `NV_TT_ThuocTinh_idx` (`idThuocTinh`),
  CONSTRAINT `NV_TT_NhanVat` FOREIGN KEY (`idNhanVat`) REFERENCES `nhanvat` (`idNhanVat`),
  CONSTRAINT `NV_TT_ThuocTinh` FOREIGN KEY (`idThuocTinh`) REFERENCES `thuoctinh` (`idThuocTinh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvat_thuoctinh`
--

LOCK TABLES `nhanvat_thuoctinh` WRITE;
/*!40000 ALTER TABLE `nhanvat_thuoctinh` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhanvat_thuoctinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvat_vatpham`
--

DROP TABLE IF EXISTS `nhanvat_vatpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvat_vatpham` (
  `idNhanVat` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idVatPham` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `soLuong` int DEFAULT NULL,
  PRIMARY KEY (`idNhanVat`,`idVatPham`),
  KEY `NV_VP_VatPham_idx` (`idVatPham`),
  KEY `NV_VP_NhanVat_idx` (`idNhanVat`),
  CONSTRAINT `NV_VP_NhanVat` FOREIGN KEY (`idNhanVat`) REFERENCES `nhanvat` (`idNhanVat`),
  CONSTRAINT `NV_VP_VatPham` FOREIGN KEY (`idVatPham`) REFERENCES `vatpham` (`idVatPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvat_vatpham`
--

LOCK TABLES `nhanvat_vatpham` WRITE;
/*!40000 ALTER TABLE `nhanvat_vatpham` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhanvat_vatpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nv_nn_cv`
--

DROP TABLE IF EXISTS `nv_nn_cv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nv_nn_cv` (
  `idNhanVat` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idNgheNghiep` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idChucVu` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `thongThao` int NOT NULL,
  `heSoLuong` double NOT NULL,
  PRIMARY KEY (`idNhanVat`,`idNgheNghiep`,`idChucVu`),
  KEY `NV_NN_CV_NgheNghiep_idx` (`idNgheNghiep`),
  KEY `NV_NN_CV_ChucVu_idx` (`idChucVu`),
  KEY `NV_NN_CV_NhanVat_idx` (`idNhanVat`),
  CONSTRAINT `NV_NN_CV_ChucVu` FOREIGN KEY (`idChucVu`) REFERENCES `chucvu` (`idChucVu`),
  CONSTRAINT `NV_NN_CV_NgheNghiep` FOREIGN KEY (`idNgheNghiep`) REFERENCES `nghenghiep` (`idNgheNghiep`),
  CONSTRAINT `NV_NN_CV_NhanVat` FOREIGN KEY (`idNhanVat`) REFERENCES `nhanvat` (`idNhanVat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nv_nn_cv`
--

LOCK TABLES `nv_nn_cv` WRITE;
/*!40000 ALTER TABLE `nv_nn_cv` DISABLE KEYS */;
/*!40000 ALTER TABLE `nv_nn_cv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sukien`
--

DROP TABLE IF EXISTS `sukien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sukien` (
  `idSuKien` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idTheGioi` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `thoiDiem` int DEFAULT NULL,
  `idMauSuKien` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idBoiCanh` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `moTa` mediumtext COLLATE utf8mb4_vietnamese_ci,
  `tomTat` text COLLATE utf8mb4_vietnamese_ci,
  `isComplete` tinyint NOT NULL,
  PRIMARY KEY (`idSuKien`,`idTheGioi`,`idMauSuKien`,`idBoiCanh`),
  KEY `SuKien_TheGioi_idx` (`idTheGioi`),
  KEY `SuKien_MSK_idx` (`idMauSuKien`),
  KEY `SuKien_BoiCanh_idx` (`idBoiCanh`),
  CONSTRAINT `SuKien_BoiCanh` FOREIGN KEY (`idBoiCanh`) REFERENCES `boicanh` (`idBoiCanh`),
  CONSTRAINT `SuKien_MSK` FOREIGN KEY (`idMauSuKien`) REFERENCES `mausukien` (`idMauSuKien`),
  CONSTRAINT `SuKien_TheGioi` FOREIGN KEY (`idTheGioi`) REFERENCES `thegioi` (`idTheGioi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sukien`
--

LOCK TABLES `sukien` WRITE;
/*!40000 ALTER TABLE `sukien` DISABLE KEYS */;
/*!40000 ALTER TABLE `sukien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sukien_dieukien`
--

DROP TABLE IF EXISTS `sukien_dieukien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sukien_dieukien` (
  `idMauSuKien` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idDieuKien` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idMauSuKien`,`idDieuKien`),
  KEY `SK_DK_DieuKien_idx` (`idDieuKien`),
  KEY `SK_DK_SuKien_idx` (`idMauSuKien`),
  CONSTRAINT `SK_DK_DieuKien` FOREIGN KEY (`idDieuKien`) REFERENCES `dieukien` (`idDieuKien`),
  CONSTRAINT `SK_DK_MauSuKien` FOREIGN KEY (`idMauSuKien`) REFERENCES `mausukien` (`idMauSuKien`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sukien_dieukien`
--

LOCK TABLES `sukien_dieukien` WRITE;
/*!40000 ALTER TABLE `sukien_dieukien` DISABLE KEYS */;
INSERT INTO `sukien_dieukien` VALUES ('MSK00001','DK1SK00001'),('MSK00002','DK1SK00002'),('MSK00006','DK1SK00006'),('MSK00007','DK1SK00007'),('MSK00007','DK2SK00007'),('MSK00008','DK1SK00008'),('MSK10002','DK1SK10002'),('MSK10003','DK1SK10003'),('MSK10006','DK1SK10006'),('MSK10007','DK1SK10007'),('MSK10008','DK1SK10008'),('MSK10008','DK2SK00008'),('MSK10009','DK1SK10009'),('MSK20001','DK1SK20001'),('MSK20003','DK1SK20003'),('MSK20006','DK1SK20006'),('MSK20007','DK1SK20007'),('MSK20008','DK1SK20008');
/*!40000 ALTER TABLE `sukien_dieukien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sukien_hieuung`
--

DROP TABLE IF EXISTS `sukien_hieuung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sukien_hieuung` (
  `idMauSuKien` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idHieuUng` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idMauSuKien`,`idHieuUng`),
  KEY `SK_HU_HieuUng_idx` (`idHieuUng`),
  KEY `SK_HU_SuKien_idx` (`idMauSuKien`),
  CONSTRAINT `SK_HU_HieuUng` FOREIGN KEY (`idHieuUng`) REFERENCES `hieuung` (`idHieuUng`),
  CONSTRAINT `SK_HU_MauSuKien` FOREIGN KEY (`idMauSuKien`) REFERENCES `mausukien` (`idMauSuKien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sukien_hieuung`
--

LOCK TABLES `sukien_hieuung` WRITE;
/*!40000 ALTER TABLE `sukien_hieuung` DISABLE KEYS */;
INSERT INTO `sukien_hieuung` VALUES ('MSK10010','HU10000004'),('MSK20001','HU20000003'),('MSK20002','HU20000002'),('MSK20006','HU10000005'),('MSK20007','HU10000006'),('MSK20008','HU20000002');
/*!40000 ALTER TABLE `sukien_hieuung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sukien_nhanvat`
--

DROP TABLE IF EXISTS `sukien_nhanvat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sukien_nhanvat` (
  `idSuKien` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idNhanVat` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `thuTu` varchar(8) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`idSuKien`,`idNhanVat`),
  KEY `SK_NV_NhanVat_idx` (`idNhanVat`),
  KEY `SK_NV_SuKien_idx` (`idSuKien`),
  CONSTRAINT `SK_NV_NhanVat` FOREIGN KEY (`idNhanVat`) REFERENCES `nhanvat` (`idNhanVat`),
  CONSTRAINT `SK_NV_SuKien` FOREIGN KEY (`idSuKien`) REFERENCES `sukien` (`idSuKien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sukien_nhanvat`
--

LOCK TABLES `sukien_nhanvat` WRITE;
/*!40000 ALTER TABLE `sukien_nhanvat` DISABLE KEYS */;
/*!40000 ALTER TABLE `sukien_nhanvat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thegioi`
--

DROP TABLE IF EXISTS `thegioi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thegioi` (
  `idTheGioi` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `nam` int NOT NULL,
  `lanChoiCuoi` datetime DEFAULT NULL,
  PRIMARY KEY (`idTheGioi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thegioi`
--

LOCK TABLES `thegioi` WRITE;
/*!40000 ALTER TABLE `thegioi` DISABLE KEYS */;
/*!40000 ALTER TABLE `thegioi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuoctinh`
--

DROP TABLE IF EXISTS `thuoctinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuoctinh` (
  `idThuocTinh` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tenThuocTinh` text CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `loaiThuocTinh` text CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `hienThi` tinyint DEFAULT NULL,
  PRIMARY KEY (`idThuocTinh`,`idMoTa`),
  KEY `ThuocTinh_MoTa_idx` (`idMoTa`),
  CONSTRAINT `TT_MoTa` FOREIGN KEY (`idMoTa`) REFERENCES `mota` (`idMoTa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuoctinh`
--

LOCK TABLES `thuoctinh` WRITE;
/*!40000 ALTER TABLE `thuoctinh` DISABLE KEYS */;
INSERT INTO `thuoctinh` VALUES ('AGE','Tuổi','AGE','AGE',NULL),('ATK','Tấn công','ATK','ATK',NULL),('CHA','Mị lực','CHA','CHA',NULL),('CLS','Băng hoại','CLS','CLS',NULL),('DEX','Khéo léo','DEX','DEX',NULL),('EPM','Kinh tế - Chính trị - Quân sự','EPM','EPM',NULL),('EXP','Kinh nghiệm','EXP','EXP',NULL),('HP','Máu','HP','HP',NULL),('INT','Trí lực','INT','INT',NULL),('LUK','May mắn','LUK','LUK',NULL),('LVL','Cấp độ','LVL','LVL',NULL),('MNA','Ma thuật - Giả kim','MNA','MNA',NULL),('MNE','Y tế - Giáo dục','MNE','MNE',NULL),('MNT','Tâm lý','MNT','MNT',NULL),('MP','Ma lực','MP','MP',NULL),('PHY','Thể lực','PHY','PHY',NULL),('RSC','Tài nguyên','RSC','RSC',NULL),('SEX','Giới tính','SEX','SEX',NULL),('SLM','Khí hậu','SLM','SLM',NULL),('SNT','Khoa học - Kỹ thuật','SNT','SNT',NULL),('SPD','Nhanh nhẹn','SPD','SPD',NULL),('STR','Sức khỏe','STR','STR',NULL),('VIT','Phòng thủ','VIT','VIT',NULL);
/*!40000 ALTER TABLE `thuoctinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuongmai`
--

DROP TABLE IF EXISTS `thuongmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuongmai` (
  `idBoiCanh` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idVatPham` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `giaCa` mediumint DEFAULT NULL,
  PRIMARY KEY (`idBoiCanh`,`idVatPham`),
  KEY `ThuongMai_VatPham_idx` (`idVatPham`),
  CONSTRAINT `ThuongMai_BoiCanh` FOREIGN KEY (`idBoiCanh`) REFERENCES `boicanh` (`idBoiCanh`),
  CONSTRAINT `ThuongMai_VatPham` FOREIGN KEY (`idVatPham`) REFERENCES `vatpham` (`idVatPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuongmai`
--

LOCK TABLES `thuongmai` WRITE;
/*!40000 ALTER TABLE `thuongmai` DISABLE KEYS */;
/*!40000 ALTER TABLE `thuongmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vatpham`
--

DROP TABLE IF EXISTS `vatpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vatpham` (
  `idVatPham` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tenVatPham` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `loaiVatPham` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `doBen` int DEFAULT NULL,
  `idMoTa` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idVatPham`,`idMoTa`),
  KEY `VatPham_MoTa_idx` (`idMoTa`),
  CONSTRAINT `VatPham_MoTa` FOREIGN KEY (`idMoTa`) REFERENCES `mota` (`idMoTa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vatpham`
--

LOCK TABLES `vatpham` WRITE;
/*!40000 ALTER TABLE `vatpham` DISABLE KEYS */;
/*!40000 ALTER TABLE `vatpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vatpham_hieuung`
--

DROP TABLE IF EXISTS `vatpham_hieuung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vatpham_hieuung` (
  `idVatPham` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idHieuUng` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idVatPham`,`idHieuUng`),
  KEY `VP_HU_HieuUng` (`idHieuUng`),
  CONSTRAINT `VP_HU_HieuUng` FOREIGN KEY (`idHieuUng`) REFERENCES `hieuung` (`idHieuUng`),
  CONSTRAINT `VP_HU_VatPham` FOREIGN KEY (`idVatPham`) REFERENCES `vatpham` (`idVatPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vatpham_hieuung`
--

LOCK TABLES `vatpham_hieuung` WRITE;
/*!40000 ALTER TABLE `vatpham_hieuung` DISABLE KEYS */;
/*!40000 ALTER TABLE `vatpham_hieuung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vatpham_thuoctinh`
--

DROP TABLE IF EXISTS `vatpham_thuoctinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vatpham_thuoctinh` (
  `idVatPham` varchar(8) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idThuocTinh` varchar(8) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `giaTri` int DEFAULT NULL,
  `tiemNang` int DEFAULT NULL,
  `tgTacDung` int DEFAULT NULL,
  PRIMARY KEY (`idVatPham`),
  KEY `VP_TT_ThuocTinh` (`idThuocTinh`),
  CONSTRAINT `VP_TT_ThuocTinh` FOREIGN KEY (`idThuocTinh`) REFERENCES `thuoctinh` (`idThuocTinh`),
  CONSTRAINT `VP_TT_VatPham` FOREIGN KEY (`idVatPham`) REFERENCES `vatpham` (`idVatPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vatpham_thuoctinh`
--

LOCK TABLES `vatpham_thuoctinh` WRITE;
/*!40000 ALTER TABLE `vatpham_thuoctinh` DISABLE KEYS */;
/*!40000 ALTER TABLE `vatpham_thuoctinh` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-28 15:49:51
