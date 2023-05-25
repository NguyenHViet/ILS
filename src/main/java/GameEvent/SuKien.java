package GameEvent;

import GameObject.NhanVat;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class SuKien implements Interface_KichHoatSK {

    /**
     * Default constructor
     */
    public SuKien() {
        this.maSK = "";
        this.moTa = "";
        this.tomTat = "";
        this.tenSK = "";
        this.dsLC = new ArrayList<LuaChon>();
        this.dsHU = new ArrayList<HieuUng>();
        this.dsDK = new ArrayList<DieuKien>();
        this.dsDTTG = new ArrayList<NhanVat>();
        this.boiCanh = null;
        this.loaiDTTG = "";
        this.soLuongDTTG = 0;
        this.thoiHan = 0;
        this.loaiSK = "";
        this.tyLeXuatHien = 0.0;
        this.daHoanThanh = false;
    }

    /**
     *
     */
    private String maSK;

    /**
     *
     */
    private String moTa;

    /**
     *
     */
    private ArrayList<LuaChon> dsLC;

    /**
     *
     */
    private ArrayList<HieuUng> dsHU;

    /**
     *
     */
    private ArrayList<DieuKien> dsDK;

    /**
     */
    private ArrayList<NhanVat> dsDTTG;

    /**
     *
     */
    private BoiCanh boiCanh;

    /**
     *
     */
    private String loaiDTTG;

    private boolean daHoanThanh;

    /**
     *
     */
    private int soLuongDTTG;

    private int thoiHan;

    private String loaiSK;

    private double tyLeXuatHien;

    private String tenSK;

    private String tomTat;

    /**
     * Get the value of tomTat
     *
     * @return the value of tomTat
     */
    public String getTomTat() {
        return tomTat;
    }

    /**
     * Set the value of tomTat
     *
     * @param tomTat new value of tomTat
     */
    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    /**
     * Get the value of tenSK
     *
     * @return the value of tenSK
     */
    public String getTenSK() {
        return tenSK;
    }

    /**
     * Set the value of tenSK
     *
     * @param tenSK new value of tenSK
     */
    public void setTenSK(String tenSK) {
        this.tenSK = tenSK;
    }

    /**
     * Get the value of daHoanThanh
     *
     * @return the value of daHoanThanh
     */
    public boolean isDaHoanThanh() {
        return daHoanThanh;
    }

    /**
     * Set the value of daHoanThanh
     *
     * @param daHoanThanh new value of daHoanThanh
     */
    public void setDaHoanThanh(boolean daHoanThanh) {
        this.daHoanThanh = daHoanThanh;
    }

    /**
     * Get the value of loaiDTTG
     *
     * @return the value of loaiDTTG
     */
    public String getLoaiDTTG() {
        return loaiDTTG;
    }

    /**
     * Set the value of loaiDTTG
     *
     * @param loaiDTTG new value of loaiDTTG
     */
    public void setLoaiDTTG(String loaiDTTG) {
        this.loaiDTTG = loaiDTTG;
    }

    /**
     * Get the value of soLuongDTTG
     *
     * @return the value of soLuongDTTG
     */
    public int getSoLuongDTTG() {
        return this.soLuongDTTG;
    }

    /**
     * Set the value of soLuongDTTG
     *
     * @param soLuongDTTG new value of soLuongDTTG
     */
    public void setSoLuongDTTG(int soLuongDTTG) {
        this.soLuongDTTG = soLuongDTTG;
    }

    /**
     * Get the value of thoiHan
     *
     * @return the value of thoiHan
     */
    public int getThoiHan() {
        return this.thoiHan;
    }

    /**
     * Set the value of thoiHan
     *
     * @param thoiHan new value of thoiHan
     */
    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    public void demNguocThoiHan() {
        this.thoiHan--;
    }

    /**
     * Get the value of loaiSL
     *
     * @return the value of loaiSL
     */
    public String getLoaiSK() {
        return this.loaiSK;
    }

    /**
     * Set the value of loaiSL
     *
     * @param loaiSK new value of loaiSK
     */
    public void setLoaiSK(String loaiSK) {
        this.loaiSK = loaiSK;
    }

    /**
     * Get the value of tyLeXuatHien
     *
     * @return the value of tyLeXuatHien
     */
    public double getTyLeXuatHien() {
        return tyLeXuatHien;
    }

    /**
     * Set the value of tyLeXuatHien
     *
     * @param tyLeXuatHien new value of tyLeXuatHien
     */
    public void setTyLeXuatHien(double tyLeXuatHien) {
        this.tyLeXuatHien = tyLeXuatHien;
    }

    /**
     * @param maSK
     * @param tenSK
     * @param moTa
     * @param tomTat
     * @param dsLC
     * @param dsHU
     * @param dsDK
     * @param dsDTTG
     * @param boiCanh
     * @param loaiDTTG
     * @param soLuong
     * @param thoiHan
     * @param loaiSK
     * @param tyLeXuatHien
     * @param daHoanThanh
     */
    public SuKien(String maSK,
            String tenSK,
            String moTa,
            String tomTat,
            ArrayList<LuaChon> dsLC,
            ArrayList<HieuUng> dsHU,
            ArrayList<DieuKien> dsDK,
            ArrayList<NhanVat> dsDTTG,
            BoiCanh boiCanh,
            String loaiDTTG,
            int soLuong,
            int thoiHan,
            String loaiSK,
            double tyLeXuatHien,
            boolean daHoanThanh) {
        this.maSK = maSK;
        this.moTa = moTa;
        this.tomTat = tomTat;
        this.tenSK = tenSK;
        this.dsLC = dsLC;
        this.dsHU = dsHU;
        this.dsDK = dsDK;
        this.dsDTTG = dsDTTG;
        this.boiCanh = boiCanh;
        this.loaiDTTG = loaiDTTG;
        this.soLuongDTTG = soLuong;
        this.thoiHan = thoiHan;
        this.loaiSK = loaiSK;
        this.tyLeXuatHien = tyLeXuatHien;
        this.daHoanThanh = daHoanThanh;
    }

    /**
     * @return
     */
    public ArrayList<LuaChon> layLCPhuHop() {
        ArrayList<LuaChon> luaChonPhuHop = new ArrayList<>();
        if (this.dsLC != null) {
            for (LuaChon lc : this.dsLC) {
                if (lc.kiemTraDK()) {
                    luaChonPhuHop.add(lc);
                }
            }
        }
        return luaChonPhuHop;
    }

    /**
     * @return
     */
    public String getMaSK() {
        return this.maSK;
    }

    /**
     * @return
     */
    public String getMoTa() {
        return this.moTa;
    }

    /**
     * @return
     */
    public ArrayList<LuaChon> getDSLC() {
        return this.dsLC;
    }

    /**
     * @return
     */
    public ArrayList<HieuUng> getDSHU() {
        return this.dsHU;
    }

    /**
     * @return
     */
    public ArrayList<DieuKien> getDSDK() {
        return this.dsDK;
    }

    /**
     * @return
     */
    public ArrayList<NhanVat> getDSDTTG() {
        return this.dsDTTG;
    }

    /**
     * @return
     */
    public BoiCanh getBoiCanh() {
        return this.boiCanh;
    }

    /**
     * @param moTa
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @param dsLC
     */
    public void setDSLC(ArrayList<LuaChon> dsLC) {
        this.dsLC = dsLC;
    }

    /**
     * @param dsHU
     */
    public void setDSHU(ArrayList<HieuUng> dsHU) {
        this.dsHU = dsHU;
    }

    /**
     * @param dsDK
     */
    public void setDSDK(ArrayList<DieuKien> dsDK) {
        this.dsDK = dsDK;
    }

    /**
     * @param dsDTTG
     */
    public void setDSDTTG(ArrayList<NhanVat> dsDTTG) {
        this.dsDTTG = dsDTTG;
    }

    /**
     * @param boiCanh
     */
    public void setBoiCanh(BoiCanh boiCanh) {
        this.boiCanh = boiCanh;
    }

    /**
     * @return
     */
    public SuKien cloneSK() {
        return new SuKien(this.maSK,
                this.tenSK,
                this.moTa,
                this.tomTat,
                this.dsLC,
                this.dsHU,
                this.dsDK,
                this.dsDTTG,
                this.boiCanh,
                this.loaiDTTG,
                this.soLuongDTTG,
                this.thoiHan,
                this.loaiSK,
                this.tyLeXuatHien,
                this.daHoanThanh);
    }

    /**
     * @return
     */
    @Override
    public boolean kiemTraDK() {
        if (dsDK == null) {
            return true;
        }
        for (DieuKien dk : dsDK) {
            if (!dk.kiemTraDK(dsDTTG, boiCanh)) {
                return false;
            }
        }
        return true;
    }

    /**
     */
    @Override
    public void kichHoat() {
        if (this.dsHU == null) {
            return;
        }
        for (HieuUng hu : this.dsHU) {
            for (NhanVat nv : this.dsDTTG) {
                nv.chiuTacDong(hu);
            }
            if (hu instanceof HU_ThuocTinh || hu instanceof HU_VatPham) {
                this.boiCanh.chiuTacDong(hu);
            }
        }
        this.daHoanThanh = true;
    }

}
