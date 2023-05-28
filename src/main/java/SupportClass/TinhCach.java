package SupportClass;

import GameEvent.*;
import java.util.*;

/**
 *
 */
public class TinhCach extends ThuocTinh {

    /**
     * Default constructor
     */
    public TinhCach() {
        super();
        this.mucDo = 0;
    }

    /**
     *
     */
    private int mucDo;

    /**
     * @param maTT
     * @param tenTT
     * @param moTa
     * @param hienThi
     * @param mucDo
     */
    public TinhCach(String maTT, String tenTT, String moTa, boolean hienThi, int mucDo) {
        super(maTT, tenTT, moTa, hienThi);
        this.mucDo = mucDo;
    }

    /**
     * @return
     */
    public int getMucDo() {
        return this.mucDo;
    }

    /**
     * @param mucDo
     */
    public void setMucDo(int mucDo) {
        this.mucDo = mucDo;
    }

    /**
     * @return
     */
    @Override
    public TinhCach cloneTT() {
        return new TinhCach(this.maTT, this.tenTT, this.moTa, this.hienThi, this.mucDo);
    }

    /**
     * @return
     */
    @Override
    public String loaiTT() {
        return "TT_TC";
    }

}
