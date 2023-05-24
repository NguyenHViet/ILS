package GameEvent;

import GameObject.NhanVat;
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
     * @param maDK
     * @param isNot
     * @param dungToiThieu
     * @param moTa
     * @param maNV
     * @param moiQH
     * @param thanThiet
     * @param tinTuong
     */
    public DK_ThanThiet(String maDK, boolean isNot, int dungToiThieu, String moTa, String maNV, String moiQH, int thanThiet, int tinTuong) {
        super(maDK, isNot, dungToiThieu, moTa);
        this.maNV = maNV;
        this.moiQH = moiQH;
        this.thanThiet = thanThiet;
        this.tinTuong = tinTuong;
    }

    /**
     * @return
     */
    public String getMaNV() {
        return this.maNV = maNV;
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
    public DK_ThanThiet cloneDK() {
        return new DK_ThanThiet(this.maDK, this.isNot, this.dungToiThieu, this.moTa, this.maNV, this.moiQH, this.thanThiet, this.tinTuong);
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
        for (NhanVat nv : dsDT) {
            MoiQuanHe mqh = nv.getMoiQuanHe(this.maNV);
            if (mqh != null) {
                if (mqh.getQuanHe().equals(this.moiQH)) {
                    boolean KQKiemTra = (mqh.getThanThiet() >= this.thanThiet && mqh.getTinTuong() >= this.tinTuong);
                    if (KQKiemTra != this.isNot) {
                        count++;
                    }
                }
            }
            if (count >= this.dungToiThieu) {
                return true;
            }
        }
        return false;
    }

}
