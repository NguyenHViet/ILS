package SupportClass;

import GameEvent.HieuUng;
import java.util.*;

/**
 *
 */
public class ChiSo extends ThuocTinh {

    /**
     * Default constructor
     */
    public ChiSo() {
        super();
        this.giaTri = 0;
        this.giaTriTamThoi = 0;
        this.tiemNang = 0;
    }

    /**
     *
     */
    private int giaTri;

    /**
     *
     */
    private int tiemNang;

    /**
     *
     */
    private int giaTriTamThoi;

    /**
     * @param maTT
     * @param tenTT
     * @param moTa
     * @param hienThi
     * @param giaTri
     * @param tiemNang
     * @param giaTriTamThoi
     */
    public ChiSo(String maTT, String tenTT, String moTa, boolean hienThi, int giaTri, int tiemNang, int giaTriTamThoi) {
        super(maTT, tenTT, moTa, hienThi);
        this.giaTri = giaTri;
        this.giaTriTamThoi = giaTriTamThoi;
        this.tiemNang = tiemNang;
    }

    /**
     * @return
     */
    public int getGiaTri() {
        return this.giaTri;
    }

    /**
     * @return
     */
    public int getTiemNang() {
        return this.tiemNang;
    }

    /**
     * @return
     */
    public int getGiaTriTamThoi() {
        return this.giaTriTamThoi;
    }

    /**
     * @param giaTri
     */
    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    /**
     * @param tiemNang
     */
    public void setTiemNang(int tiemNang) {
        this.tiemNang = tiemNang;
    }

    /**
     * @param giaTriTamThoi
     */
    public void setGiaTriTamThoi(int giaTriTamThoi) {
        this.giaTriTamThoi = giaTriTamThoi;
    }

    /**
     * @param tangCS
     */
    public void tangChiSoTamThoi(int tangCS) {
        this.giaTriTamThoi += tangCS;
    }

    /**
     * @return
     */
    @Override
    public ChiSo cloneTT() {
        return new ChiSo(this.maTT, this.tenTT, this.moTa, this.hienThi, this.giaTri, this.tiemNang, this.giaTriTamThoi);
    }

    /**
     * @return
     */
    @Override
    public String loaiTT() {
        return "TT_CS";
    }

    /**
     * @param hu 
     */
    @Override
    public void chiuTacDong(HieuUng hu) {
    }

}
