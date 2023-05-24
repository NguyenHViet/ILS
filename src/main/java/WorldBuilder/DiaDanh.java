package WorldBuilder;

import GameEvent.*;
import GameObject.*;
import SupportClass.*;
import java.util.*;

/**
 *
 */
public class DiaDanh extends BoiCanh {

    /**
     * Default constructor
     */
    public DiaDanh() {
        super();
        this.loaiDD = "";
        this.dsLC = new ArrayList<LuaChon>();
        this.taiNguyen = new ArrayList<VatPham>();
    }

    /**
     *
     */
    private String loaiDD;

    /**
     *
     */
    private ArrayList<VatPham> taiNguyen;

    /**
     *
     */
    private ArrayList<LuaChon> dsLC;
    
    

    /**
     * @param maBC
     * @param tenBC
     * @param dsTT
     * @param boiCanhChung
     * @param loaiDD
     * @param taiNguyen
     * @param dsLC
     */
    public DiaDanh(String maBC,
            String tenBC,
            ArrayList<ThuocTinh> dsTT,
            BoiCanh boiCanhChung,
            String loaiDD,
            ArrayList<VatPham> taiNguyen,
            ArrayList<LuaChon> dsLC) {
        super(maBC, tenBC, dsTT, boiCanhChung);
        this.loaiDD = loaiDD;
        this.taiNguyen = taiNguyen;
        this.dsLC = dsLC;
    }

    /**
     * @return
     */
    public ArrayList<VatPham> getTaiNguyen() {
        return this.taiNguyen;
    }

    /**
     * @return
     */
    public String getLoaiDD() {
        return this.loaiDD;
    }

    /**
     * @return
     */
    public ArrayList<LuaChon> getDSLC() {
        return this.dsLC;
    }

    /**
     * @param dsDT
     * @param tg
     * @return
     */
    public ArrayList<LuaChon> layLCPhuHop(ArrayList<NhanVat> dsDT, TheGioi tg) {
        ArrayList<LuaChon> dsLCPhuHop = new ArrayList<LuaChon>();
        return dsLCPhuHop;
    }

    /**
     * @param loaiDD
     */
    public void setLoaiDD(String loaiDD) {
        this.loaiDD = loaiDD;
    }

    /**
     * @param taiNguyen
     */
    public void setTaiNguyen(ArrayList<VatPham> taiNguyen) {
        this.taiNguyen = taiNguyen;
    }

    /**
     * @param dsLC
     */
    public void setDSLC(ArrayList<LuaChon> dsLC) {
        this.dsLC = dsLC;
    }

    /**
     * @return
     */
    @Override
    public DiaDanh cloneBC() {
        return new DiaDanh(this.maBC,
                this.tenBC,
                this.dsTT,
                this.boiCanh,
                this.loaiDD,
                this.taiNguyen,
                this.dsLC);
    }

    /**
     * @return
     */
    @Override
    public String loaiBC() {
        return "BC_DD";
    }

    @Override
    public void chiuTacDong(HieuUng hu) {
    }

}
