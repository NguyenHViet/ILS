/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GameEvent.*;
import java.util.*;

/**
 *
 * @author vuvuive
 */
public class ModelDieuKien {

    private static ArrayList<DieuKien> dsDieuKien = new ArrayList<DieuKien>();

    public static void taiDieuKien() {
//        Tạo điều kiện thử nghiệm
        DieuKien dk0000 = new DK_SoSanh(
                "0000",
                false,
                0,
                "Tài nguyên khan hiếm",
                "RSC",
                20,
                "BOICANH",
                DK_SoSanh.NHO_HON_HOAC_BANG
        );

        DieuKien dk0001 = new DK_SoSanh(
                "0001",
                false,
                1,
                "Sức khỏe yếu",
                "STR",
                20,
                "NHANVAT",
                DK_SoSanh.NHO_HON_HOAC_BANG
        );

        DieuKien dk0002 = new DK_SoSanh(
                "0002",
                false,
                1,
                "Tâm lý yếu",
                "MNT",
                20,
                "NHANVAT",
                DK_SoSanh.NHO_HON_HOAC_BANG
        );

        DieuKien dk0003 = new DK_ThanThiet(
                "0003",
                true,
                1,
                "Ba không thương",
                "",
                "Cha",
                "GIADINH",
                20,
                50
        );

        DieuKien dk0004 = new DK_ThanThiet(
                "0004",
                true,
                1,
                "Mẹ không yêu",
                "",
                "Mẹ",
                "GIADINH",
                20,
                50
        );

        DieuKien dk0005 = new DK_SoHuuVP(
                "0005",
                true,
                1,
                "Không có một cục đá",
                "0000",
                "NGUYENLIEU",
                1,
                "NHANVAT"
        );

        DieuKien dk0006 = new DK_SoSanh(
                "0006",
                false,
                1,
                "Lớn lên",
                "AGE",
                2,
                "NHANVAT",
                DK_SoSanh.LON_HON
        );

        dsDieuKien.add(dk0000);
        dsDieuKien.add(dk0001);
        dsDieuKien.add(dk0002);
        dsDieuKien.add(dk0003);
        dsDieuKien.add(dk0004);
        dsDieuKien.add(dk0005);
        dsDieuKien.add(dk0006);

        ArrayList<HashMap> DsDieuKien = Model.GameDatabase.getDsDieuKien();
        ArrayList<HashMap> DsDK_HU = Model.GameDatabase.getDsDK_HU();
        ArrayList<HashMap> DsDK_QH = Model.GameDatabase.getDsDK_QH();
        ArrayList<HashMap> DsDK_TT = Model.GameDatabase.getDsDK_TT();
        ArrayList<HashMap> DsDK_VP = Model.GameDatabase.getDsDK_VP();

        for (HashMap DK : DsDieuKien) {
            String MaDK = (String) DK.get("MaDK");
            System.out.println("Load object DieuKien with maDK = " + MaDK);
            int SLDTT = -1;
            if (DK.get("SLDTT") != null) {
                SLDTT = Integer.parseInt((String) DK.get("SLDTT"));
            }
            switch ((String) DK.get("LoaiDK")) {
                case "THUOCTINH":
                    for (HashMap DK_TT : DsDK_TT) {
                        if (DK_TT.get("MaDK").equals(MaDK)) {
                            DK_SoSanh temp = new DK_SoSanh(
                                    MaDK,
                                    Boolean.parseBoolean((String) DK_TT.get("IsNot")),
                                    SLDTT,
                                    (String) DK.get("MoTa"),
                                    (String) DK_TT.get("MaTT"),
                                    Integer.parseInt((String) DK_TT.get("GTSS")),
                                    (String) DK_TT.get("LoaiDT"),
                                    (String) DK_TT.get("LoaiSS")
                            );
                            ModelDieuKien.dsDieuKien.add(temp);
                        }
                    }
                    break;
                case "QUANHE":
                    for (HashMap DK_QH : DsDK_QH) {
                        if (DK_QH.get("MaDK").equals(MaDK)) {
                            DK_ThanThiet temp = new DK_ThanThiet(
                                    MaDK,
                                    Boolean.parseBoolean((String) DK_QH.get("IsNot")),
                                    SLDTT,
                                    (String) DK.get("MoTa"),
                                    "",
                                    (String) DK_QH.get("LoaiQH"),
                                    (String) DK_QH.get("VongQH"),
                                    Integer.parseInt((String) DK_QH.get("ThanThiet")),
                                    Integer.parseInt((String) DK_QH.get("TinTuong"))
                            );
                            ModelDieuKien.dsDieuKien.add(temp);
                        }
                    }
                    break;
                case "VATPHAM":
                    for (HashMap DK_VP : DsDK_VP) {
                        if (DK_VP.get("MaDK").equals(MaDK)) {
                            DK_SoHuuVP temp = new DK_SoHuuVP(
                                    MaDK,
                                    Boolean.parseBoolean((String) DK_VP.get("IsNot")),
                                    SLDTT,
                                    (String) DK.get("MoTa"),
                                    (String) DK_VP.get("MaVP"),
                                    (String) DK_VP.get("LoaiVP"),
                                    Integer.parseInt((String) DK_VP.get("SoLuong")),
                                    (String) DK_VP.get("LoaiDT")
                            );
                            ModelDieuKien.dsDieuKien.add(temp);
                        }
                    }
                    break;
                default:
                    System.out.println("ERROR: loaiDK = " + (String) DK.get("LoaiDK") + " not exsist" );
            }
        }
    }

    public static void themDieuKien(DieuKien dk) {
        dsDieuKien.add(dk);
    }

    public static ArrayList<DieuKien> getDSDieuKien() {
        return dsDieuKien;
    }

    public static DieuKien getDieuKien(String maDK) {
        DieuKien result = null;
        for (DieuKien dk : dsDieuKien) {
            if (dk.getMaDK().equals(maDK)) {
                result = dk.cloneDK();
                return result;
            }
        }
        System.out.println("Not found DieuKien with maDK = " + maDK);
        return result;
    }

    public static String maDieuKienMoi() {
        String maNV = "0000" + dsDieuKien.size();
        return maNV.substring(maNV.length() - 4, maNV.length());
    }
}
