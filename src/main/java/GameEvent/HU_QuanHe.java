package GameEvent;

import GameObject.NhanVat;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class HU_QuanHe extends HieuUng {

    /**
     * Default constructor
     */
    public HU_QuanHe() {
        super();
        this.maNV = "";
        this.moiQH = "";
        this.thanThiet = 0;
        this.tinTuong = 0;
    }

    /**
     *
     */
    private String maNV;

    /**
     *
     */
    private String moiQH;

    /**
     *
     */
    private int thanThiet;

    /**
     *
     */
    private int tinTuong;

    /**
     * @param maHU
     * @param moTa
     * @param dsDK
     * @param maNV
     * @param moiQH
     * @param thanThiet
     * @param tinTuong
     */
    public HU_QuanHe(String maHU, String moTa, ArrayList<DieuKien> dsDK, String maNV, String moiQH, int thanThiet, int tinTuong) {
        super(maHU, moTa, dsDK);
        this.maNV = maNV;
        this.moiQH = moiQH;
        this.thanThiet = thanThiet;
        this.tinTuong = tinTuong;
    }

    /**
     * @return
     */
    public String getMaNV() {
        return this.maNV;
    }

    /**
     * @return
     */
    public String getMoiQH() {
        return this.moiQH;
    }

    /**
     * @return
     */
    public int getThanThiet() {
        return this.thanThiet;
    }

    /**
     * @return
     */
    public int getTinTuong() {
        return this.tinTuong;
    }

    /**
     * @param maNV
     */
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    /**
     * @param moiQH
     */
    public void setMoiQH(String moiQH) {
        this.moiQH = moiQH;
    }

    /**
     * @param thanThiet
     */
    public void setThanThiet(int thanThiet) {
        this.thanThiet = thanThiet;
    }

    /**
     * @param tinTuong
     */
    public void setTinTuong(int tinTuong) {
        this.tinTuong = tinTuong;
    }

    /**
     * @return
     */
    @Override
    public HU_QuanHe cloneHU() {
        return new HU_QuanHe(this.maHU, this.moTa, this.dsDK, this.maNV, this.moiQH, this.thanThiet, this.tinTuong);
    }

    /**
     * @return
     */
    @Override
    public String loaiHU() {
        return "HU_QH";
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
