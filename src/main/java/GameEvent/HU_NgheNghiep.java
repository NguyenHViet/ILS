package GameEvent;

import GameObject.NhanVat;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class HU_NgheNghiep extends HieuUng {

    /**
     * Default constructor
     */
    public HU_NgheNghiep() {
        super();
        this.maNN = "";
        this.thongThao = 0;
        this.maCV = "";
        this.hsChinhLuong = 0.0;
    }

    /**
     *
     */
    private String maNN;

    /**
     *
     */
    private int thongThao;

    /**
     *
     */
    private String maCV;

    /**
     *
     */
    private double hsChinhLuong;

    /**
     * @param maHU
     * @param moTa
     * @param dsDK
     * @param maNN
     * @param thongThao
     * @param maCV
     * @param hsChinhLuong
     */
    public HU_NgheNghiep(String maHU, String moTa, ArrayList<DieuKien> dsDK, String maNN, int thongThao, String maCV, double hsChinhLuong) {
        super(maHU, moTa, dsDK);
        this.maNN = maNN;
        this.thongThao = thongThao;
        this.maCV = maCV;
        this.hsChinhLuong = hsChinhLuong;
    }

    /**
     * @return
     */
    public String getMaNN() {
        return this.maNN;
    }

    /**
     * @return
     */
    public int getThongThao() {
        return this.thongThao;
    }

    /**
     * @return
     */
    public String getMaCV() {
        return this.maCV;
    }

    /**
     * @return
     */
    public double getHSChinhLuong() {
        return this.hsChinhLuong;
    }

    /**
     * @param maNN
     */
    public void setMaNN(String maNN) {
        this.maNN = maNN;
    }

    /**
     * @param thongThao
     */
    public void setThongThao(int thongThao) {
        this.thongThao = thongThao;
    }

    /**
     * @param maCV
     */
    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    /**
     * @param hsChinhLuong
     */
    public void setHSChinhLuong(double hsChinhLuong) {
        this.hsChinhLuong = hsChinhLuong;
    }

    /**
     * @return
     */
    @Override
    public HU_NgheNghiep cloneHU() {
        return new HU_NgheNghiep(this.maHU, this.moTa, this.dsDK, this.maNN, this.thongThao, this.maCV, this.hsChinhLuong);
    }

    /**
     * @return
     */
    @Override
    public String loaiHU() {
        return "HU_NN";
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
