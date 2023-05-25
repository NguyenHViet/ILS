package SupportClass;

import GameEvent.*;
import java.util.*;

/**
 *
 */
public class TrangThai extends ThuocTinh {

    /**
     * Default constructor
     */
    public TrangThai() {
        super();
        this.tinhTrang = 0;
        this.thoiHan = 0;
        this.soLanKhaDung = 0;
    }

    /**
     *
     */
    private int tinhTrang;

    /**
     *
     */
    private int soLanKhaDung;

    /**
     *
     */
    private int thoiHan;

    /**
     * @param maTT
     * @param tenTT
     * @param moTa
     * @param hienThi
     * @param tinhTrang
     * @param soLanKhaDung
     * @param thoiHan
     */
    public TrangThai(String maTT, String tenTT, String moTa, boolean hienThi, int tinhTrang, int soLanKhaDung, int thoiHan) {
        super(maTT, tenTT, moTa, hienThi);
        this.tinhTrang = tinhTrang;
        this.soLanKhaDung = soLanKhaDung;
        this.thoiHan = thoiHan;
    }

    /**
     * @return
     */
    public int getTinhTrang() {
        return this.tinhTrang;
    }

    /**
     * @return
     */
    public int getThoiHan() {
        return this.thoiHan;
    }

    /**
     * @return
     */
    public int getSoLanKhaDung() {
        return this.soLanKhaDung;
    }

    /**
     * @param tinhTrang
     */
    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    /**
     * @param thoiHan
     */
    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    /**
     * @param soLanKhaDung
     */
    public void setSoLanKhaDung(int soLanKhaDung) {
        this.soLanKhaDung = soLanKhaDung;
    }

    /**
     * @return
     */
    @Override
    public TrangThai cloneTT() {
        return new TrangThai(this.maTT,
                this.tenTT,
                this.moTa,
                this.hienThi,
                this.tinhTrang,
                this.soLanKhaDung,
                this.thoiHan);
    }

    /**
     * @return
     */
    @Override
    public String loaiTT() {
        return "TT_TT";
    }

}
