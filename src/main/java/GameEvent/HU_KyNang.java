package GameEvent;

import GameObject.NhanVat;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class HU_KyNang extends HieuUng {

    /**
     * Default constructor
     */
    public HU_KyNang() {
        super();
        this.maKN = "";
        this.kinhNghiem = 0;
    }

    /**
     *
     */
    private String maKN;

    /**
     *
     */
    private int kinhNghiem;

    /**
     * @param maHU
     * @param moTa
     * @param dsDK
     * @param maKN
     * @param kinhNghiem
     */
    public HU_KyNang(String maHU, String moTa, ArrayList<DieuKien> dsDK, String maKN, int kinhNghiem) {
        super(maHU, moTa, dsDK);
        this.maKN = maKN;
        this.kinhNghiem = kinhNghiem;
    }

    /**
     * @return
     */
    public String getMaKN() {
        return this.maKN;
    }

    /**
     * @return
     */
    public int getKinhNghiem() {
        return this.kinhNghiem;
    }

    /**
     * @param maKN
     */
    public void setMaKN(String maKN) {
        this.maKN = maKN;
    }

    /**
     * @param kinhNghiem
     * @return
     */
    public void setKinhNghiem(int kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }

    /**
     * @return
     */
    @Override
    public HU_KyNang cloneHU() {
        return new HU_KyNang(this.maHU, this.moTa, this.dsDK, this.maKN, this.kinhNghiem);
    }

    /**
     * @return
     */
    @Override
    public String loaiHU() {
        return "HU_KN";
    }

    /**
     * @param dsDT
     * @param bc
     * @return
     */
    @Override
    public boolean kiemTraDK(ArrayList<NhanVat> dsDT, BoiCanh bc) {
        return false;
    }

}
