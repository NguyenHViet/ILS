package WorldBuilder;

import GameEvent.*;
import SupportClass.*;
import java.util.*;

/**
 *
 */
public class TheGioi extends BoiCanh {

    /**
     * Default constructor
     */
    public TheGioi() {
        super();
        this.dsQG = new ArrayList<QuocGia>();
    }

    /**
     *
     */
    private ArrayList<QuocGia> dsQG;

    /**
     * @param maBC
     * @param tenBC
     * @param dsTT
     * @param dsQG
     */
    public TheGioi(String maBC, String tenBC, ArrayList<ThuocTinh> dsTT, ArrayList<QuocGia> dsQG) {
        super(maBC, tenBC, dsTT, null);
        this.dsQG = dsQG;
    }

    /**
     * @param maBC
     */
    public TheGioi(String maBC) {
        super(maBC);
        this.dsQG = new ArrayList<QuocGia>();
    }

    /**
     * @return
     */
    public ArrayList<QuocGia> getDSQG() {
        return this.dsQG;
    }

    /**
     * @param dsQG
     */
    public void setDSQG(ArrayList<QuocGia> dsQG) {
        this.dsQG = dsQG;
    }

    /**
     * @param hu
     */
    @Override
    public void chiuTacDong(HieuUng hu) {
    }

    /**
     * @return
     */
    @Override
    public TheGioi cloneBC() {
        return new TheGioi(this.maBC, this.tenBC, this.dsTT, this.dsQG);
    }

    /**
     * @return
     */
    @Override
    public String loaiBC() {
        return "BC_TG";
    }

}
