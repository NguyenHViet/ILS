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
        this.tangTT = 0;
        this.tyLeTTTang = 0.0;
    }

    /**
     *
     */
    private String maTT;

    /**
     *
     */
    private int tangTT;

    /**
     *
     */
    private double tyLeTTTang;

    private int tangTiemNang;

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

    /**
     * @param maHU
     * @param moTa
     * @param dsDK
     * @param maTT
     * @param tangTT
     * @param tyLeTTTang
     * @param tangTiemNang
     */
    public HU_ThuocTinh(String maHU,
            String moTa,
            ArrayList<DieuKien> dsDK,
            String maTT, int tangTT,
            double tyLeTTTang,
            int tangTiemNang
    ) {
        super(maHU, moTa, dsDK);
        this.maTT = maTT;
        this.tangTT = tangTT;
        this.tyLeTTTang = tyLeTTTang;
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
    public int getTangTT() {
        return this.tangTT;
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
     * @param tangTT
     */
    public void setTangTT(int tangTT) {
        this.tangTT = tangTT;
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
                this.tangTT,
                this.tyLeTTTang,
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

    /**
     * @param dsDT
     * @param bc
     * @return
     */
    @Override
    public boolean kiemTraDK(ArrayList<NhanVat> dsDT, BoiCanh bc) {
        if (dsDK == null) {
            return true;
        }
        for (DieuKien dk : dsDK) {
            if (!dk.kiemTraDK(dsDT, bc)) {
                return false;
            }
        }
        return true;
    }

}
