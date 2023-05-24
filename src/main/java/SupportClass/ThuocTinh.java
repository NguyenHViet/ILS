package SupportClass;

import GameEvent.*;
import java.util.*;

/**
 *
 */
public abstract class ThuocTinh {

    /**
     * Default constructor
     */
    public ThuocTinh() {
        this.maTT = "";
        this.tenTT = "";
        this.moTa = "";
        this.hienThi = true;
    }

    /**
     *
     */
    protected String maTT;

    /**
     *
     */
    protected String tenTT;

    /**
     *
     */
    protected String moTa;

    protected boolean hienThi;

    /**
     * Get the value of hienTri
     *
     * @return the value of hienTri
     */
    public boolean isHienThi() {
        return this.hienThi;
    }

    /**
     * Set the value of hienTri
     *
     * @param hienThi
     */
    public void setHienTri(boolean hienThi) {
        this.hienThi = hienThi;
    }

    /**
     * @param maTT
     * @param tenTT
     * @param moTa
     */
    public ThuocTinh(String maTT, String tenTT, String moTa, boolean hienThi) {
        this.maTT = maTT;
        this.tenTT = tenTT;
        this.moTa = moTa;
        this.hienThi = hienThi;
    }

    /**
     * @return
     */
    public String getMaTT() {
        return this.maTT;
    }

    /**
     * @return
     */
    public String getTenTT() {
        return this.tenTT;
    }

    /**
     * @return
     */
    public String getMoTa() {
        return this.moTa;
    }

    /**
     * @param tenTT
     */
    public void setTenTT(String tenTT) {
        this.tenTT = tenTT;
    }

    /**
     * @param moTa
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return
     */
    abstract public ThuocTinh cloneTT();

    /**
     * @return
     */
    abstract public String loaiTT();

    /**
     * @param hu
     */
    abstract public void chiuTacDong(HieuUng hu);

}
