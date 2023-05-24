package SupportClass;

import java.util.*;

/**
 *
 */
public class ChucVu {

    /**
     * Default constructor
     */
    public ChucVu() {
        this.maCV = "";
        this.tenCV = "";
        this.capBac = 0;
        this.luong = 0;
    }

    /**
     *
     */
    private String maCV;

    /**
     *
     */
    private String tenCV;

    /**
     *
     */
    private int capBac;

    /**
     *
     */
    private long luong;

    /**
     * @param maCV
     * @param tenCV
     * @param capBac
     * @param luong
     */
    public ChucVu(String maCV, String tenCV, int capBac, long luong) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.capBac = capBac;
        this.luong = luong;
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
    public String getTenCV() {
        return this.tenCV;
    }

    /**
     * @return
     */
    public int getCapBac() {
        return this.capBac;
    }

    /**
     * @return
     */
    public long getLuong() {
        return this.luong;
    }

    /**
     * @param tenCV
     */
    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    /**
     * @param capBac
     */
    public void setCapBac(int capBac) {
        this.capBac = capBac;
    }

    /**
     * @param luong
     */
    public void setLuong(long luong) {
        this.luong = luong;
    }

    /**
     * @return
     */
    public ChucVu cloneCV() {
        return new ChucVu(this.maCV, this.tenCV, this.capBac, this.luong);
    }

}
