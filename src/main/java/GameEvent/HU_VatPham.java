package GameEvent;

import GameObject.NhanVat;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class HU_VatPham extends HieuUng {

    /**
     * Default constructor
     */
    public HU_VatPham() {
        super();
        this.maVP = "";
        this.soLuong = 0;
        this.suDung = false;
    }

    /**
     *
     */
    private String maVP;

    /**
     *
     */
    private int soLuong;

    /**
     *
     */
    private boolean suDung;

    /**
     * @param maHU
     * @param moTa
     * @param dsDK
     * @param maVP
     * @param soLuong
     * @param suDung
     */
    public HU_VatPham(String maHU, String moTa, ArrayList<DieuKien> dsDK, String maVP, int soLuong, boolean suDung) {
        super(maHU, moTa, dsDK);
        this.maVP = maVP;
        this.soLuong = soLuong;
        this.suDung = suDung;
    }

    /**
     * @return
     */
    public String getMaVP() {
        return this.maVP;
    }

    /**
     * @return
     */
    public int getSoLuong() {
        return this.soLuong;
    }

    /**
     * @return
     */
    public boolean getSuDung() {
        return this.suDung;
    }

    /**
     * @param maVP
     */
    public void setMaVP(String maVP) {
        this.maVP = maVP;
    }

    /**
     * @param soLuong
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @param suDung
     */
    public void setSuDung(boolean suDung) {
        this.suDung = suDung;
    }

    /**
     * @return
     */
    @Override
    public HU_VatPham cloneHU() {
        return new HU_VatPham(this.maHU, this.moTa, this.dsDK, this.maVP, this.soLuong, this.suDung);
    }

    /**
     * @return
     */
    @Override
    public String loaiHU() {
        return "HU_VP";
    }

    /**
     * @param dsDT
     * @param bc
     * @return
     */
    @Override
    public boolean kiemTraDK(ArrayList<NhanVat> dsDT, BoiCanh bc) {
        return false;
    }

}
