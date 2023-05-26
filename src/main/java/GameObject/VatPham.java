package GameObject;

import GameEvent.*;
import WorldBuilder.*;
import java.util.*;

/**
 *
 */
public abstract class VatPham {

    /**
     * Default constructor
     */
    public VatPham() {
        this.maVP = "";
        this.tenVP = "";
        this.loaiVP = "";
        this.moTa = "";
        this.dsLC = new ArrayList<LuaChon>();
    }

    /**
     *
     */
    protected String maVP;

    /**
     *
     */
    protected String tenVP;

    /**
     *
     */
    protected String loaiVP;

    /**
     *
     */
    protected ArrayList<LuaChon> dsLC;

    protected String moTa;

    /**
     * Get the value of moTa
     *
     * @return the value of moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * Set the value of moTa
     *
     * @param moTa new value of moTa
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @param maVP
     * @param tenVP
     * @param loaiVP
     * @param moTa
     * @param dsLC
     */
    public VatPham(String maVP, String tenVP, String loaiVP, String moTa, ArrayList<LuaChon> dsLC) {
        this.maVP = maVP;
        this.tenVP = tenVP;
        this.loaiVP = loaiVP;
        this.moTa = moTa;
        this.dsLC = dsLC;
    }

    /**
     * @return
     */
    public String getMaVP() {
        return this.maVP;
    }

    /**
     * @return
     */
    public String getTenVP() {
        return this.tenVP;
    }

    /**
     * @return
     */
    public String getLoaiVP() {
        return this.loaiVP;
    }

    /**
     * @return
     */
    public ArrayList<LuaChon> getDSLC() {
        return this.dsLC;
    }

    /**
     * @param dsDT
     * @param bc
     * @return
     */
    public ArrayList<LuaChon> getLCPhuHop(ArrayList<NhanVat> dsDT, BoiCanh bc) {
        // TODO implement here
        return null;
    }

    /**
     * @param tenVP
     */
    public void setTenVP(String tenVP) {
        this.tenVP = tenVP;
    }

    /**
     * @param loaiVP
     * @return
     */
    public void setLoaiVP(String loaiVP) {
        this.loaiVP = loaiVP;
    }

    /**
     * @param dsLC
     * @return
     */
    public void setDSLC(ArrayList<LuaChon> dsLC) {
        this.dsLC = dsLC;
    }

    /**
     * @return
     */
    abstract public VatPham cloneVP();

    /**
     * @return
     */
    abstract public String loaiVP();

}
