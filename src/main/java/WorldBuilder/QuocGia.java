package WorldBuilder;

import GameEvent.*;
import SupportClass.*;
import java.util.*;

/**
 *
 */
public class QuocGia extends BoiCanh {

    /**
     * Default constructor
     */
    public QuocGia() {
        super();
        this.dsT = new ArrayList<Tinh>();
    }

    /**
     *
     */
    private ArrayList<Tinh> dsT;

    /**
     * @param maBC
     * @param tenBC
     * @param dsTT
     * @param boiCanh
     * @param dsT
     */
    public QuocGia(String maBC, String tenBC, ArrayList<ThuocTinh> dsTT, BoiCanh boiCanh, ArrayList<Tinh> dsT) {
        super(maBC, tenBC, dsTT, boiCanh);
        this.dsT = dsT;
    }

    /**
     * @return
     */
    public ArrayList<Tinh> getDST() {
        return this.dsT;
    }

    /**
     * @param dsT
     */
    public void setDST(ArrayList<Tinh> dsT) {
        this.dsT = dsT;
    }

    /**
     * @param hu
     */
    @Override
    public void chiuTacDong(HieuUng hu) {
        // TODO implement here
    }

    /**
     * @return
     */
    @Override
    public QuocGia cloneBC() {
        return new QuocGia(this.maBC, this.tenBC, this.dsTT, this.boiCanh, this.dsT);
    }

    /**
     * @return
     */
    @Override
    public String loaiBC() {
        return "BC_QG";
    }

}
