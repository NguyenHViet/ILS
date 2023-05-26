package GameObject;

import GameEvent.HieuUng;
import GameEvent.LuaChon;
import SupportClass.ThuocTinh;
import java.util.*;

/**
 *
 */
public class TrangBi extends VatPham {

    /**
     * Default constructor
     */
    public TrangBi() {
        super();
        this.doBen = 0;
        this.dsTT = new ArrayList<ThuocTinh>();
        this.dsHU = new ArrayList<HieuUng>();
    }

    /**
     *
     */
    private int doBen;

    /**
     *
     */
    private ArrayList<ThuocTinh> dsTT;

    /**
     *
     */
    private ArrayList<HieuUng> dsHU;

    /**
     * @param maVP
     * @param tenVP
     * @param loaiVP
     * @param moTa
     * @param dsLC
     * @param doBen
     * @param dsTT
     * @param dsHU
     */
    public TrangBi(String maVP, String tenVP, String loaiVP, String moTa, ArrayList<LuaChon> dsLC, int doBen, ArrayList<ThuocTinh> dsTT, ArrayList<HieuUng> dsHU) {
        super(maVP, tenVP, loaiVP, moTa, dsLC);
        this.doBen = doBen;
        this.dsTT = dsTT;
        this.dsHU = dsHU;
    }

    /**
     * @return
     */
    public int getDoBen() {
        return this.doBen;
    }

    /**
     * @return
     */
    public ArrayList<ThuocTinh> getDSTT() {
        return this.dsTT;
    }

    /**
     * @return
     */
    public ArrayList<HieuUng> getDSHU() {
        return this.dsHU;
    }

    /**
     * @param doBen
     */
    public void setDoBen(int doBen) {
        this.doBen = doBen;
    }

    /**
     * @param dsTT
     */
    public void setDSTT(ArrayList<ThuocTinh> dsTT) {
        this.dsTT = dsTT;
    }

    /**
     * @param dsHU
     */
    public void setDSHU(ArrayList<HieuUng> dsHU) {
        this.dsHU = dsHU;
    }

    /**
     * @return
     */
    @Override
    public TrangBi cloneVP() {
        return new TrangBi(this.maVP, this.tenVP, this.loaiVP, this.moTa, this.dsLC, this.doBen, this.dsTT, this.dsHU);
    }

    /**
     * @return
     */
    @Override
    public String loaiVP() {
        return "VP_TB";
    }

}
