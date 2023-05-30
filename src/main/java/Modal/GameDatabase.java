package Modal;

import java.sql.*;
import GameEvent.*;
import WorldBuilder.*;
import GameObject.*;
import java.util.*;

/**
 *
 */
public class GameDatabase {

    /**
     *
     */
    static private Connection dataConn;

    /**
     *
     */
    static private String maTG;
    

    static private ArrayList<HashMap> dsNhanVat = new ArrayList<>();
    static private ArrayList<HashMap> dsVatPham = new ArrayList<>();
    static private ArrayList<HashMap> dsThuocTinh = new ArrayList<>();
    static private ArrayList<HashMap> dsKyNang = new ArrayList<>();
    static private ArrayList<HashMap> dsNgheNghiep = new ArrayList<>();
    static private ArrayList<HashMap> dsChucVu = new ArrayList<>();
    static private ArrayList<HashMap> dsBoiCanh = new ArrayList<>();
    static private ArrayList<HashMap> dsDauAn = new ArrayList<>();
    static private ArrayList<HashMap> dsThuongMai = new ArrayList<>();
    static private ArrayList<HashMap> dsSuKien = new ArrayList<>();
    static private ArrayList<HashMap> dsLuaChon = new ArrayList<>();
    static private ArrayList<HashMap> dsHieuUng = new ArrayList<>();
    static private ArrayList<HashMap> dsQuanHe = new ArrayList<>();
    static private ArrayList<HashMap> dsDieuKien = new ArrayList<>();
    static private ArrayList<HashMap> dsBC_BC = new ArrayList<>();
    static private ArrayList<HashMap> dsBC_TN = new ArrayList<>();
    static private ArrayList<HashMap> dsDK_HU = new ArrayList<>();
    static private ArrayList<HashMap> dsDK_KN = new ArrayList<>();
    static private ArrayList<HashMap> dsDK_NN = new ArrayList<>();
    static private ArrayList<HashMap> dsDK_QH = new ArrayList<>();
    static private ArrayList<HashMap> dsDK_TT = new ArrayList<>();
    static private ArrayList<HashMap> dsDK_VP = new ArrayList<>();
    static private ArrayList<HashMap> dsHU_KN = new ArrayList<>();
    static private ArrayList<HashMap> dsHU_NN = new ArrayList<>();
    static private ArrayList<HashMap> dsHU_QH = new ArrayList<>();
    static private ArrayList<HashMap> dsHU_TT = new ArrayList<>();
    static private ArrayList<HashMap> dsHU_VP = new ArrayList<>();
    static private ArrayList<HashMap> dsLC_DK = new ArrayList<>();
    static private ArrayList<HashMap> dsMLC_MSK = new ArrayList<>();
    static private ArrayList<HashMap> dsMSK_MLC = new ArrayList<>();
    static private ArrayList<HashMap> dsNV_KN = new ArrayList<>();
    static private ArrayList<HashMap> dsNV_TT = new ArrayList<>();
    static private ArrayList<HashMap> dsNV_VP = new ArrayList<>();
    static private ArrayList<HashMap> dsNV_NN_CV = new ArrayList<>();
    static private ArrayList<HashMap> dsSK_DK = new ArrayList<>();
    static private ArrayList<HashMap> dsSK_HU = new ArrayList<>();
    static private ArrayList<HashMap> dsSK_NV = new ArrayList<>();
    static private ArrayList<HashMap> dsVP_HU = new ArrayList<>();
    static private ArrayList<HashMap> dsVP_TT= new ArrayList<>();
    
    static private HashMap getMoTa(ArrayList<HashMap> dsMoTa, String MaMT){
        for(HashMap temp: dsMoTa){
            String value = (String) temp.get("MaMT");
            if (value != null && value.equals(MaMT)) {
                return temp;
            }
        }
        return new HashMap<>();
    };

