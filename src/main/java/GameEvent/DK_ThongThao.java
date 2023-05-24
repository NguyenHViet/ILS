package GameEvent;

import GameObject.NhanVat;
import SupportClass.NgheNghiep;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class DK_ThongThao extends DieuKien {

    /**
     * Default constructor
     */
    public DK_ThongThao() {
        super();
        this.maNN = "";
        this.thongThao = 0;
        this.capBac = 0;
    }

    /**
     *
     */
    private String maNN;

    /**
     *
     */
    private int thongThao;

    /**
     *
     */
    private int capBac;

    /**
     * @param maDK
     * @param isNot
     * @param dungToiThieu
     * @param moTa
     * @param maNN
     * @param thongThao
     * @param capBac
     */
    public DK_ThongThao(String maDK, boolean isNot, int dungToiThieu, String moTa, String maNN, int thongThao, int capBac) {
        super(maDK, isNot, dungToiThieu, moTa);
        this.maNN = maNN;
        this.thongThao = thongThao;
        this.capBac = capBac;
    }

    /**
     * @return
     */
    public String getMaNN() {
        return this.maNN;
    }

    /**
     * @return
     */
    public int getThongThao() {
        return this.thongThao;
    }

    /**
     * @return
     */
    public int getCapBac() {
        return this.capBac;
    }

    /**
     * @param maNN
     */
    public void setMaNN(String maNN) {
        this.maNN = maNN;
    }

    /**
     * @param thongThao
     */
    public void setThongThao(int thongThao) {
        this.thongThao = thongThao;
    }

    /**
     * @param capBac
     */
    public void setCapBac(int capBac) {
        this.capBac = capBac;
    }

    /**
     * @return
     */
    @Override
    public DK_ThongThao cloneDK() {
        return new DK_ThongThao(this.maDK, this.isNot, this.dungToiThieu, this.moTa, this.maNN, this.thongThao, this.capBac);
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
            NgheNghiep job = nv.getNgheNghiep();
            boolean KQKiemTra = (job.getThongThao() >= this.thongThao && job.getChucVu().getCapBac() >= this.capBac);
            if (KQKiemTra != this.isNot) {
                count++;
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
        return "DK_TgT";
    }

}
