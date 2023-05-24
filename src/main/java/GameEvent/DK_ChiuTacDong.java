package GameEvent;

import GameObject.NhanVat;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class DK_ChiuTacDong extends DieuKien {

    /**
     * Default constructor
     */
    public DK_ChiuTacDong() {
        super();
        this.maHU = "";
    }

    /**
     *
     */
    private String maHU;

    /**
     * @param maDK
     * @param isNot
     * @param dungToiThieu
     * @param moTa
     * @param maHU
     */
    public DK_ChiuTacDong(String maDK, boolean isNot, int dungToiThieu, String moTa, String maHU) {
        super(maDK, isNot, dungToiThieu, moTa);
        this.maHU = maHU;
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

    public boolean kiemTraDK(String maHU) {
        boolean KQKiemTra = (this.maHU.equals(maHU));
        return KQKiemTra != this.isNot;
    }

    /**
     * @return
     */
    public String getMaHU() {
        return this.maHU;
    }

    /**
     * @param maHU
     */
    public void setMaHU(String maHU) {
        this.maHU = maHU;
    }

    /**
     * @return
     */
    @Override
    public DK_ChiuTacDong cloneDK() {
        return new DK_ChiuTacDong(this.maDK, this.isNot, this.dungToiThieu, this.moTa, this.maHU);
    }

    /**
     * @return
     */
    @Override
    public String loaiDK() {
        return "DK_CTD";
    }

}
