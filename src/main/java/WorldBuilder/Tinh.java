package WorldBuilder;

import GameEvent.*;
import SupportClass.*;
import java.util.*;

/**
 *
 */
public class Tinh extends BoiCanh {

    /**
     * Default constructor
     */
    public Tinh() {
        super();
        this.dsDD = new ArrayList<DiaDanh>();
    }

    /**
     *
     */
    private ArrayList<DiaDanh> dsDD;

    /**
     * @param maBC
     * @param tenBC
     * @param dsTT
     * @param boiCanh
     * @param dsDD
     */
    public Tinh(String maBC, String tenBC, ArrayList<ThuocTinh> dsTT, BoiCanh boiCanh, ArrayList<DiaDanh> dsDD) {
        super(maBC, tenBC, dsTT, boiCanh);
        this.dsDD = dsDD;
    }

    /**
     * @return
     */
    public ArrayList<DiaDanh> getDSDD() {
        return this.dsDD;
    }

    /**
     * @param dsDD
     */
    public void setDSDD(ArrayList<DiaDanh> dsDD) {
        this.dsDD = dsDD;
    }

    /**
     * @return
     */
    @Override
    public Tinh cloneBC() {
        return new Tinh(this.maBC, this.tenBC, this.dsTT, this.boiCanh, this.dsDD);
    }

    /**
     * @return
     */
    @Override
    public String loaiBC() {
        return "BC_T";
    }

    @Override
    public void chiuTacDong(HieuUng hu) {
    }

}
