package GameEvent;

import GameObject.NhanVat;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class LuaChon implements Interface_KichHoatSK {

    /**
     * Default constructor
     */
    public LuaChon() {
        this.maLC = "";
        this.moTa = "";
        this.dsSK = new ArrayList<String>();
        this.dsDK = new ArrayList<DieuKien>();
        this.dsDTTG = new ArrayList<NhanVat>();
        this.boiCanh = null;
        this.loaiDTTG = "";
    }

    /**
     *
     */
    private String maLC;

    /**
     *
     */
    private String moTa;

    /**
     *
     */
    private ArrayList<String> dsSK;

    /**
     *
     */
    private ArrayList<DieuKien> dsDK;

    /**
     *
     */
    private ArrayList<NhanVat> dsDTTG;

    /**
     *
     */
    private BoiCanh boiCanh;

    private String loaiDTTG;

    private int soLuongDTTG;

    /**
     * Get the value of soLuongDTTG
     *
     * @return the value of soLuongDTTG
     */
    public int getSoLuongDTTG() {
        return soLuongDTTG;
    }

    /**
     * Set the value of soLuongDTTG
     *
     * @param soLuongDTTG new value of soLuongDTTG
     */
    public void setSoLuongDTTG(int soLuongDTTG) {
        this.soLuongDTTG = soLuongDTTG;
    }

    /**
     * Get the value of loaiDTTG
     *
     * @return the value of loaiDTTG
     */
    public String getLoaiDTTG() {
        return loaiDTTG;
    }

    /**
     * Set the value of loaiDTTG
     *
     * @param loaiDTTG new value of loaiDTTG
     */
    public void setLoaiDTTG(String loaiDTTG) {
        this.loaiDTTG = loaiDTTG;
    }

    /**
     * @param maLC
     * @param moTa
     * @param dsSK
     * @param dsDK
     * @param loaiDTTG
     * @param dsDTTG
     * @param boiCanh
     */
    public LuaChon(String maLC,
            String moTa,
            ArrayList<String> dsSK,
            ArrayList<DieuKien> dsDK,
            String loaiDTTG,
            int soLuongDTTG,
            ArrayList<NhanVat> dsDTTG,
            BoiCanh boiCanh) {
        this.maLC = maLC;
        this.moTa = moTa;
        this.dsSK = dsSK;
        this.dsDK = dsDK;
        this.loaiDTTG = loaiDTTG;
        this.soLuongDTTG = soLuongDTTG;
        this.dsDTTG = dsDTTG;
        this.boiCanh = boiCanh;
    }

    /**
     * @return
     */
    public String getMaLC() {
        return this.maLC;
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
    public ArrayList<String> getDSSK() {
        return this.dsSK;
    }

    /**
     * @return
     */
    public ArrayList<DieuKien> getDSDK() {
        return this.dsDK;
    }

    /**
     * @return
     */
    public ArrayList<NhanVat> getDSDTTG() {
        return this.dsDTTG;
    }

    /**
     * @return
     */
    public BoiCanh getBoiCanh() {
        return this.boiCanh;
    }

    /**
     * @param moTa
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @param dsSK
     */
    public void setDSSK(ArrayList<String> dsSK) {
        this.dsSK = dsSK;
    }

    /**
     * @param dsDK
     */
    public void setDSDK(ArrayList<DieuKien> dsDK) {
        this.dsDK = dsDK;
    }

    /**
     * @param dsDTTG
     */
    public void setDSDTTG(ArrayList<NhanVat> dsDTTG) {
        this.dsDTTG = dsDTTG;
    }

    /**
     * @param boiCanh
     */
    public void setBoiCanh(BoiCanh boiCanh) {
        this.boiCanh = boiCanh;
    }

    /**
     * @return
     */
    public LuaChon cloneLC() {
        return new LuaChon(
                this.maLC,
                this.moTa,
                this.dsSK,
                this.dsDK,
                this.loaiDTTG,
                this.soLuongDTTG,
                this.dsDTTG,
                this.boiCanh);
    }

    /**
     * @return
     */
    @Override
    public boolean kiemTraDK() {
        if (dsDK == null) {
            return true;
        }
        for (DieuKien dk : dsDK) {
            if (!dk.kiemTraDK(dsDTTG, boiCanh)) {
                return false;
            }
        }
        return true;
    }

    /**
     */
    @Override
    public void kichHoat() {
        // TODO implement here
    }

}
