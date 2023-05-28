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

    static private ArrayList<SuKien> dsSKLauDai = new ArrayList<SuKien>();

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
        ArrayList<SuKien> dsSKDuBi = new ArrayList<>();
        ArrayList<SuKien> result = new ArrayList<>();
        double lucky = new Random().nextDouble();

        for (SuKien mauSK : dsMauSK) {
            SuKien sk = GameSystem.GeneratorSystem.taoSuKien(mauSK, nguoiChoi, dsNV, tg);
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
        int SoLuongSKTGToiDa = 1;
        ArrayList<SuKien> dsSKTG = chuanBiSuKienTiepTheo(Modal.ModalMauSuKien.suKienTheGioi(), SoLuongSKTGToiDa);
        MainSystem.dsSKHienTai.addAll(dsSKTG);
//        Sự kiện quốc gia
//        Sự kiện tỉnh
//        Sự kiện hằng năm
        int SoLuongSKHNToiDa = 1;
        ArrayList<SuKien> dsSKHN = chuanBiSuKienTiepTheo(Modal.ModalMauSuKien.suKienHangNam(), SoLuongSKHNToiDa);
        MainSystem.dsSKHienTai.addAll(dsSKHN);
//        Sự kiện tùy biến
    }

    /**
     * @param luaChon
     */
    static public void xuLySuKienHienTai(LuaChon luaChon) {
        luaChon.kichHoat();
        ArrayList<String> nextEvent = luaChon.getDSSK();
        // Xóa sự kiện hiện tại
        if (!MainSystem.dsSKHienTai.isEmpty()) {
            dsSKHienTai.remove(0);
        }
        // Thêm sự kiện tiếp theo
        ArrayList<SuKien> dsSuKienTiepTheo = new ArrayList<>();
        ArrayList<SuKien> dsSK = new ArrayList<>();
        if (nextEvent != null) {
            for (String maSK : nextEvent) {
                SuKien mauSK = Modal.ModalMauSuKien.getMauSuKien(maSK);
                dsSuKienTiepTheo.add(GameSystem.GeneratorSystem.taoSuKien(mauSK, nguoiChoi, dsNV, tg));
            }
            dsSK.addAll(0, chuanBiSuKienTiepTheo(dsSuKienTiepTheo, 100));
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

    static public void suKienKhanCap(SuKien sk) {
        dsSKHienTai.add(0, sk);
    }

    /**
     */
    static public void suKienNamKeTiep() {
        MainSystem.dsSKHienTai.clear();
        for (SuKien sk : MainSystem.dsSKLauDai) {
            sk.demNguocThoiHan();
            if (sk.getThoiHan() == 0) {
                MainSystem.dsSKHienTai.add(sk);
            }
        }
        MainSystem.taoSuKien();
        MainSystem.suKienHienTai = MainSystem.dsSKHienTai.get(0);
    }

    static public void nhanVatPhatTrien() {
        MainSystem.nguoiChoi.phatTrien();
        for (NhanVat npc : MainSystem.dsNV) {
            npc.phatTrien();
        }
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
     * @param maNV
     * @return
     */
    static public NhanVat getNhanVat(String maNV) {
        ArrayList<NhanVat> ds = (ArrayList<NhanVat>) dsNV.clone();
        ds.add(nguoiChoi);
        NhanVat result = null;
        for (NhanVat nv : ds) {
            if (nv.getMaNV().equals(maNV)) {
                result = nv;
                break;
            }
        }
        return result;
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
