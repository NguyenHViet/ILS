package GameEvent;

import GameObject.NhanVat;
import SupportClass.KyNang;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class DK_CapDo extends DieuKien {

    /**
     * Default constructor
     */
    public DK_CapDo() {
        super();
        this.maKN = "";
        this.capDo = 0;
    }

    /**
     *
     */
    private String maKN;

    /**
     *
     */
    private int capDo;

    /**
     * @param maDK
     * @param isNot
     * @param dungToiThieu
     * @param moTa
     * @param maKN
     * @param capDo
     */
    public DK_CapDo(String maDK, boolean isNot, int dungToiThieu, String moTa, String maKN, int capDo) {
        super(maDK, isNot, dungToiThieu, moTa);
        this.maKN = maKN;
        this.capDo = capDo;
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
    public int getCapDo() {
        return this.capDo;
    }

    /**
     * @param maKN
     */
    public void setMaKN(String maKN) {
        this.maKN = maKN;
    }

    /**
     * @param capDo
     */
    public void setCapDo(int capDo) {
        this.capDo = capDo;
    }

    /**
     * @return
     */
    @Override
    public DK_CapDo cloneDK() {
        return new DK_CapDo(this.maDK, this.isNot, this.dungToiThieu, this.moTa, this.maKN, this.capDo);
    }

    /**
     * @param dsDT
     * @param bc
     * @return
     */
    @Override
    public boolean kiemTraDK(ArrayList<NhanVat> dsDT, BoiCanh bc) {
        int count = 0;
        for (NhanVat nv : dsDT) {
            for (KyNang kn : nv.getDSKyNang()) {
                if (kn != null) {
                    if (kn.getMaKN().equals(this.maKN)) {
                        boolean KQKiemTra = (kn.getCapDo() >= this.capDo);
                        if (KQKiemTra != this.isNot) {
                            count++;
                        }
                        break;
                    }
                }
            }
            if (count >= this.dungToiThieu) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return
     */
    @Override
    public String loaiDK() {
        return "DK_KN";
    }

}
