package GameSystem;

import GameEvent.*;
import GameObject.*;
import WorldBuilder.*;
import SupportClass.*;
import GUI.*;
import java.io.IOException;
import java.util.*;

/**
 *
 */
public class MainSystem {

    /**
     *
     */
    static private TheGioi tg = new TheGioi();

    /**
     *
     */
    static private ArrayList<NhanVat> dsNV = new ArrayList<NhanVat>();

    /**
     *
     */
    static private NhanVat nguoiChoi = new NhanVat();

    /**
     *
     */
    static private ArrayList<SuKien> dsSKHienTai = new ArrayList<SuKien>();

    private static SuKien suKienHienTai;

    static private ArrayList<SuKien> dsSKLauDai;

    /**
     * Get the value of suKienHienTai
     *
     * @return the value of suKienHienTai
     */
    public static SuKien getSuKienHienTai() {
        return suKienHienTai;
    }

    /**
     * Set the value of suKienHienTai
     *
     * @param suKienHienTai new value of suKienHienTai
     */
    public static void setSuKienHienTai(SuKien suKienHienTai) {
        MainSystem.suKienHienTai = suKienHienTai;
    }

    /**
     * Get the value of dsSKLauDai
     *
     * @return the value of dsSKLauDai
     */
    public ArrayList<SuKien> getDsSKLauDai() {
        return dsSKLauDai;
    }

    /**
     * Set the value of dsSKLauDai
     *
     * @param dsSKLauDai new value of dsSKLauDai
     */
    public void setDsSKLauDai(ArrayList<SuKien> dsSKLauDai) {
        MainSystem.dsSKLauDai = dsSKLauDai;
    }

    static private ArrayList<SuKien> chuanBiSuKienTiepTheo(ArrayList<SuKien> dsMauSK, int soLuongSKToiDa) {
        ArrayList<SuKien> dsSKDuBi = new ArrayList<SuKien>();
        ArrayList<SuKien> result = new ArrayList<SuKien>();
        double lucky = new Random().nextDouble();

        for (SuKien mauSK : dsMauSK) {
            SuKien sk = GameSystem.GeneratorSystem.taoSuKien(mauSK, nguoiChoi, tg);
            if (lucky <= sk.getTyLeXuatHien()) {
                if (sk.kiemTraDK()) {
                    if (sk.getTyLeXuatHien() == 1.0) {
                        result.add(sk);
                    } else {
                        dsSKDuBi.add(sk);
                    }
                }
            }
        }

        for (int i = 0; i < soLuongSKToiDa && i < dsSKDuBi.size(); i++) {
            int index = new Random().nextInt(dsSKDuBi.size());
            result.add(dsSKDuBi.get(index));
            dsSKDuBi.remove(index);
        }

        return result;
    }

    /**
     */
    static public void taoSuKien() {
//        Sự kiện thế giới
        int SoLuongSKTGToiDa = 3;
        ArrayList<SuKien> dsSKTG = chuanBiSuKienTiepTheo(Modal.ModalMauSuKien.suKienTheGioi(), SoLuongSKTGToiDa);
        MainSystem.dsSKHienTai.addAll(dsSKTG);
//        Sự kiện quốc gia
//        Sự kiện tỉnh
//        Sự kiện hằng năm
//        Sự kiện tùy biến
    }

    /**
     */
    static public void xuLySuKienHienTai(LuaChon luaChon) {
        luaChon.kichHoat();
        ArrayList<String> nextEvent = luaChon.getDSSK();
        // Xóa sự kiện hiện tại
        if (!MainSystem.dsSKHienTai.isEmpty()) {
            dsSKHienTai.remove(0);
        }
        // Thêm sự kiện tiếp theo
        ArrayList<SuKien> dsSuKienTiepTheo = new ArrayList<SuKien>();
        ArrayList<SuKien> dsSK = new ArrayList<SuKien>();
        if (nextEvent != null) {
            for (String maSK : nextEvent) {
                SuKien mauSK = Modal.ModalMauSuKien.getMauSuKien(maSK);
                dsSuKienTiepTheo.add(GameSystem.GeneratorSystem.taoSuKien(mauSK, nguoiChoi, tg));
            }
            dsSK.addAll(chuanBiSuKienTiepTheo(dsSuKienTiepTheo, 100));
        }
        MainSystem.dsSKHienTai.addAll(dsSK);
        if (!MainSystem.dsSKHienTai.isEmpty()) {
            MainSystem.suKienHienTai = MainSystem.dsSKHienTai.get(0);
        } else {
            MainSystem.suKienHienTai = null;
        }
    }

    static public void kichHoatSuKienHienTai() {
        MainSystem.suKienHienTai.kichHoat();
    }

    /**
     */
    static public void suKienNamKeTiep() {
        MainSystem.taoSuKien();
        MainSystem.suKienHienTai = MainSystem.dsSKHienTai.get(0);
    }

    /**
     * @return
     */
    static public TheGioi getTG() {
        return tg;
    }

    /**
     * @return
     */
    static public ArrayList<NhanVat> getDSNV() {
        return dsNV;
    }

    /**
     * @return
     */
    static public NhanVat getNguoiChoi() {
        // TODO implement here
        return nguoiChoi;
    }

    /**
     * @return
     */
    static public ArrayList<SuKien> getDSSKHienTai() {
        return dsSKHienTai;
    }

    /**
     * @param tg
     */
    static public void setTG(TheGioi tg) {
        MainSystem.tg = tg;
    }

    /**
     * @param dsNV
     */
    static public void setDSNV(ArrayList<NhanVat> dsNV) {
        MainSystem.dsNV = dsNV;
    }

    /**
     * @param nguoiChoi
     */
    static public void setNguoiChoi(NhanVat nguoiChoi) {
        MainSystem.nguoiChoi = nguoiChoi;
    }

}
