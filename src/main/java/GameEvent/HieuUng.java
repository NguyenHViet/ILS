package GameEvent;

import WorldBuilder.*;
import GameObject.*;
import java.util.*;

/**
 *
 */
public abstract class HieuUng implements Interface_KiemTraDK {

    /**
     * Default constructor
     */
    public HieuUng() {
        this.maHU = "";
        this.moTa = "";
        this.dsDK = new ArrayList<DieuKien>();
    }

    /**
     *
     */
    protected String maHU;

    /**
     *
     */
    protected String moTa;

    /**
     *
     */
    protected ArrayList<DieuKien> dsDK;

    /**
     * @param maHU
     * @param moTa
     * @param dsDK
     */
    public HieuUng(String maHU, String moTa, ArrayList<DieuKien> dsDK) {
        this.maHU = maHU;
        this.moTa = moTa;
        this.dsDK = dsDK;
    }

    /**
     * @return
     */
    public String getMaHU() {
        return this.maHU;
    }

    /**
     * @return
     */
    public String getMoTa() {
        return this.moTa;
    }

    /**
     * @return
     */
    public ArrayList<DieuKien> getDSDK() {
        return this.dsDK;
    }

    /**
     * @param moTa
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @param dsDK
     */
    public void setDSDK(ArrayList<DieuKien> dsDK) {
        this.dsDK = dsDK;
    }

    /**
     * @return
     */
    abstract public HieuUng cloneHU();

    /**
     * @return
     */
    abstract public String loaiHU();
    
    @Override
    abstract public boolean kiemTraDK(ArrayList<NhanVat> dsDT, BoiCanh bc);
    
}
