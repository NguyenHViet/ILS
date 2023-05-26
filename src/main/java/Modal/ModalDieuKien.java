/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import GameEvent.*;
import java.util.ArrayList;

/**
 *
 * @author vuvuive
 */
public class ModalDieuKien {

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
                DK_SoSanh.NHO_HON_HOAC_BANG);

        DieuKien dk0001 = new DK_SoSanh(
                "0001",
                false,
                1,
                "Sức khỏe yếu",
                "STR",
                20,
                "NHANVAT",
                DK_SoSanh.NHO_HON_HOAC_BANG);

        DieuKien dk0002 = new DK_SoSanh(
                "0002",
                false,
                1,
                "Tâm lý yếu",
                "MNT",
                20,
                "NHANVAT",
                DK_SoSanh.NHO_HON_HOAC_BANG);

        DieuKien dk0003 = new DK_ThanThiet(
                "0003",
                true,
                1,
                "Ba không thương",
                "",
                "Cha",
                "GIADINH",
                100,
                100
        );
        
        DieuKien dk0004 = new DK_ThanThiet(
                "0004",
                true,
                1,
                "Mẹ không yêu",
                "",
                "Mẹ",
                "GIADINH",
                100,
                100
        );

        dsDieuKien.add(dk0000);
        dsDieuKien.add(dk0001);
        dsDieuKien.add(dk0002);
        dsDieuKien.add(dk0003);
        dsDieuKien.add(dk0004);
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
                break;
            }
        }
        return result;
    }

    public static String maDieuKienMoi() {
        String maNV = "0000" + dsDieuKien.size();
        return maNV.substring(maNV.length() - 4, maNV.length());
    }
}
