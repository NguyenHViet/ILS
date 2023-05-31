/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GameObject.NhanVat;
import java.util.ArrayList;

/**
 *
 * @author vuvuive
 */
public class ModelNhanVat {

    private static ArrayList<NhanVat> dsNhanVat = new ArrayList<NhanVat>();

    public static void themNhanVat(NhanVat nv) {
        dsNhanVat.add(nv);
    }

    public static ArrayList<NhanVat> getDSNhanVat() {
        return dsNhanVat;
    }

    public static NhanVat getNhanVat(String maNV) {
        NhanVat result = null;
        for (NhanVat nv : dsNhanVat) {
            if (nv.getMaNV().equals(maNV)) {
                result = nv.cloneNV();
                break;
            }
        }
        return result;
    }

    public static String maNhanVatMoi() {
        String maNV = "0000" + dsNhanVat.size();
        return maNV.substring(maNV.length() - 4, maNV.length());
    }

}
