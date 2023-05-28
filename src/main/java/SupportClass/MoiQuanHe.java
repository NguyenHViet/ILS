package SupportClass;

import java.util.*;

/**
 *
 */
public class MoiQuanHe {

    /**
     * Default constructor
     */
    public MoiQuanHe() {
        this.quanHe = "";
        this.vongQuanHe = "";
        this.maNV = "";
        this.thanThiet = 0;
        this.tinTuong = 0;
    }

    /**
     *
     */
    private String quanHe;

    /**
     *
     */
    private String maNV;

    /**
     *
     */
    private int thanThiet;

    /**
     *
     */
    private int tinTuong;

    private String vongQuanHe;

    /**
     * Get the value of vongQuanHe
     *
     * @return the value of vongQuanHe
     */
    public String getVongQuanHe() {
        return vongQuanHe;
    }

    /**
     * Set the value of vongQuanHe
     *
     * @param vongQuanHe new value of vongQuanHe
     */
    public void setVongQuanHe(String vongQuanHe) {
        this.vongQuanHe = vongQuanHe;
    }

    /**
     * @param quanHe
     * @param vongQuanHe
     * @param maNV
     * @param thanThiet
     * @param tinTuong
     */
    public MoiQuanHe(String quanHe, String vongQuanHe, String maNV, int thanThiet, int tinTuong) {
        this.quanHe = quanHe;
        this.vongQuanHe = vongQuanHe;
        this.maNV = maNV;
        this.thanThiet = thanThiet;
        this.tinTuong = tinTuong;
    }

    /**
     * @return
     */
    public String getQuanHe() {
        return this.quanHe;
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
     * @param quanHe
     * @return
     */
    public void setQuanHe(String quanHe) {
        this.quanHe = quanHe;
    }

    /**
     * @param thanThiet
     * @return
     */
    public void setThanThiet(int thanThiet) {
        this.thanThiet = thanThiet;
    }

    /**
     * @param tinTuong
     * @return
     */
    public void setTinTuong(int tinTuong) {
        this.tinTuong = tinTuong;
    }

    /**
     * @return
     */
    public MoiQuanHe cloneMQH() {
        return new MoiQuanHe(this.quanHe, this.vongQuanHe, this.maNV, this.thanThiet, this.tinTuong);
    }

}
