package SupportClass;

import java.util.*;

/**
 *
 */
public class KyNang {

    /**
     * Default constructor
     */
    public KyNang() {
        this.maKN = "";
        this.tenKN = "";
        this.capDo = 0;
        this.kinhNghiem = 0;
    }

    /**
     *
     */
    private String maKN;

    /**
     *
     */
    private String tenKN;

    /**
     *
     */
    private int capDo;

    /**
     *
     */
    private int kinhNghiem;

    /**
     * @param maKN
     * @param tenKN
     * @param capDo
     * @param kinhNghiem
     */
    public KyNang(String maKN, String tenKN, int capDo, int kinhNghiem) {
        this.maKN = maKN;
        this.tenKN = tenKN;
        this.capDo = capDo;
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
    public String getTenKN() {
        return this.tenKN;
    }

    /**
     * @return
     */
    public int getCapDo() {
        return this.capDo;
    }

    /**
     * @return
     */
    public int getKinhNghiem() {
        return this.kinhNghiem;
    }

    /**
     * @param tenKN
     */
    public void setTenKN(String tenKN) {
        this.tenKN = tenKN;
    }

    /**
     * @param capDo
     */
    public void setCapDo(int capDo) {
        this.capDo = capDo;
    }

    /**
     * @param kinhNghiem
     */
    public void setKinhNghiem(int kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }

    /**
     * @return
     */
    public KyNang cloneKN() {
        return new KyNang(this.maKN, this.tenKN, this.capDo, this.kinhNghiem);
    }

}
