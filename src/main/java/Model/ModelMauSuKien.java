/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GameEvent.DieuKien;
import GameEvent.HieuUng;
import GameEvent.LuaChon;
import GameEvent.SuKien;
import GameObject.NhanVat;
import GameSystem.GeneratorSystem;
import java.util.*;

/**
 *
 * @author vuvuive
 */
public class ModelMauSuKien {

//    Sự kiện bối cảnh chung
    private static ArrayList<SuKien> dsSK = new ArrayList<>();

    public static void taiMauSuKien() {
        dsSK = new ArrayList<SuKien>();
//        Sự kiện thử nghiệm
        DieuKien dk0000 = Model.ModelDieuKien.getDieuKien("0000");
        DieuKien dk0001 = Model.ModelDieuKien.getDieuKien("0001");
        DieuKien dk0002 = Model.ModelDieuKien.getDieuKien("0002");
        DieuKien dk0003 = Model.ModelDieuKien.getDieuKien("0003");
        DieuKien dk0004 = Model.ModelDieuKien.getDieuKien("0004");
        DieuKien dk0005 = Model.ModelDieuKien.getDieuKien("0005");
        DieuKien dk0006 = Model.ModelDieuKien.getDieuKien("0006");

        LuaChon lc0000 = Model.ModelLuaChon.getLuaChon("0000");
        LuaChon lc0001 = Model.ModelLuaChon.getLuaChon("0001");
        LuaChon lc0002 = Model.ModelLuaChon.getLuaChon("0002");

        HieuUng hu0000 = Model.ModelHieuUng.getHieuUng("0000");
        HieuUng hu0001 = Model.ModelHieuUng.getHieuUng("0001");
        HieuUng hu0002 = Model.ModelHieuUng.getHieuUng("0002");
        HieuUng hu0003 = Model.ModelHieuUng.getHieuUng("0003");

        ArrayList<LuaChon> dsLC = new ArrayList<>();
        ArrayList<DieuKien> dsDK = new ArrayList<>();
        ArrayList<HieuUng> dsHU = new ArrayList<>();

        dsLC.add(lc0000);
        dsLC.add(lc0001);
        dsLC.add(lc0002);

        dsDK.add(dk0000);

        dsHU.add(hu0000);

        SuKien sk0000 = new SuKien("0000",
                "MỘT NĂM BÌNH AN",
                "Không có chuyện gì đặc sắc, mọi chuyện trôi qua bình an.",
                "",
                null,
                null,
                null,
                null,
                null,
                "NONE",
                0,
                0,
                "HANGNAM",
                99,
                false);

        SuKien sk0001 = new SuKien("0001",
                "TÀI NGUYÊN KHAN HIẾM",
                "Các nước bắt đầu cạnh tranh khốc liệt để dành làm chủ lượng tài ít ỏi còn lại. Lượng tài nguyên ít ỏi bị chia nhỏ, tình hình chính trị trở nên căng thẳng.",
                "",
                dsLC,
                null,
                (ArrayList<DieuKien>) dsDK.clone(),
                null,
                null,
                "MC",
                0,
                0,
                "HANGNAM",
                100,
                false);

        dsDK.clear();
        dsDK.add(dk0000);

        SuKien sk0002 = new SuKien("0002",
                "CẢM THẤY MỆT MỎI",
                "Vì sức khỏe yếu, tài nguyên khan hiếm khiến bạn càng thiếu thốn dinh dưỡng.",
                "",
                null,
                (ArrayList<HieuUng>) dsHU.clone(),
                null,
                null,
                null,
                "MC",
                0,
                0,
                "HEQUA",
                100,
                false);

        dsDK.clear();
        dsDK.add(dk0003);
        dsDK.add(dk0004);

        dsHU.clear();
        dsHU.add(hu0001);
        dsHU.add(hu0002);

        SuKien sk0003 = new SuKien("0003",
                "KHÔNG AI YÊU THƯƠNG",
                "Cha mẹ bạn không ai quan tâm đến bạn, bạn thấy lạc lõng trong ngôi nhà lặng ngắt.",
                "",
                null,
                (ArrayList<HieuUng>) dsHU.clone(),
                (ArrayList<DieuKien>) dsDK.clone(),
                null,
                null,
                "GIADINH",
                0,
                0,
                "HANGNAM",
                100,
                false);

        dsDK.clear();
        dsDK.add(dk0006);

        dsHU.clear();
        dsHU.add(hu0003);

        SuKien sk0004 = new SuKien("0004",
                "ĐI NHẶT ĐÁ",
                "Bạn cảm thấy chán, nên bạn đi ra ngoài chơi và nhặt được 1 cục đá.",
                "",
                null,
                (ArrayList<HieuUng>) dsHU.clone(),
                (ArrayList<DieuKien>) dsDK.clone(),
                null,
                null,
                "MC",
                0,
                0,
                "HANGNAM",
                50,
                false);

        dsDK.clear();
        dsDK.add(dk0006);

        SuKien sk0005 = new SuKien("0005",
                "SỐNG KHỞE",
                "Bạn đã sống được 3 năm.",
                "",
                null,
                null,
                (ArrayList<DieuKien>) dsDK.clone(),
                null,
                null,
                "MC",
                0,
                3,
                "UOCMO",
                100,
                false);

        dsSK.add(sk0000);
        dsSK.add(sk0001);
        dsSK.add(sk0002);
        dsSK.add(sk0003);
        dsSK.add(sk0004);
        dsSK.add(sk0005);

        ArrayList<HashMap> DsSK = Model.GameDatabase.getDsSuKien();
        ArrayList<HashMap> DsSK_LC = Model.GameDatabase.getDsMSK_MLC();
        ArrayList<HashMap> DsSK_HU = Model.GameDatabase.getDsSK_HU();
        ArrayList<HashMap> DsSK_DK = Model.GameDatabase.getDsSK_DK();
        ArrayList<HashMap> DsSK_NV = Model.GameDatabase.getDsSK_NV();
        for (HashMap SK : DsSK) {
            String MaSK = (String) SK.get("MaSK");
            ArrayList<LuaChon> DsLC = new ArrayList<>();
            ArrayList<HieuUng> DsHU = new ArrayList<>();
            ArrayList<DieuKien> DsDK = new ArrayList<>();
            ArrayList<NhanVat> DsDTTG = new ArrayList<>();
            for (HashMap SK_LC : DsSK_LC) {
                if (SK_LC.get("MaMSK").equals(MaSK)) {
                    DsLC.add(Model.ModelLuaChon.getLuaChon((String) SK_LC.get("MaMLC")));
                }
            }
            for (HashMap SK_HU : DsSK_HU) {
                if (SK_HU.get("MaMSK").equals(MaSK)) {
                    HieuUng hu = Model.ModelHieuUng.getHieuUng((String) SK_HU.get("MaHU"));
                    if (hu != null) {
                        DsHU.add(hu);
                    }
                }
            }
            for (HashMap SK_DK : DsSK_DK) {
                if (SK_DK.get("MaMSK").equals(MaSK)) {
                    DieuKien dk = Model.ModelDieuKien.getDieuKien((String) SK_DK.get("MaDK"));
                    if (dk != null) {
                        DsDK.add(dk);
                    }
                }
            }
//            for (HashMap SK_NV : DsSK_NV) {
//                if (SK_NV.get("MaMSK").equals(MaSK)) {
//                    DsDTTG.add(Modal.ModalNhanVat.getNhanVat((String) SK_NV.get("MaNN")));
//                }
//            }
            SuKien temp = new SuKien(
                    MaSK,
                    (String) SK.get("TenSK"),
                    (String) SK.get("MoTa"),
                    (String) SK.get("TomTat"),
                    DsLC,
                    DsHU,
                    DsDK,
                    DsDTTG,
                    null,
                    (String) SK.get("LoaiDTTG"),
                    Integer.parseInt((String) SK.get("SLTG")),
                    Integer.parseInt((String) SK.get("ThoiHan")),
                    (String) SK.get("LoaiSK"),
                    Double.parseDouble((String) SK.get("TLXH")),
                    false
            );
            // Thêm vào Ds Sự kiện
            // ********
            dsSK.add(temp);
        }
    }

