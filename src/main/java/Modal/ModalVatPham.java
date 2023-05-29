/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import GameObject.*;
import java.util.ArrayList;

/**
 *
 * @author vuvuive
 */
public class ModalVatPham {

    private static ArrayList<VatPham> dsVatPham = new ArrayList<>();

    public static void taiVatPham() {
//        Tạo vật phẩm thử nghiệm
        VatPham vp0000 = new VPTieuHao(
                "0000",
                "Cục đá",
                "NGUYENLIEU",
                "Cục đá vô tri. Có thể dùng để chọi cái một gì đó. Chó chẳng hạn... Thật là một thú vui tao nhã.",
                null,
                0,
                null
        );
        
        dsVatPham.add(vp0000);
    }

    public static void themVatPham(VatPham vp) {
        dsVatPham.add(vp);
    }

    public static ArrayList<VatPham> getDSVatPham() {
        return dsVatPham;
    }

    public static VatPham getVatPham(String maVP) {
        VatPham result = null;
        for (VatPham vp : dsVatPham) {
            if (vp.getMaVP().equals(maVP)) {
                result = vp.cloneVP();
                break;
            }
        }
        return result;
    }

    public static String maVatPhamMoi() {
        String maNV = "0000" + dsVatPham.size();
        return maNV.substring(maNV.length() - 4, maNV.length());
    }
}
