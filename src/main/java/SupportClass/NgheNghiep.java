package SupportClass;

import java.util.*;
import WorldBuilder.*;
/**
 *
 */
public class NgheNghiep {

    /**
     * Default constructor
     */
    public NgheNghiep() {
        this.maNN = "";
        this.tenNN = "";
        this.thongThao = 0;
        this.diaDiemLV = new DiaDanh();
        this.chucVu = new ChucVu();
    }

    /**
     *
     */
    private String maNN;

    /**
     *
     */
    private String tenNN;

    /**
     *
     */
    private int thongThao;

    /**
     *
     */
    private DiaDanh diaDiemLV;

    /**
     *
     */
    private ChucVu chucVu;

    /**
     * @param maNN
     * @param tenNN
     * @param thongThao
     * @param diaDiemLV
     * @param chucVu
     */
    public NgheNghiep(String maNN, String tenNN, int thongThao, DiaDanh diaDiemLV, ChucVu chucVu) {
        this.maNN = maNN;
        this.tenNN = tenNN;
        this.thongThao = thongThao;
        this.diaDiemLV = diaDiemLV;
        this.chucVu = chucVu;
    }

    /**
     * @return
     */
    public long lamViec() {
//        Lương cơ bản
        long luong = this.chucVu.getLuong();
        return luong;
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
    public String getTenNN() {
        return this.tenNN;
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
    public ChucVu getChucVu() {
        return this.chucVu;
    }

    /**
     * @return
     */
    public DiaDanh getDiaDiemLV() {
        return this.diaDiemLV;
    }

    /**
     * @param tenNN
     */
    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    /**
     * @param thongThao
     */
    public void setThongThao(int thongThao) {
        this.thongThao = thongThao;
    }

    /**
     * @param chucVu
     */
    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    /**
     * @param diaDiemLV
     */
    public void setDiaDiemLV(DiaDanh diaDiemLV) {
        this.diaDiemLV = diaDiemLV;
    }

    /**
     * @return
     */
    public NgheNghiep cloneNN() {
        return new NgheNghiep(this.maNN, this.tenNN, this.thongThao, this.diaDiemLV, this.chucVu);
    }

}
