package GameEvent;

import GameObject.NhanVat;
import GameSystem.MainSystem;
import SupportClass.MoiQuanHe;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class DK_ThanThiet extends DieuKien {

    /**
     * Default constructor
     */
    public DK_ThanThiet() {
        super();
        this.maNV = "";
        this.loaiQH = "";
        this.vongQuanHe = "";
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
    private String loaiQH;

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
     * @param maDK
     * @param isNot
     * @param dungToiThieu
     * @param moTa
     * @param maNV
     * @param loaiQH
     * @param vongQuanHe
     * @param thanThiet
     * @param tinTuong
     */
    public DK_ThanThiet(String maDK,
            boolean isNot,
            int dungToiThieu,
            String moTa,
            String maNV,
            String loaiQH,
            String vongQuanHe,
            int thanThiet,
            int tinTuong) {
        super(maDK, isNot, dungToiThieu, moTa);
        this.maNV = maNV;
        this.loaiQH = loaiQH;
        this.vongQuanHe = vongQuanHe;
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
    public String getLoaiQH() {
        return this.loaiQH;
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
     * @param loaiQH
     */
    public void setLoaiQH(String loaiQH) {
        this.loaiQH = loaiQH;
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
    public DK_ThanThiet cloneDK() {
        return new DK_ThanThiet(
                this.maDK,
                this.isNot,
                this.dungToiThieu,
                this.moTa,
                this.maNV,
                this.loaiQH,
                this.vongQuanHe,
                this.thanThiet,
                this.tinTuong);
    }

    /**
     * @return
     */
    @Override
    public String loaiDK() {
        return "DK_TT";
    }

    /**
     * @param dsDT
     * @param bc
     * @return
     */
    @Override
    public boolean kiemTraDK(ArrayList<NhanVat> dsDT, BoiCanh bc) {
        int count = 0;
        int toiThieu = this.dungToiThieu;
        if (this.dungToiThieu == -1) {
            toiThieu = dsDT.size();
        }
        NhanVat mc = Model.ModelNhanVat.getNhanVat(this.maNV);
        
        if (dsDT.size() < this.dungToiThieu) {
            return false;
        }
        
        for (NhanVat nv : dsDT) {
            MoiQuanHe mqh = mc.getMoiQuanHe(nv.getMaNV());
            if (mqh != null) {
                if (mqh.getQuanHe().equals(this.loaiQH)) {
                    boolean KQKiemTra = (mqh.getThanThiet() >= this.thanThiet && mqh.getTinTuong() >= this.tinTuong);
                    if (KQKiemTra != this.isNot) {
                        count++;
                    }
                }
            } else {
                if ("Người lạ".equals(this.loaiQH)) {
                    count++;
                } else {
                    return false;
                }
            }
            if (count >= toiThieu) {
                return true;
            }
        }

        return false;
    }

}