    /**
     * @param dbURL
     * @param username
     * @param password
     */
    static public void connectDatabase(String dbURL, String username, String password) {
        // Kết nối cơ sở dữ liệu
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            GameDatabase.dataConn = conn;
            System.out.println("Kết nối thành công!");
            
            // Câu query lấy dữ liệu
            String queryNV = "SELECT * FROM NhanVat";
            String queryVP = "SELECT * FROM VatPham";
            String queryDK = "SELECT * FROM DieuKien";
            String queryHU = "SELECT * FROM HieuUng";
            String queryNN = "SELECT * FROM NgheNghiep";
            String queryCV = "SELECT * FROM ChucVu";
            String queryTT = "SELECT * FROM ThuocTinh";
            String queryMoTa = "SELECT * FROM MoTa";
            String queryBC = "SELECT * FROM BoiCanh";
            String queryDA = "SELECT * FROM DauAn";
            String queryKN = "SELECT * FROM KyNang";
            String queryMLC = "SELECT * FROM MauLuaChon";
            String queryMQH = "SELECT * FROM MoiQuanHe";
            String queryTM = "SELECT * FROM ThuongMai";
            String queryMSK = "SELECT * FROM MauSuKien";
            String queryBC_BC = "SELECT * FROM BoiCanh_BoiCanh";
            String queryBC_TN = "SELECT * FROM BoiCanh_TaiNguyen";
            String queryDK_HU = "SELECT * FROM DieuKien_HieuUng";
            String queryDK_KN = "SELECT * FROM DieuKien_KyNang";
            String queryDK_NN = "SELECT * FROM DieuKien_NgheNghiep";
            String queryDK_QH = "SELECT * FROM DieuKien_QuanHe";
            String queryDK_TT = "SELECT * FROM DieuKien_ThuocTinh";
            String queryDK_VP = "SELECT * FROM DieuKien_VatPham";
            String queryHU_KN = "SELECT * FROM HieuUng_KyNang";
            String queryHU_NN = "SELECT * FROM HieuUng_NgheNghiep";
            String queryHU_QH = "SELECT * FROM HieuUng_QuanHe";
            String queryHU_TT = "SELECT * FROM HieuUng_ThuocTinh";
            String queryHU_VP = "SELECT * FROM HieuUng_VatPham";
            String queryLC_DK = "SELECT * FROM LuaChon_DieuKien";
            String queryMSK_MLC = "SELECT * FROM MSK_MLC";
            String queryMLC_MSK = "SELECT * FROM MLC_MSK";
            String queryNV_KN = "SELECT * FROM NhanVat_KyNang";
            String queryNV_TT = "SELECT * FROM NhanVat_ThuocTinh";
            String queryNV_VP = "SELECT * FROM NhanVat_VatPham";
            String queryNV_NN_CV = "SELECT * FROM NV_NN_CV";
            String querySK_DK = "SELECT * FROM SuKien_DieuKien";
            String querySK_HU = "SELECT * FROM SuKien_HieuUng";
            String querySK_NV = "SELECT * FROM SuKien_NhanVat";
            String queryVP_HU = "SELECT * FROM VatPham_HieuUng";
            String queryVP_TT = "SELECT * FROM VatPham_ThuocTinh";
            
            // Lưu các bảng phụ
            ArrayList<HashMap> dsMoTa = new ArrayList<>();

            Statement statement = conn.createStatement();
            
            // Lấy dữ liệu từ bảng MoTa
            ResultSet bangMoTa = statement.executeQuery(queryMoTa);
            while (bangMoTa.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> MoTa = new HashMap<>();
                String tomtat = bangMoTa.getString("tomTat");
                MoTa.put("MaMT", bangMoTa.getString("idMoTa"));
                MoTa.put("NoiDung", bangMoTa.getString("noiDung"));
                if(tomtat != null){
                    MoTa.put("TomTat", tomtat);
                }
                dsMoTa.add(MoTa);
            }
            
            // Lấy dữ liệu từ bảng NhanVat
            ResultSet bangNV = statement.executeQuery(queryNV);
            while (bangNV.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> NV = new HashMap<>();
                String MC = bangNV.getString("nguoiChoi");
                NV.put("MaNV", bangNV.getString("idNhanVat"));
                NV.put("MaTG", bangNV.getString("idTheGioi"));
                NV.put("TenNV", bangNV.getString("tenNhanVat"));
                NV.put("ViTri", bangNV.getString("viTri"));
                if(MC != null){
                    NV.put("NguoiChoi", MC);
                }
                GameDatabase.dsNhanVat.add(NV);
            }
            
            // Lấy dữ liệu từ bảng VatPham
            ResultSet bangVP = statement.executeQuery(queryVP);
            while (bangVP.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> temp = new HashMap<>();
                temp.put("MaVP", bangVP.getString("idVatPham"));
                temp.put("TenVP", bangVP.getString("tenVatPham"));
                temp.put("LoaiVP", bangVP.getString("loaiVatPham"));
                temp.put("doBen", bangVP.getString("doBen"));
                temp.put("MoTa",(String) getMoTa(dsMoTa, bangVP.getString("idMoTa")).get("NoiDung"));
                
                GameDatabase.dsVatPham.add(temp);
            }
            
            // Lấy dữ liệu từ bảng HieuUng
            ResultSet bangHU = statement.executeQuery(queryHU);
            while (bangHU.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> temp = new HashMap<>();
                temp.put("MaHU", bangHU.getString("idHieuUng"));
                temp.put("LoaiSK", bangHU.getString("loaiSuKien"));
                temp.put("MoTa",(String) getMoTa(dsMoTa, bangHU.getString("idMoTa")).get("NoiDung"));
                GameDatabase.dsHieuUng.add(temp);
            }
            
            // Lấy dữ liệu từ bảng NgheNghiep
            ResultSet bangNN = statement.executeQuery(queryNN);
            while (bangNN.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> temp = new HashMap<>();
                temp.put("MaNN", bangNN.getString("idNgheNghiep"));
                temp.put("TenNN", bangNN.getString("tenNgheNghiep"));
                temp.put("MoTa",(String) getMoTa(dsMoTa, bangNN.getString("idMoTa")).get("NoiDung"));
                GameDatabase.dsNgheNghiep.add(temp);
            }
            
            // Lấy dữ liệu từ bảng ChucVu
            ResultSet bangCV = statement.executeQuery(queryCV);
            while (bangCV.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> temp = new HashMap<>();
                temp.put("MaCV", bangCV.getString("idChucVu"));
                temp.put("TenCV", bangCV.getString("tenChucVu"));
                temp.put("MaNN", bangCV.getString("idNgheNghiep"));
                temp.put("MoTa",(String) getMoTa(dsMoTa, bangCV.getString("idMoTa")).get("NoiDung"));
                temp.put("CapBac", bangCV.getString("capBac"));
                temp.put("LCB", bangCV.getString("luongCoBan"));
                GameDatabase.dsChucVu.add(temp);
            }
            
            // Lấy dữ liệu từ bảng ThuocTinh
            ResultSet bangTT = statement.executeQuery(queryTT);
            while (bangTT.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> temp = new HashMap<>();
                temp.put("MaTT", bangTT.getString("idThuocTinh"));
                temp.put("TenTT", bangTT.getString("tenThuocTinh"));
                temp.put("MoTa",(String) getMoTa(dsMoTa, bangTT.getString("idMoTa")).get("NoiDung"));
                temp.put("LoaiTT", bangTT.getString("loaiThuocTinh"));
                String HT = bangTT.getString("hienThi");
                if(HT != null){
                    temp.put("HienThi", HT);
                }
                GameDatabase.dsThuocTinh.add(temp);
            }
            
            // Lấy dữ liệu từ bảng BoiCanh
            ResultSet bangBC = statement.executeQuery(queryBC);
            while (bangBC.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> BC = new HashMap<>();
                BC.put("MaBC", bangBC.getString("idBoiCanh"));
                BC.put("MaTG", bangBC.getString("idTheGioi"));
                BC.put("TenBC", bangBC.getString("tenBoiCanh"));
                BC.put("LoaiBC", bangBC.getString("loaiBoiCanh"));
                BC.put("HD", bangBC.getString("hoanhDo"));
                BC.put("TD", bangBC.getString("tungDo"));
                GameDatabase.dsBoiCanh.add(BC);
            }
            
            // Lấy dữ liệu từ bảng DauAn
            ResultSet bangDA = statement.executeQuery(queryDA);
            while (bangDA.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> DA = new HashMap<>();
                DA.put("MaNV", bangDA.getString("idNhanVat"));
                DA.put("MaSK", bangDA.getString("idSụKien"));
                GameDatabase.dsDauAn.add(DA);
            }
            
             // Lấy dữ liệu từ bảng KyNang
            ResultSet bangKN = statement.executeQuery(queryKN);
            while (bangKN.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> KN = new HashMap<>();
                KN.put("MaBC", bangKN.getString("idKyNang"));
                KN.put("TenKN", bangKN.getString("tenKyNang"));
                KN.put("MoTa",(String) getMoTa(dsMoTa, bangKN.getString("idMoTa")).get("NoiDung"));
                GameDatabase.dsKyNang.add(KN);
            }
            
            // Lấy dữ liệu từ bảng MLC
            ResultSet bangMLC = statement.executeQuery(queryMLC);
            while (bangMLC.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> MLC = new HashMap<>();
                String LDTTG = bangMLC.getString("loaiDoiTuongTG");
                MLC.put("MaMLC", bangMLC.getString("idMauLuaChon"));
                MLC.put("MoTa",(String) getMoTa(dsMoTa, bangMLC.getString("idMoTa")).get("NoiDung"));
                if(LDTTG != null){
                    MLC.put("LDTTG", LDTTG);
                }
                GameDatabase.dsLuaChon.add(MLC);
            }
            
            // Lấy dữ liệu từ bảng MoiQuanHe
            ResultSet bangMQH = statement.executeQuery(queryMQH);
            while (bangMQH.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> MQH = new HashMap<>();
                MQH.put("MaNV1", bangMQH.getString("idNhanVat1"));
                MQH.put("MaNV2", bangMQH.getString("idNhanVat2"));
                MQH.put("QuanHe", bangMQH.getString("quanHe"));
                MQH.put("ThanThiet", bangMQH.getString("ThanThiet"));
                MQH.put("TinTuong", bangMQH.getString("tinTuong"));
                GameDatabase.dsQuanHe.add(MQH);
            }
            
            // Lấy dữ liệu từ bảng ThuongMai
            ResultSet bangTM = statement.executeQuery(queryTM);
            while (bangTM.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> TM = new HashMap<>();
                TM.put("MaBC", bangTM.getString("idBoiCanh"));
                TM.put("MaVP", bangTM.getString("idVatPham"));
                TM.put("GiaCa", bangTM.getString("giaCa"));
                GameDatabase.dsThuongMai.add(TM);
            }
            
            // Lấy dữ liệu từ bảng MauSuKien
            ResultSet bangMSK = statement.executeQuery(queryMSK);
            while (bangMSK.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> MSK = new HashMap<>();
                MSK.put("MaSK", bangMSK.getString("idMauSuKien"));
                MSK.put("MoTa",(String) getMoTa(dsMoTa, bangMSK.getString("idMoTa")).get("NoiDung"));
                MSK.put("TomTat",(String) getMoTa(dsMoTa, bangMSK.getString("idMoTa")).get("TomTat"));
                MSK.put("TenSK", bangMSK.getString("tenMauSuKien"));
                MSK.put("LoaiSK", bangMSK.getString("loaiSuKien"));
                MSK.put("ThoiHan", bangMSK.getString("thoiHan"));
                MSK.put("LoaiDTTG", bangMSK.getString("loaiDoiTuongTG"));
                MSK.put("SLTG", bangMSK.getString("soLuongTG"));
                MSK.put("TLXH", bangMSK.getString("tyLeXuatHien"));
                GameDatabase.dsSuKien.add(MSK);
            }
            
            // Lấy dữ liệu từ bảng DieuKien
            ResultSet bangDK = statement.executeQuery(queryDK);
            while (bangDK.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> DK = new HashMap<>();
                DK.put("MaDK", bangDK.getString("idDieuKien"));
                DK.put("LoaiDK", bangDK.getString("loaiDieuKien"));
                DK.put("MoTa",(String) getMoTa(dsMoTa, bangDK.getString("idMoTa")).get("NoiDung"));
                String SLDTT = bangDK.getString("slDungTT");
                if(SLDTT != null){
                    DK.put("SLDTT", SLDTT);
                }
                
                GameDatabase.dsDieuKien.add(DK);
            }
            
            // Lấy dữ liệu từ bảng BoiCanh_BoiCanh
            ResultSet bangBC_BC = statement.executeQuery(queryBC_BC);
            while (bangBC_BC.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> BC_BC = new HashMap<>();
                BC_BC.put("MaBC1", bangBC_BC.getString("idBoiCanh1"));
                BC_BC.put("MaBC2", bangBC_BC.getString("idBoiCanh2"));
                GameDatabase.dsBC_BC.add(BC_BC);
            }
            
            // Lấy dữ liệu từ bảng BoiCanh_TaiNguyen
            ResultSet bangBC_TN = statement.executeQuery(queryBC_TN);
            while (bangBC_TN.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> BC_TN = new HashMap<>();
                BC_TN.put("MaBC1", bangBC_TN.getString("idBoiCanh"));
                BC_TN.put("MaVP", bangBC_TN.getString("idVatPham"));
                GameDatabase.dsBC_TN.add(BC_TN);
            }
            
            // Lấy dữ liệu từ bảng DieuKien_HieuUng
            ResultSet bangDK_HU = statement.executeQuery(queryDK_HU);
            while (bangDK_HU.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> DK_HU = new HashMap<>();
                DK_HU.put("MaDK", bangDK_HU.getString("idDieuKien"));
                DK_HU.put("MaHU", bangDK_HU.getString("idHieuUng"));
                DK_HU.put("IsNot", bangDK_HU.getString("isNot"));
                GameDatabase.dsDK_HU.add(DK_HU);
            }
            
            // Lấy dữ liệu từ bảng DieuKien_KyNang
            ResultSet bangDK_KN = statement.executeQuery(queryDK_KN);
            while (bangDK_KN.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> DK_KN = new HashMap<>();
                DK_KN.put("MaDK", bangDK_KN.getString("idDieuKien"));
                DK_KN.put("MaKN", bangDK_KN.getString("idKyNang"));
                DK_KN.put("IsNot", bangDK_KN.getString("isNot"));
                DK_KN.put("CapDo", bangDK_KN.getString("capDo"));
                GameDatabase.dsDK_KN.add(DK_KN);
            }
            
            // Lấy dữ liệu từ bảng DieuKien_NgheNghiep
            ResultSet bangDK_NN = statement.executeQuery(queryDK_NN);
            while (bangDK_NN.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> DK_NN = new HashMap<>();
                DK_NN.put("MaDK", bangDK_NN.getString("idDieuKien"));
                DK_NN.put("MaNN", bangDK_NN.getString("idNgheNghiep"));
                DK_NN.put("IsNot", bangDK_NN.getString("isNot"));
                DK_NN.put("ThongThao", bangDK_NN.getString("thongThao"));
                DK_NN.put("CapBac", bangDK_NN.getString("capBac"));
                GameDatabase.dsDK_NN.add(DK_NN);
            }
            
            // Lấy dữ liệu từ bảng DieuKien_QuanHe
            ResultSet bangDK_QH = statement.executeQuery(queryDK_QH);
            while (bangDK_QH.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> DK_QH = new HashMap<>();
                DK_QH.put("MaDK", bangDK_QH.getString("idDieuKien"));
                DK_QH.put("LoaiQH", bangDK_QH.getString("loaiQuanHe"));
                DK_QH.put("IsNot", bangDK_QH.getString("isNot"));
                DK_QH.put("VongQH", bangDK_QH.getString("vongQH"));
                DK_QH.put("ThanThiet", bangDK_QH.getString("thanThiet"));
                DK_QH.put("TinTuong", bangDK_QH.getString("tinTuong"));
                GameDatabase.dsDK_QH.add(DK_QH);
            }
            
            // Lấy dữ liệu từ bảng DieuKien_ThuocTinh
            ResultSet bangDK_TT = statement.executeQuery(queryDK_TT);
            while (bangDK_TT.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> DK_TT = new HashMap<>();
                DK_TT.put("MaDK", bangDK_TT.getString("idDieuKien"));
                DK_TT.put("MaTT", bangDK_TT.getString("idThuocTinh"));
                DK_TT.put("IsNot", bangDK_TT.getString("isNot"));
                DK_TT.put("LoaiSS", bangDK_TT.getString("loaiSoSanh"));
                DK_TT.put("LoaiDT", bangDK_TT.getString("loaiDoiTuong"));
                DK_TT.put("GTSS", bangDK_TT.getString("giaTriSS"));
                GameDatabase.dsDK_TT.add(DK_TT);
            }
            
            // Lấy dữ liệu từ bảng DieuKien_VatPham
            ResultSet bangDK_VP = statement.executeQuery(queryDK_VP);
            while (bangDK_VP.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> DK_VP = new HashMap<>();
                DK_VP.put("MaDK", bangDK_VP.getString("idDieuKien"));
                DK_VP.put("MaVP", bangDK_VP.getString("idVatPham"));
                DK_VP.put("IsNot", bangDK_VP.getString("isNot"));
                DK_VP.put("LoaiDT", bangDK_VP.getString("loaiDoiTuong"));
                DK_VP.put("LoaiVP", bangDK_VP.getString("loaiVatPham"));
                DK_VP.put("SoLuong", bangDK_VP.getString("soLuong"));
                GameDatabase.dsDK_VP.add(DK_VP);
            }
            
            // Lấy dữ liệu từ bảng HieuUng_KyNang
            ResultSet bangHU_KN = statement.executeQuery(queryHU_KN);
            while (bangHU_KN.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> HU_KN = new HashMap<>();
                HU_KN.put("MaHU", bangHU_KN.getString("idHieuUng"));
                HU_KN.put("MaKN", bangHU_KN.getString("idKyNang"));
                HU_KN.put("EXP", bangHU_KN.getString("kinhNghiem"));
                GameDatabase.dsHU_KN.add(HU_KN);
            }

            // Lấy dữ liệu từ bảng HieuUng_NgheNghiep
            ResultSet bangHU_NN = statement.executeQuery(queryHU_NN);
            while (bangHU_NN.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> HU_NN = new HashMap<>();
                HU_NN.put("MaHU", bangHU_NN.getString("idHieuUng"));
                HU_NN.put("MaNN", bangHU_NN.getString("idNgheNghiep"));
                HU_NN.put("ThongThao", bangHU_NN.getString("thongThao"));
                HU_NN.put("MaCV", bangHU_NN.getString("idChucVu"));
                HU_NN.put("HSLuong", bangHU_NN.getString("heSoLuong"));
                GameDatabase.dsHU_NN.add(HU_NN);
            }
            
            // Lấy dữ liệu từ bảng HieuUng_QuanHe
            ResultSet bangHU_QH = statement.executeQuery(queryHU_QH);
            while (bangHU_QH.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> HU_QH = new HashMap<>();
                HU_QH.put("MaHU", bangHU_QH.getString("idHieuUng"));
                HU_QH.put("QuanHe", bangHU_QH.getString("quanHe"));
                HU_QH.put("ThanThiet", bangHU_QH.getString("thanThiet"));
                HU_QH.put("TinTuong", bangHU_QH.getString("tinTuong"));
                GameDatabase.dsHU_QH.add(HU_QH);
            }
            
            // Lấy dữ liệu từ bảng HieuUng_ThuocTinh
            ResultSet bangHU_TT = statement.executeQuery(queryHU_TT);
            while (bangHU_TT.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> HU_TT = new HashMap<>();
                HU_TT.put("MaHU", bangHU_TT.getString("idHieuUng"));
                HU_TT.put("MaTT", bangHU_TT.getString("idThuocTinh"));
                HU_TT.put("GiaTriTang", bangHU_TT.getString("giaTriTang"));
                HU_TT.put("TLTang", bangHU_TT.getString("tiLeTang"));
                GameDatabase.dsHU_TT.add(HU_TT);
            }
            
            // Lấy dữ liệu từ bảng HieuUng_VatPham
            ResultSet bangHU_VP = statement.executeQuery(queryHU_VP);
            while (bangHU_VP.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> HU_VP = new HashMap<>();
                HU_VP.put("MaHU", bangHU_VP.getString("idHieuUng"));
                HU_VP.put("MaVP", bangHU_VP.getString("idVatPham"));
                HU_VP.put("LoaiVP", bangHU_VP.getString("loaiVatPham"));
                HU_VP.put("SoLuong", bangHU_VP.getString("soLuong"));
                HU_VP.put("SuDung", bangHU_VP.getString("SuDung"));
                GameDatabase.dsHU_VP.add(HU_VP);
            }
            
            // Lấy dữ liệu từ bảng LuaChon_DieuKien
            ResultSet bangLC_DK = statement.executeQuery(queryLC_DK);
            while (bangLC_DK.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> LC_DK = new HashMap<>();
                LC_DK.put("MaMLC", bangLC_DK.getString("idMauLuaChon"));
                LC_DK.put("MaDK", bangLC_DK.getString("idDieuKien"));
                GameDatabase.dsLC_DK.add(LC_DK);
            }
            
            // Lấy dữ liệu từ bảng MLC_MSK
            ResultSet bangMLC_MSK = statement.executeQuery(queryMLC_MSK);
            while (bangMLC_MSK.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> MLC_MSK = new HashMap<>();
                MLC_MSK.put("MaMLC", bangMLC_MSK.getString("idMauLuaChon"));
                MLC_MSK.put("MaMSK", bangMLC_MSK.getString("idMauSuKien"));
                GameDatabase.dsMLC_MSK.add(MLC_MSK);
            }
            
            // Lấy dữ liệu từ bảng MSK_MLC
            ResultSet bangMSK_MLC = statement.executeQuery(queryMSK_MLC);
            while (bangMSK_MLC.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> MSK_MLC = new HashMap<>();
                MSK_MLC.put("MaMLC", bangMSK_MLC.getString("idMauLuaChon"));
                MSK_MLC.put("MaMSK", bangMSK_MLC.getString("idMauSuKien"));
                GameDatabase.dsMSK_MLC.add(MSK_MLC);
            }
            
            // Lấy dữ liệu từ bảng NhanVat_KyNang
            ResultSet bangNV_KN = statement.executeQuery(queryNV_KN);
            while (bangNV_KN.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> NV_KN = new HashMap<>();
                NV_KN.put("MaNV", bangNV_KN.getString("idNhanVat"));
                NV_KN.put("MaKN", bangNV_KN.getString("idKyNang"));
                NV_KN.put("EXP", bangNV_KN.getString("kinhNghiem"));
                NV_KN.put("CapDo", bangNV_KN.getString("capDo"));
                GameDatabase.dsNV_KN.add(NV_KN);
            }
            
            // Lấy dữ liệu từ bảng NhanVat_ThuocTinh
            ResultSet bangNV_TT = statement.executeQuery(queryNV_TT);
            while (bangNV_TT.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> NV_TT = new HashMap<>();
                NV_TT.put("MaNV", bangNV_TT.getString("idNhanVat"));
                NV_TT.put("MaTT", bangNV_TT.getString("idThuocTinh"));
                NV_TT.put("GiaTri", bangNV_TT.getString("giaTri"));
                NV_TT.put("TiemNang", bangNV_TT.getString("tiemNang"));
                NV_TT.put("TGHL", bangNV_TT.getString("tgHieuLuc"));
                GameDatabase.dsNV_TT.add(NV_TT);
            }
            
            // Lấy dữ liệu từ bảng NhanVat_VatPham
            ResultSet bangNV_VP = statement.executeQuery(queryNV_VP);
            while (bangNV_VP.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> NV_VP = new HashMap<>();
                NV_VP.put("MaNV", bangNV_VP.getString("idNhanVat"));
                NV_VP.put("MaVP", bangNV_VP.getString("idVatPham"));
                NV_VP.put("SoLuong", bangNV_VP.getString("soLuong"));
                GameDatabase.dsNV_VP.add(NV_VP);
            }
            
            // Lấy dữ liệu từ bảng NhanVat_VatPham
            ResultSet bangNV_NN_CV = statement.executeQuery(queryNV_NN_CV);
            while (bangNV_NN_CV.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> NV_NN_CV = new HashMap<>();
                NV_NN_CV.put("MaNV", bangNV_NN_CV.getString("idNhanVat"));
                NV_NN_CV.put("MaNN", bangNV_NN_CV.getString("idNgheNghiep"));
                NV_NN_CV.put("MaCV", bangNV_NN_CV.getString("idChucVu"));
                NV_NN_CV.put("ThongThao", bangNV_NN_CV.getString("thongThao"));
                NV_NN_CV.put("HSLuong", bangNV_NN_CV.getString("HSLuong"));
                GameDatabase.dsNV_NN_CV.add(NV_NN_CV);
            }
            
            // Lấy dữ liệu từ bảng SuKien_DieuKien
            ResultSet bangSK_DK = statement.executeQuery(querySK_DK);
            while (bangSK_DK.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> SK_DK = new HashMap<>();
                SK_DK.put("MaMSK", bangSK_DK.getString("idMauSuKien"));
                SK_DK.put("MaDK", bangSK_DK.getString("idDieuKien"));
                GameDatabase.dsSK_DK.add(SK_DK);
            }
            
            // Lấy dữ liệu từ bảng SuKien_HieuUng
            ResultSet bangSK_HU = statement.executeQuery(querySK_HU);
            while (bangSK_HU.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> SK_HU = new HashMap<>();
                SK_HU.put("MaMSK", bangSK_HU.getString("idMauSuKien"));
                SK_HU.put("MaHU", bangSK_HU.getString("idHieuUng"));
                GameDatabase.dsSK_HU.add(SK_HU);
            }
            
            // Lấy dữ liệu từ bảng SuKien_HieuUng
            ResultSet bangSK_NV = statement.executeQuery(querySK_NV);
            while (bangSK_NV.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> SK_NV = new HashMap<>();
                SK_NV.put("MaMSK", bangSK_NV.getString("idMauSuKien"));
                SK_NV.put("MaNV", bangSK_NV.getString("idNhanVat"));
                SK_NV.put("ThuTu", bangSK_NV.getString("thuTu"));
                GameDatabase.dsSK_NV.add(SK_NV);
            }
            
            // Lấy dữ liệu từ bảng VatPham_HieuUng
            ResultSet bangVP_HU = statement.executeQuery(queryVP_HU);
            while (bangVP_HU.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> VP_HU = new HashMap<>();
                VP_HU.put("MaVP", bangVP_HU.getString("idVatPham"));
                VP_HU.put("MaHU", bangVP_HU.getString("idHieuUng"));
                GameDatabase.dsVP_HU.add(VP_HU);
            }
            
            // Lấy dữ liệu từ bảng VatPham_ThuocTinh
            ResultSet bangVP_TT = statement.executeQuery(queryVP_TT);
            while (bangVP_TT.next()) {
                // Lấy giá trị từ các cột
                HashMap<String, String> VP_TT = new HashMap<>();
                VP_TT.put("MaVP", bangVP_TT.getString("idVatPham"));
                VP_TT.put("MaTT", bangVP_TT.getString("idThuocTinh"));
                VP_TT.put("GiaTri", bangVP_TT.getString("giaTri"));
                VP_TT.put("tiemNang", bangVP_TT.getString("tiemNang"));
                VP_TT.put("TGTD", bangVP_TT.getString("tgTacDung"));
                GameDatabase.dsVP_TT.add(VP_TT);
                
            }
            
            // Đóng kết nối
            conn.close();
            System.out.println("Đã đóng kết nối!");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
        }

    }

    /**
     * @return
     */
    static public ArrayList<String> getDSTheGioi() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public TheGioi getTheGioi() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public NhanVat getNguoiChoi() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public ArrayList<NhanVat> getDSNV() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public Connection getDataConn() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public String getMaTG() {
        // TODO implement here
        return "";
    }

    /**
     * @param maTG
     */
    static public void setMaTG(String maTG) {
        // TODO implement here
    }

    public static ArrayList<HashMap> getDsNhanVat() {
        return dsNhanVat;
    }

    public static ArrayList<HashMap> getDsVatPham() {
        return dsVatPham;
    }

    public static ArrayList<HashMap> getDsThuocTinh() {
        return dsThuocTinh;
    }

    public static ArrayList<HashMap> getDsKyNang() {
        return dsKyNang;
    }

    public static ArrayList<HashMap> getDsNgheNghiep() {
        return dsNgheNghiep;
    }

    public static ArrayList<HashMap> getDsChucVu() {
        return dsChucVu;
    }

    public static ArrayList<HashMap> getDsBoiCanh() {
        return dsBoiCanh;
    }

    public static ArrayList<HashMap> getDsDauAn() {
        return dsDauAn;
    }

    public static ArrayList<HashMap> getDsThuongMai() {
        return dsThuongMai;
    }

    public static ArrayList<HashMap> getDsSuKien() {
        return dsSuKien;
    }

    public static ArrayList<HashMap> getDsLuaChon() {
        return dsLuaChon;
    }

    public static ArrayList<HashMap> getDsHieuUng() {
        return dsHieuUng;
    }

    public static ArrayList<HashMap> getDsQuanHe() {
        return dsQuanHe;
    }

    public static ArrayList<HashMap> getDsDieuKien() {
        return dsDieuKien;
    }

    public static ArrayList<HashMap> getDsBC_BC() {
        return dsBC_BC;
    }

    public static ArrayList<HashMap> getDsBC_TN() {
        return dsBC_TN;
    }

    public static ArrayList<HashMap> getDsDK_HU() {
        return dsDK_HU;
    }

    public static ArrayList<HashMap> getDsDK_KN() {
        return dsDK_KN;
    }

    public static ArrayList<HashMap> getDsDK_NN() {
        return dsDK_NN;
    }

    public static ArrayList<HashMap> getDsDK_QH() {
        return dsDK_QH;
    }

    public static ArrayList<HashMap> getDsDK_TT() {
        return dsDK_TT;
    }

    public static ArrayList<HashMap> getDsDK_VP() {
        return dsDK_VP;
    }

    public static ArrayList<HashMap> getDsHU_KN() {
        return dsHU_KN;
    }

    public static ArrayList<HashMap> getDsHU_NN() {
        return dsHU_NN;
    }

    public static ArrayList<HashMap> getDsHU_QH() {
        return dsHU_QH;
    }

    public static ArrayList<HashMap> getDsHU_TT() {
        return dsHU_TT;
    }

    public static ArrayList<HashMap> getDsHU_VP() {
        return dsHU_VP;
    }

    public static ArrayList<HashMap> getDsLC_DK() {
        return dsLC_DK;
    }

    public static ArrayList<HashMap> getDsMLC_MSK() {
        return dsMLC_MSK;
    }

    public static ArrayList<HashMap> getDsMSK_MLC() {
        return dsMSK_MLC;
    }

    public static ArrayList<HashMap> getDsNV_KN() {
        return dsNV_KN;
    }

    public static ArrayList<HashMap> getDsNV_TT() {
        return dsNV_TT;
    }

    public static ArrayList<HashMap> getDsNV_VP() {
        return dsNV_VP;
    }

    public static ArrayList<HashMap> getDsNV_NN_CV() {
        return dsNV_NN_CV;
    }

    public static ArrayList<HashMap> getDsSK_DK() {
        return dsSK_DK;
    }

    public static ArrayList<HashMap> getDsSK_HU() {
        return dsSK_HU;
    }

    public static ArrayList<HashMap> getDsSK_NV() {
        return dsSK_NV;
    }

    public static ArrayList<HashMap> getDsVP_HU() {
        return dsVP_HU;
    }

    public static ArrayList<HashMap> getDsVP_TT() {
        return dsVP_TT;
    }
    

}
