/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import GameEvent.DieuKien;
import GameEvent.LuaChon;
import java.util.ArrayList;

/**
 *
 * @author vuvuive
 */
public class ModalLuaChon {

    private static ArrayList<LuaChon> dsLuaChon = new ArrayList<LuaChon>();

    public static void taiLuaChon() {
//        Tạo lựa chọn thử nghiệm
        DieuKien dk0001 = Modal.ModalDieuKien.getDieuKien("0001");
        DieuKien dk0002 = Modal.ModalDieuKien.getDieuKien("0002");

        ArrayList<DieuKien> dsDK = new ArrayList<>();
        ArrayList<String> nextEvent = new ArrayList<>();

        dsDK.add(dk0001);

        nextEvent.add("0002");

        LuaChon lc0000 = new LuaChon(
                "0000",
                "Thật tuyệt vời",
                null,
                null,
                "NONE",
                0,
                null,
                null
        );

        LuaChon lc0001 = new LuaChon(
                "0001",
                "Thật tồi tệ!",
                nextEvent,
                dsDK,
                "MC",
                1,
                null,
                null
        );

        ArrayList<DieuKien> dsDK1 = new ArrayList<>();
        dsDK1.add(dk0002);

        LuaChon lc0002 = new LuaChon(
                "0002",
                "Thật đáng sợ",
                null,
                dsDK1,
                "MC",
                1,
                null,
                null
        );

        dsLuaChon.add(lc0000);
        dsLuaChon.add(lc0001);
        dsLuaChon.add(lc0002);
    }

    public static void themLuaChon(LuaChon dk) {
        dsLuaChon.add(dk);
    }

    public static ArrayList<LuaChon> getDSLuaChon() {
        return dsLuaChon;
    }

    public static LuaChon getLuaChon(String maDK) {
        LuaChon result = null;
        for (LuaChon lc : dsLuaChon) {
            if (lc.getMaLC().equals(maDK)) {
                result = lc.cloneLC();
                break;
            }
        }
        return result;
    }

    public static String maLuaChonMoi() {
        String maNV = "0000" + dsLuaChon.size();
        return maNV.substring(maNV.length() - 4, maNV.length());
    }
}
