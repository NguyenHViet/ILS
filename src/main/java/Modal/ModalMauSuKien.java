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
//    Sự kiện hằng năm
    private static ArrayList<SuKien> dsSKHN = new ArrayList<>();
//    Sự kiện tùy biến
    private static ArrayList<SuKien> dsSKTB = new ArrayList<>();
//    Danh sách kỳ vọng
    private static ArrayList<SuKien> dsKV = new ArrayList<>();
//    Danh sách hệ quả
    private static ArrayList<SuKien> dsHQ = new ArrayList<>();

    public static void taiMauSuKien() {
        dsSKBC = new ArrayList<SuKien>();
//        Sự kiện thử nghiệm
        DieuKien dk0000 = Modal.ModalDieuKien.getDieuKien("0000");
        DieuKien dk0001 = Modal.ModalDieuKien.getDieuKien("0001");
        DieuKien dk0002 = Modal.ModalDieuKien.getDieuKien("0002");
        DieuKien dk0003 = Modal.ModalDieuKien.getDieuKien("0003");
        DieuKien dk0004 = Modal.ModalDieuKien.getDieuKien("0004");
        DieuKien dk0005 = Modal.ModalDieuKien.getDieuKien("0005");
        DieuKien dk0006 = Modal.ModalDieuKien.getDieuKien("0006");

        LuaChon lc0000 = Modal.ModalLuaChon.getLuaChon("0000");
        LuaChon lc0001 = Modal.ModalLuaChon.getLuaChon("0001");
        LuaChon lc0002 = Modal.ModalLuaChon.getLuaChon("0002");

        HieuUng hu0000 = Modal.ModalHieuUng.getHieuUng("0000");
        HieuUng hu0001 = Modal.ModalHieuUng.getHieuUng("0001");
        HieuUng hu0002 = Modal.ModalHieuUng.getHieuUng("0002");
        HieuUng hu0003 = Modal.ModalHieuUng.getHieuUng("0003");

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
                "Không có chuyện gì đặc sắc, mọi chuyện trôi qua bình an.",
                null,
                null,
                null,
                null,
                null,
                "BOICANH",
                0,
                0,
                "BOICANH",
                0.99,
                false);

        SuKien sk0001 = new SuKien("0001",
                "TÀI NGUYÊN KHAN HIẾM",
                "Các nước bắt đầu cạnh tranh khốc liệt để dành làm chủ lượng tài ít ỏi còn lại. Lượng tài nguyên ít ỏi bị chia nhỏ, tình hình chính trị trở nên căng thẳng.",
                "Các nước tranh giành nhau vì tài nguyên ít ỏi làm tình hình căng thẳng.",
                dsLC,
                null,
                (ArrayList<DieuKien>) dsDK.clone(),
                null,
                null,
                "MC",
                0,
                0,
                "BOICANH",
                1,
                false);

        dsDK.clear();
        dsDK.add(dk0000);

        SuKien sk0002 = new SuKien("0002",
                "CẢM THẤY MỆT MỎI",
                "Vì sức khỏe yếu, tài nguyên khan hiếm khiến bạn càng thiếu thốn dinh dưỡng.",
                "Bạn thấy sức khỏe của bản thân yếu đi.",
                null,
                (ArrayList<HieuUng>) dsHU.clone(),
                null,
                null,
                null,
                "MC",
                0,
                0,
                "HEQUA",
                1,
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
                "Bạn thấy buồn vì cha mẹ không doái hoài gì đến bạn.",
                null,
                (ArrayList<HieuUng>) dsHU.clone(),
                (ArrayList<DieuKien>) dsDK.clone(),
                null,
                null,
                "GIADINH",
                0,
                0,
                "SUKIEN",
                1,
                false);

        dsDK.clear();
        dsDK.add(dk0005);

        dsHU.clear();
        dsHU.add(hu0003);

        SuKien sk0004 = new SuKien("0004",
                "ĐI NHẶT ĐÁ",
                "Bạn cảm thấy chán, nên bạn đi ra ngoài chơi và nhặt được 1 cục đá.",
                "Bạn nhặt được cục đá",
                null,
                (ArrayList<HieuUng>) dsHU.clone(),
                (ArrayList<DieuKien>) dsDK.clone(),
                null,
                null,
                "MC",
                0,
                0,
                "HANGNAM",
                1,
                false);

        dsDK.clear();
        dsDK.add(dk0006);

        SuKien sk0005 = new SuKien("0005",
                "SỐNG KHỞE",
                "Bạn đã sống được 5 năm.",
                "Bạn đã thành công lên 5 tuổi.",
                null,
                null,
                (ArrayList<DieuKien>) dsDK.clone(),
                null,
                null,
                "MC",
                0,
                5,
                "UOCMO",
                1,
                false);

        dsSKBC.add(sk0000);
        dsSKBC.add(sk0001);
        dsHQ.add(sk0002);
        dsSKHN.add(sk0003);
        dsSKHN.add(sk0004);
        dsKV.add(sk0005);
    }

    public static SuKien getMauSuKien(String maSK) {
        ArrayList<SuKien> toanBoSuKien = new ArrayList<SuKien>(dsSKBC);
        toanBoSuKien.addAll(dsSKTG);
        toanBoSuKien.addAll(dsSKQG);
        toanBoSuKien.addAll(dsSKT);
        toanBoSuKien.addAll(dsSKHN);
        toanBoSuKien.addAll(dsSKTB);
        toanBoSuKien.addAll(dsKV);
        toanBoSuKien.addAll(dsHQ);

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
    static public ArrayList<SuKien> suKienHangNam() {
        return dsSKHN;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienTuyBien() {
        // TODO implement here
        return dsSKTB;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> suKienKyVong() {
        // TODO implement here
        return dsKV;
    }

}
