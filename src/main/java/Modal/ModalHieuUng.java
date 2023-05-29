/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import GameEvent.*;
import java.util.*;

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
        ArrayList<HashMap> DsHieuUng = Modal.GameDatabase.getDsHieuUng();
        ArrayList<DieuKien> DsDK = Modal.ModalDieuKien.getDSDieuKien();
        ArrayList<HashMap> DsDK_HU = Modal.GameDatabase.getDsDK_HU();
        ArrayList<HashMap> DsHU_TT = Modal.GameDatabase.getDsHU_TT();
        ArrayList<HashMap> DsHU_QH = Modal.GameDatabase.getDsHU_QH();
        ArrayList<HashMap> DsHU_VP = Modal.GameDatabase.getDsHU_VP();
        
        for(HashMap HU: DsHieuUng){
            String MaHU = (String) HU.get("MaHU");
            ArrayList<DieuKien> DsHU_DK = new ArrayList<>();
            for(HashMap DK_HU: DsDK_HU){
                if(DK_HU.get("MaHU").equals(MaHU)){
                    DsHU_DK.add(Modal.ModalDieuKien.getDieuKien((String) DK_HU.get("MaDK")));
                }
            }
            switch ((String) HU.get("LoaiHU")){
                case "THUOCTINH":
                    for(HashMap HU_TT: DsHU_TT){
                        if(HU_TT.get("MaHU").equals(MaHU)){
                            HieuUng temp = new HU_ThuocTinh(
                                    MaHU,
                                    (String) HU.get("MoTa"),
                                    DsHU_DK,
                                    (String) HU_TT.get("MaTT"),
                                    Integer.parseInt((String) HU_TT.get("GiaTriTang")),
                                    Integer.parseInt((String) HU_TT.get("TLTang")),
                                    0,
                                    0
                            );
                            Modal.ModalHieuUng.dsHieuUng.add(temp);
                        }
                    }
                    break;
                case "QUANHE":
                    for(HashMap HU_QH: DsHU_QH){
                        if(HU_QH.get("MaHU").equals(MaHU)){
                            HieuUng temp = new HU_QuanHe(
                                    MaHU,
                                    (String) HU.get("MoTa"),
                                    DsHU_DK,
                                    (String) HU_QH.get("MaNV"),
                                    (String) HU_QH.get("QuanHe"),
                                    "",
                                    "",
                                    Integer.parseInt((String) HU_QH.get("ThanThiet")),
                                    Integer.parseInt((String) HU_QH.get("TinTuong"))
                            );
                            Modal.ModalHieuUng.dsHieuUng.add(temp);
                        }
                    }
                    break;
                case "VATPHAM":
                    for(HashMap HU_VP: DsHU_VP){
                        if(HU_VP.get("MaHU").equals(MaHU)){
                            HieuUng temp = new HU_VatPham(
                                    MaHU,
                                    (String) HU.get("MoTa"),
                                    DsHU_DK,
                                    (String) HU_VP.get("MaVP"),
                                    Integer.parseInt((String) HU_VP.get("SoLuong")),
                                    (boolean) HU_VP.get("SuDung")
                            );
                            Modal.ModalHieuUng.dsHieuUng.add(temp);
                        }
                    }
                default:
                    System.out.println("ERROR");
            }
        }
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
