package GameEvent;

import GameObject.NhanVat;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class HU_ThuocTinh extends HieuUng {

    /**
     * Default constructor
     */
    public HU_ThuocTinh() {
        super();
        this.maTT = "";
        this.tangGiaTri = 0;
        this.tyLeTTTang = 0.0;
        this.tangTiemNang = 0;
        this.tangTamThoi = 0;
    }

    /**
     *
     */
    private String maTT;

    /**
     *
     */
    private int tangGiaTri;

    /**
     *
     */
    private double tyLeTTTang;

    private int tangTiemNang;

    private int tangTamThoi;

    /**
     * Get the value of tangTiemNang
     *
     * @return the value of tangTiemNang
     */
    public int getTangTiemNang() {
        return tangTiemNang;
    }

    /**
     * Set the value of tangTiemNang
     *
     * @param tangTiemNang new value of tangTiemNang
     */
    public void setTangTiemNang(int tangTiemNang) {
        this.tangTiemNang = tangTiemNang;
    }

    public int getTangTamThoi() {
        return tangTamThoi;
    }

    public void setTangTamThoi(int tangTamThoi) {
        this.tangTamThoi = tangTamThoi;
    }

    /**
     * @param maHU
     * @param moTa
     * @param dsDK
     * @param maTT
     * @param tangTT
     * @param tyLeTTTang
     * @param tangTamThoi
     * @param tangTiemNang
     */
    public HU_ThuocTinh(String maHU,
            String moTa,
            ArrayList<DieuKien> dsDK,
            String maTT, int tangTT,
            double tyLeTTTang,
            int tangTamThoi,
            int tangTiemNang
    ) {
        super(maHU, moTa, dsDK);
        this.maTT = maTT;
        this.tangGiaTri = tangTT;
        this.tyLeTTTang = tyLeTTTang;
        this.tangTamThoi = tangTamThoi;
        this.tangTiemNang = tangTiemNang;
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
    public int getTangGiaTri() {
        return this.tangGiaTri;
    }

    /**
     * @return
     */
    public double getTyLeTangTT() {
        return this.tyLeTTTang;
    }

    /**
     * @param maTT
     */
    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    /**
     * @param tangGiaTri
     */
    public void setTangGiaTri(int tangGiaTri) {
        this.tangGiaTri = tangGiaTri;
    }

    /**
     * @param tyLeTangTT
     */
    public void setTyLeTangTT(double tyLeTangTT) {
        this.tyLeTTTang = tyLeTangTT;
    }

    /**
     * @return
     */
    @Override
    public HU_ThuocTinh cloneHU() {
        return new HU_ThuocTinh(
                this.maHU,
                this.moTa,
                this.dsDK,
                this.maTT,
                this.tangGiaTri,
                this.tyLeTTTang,
                this.tangTamThoi,
                this.tangTiemNang
        );
    }

    /**
     * @return
     */
    @Override
    public String loaiHU() {
        return "HU_TT";
    }

}
