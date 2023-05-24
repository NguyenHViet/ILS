package GameEvent;

import java.util.*;
import GameObject.*;
import WorldBuilder.*;

/**
 *
 */
public abstract class DieuKien implements Interface_KiemTraDK {

    /**
     * Default constructor
     */
    public DieuKien() {
        this.maDK = "";
        this.moTa = "";
        this.isNot = false;
        this.dungToiThieu = -1;
    }

    /**
     *
     */
    protected String maDK;

    /**
     *
     */
    protected boolean isNot;

    /**
     *
     */
    protected int dungToiThieu;

    /**
     *
     */
    protected String moTa;

    /**
     * @param maDK
     * @param isNot
     * @param dungToiThieu
     * @param moTa
     */
    public DieuKien(String maDK, boolean isNot, int dungToiThieu, String moTa) {
        this.maDK = maDK;
        this.dungToiThieu = dungToiThieu;
        this.moTa = moTa;
        this.isNot = isNot;
    }

    /**
     * @return
     */
    public String getMaDK() {
        return this.maDK;
    }

    /**
     * @return
     */
    public boolean getDkDung() {
        return this.isNot;
    }

    /**
     * @return
     */
    public String getMoTa() {
        return this.moTa;
    }

    /**
     * @param dkDung
     */
    public void setDkDung(boolean dkDung) {
        this.isNot = dkDung;
    }

    /**
     * @param moTa
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return
     */
    abstract public DieuKien cloneDK();

    /**
     * @return
     */
    abstract public String loaiDK();

    @Override
    abstract public boolean kiemTraDK(ArrayList<NhanVat> dsDT, BoiCanh bc);

}
