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

    static private ArrayList<SuKien> dsThanhTuu = new ArrayList<SuKien>();

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
    public static ArrayList<SuKien> getDsSKLauDai() {
        return dsSKLauDai;
    }

    public static ArrayList<SuKien> getDsThanhTuu() {
        return dsThanhTuu;
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
        ArrayList<SuKien> toanBoSK = new ArrayList<>();
        ArrayList<SuKien> dsKVDuBi = new ArrayList<>();
        ArrayList<SuKien> dsKHDuBi = new ArrayList<>();
        double lucky = new Random().nextDouble();
        for (SuKien mauSK : dsMauSK) {
            SuKien sk = GameSystem.GeneratorSystem.taoSuKien(mauSK, nguoiChoi, dsNV, tg);
            double tyLeXuatHien = sk.getTyLeXuatHien() / 100.0;
            if (lucky <= tyLeXuatHien) {
                switch (sk.getLoaiSK()) {
                    case "KYVONG":
                    case "UOCMO":
                        boolean dangKyVong = false;
                        for (SuKien skLD : MainSystem.dsSKLauDai) {
                            if (skLD.getMaSK().equals(sk.getMaSK())) {
                                dangKyVong = true;
                            }
                        }
                        if (!dangKyVong) {
                            if (tyLeXuatHien >= 1.0) {
                                MainSystem.dsSKLauDai.add(sk);
                            } else {
                                dsKVDuBi.add(sk);
                            }
                        }
                        break;
                    case "KEHOACH":
                        boolean daKeHoach = false;
                        for (SuKien skLD : MainSystem.dsThanhTuu) {
                            if (skLD.getMaSK().equals(sk.getMaSK())) {
                                daKeHoach = true;
                            }
                        }
                        if (!daKeHoach) {
                            if (tyLeXuatHien >= 1.0) {
                                MainSystem.dsThanhTuu.add(sk);
                            } else {
                                dsKHDuBi.add(sk);
                            }
                        }
                        break;
                    default:
                        if (sk.kiemTraDK()) {
                            if (tyLeXuatHien >= 1.0) {
                                toanBoSK.add(sk);
                            } else {
                                dsSKDuBi.add(sk);
                            }
                            break;
                        }
                }
            }
        }

        ArrayList<SuKien> dsSK = new ArrayList<>();

        for (int i = 0; dsSK.size() < soLuongSKToiDa && i < dsSKDuBi.size(); i++) {
            int index = new Random().nextInt(dsSKDuBi.size());
            dsSK.add(dsSKDuBi.get(index));
            dsSKDuBi.remove(index);
            i--;
        }

        for (int i = 0; dsSK.size() < soLuongSKToiDa && i < dsKVDuBi.size(); i++) {
            int index = new Random().nextInt(dsKVDuBi.size());
            MainSystem.dsSKLauDai.add(dsKVDuBi.get(index));
            dsKVDuBi.remove(index);
            i--;
        }

        for (int i = 0; dsSK.size() < soLuongSKToiDa && i < dsKHDuBi.size(); i++) {
            int index = new Random().nextInt(dsKHDuBi.size());
            MainSystem.dsThanhTuu.add(dsKHDuBi.get(index));
            dsKHDuBi.remove(index);
            i--;
        }

        toanBoSK.addAll(dsSK);
        return toanBoSK;
    }

    /**
     */
    static public void taoSuKien() {
//        Sự kiện thế giới
        int SoLuongSKTGToiDa = 1;
        ArrayList<SuKien> dsSKTG = chuanBiSuKienTiepTheo(Model.ModelMauSuKien.suKienTheGioi(), SoLuongSKTGToiDa);
        MainSystem.dsSKHienTai.addAll(dsSKTG);
//        Sự kiện quốc gia
//        Sự kiện tỉnh
//        Sự kiện hằng năm
        int SoLuongSKHNToiDa = 1;
        ArrayList<SuKien> dsSKHN = chuanBiSuKienTiepTheo(Model.ModelMauSuKien.suKienHangNam(), SoLuongSKHNToiDa);
        MainSystem.dsSKHienTai.addAll(dsSKHN);
//        Sự kiện kỳ vọng
        int SoLuongSKKVToiDa = 1;
        ArrayList<SuKien> dsSKKV = chuanBiSuKienTiepTheo(Model.ModelMauSuKien.suKienKyVong(), SoLuongSKKVToiDa);
        MainSystem.dsSKHienTai.addAll(dsSKKV);
    }

    /**
     * @param luaChon
     */
    static public void xuLySuKienHienTai(LuaChon luaChon) {
        luaChon.kichHoat();
        MainSystem.suKienHienTai.setDaHoanThanh(true);
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
                SuKien mauSK = Model.ModelMauSuKien.getMauSuKien(maSK);
                dsSuKienTiepTheo.add(GameSystem.GeneratorSystem.taoSuKien(mauSK, nguoiChoi, dsNV, tg));
            }
            dsSK.addAll(0, chuanBiSuKienTiepTheo(dsSuKienTiepTheo, 100));
        }
        MainSystem.dsSKHienTai.addAll(dsSK);
//        Kiểm tra sự kiện kỳ vọng và ước mơ
        for (int i = 0; i < MainSystem.dsSKLauDai.size(); i++) {
            SuKien sk = MainSystem.dsSKLauDai.get(i);
            if (!sk.isDaHoanThanh()) {
                if (sk.getThoiHan() == 0 || sk.kiemTraDK()) {
                    MainSystem.dsSKHienTai.add(sk);
                    if ("KYVONG".equals(sk.getLoaiSK())) {
                        MainSystem.dsSKLauDai.remove(sk);
                        i--;
                    }
                }
            }
        }

        if (!MainSystem.dsSKHienTai.isEmpty()) {
            MainSystem.suKienHienTai = MainSystem.dsSKHienTai.get(0);
        } else {
            MainSystem.suKienHienTai = null;
        }
    }

    static public void kichHoatSuKienHienTai(MainScreen mainScreenController) {
        MainSystem.suKienHienTai.kichHoat();
        mainScreenController.addLog(MainSystem.suKienHienTai.getTomTat());
    }

    static public void suKienKhanCap(SuKien sk) {
        dsSKHienTai.add(0, sk);
    }

    /**
     * @param mainScreenController
     */
    static public void suKienNamKeTiep(MainScreen mainScreenController) {
        mainScreenController.addTitle("Năm " + MainSystem.nguoiChoi.getTuoi() + " tuổi:");
        MainSystem.dsSKHienTai.clear();
        for (int i = 0; i < MainSystem.dsSKLauDai.size(); i++) {
            SuKien sk = MainSystem.dsSKLauDai.get(i);
            if (!sk.isDaHoanThanh()) {
                sk.demNguocThoiHan();
                if (sk.getThoiHan() == 0 || sk.kiemTraDK()) {
                    MainSystem.dsSKHienTai.add(sk);
                    if ("KYVONG".equals(sk.getLoaiSK())) {
                        MainSystem.dsSKLauDai.remove(sk);
                        i--;
                    }
                }
            }
        }
        for (SuKien sk : MainSystem.dsThanhTuu) {
            if (!sk.isDaHoanThanh()) {
                sk.demNguocThoiHan();
                if (sk.getThoiHan() == 0) {
                    MainSystem.dsSKHienTai.add(sk);
                }
            }
        }
        MainSystem.taoSuKien();
        if (MainSystem.dsSKHienTai.isEmpty()) {
            MainSystem.suKienHienTai = null;
        } else {
            MainSystem.suKienHienTai = MainSystem.dsSKHienTai.get(0);
        }
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
