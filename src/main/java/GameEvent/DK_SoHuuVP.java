package GameEvent;

import GameObject.NhanVat;
import GameObject.TrangBi;
import GameObject.VPTieuHao;
import GameObject.VatPham;
import WorldBuilder.BoiCanh;
import WorldBuilder.DiaDanh;
import java.util.*;

/**
 *
 */
public class DK_SoHuuVP extends DieuKien {

    /**
     * Default constructor
     */
    public DK_SoHuuVP() {
        super();
        this.maVP = "";
        this.loaiVP = "";
        this.soLuong = 0;
        this.loaiDT = "";
    }

    /**
     *
     */
    private String maVP;

    /**
     *
     */
    private String loaiVP;

    /**
     *
     */
    private int soLuong;

    /**
     *
     */
    private String loaiDT;

    /**
     * @param maDK
     * @param isNot
     * @param dungToiThieu
     * @param moTa
     * @param maVP
     * @param loaiVP
     * @param soLuong
     * @param loaiDT
     */
    public DK_SoHuuVP(String maDK, boolean isNot, int dungToiThieu, String moTa, String maVP, String loaiVP, int soLuong, String loaiDT) {
        super(maDK, isNot, dungToiThieu, moTa);
        this.maVP = maVP;
        this.loaiVP = loaiVP;
        this.soLuong = soLuong;
        this.loaiDT = loaiDT;
    }

    /**
     * @param dsDT
     * @param bc
     * @return
     */
    @Override
    public boolean kiemTraDK(ArrayList<NhanVat> dsDT, BoiCanh bc) {
        switch (loaiDT) {
            case "NV":
                int count = 0;
                for (NhanVat nv : dsDT) {
                    int sLg = 0;
                    for (VatPham vp : nv.getTuiDo()) {
                        if (!this.maVP.equals("")) {
                            if (vp.getMaVP().equals(this.maVP)) {
                                if (vp instanceof VPTieuHao) {
                                    sLg += ((VPTieuHao) vp).getSoLuong();
                                } else if (vp instanceof TrangBi) {
                                    sLg += 1;
                                }
                            }
                        } else {
                            if (vp.getLoaiVP().equals(this.loaiVP)) {
                                if (vp instanceof VPTieuHao) {
                                    sLg += ((VPTieuHao) vp).getSoLuong();
                                } else if (vp instanceof TrangBi) {
                                    sLg += 1;
                                }
                            }
                        }
                    }
                    boolean KQKiemTra = (sLg >= this.soLuong);
                    if (KQKiemTra != this.isNot) {
                        count++;
                    }

                    if (count >= this.dungToiThieu) {
                        return true;
                    }
                }
                break;
            case "BC":
                if (bc instanceof DiaDanh) {
                    int sLg = 0;
                    for (VatPham vp : ((DiaDanh) bc).getTaiNguyen()) {
                        if (!this.maVP.equals("")) {
                            if (vp.getMaVP().equals(this.maVP)) {
                                if (vp instanceof VPTieuHao) {
                                    sLg += ((VPTieuHao) vp).getSoLuong();
                                } else if (vp instanceof TrangBi) {
                                    sLg += 1;
                                }
                            }
                        } else {
                            if (vp.getLoaiVP().equals(this.loaiVP)) {
                                if (vp instanceof VPTieuHao) {
                                    sLg += ((VPTieuHao) vp).getSoLuong();
                                } else if (vp instanceof TrangBi) {
                                    sLg += 1;
                                }
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
        return false;
    }

    /**
     * @return
     */
    public String getMaVP() {
        return this.maVP;
    }

    /**
     * @return
     */
    public String getLoaiVP() {
        return this.loaiVP;
    }

    /**
     * @return
     */
    public int getSoLuong() {
        return this.soLuong;
    }

    /**
     * @return
     */
    public String getLoaiDT() {
        return this.loaiDT;
    }

    /**
     * @param maVP
     */
    public void setMaVP(String maVP) {
        this.maVP = maVP;
    }

    /**
     * @param loaiVP
     */
    public void setLoaiVP(String loaiVP) {
        this.loaiVP = loaiVP;
    }

    /**
     * @param soLuong
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @param loaiDT
     */
    public void setLoaiDT(String loaiDT) {
        this.loaiDT = loaiDT;
    }

    /**
     * @return
     */
    @Override
    public DK_SoHuuVP cloneDK() {
        return new DK_SoHuuVP(this.maDK, this.isNot, this.dungToiThieu, this.moTa, this.maVP, this.loaiVP, this.soLuong, this.loaiDT);
    }

    /**
     * @return
     */
    @Override
    public String loaiDK() {
        return "DK_SHVP";
    }

}
