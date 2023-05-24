package GameObject;

import GameEvent.HieuUng;
import GameEvent.LuaChon;
import java.util.*;

/**
 *
 */
public class VPTieuHao extends VatPham {

    /**
     * Default constructor
     */
    public VPTieuHao() {
        super();
        this.soLuong = 0;
        this.dsHU = new ArrayList<HieuUng>();
    }

    /**
     *
     */
    private int soLuong;

    /**
     *
     */
    private ArrayList<HieuUng> dsHU;

    /**
     * @param maVP
     * @param tenVP
     * @param loaiVP
     * @param dsLC
     * @param soLuong
     * @param dsHU
     */
    public VPTieuHao(String maVP, String tenVP, String loaiVP, ArrayList<LuaChon> dsLC, int soLuong, ArrayList<HieuUng> dsHU) {
        super(maVP, tenVP, loaiVP, dsLC);
        this.soLuong = soLuong;
        this.dsHU = dsHU;
    }

    /**
     * @return
     */
    public int getSoLuong() {
        return this.soLuong;
    }

    /**
     * @return
     */
    public ArrayList<HieuUng> getDSHU() {
        return this.dsHU;
    }

    /**
     * @param soLuong
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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
    public VPTieuHao cloneVP() {
        return new VPTieuHao(this.maVP, this.tenVP, this.loaiVP, this.dsLC, this.soLuong, this.dsHU);
    }

    /**
     * @return
     */
    @Override
    public String loaiVP() {
        return "VP_VPTH";
    }

}