    public static SuKien getMauSuKien(String maSK) {
        ArrayList<SuKien> toanBoSuKien = (ArrayList<SuKien>) dsSK.clone();

        for (SuKien sk : toanBoSuKien) {
            if (sk.getMaSK().equals(maSK)) {
                return sk.cloneSK();
            }
        }
        return null;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienTheGioi() {
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        for (SuKien sk : dsSK) {
            if ("BOICANH".equals(sk.getLoaiSK()) || "THEGIOI".equals(sk.getLoaiSK())) {
                result.add(sk);
            }
        }
        return result;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienQuocGia() {
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        for (SuKien sk : dsSK) {
            if ("BOICANH".equals(sk.getLoaiSK()) || "QUOCGIA".equals(sk.getLoaiSK())) {
                result.add(sk);
            }
        }
        return result;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienTinh() {
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        for (SuKien sk : dsSK) {
            if ("BOICANH".equals(sk.getLoaiSK()) || "TINH".equals(sk.getLoaiSK())) {
                result.add(sk);
            }
        }
        return result;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienHangNam() {
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        for (SuKien sk : dsSK) {
            if ("HANGNAM".equals(sk.getLoaiSK())) {
                result.add(sk);
            }
        }
        return result;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienTuyBien() {
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        for (SuKien sk : dsSK) {
            if ("TUYBIEN".equals(sk.getLoaiSK())) {
                result.add(sk);
            }
        }
        return result;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienKyVong() {
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        for (SuKien sk : dsSK) {
            if ("KYVONG".equals(sk.getLoaiSK())) {
                result.add(sk);
            }
        }
        return result;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienUocMo() {
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        for (SuKien sk : dsSK) {
            if ("UOCMO".equals(sk.getLoaiSK())) {
                result.add(sk);
            }
        }
        return result;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienKeHoach() {
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        for (SuKien sk : dsSK) {
            if ("KEHOACH".equals(sk.getLoaiSK())) {
                result.add(sk);
            }
        }
        return result;
    }

    static public ArrayList<SuKien> suKienHeQua() {
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        for (SuKien sk : dsSK) {
            if ("HEQUA".equals(sk.getLoaiSK())) {
                result.add(sk);
            }
        }
        return result;
    }

}
