/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import GameEvent.DieuKien;
import GameEvent.HieuUng;
import GameEvent.LuaChon;
import GameEvent.SuKien;
import GameObject.NhanVat;
import GameSystem.GeneratorSystem;
import java.util.ArrayList;

/**
 *
 * @author vuvuive
 */
public class ModalMauSuKien {

//    Sự kiện bối cảnh chung
    private static ArrayList<SuKien> dsSKBC = new ArrayList<>();
//    Sự kiện thế giới
    private static ArrayList<SuKien> dsSKTG = new ArrayList<>();
//    Sự kiện quốc gia
    private static ArrayList<SuKien> dsSKQG = new ArrayList<>();
//    Sự kiện tỉnh
    private static ArrayList<SuKien> dsSKT = new ArrayList<>();
//    Sự kiện thông thường
    private static ArrayList<SuKien> dsSKTT = new ArrayList<>();
//    Sự kiện tùy biến
    private static ArrayList<SuKien> dsSKTB = new ArrayList<>();
//    Danh sách kỳ vọng
    private static ArrayList<SuKien> dsKV = new ArrayList<>();

    public static void taiMauSuKien() {
        dsSKBC = new ArrayList<SuKien>();
//        Sự kiện thử nghiệm
        DieuKien dk0000 = Modal.ModalDieuKien.getDieuKien("0000");
        
        LuaChon lc0000 = Modal.ModalLuaChon.getLuaChon("0000");
        LuaChon lc0001 = Modal.ModalLuaChon.getLuaChon("0001");
        LuaChon lc0002 = Modal.ModalLuaChon.getLuaChon("0002");
        
        HieuUng hu0000 = Modal.ModalHieuUng.getHieuUng("0000");

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
                "SUKIEN_BOICANH",
                0.99,
                false);

        SuKien sk0001 = new SuKien("0001",
                "TÀI NGUYÊN KHAN HIẾM",
                "Các nước bắt đầu cạnh tranh khốc liệt để dành làm chủ lượng tài ít ỏi còn lại. Lượng tài nguyên ít ỏi bị chia nhỏ, tình hình chính trị trở nên căng thẳng.",
                "",
                dsLC,
                null,
                dsDK,
                null,
                null,
                "MC",
                0,
                0,
                "SUKIEN_BOICANH",
                1,
                false);
        
        dsDK.clear();
        dsDK.add(dk0000);
        
        SuKien sk0002 = new SuKien("0002",
                "CẢM THẤY MỆT MỎI",
                "Vì sức khỏe yếu, tài nguyên khan hiếm khiến bạn càng thiếu thốn dinh dưỡng.",
                "",
                null,
                dsHU,
                null,
                null,
                null,
                "MC",
                0,
                0,
                "SUKIEN_BOICANH",
                1,
                false);

        dsSKBC.add(sk0000);
        dsSKBC.add(sk0001);
        dsSKTT.add(sk0002);
    }

    public static SuKien getMauSuKien(String maSK) {
        ArrayList<SuKien> toanBoSuKien = new ArrayList<SuKien>(dsSKBC);
        toanBoSuKien.addAll(dsSKTG);
        toanBoSuKien.addAll(dsSKQG);
        toanBoSuKien.addAll(dsSKT);
        toanBoSuKien.addAll(dsSKTT);
        toanBoSuKien.addAll(dsSKTB);

        for (SuKien sk : toanBoSuKien) {
            if (sk.getMaSK().equals(maSK)) {
                return sk;
            }
        }
        return null;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienTheGioi() {
        ArrayList<SuKien> result = new ArrayList<SuKien>(dsSKBC);
        result.addAll(dsSKTG);
        return result;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienQuocGia() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienTinh() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienNV() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienTuyBien() {
        // TODO implement here
        return null;
    }

}
