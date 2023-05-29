package WorldBuilder;

import SupportClass.*;
import GameEvent.*;
import java.util.*;

/**
 *
 */
public abstract class BoiCanh {
    

    /**
     * Default constructor
     */
    public BoiCanh() {
        this.maBC = "";
        this.tenBC = "";
        this.dsTT = new ArrayList<>();
        this.hoanhDo = 0;
        this.tungDo = 0;
        this.boiCanh = null;
    }

    /**
     *
     */
    protected String maBC;

    /**
     *
     */
    protected String tenBC;

    /**
     *
     */
    protected ArrayList<ThuocTinh> dsTT;

    protected int hoanhDo;

    protected int tungDo;

    protected BoiCanh boiCanh;

    /**
     * Get the value of boiCanh
     *
     * @return the value of boiCanh
     */
    public BoiCanh getBoiCanh() {
        return boiCanh;
    }

    /**
     * Set the value of boiCanh
     *
     * @param boiCanh new value of boiCanh
     */
    public void setBoiCanh(BoiCanh boiCanh) {
        this.boiCanh = boiCanh;
    }

    /**
     * Get the value of tungDo
     *
     * @return the value of tungDo
     */
    public int getTungDo() {
        return tungDo;
    }

    /**
     * Set the value of tungDo
     *
     * @param tungDo new value of tungDo
     */
    public void setTungDo(int tungDo) {
        this.tungDo = tungDo;
    }

    /**
     * Get the value of hoanhDo
     *
     * @return the value of hoanhDo
     */
    public int getHoanhDo() {
        return hoanhDo;
    }

    /**
     * Set the value of hoanhDo
     *
     * @param hoanhDo new value of hoanhDo
     */
    public void setHoanhDo(int hoanhDo) {
        this.hoanhDo = hoanhDo;
    }

    public void setToaDo(int[] toaDo) {
        this.tungDo = toaDo[0];
        this.hoanhDo = toaDo[1];
    }

    /**
     * @param maBC
     * @param tenBC
     * @param dsTT
     * @param boiCanh
     */
    public BoiCanh(String maBC, String tenBC, ArrayList<ThuocTinh> dsTT, BoiCanh boiCanh) {
        this.maBC = maBC;
        this.tenBC = tenBC;
        this.dsTT = dsTT;
        this.boiCanh = boiCanh;
    }

    /**
     * @param maBC
     */
    public BoiCanh(String maBC) {
        this.maBC = maBC;
        this.tenBC = "";
        this.dsTT = new ArrayList<>();
    }

    /**
     * @param hu
     */
    abstract public void chiuTacDong(HieuUng hu);

    /**
     * @return
     */
    public String getMaBC() {
        return this.maBC;
    }

    /**
     * @return
     */
    public String getTenBC() {
        return this.tenBC;
    }

    /**
     * @return
     */
    public ArrayList<ThuocTinh> getDSTT() {
        return this.dsTT;
    }

    /**
     * @param maTT
     * @return
     */
    public ThuocTinh getThuocTinh(String maTT) {
        ThuocTinh tt_info = null;
        for (ThuocTinh tt : this.dsTT) {
            if (tt.getMaTT().equals(maTT)) {
                tt_info = tt;
                break;
            }
        }
        return tt_info;
    }

    /**
     * @param tenBC
     */
    public void setTenBC(String tenBC) {
        this.tenBC = tenBC;
    }

    /**
     * @param dsTT
     */
    public void setDSTT(ArrayList<ThuocTinh> dsTT) {
        this.dsTT = dsTT;
    }

    /**
     * @return
     */
    abstract public BoiCanh cloneBC();

    /**
     * @return
     */
    abstract public String loaiBC();

}
