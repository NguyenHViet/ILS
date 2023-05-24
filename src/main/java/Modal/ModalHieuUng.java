/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import GameEvent.HieuUng;
import java.util.ArrayList;

/**
 *
 * @author vuvuive
 */
public class ModalHieuUng {
    private static ArrayList<HieuUng> dsHieuUng = new ArrayList<HieuUng>();

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
