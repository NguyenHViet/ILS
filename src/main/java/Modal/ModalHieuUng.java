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
public class ModalHieuUng {

    private static ArrayList<HieuUng> dsHieuUng = new ArrayList<HieuUng>();

    public static void taiHieuUng() {
//        Tạo điều kiện thử nghiệm
        HieuUng hu0000 = new HU_ThuocTinh(
                "0000",
                "Giảm sức khỏe",
                null,
                "STR",
                -10,
                0,
                0,
                0
        );

        HieuUng hu0001 = new HU_QuanHe(
                "0001",
                "Giảm thân thiết với cha",
                null,
                "",
                "Cha",
                "",
                "",
                -10,
                -5
        );
        
        HieuUng hu0002 = new HU_QuanHe(
                "0002",
                "Giảm thân thiết với mẹ",
                null,
                "",
                "Mẹ",
                "",
                "",
                -10,
                -5
        );
        
        HieuUng hu0003 = new HU_VatPham(
                "0003",
                "Nhặt được cục đá",
                null,
                "0000",
                1,
                false
        );

        dsHieuUng.add(hu0000);
        dsHieuUng.add(hu0001);
        dsHieuUng.add(hu0002);
        dsHieuUng.add(hu0003);
    }

    public static void themHieuUng(HieuUng hu) {
        dsHieuUng.add(hu);
    }

    public static ArrayList<HieuUng> getDSHieuUng() {
        return dsHieuUng;
    }

    public static HieuUng getHieuUng(String maHU) {
        HieuUng result = null;
        for (HieuUng hu : dsHieuUng) {
            if (hu.getMaHU().equals(maHU)) {
                result = hu.cloneHU();
                break;
            }
        }
        return result;
    }

    public static String maHieuUngMoi() {
        String maNV = "0000" + dsHieuUng.size();
        return maNV.substring(maNV.length() - 4, maNV.length());
    }

}
