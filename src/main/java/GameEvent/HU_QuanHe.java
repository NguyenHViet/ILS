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
        this.loaiQuanHe = "";
        this.MQHMoiTuNV = "";
        this.MQHMoiDenNV = "";
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
    private String MQHMoiTuNV;

    /**
     *
     */
    private int thanThiet;

    /**
     *
     */
    private int tinTuong;

    private String MQHMoiDenNV;

    private String loaiQuanHe;

    /**
     * Get the value of loaiQuanHe
     *
     * @return the value of loaiQuanHe
     */
    public String getLoaiQuanHe() {
        return loaiQuanHe;
    }

    /**
     * Set the value of loaiQuanHe
     *
     * @param loaiQuanHe new value of loaiQuanHe
     */
    public void setLoaiQuanHe(String loaiQuanHe) {
        this.loaiQuanHe = loaiQuanHe;
    }

    /**
     * Get the value of MQHMoiDenNV
     *
     * @return the value of MQHMoiDenNV
     */
    public String getMQHMoiDenNV() {
        return MQHMoiDenNV;
    }

    /**
     * Set the value of MQHMoiDenNV
     *
     * @param MQHMoiDenNV new value of MQHMoiDenNV
     */
    public void setMQHMoiDenNV(String MQHMoiDenNV) {
        this.MQHMoiDenNV = MQHMoiDenNV;
    }

    /**
     * @param maHU
     * @param moTa
     * @param dsDK
     * @param maNV
     * @param loaiQuanHe
     * @param MQHMoiTuNV
     * @param MQHMoiDenNV
     * @param thanThiet
     * @param tinTuong
     */
    public HU_QuanHe(String maHU,
            String moTa,
            ArrayList<DieuKien> dsDK,
            String maNV,
            String loaiQuanHe,
            String MQHMoiTuNV,
            String MQHMoiDenNV,
            int thanThiet,
            int tinTuong) {
        super(maHU, moTa, dsDK);
        this.maNV = maNV;
        this.loaiQuanHe = loaiQuanHe;
        this.MQHMoiTuNV = MQHMoiTuNV;
        this.MQHMoiDenNV = MQHMoiDenNV;
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
    public String getMQHMoiTuNV() {
        return this.MQHMoiTuNV;
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
     * @param MQHMoiTuNV
     */
    public void setMQHMoiTuNV(String MQHMoiTuNV) {
        this.MQHMoiTuNV = MQHMoiTuNV;
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
        return new HU_QuanHe(
                this.maHU,
                this.moTa,
                this.dsDK,
                this.maNV,
                this.loaiQuanHe,
                this.MQHMoiTuNV,
                this.MQHMoiDenNV,
                this.thanThiet,
                this.tinTuong);
    }

    /**
     * @return
     */
    @Override
    public String loaiHU() {
        return "HU_QH";
    }

}
