package GameEvent;

import GameObject.NhanVat;
import SupportClass.*;
import WorldBuilder.BoiCanh;
import java.util.*;

/**
 *
 */
public class DK_SoSanh extends DieuKien {

    public static final String NHO_HON = "nhohon";
    public static final String NHO_HON_HOAC_BANG = "nhohonhoacbang";
    public static final String LON_HON = "lonhon";
    public static final String LON_HON_HOAC_BANG = "lonhonhoacbang";
    public static final String BANG_NHAU = "bangnhau";
    public static final String KHAC_NHAU = "khacnhau";

    /**
     * Default constructor
     */
    public DK_SoSanh() {
        super();
        this.maTT = "";
        this.giaTriSS = 0;
        this.loaiDT = "";
        this.loaiSS = "";
    }

    /**
     *
     */
    private String maTT;

    /**
     *
     */
    private int giaTriSS;

    /**
     *
     */
    private String loaiDT;

    /**
     *
     */
    private String loaiSS;

    /**
     * Get the value of loaiSS
     *
     * @return the value of loaiSS
     */
    public String getLoaiSS() {
        return loaiSS;
    }

    /**
     * Set the value of loaiSS
     *
     * @param loaiSS new value of loaiSS
     */
    public void setLoaiSS(String loaiSS) {
        this.loaiSS = loaiSS;
    }

    /**
     * @param maDK
     * @param isNot
     * @param dungToiThieu
     * @param moTa
     * @param maTT
     * @param giaTriSS
     * @param loaiDT
     * @param loaiSS
     */
    public DK_SoSanh(String maDK,
            boolean isNot,
            int dungToiThieu,
            String moTa,
            String maTT,
            int giaTriSS,
            String loaiDT,
            String loaiSS) {
        super(maDK, isNot, dungToiThieu, moTa);
        this.maTT = maTT;
        this.giaTriSS = giaTriSS;
        this.loaiDT = loaiDT;
        this.loaiSS = loaiSS;
    }

    private boolean soSanhGiaTri(int giaTriKiemTra, int giaTriSoSanh) {
        switch (this.loaiSS) {
            case DK_SoSanh.NHO_HON:
                if (giaTriKiemTra < giaTriSoSanh) {
                    return true;
                }
                break;
            case DK_SoSanh.NHO_HON_HOAC_BANG:
                if (giaTriKiemTra <= giaTriSoSanh) {
                    return true;
                }
                break;
            case DK_SoSanh.LON_HON:
                if (giaTriKiemTra > giaTriSoSanh) {
                    return true;
                }
                break;
            case DK_SoSanh.LON_HON_HOAC_BANG:
                if (giaTriKiemTra >= giaTriSoSanh) {
                    return true;
                }
                break;
            case DK_SoSanh.BANG_NHAU:
                if (giaTriKiemTra == giaTriSoSanh) {
                    return true;
                }
                break;
            case DK_SoSanh.KHAC_NHAU:
                if (giaTriKiemTra != giaTriSoSanh) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    /**
     * @param dsDT
     * @param bc
     * @return
     */
    @Override
    public boolean kiemTraDK(ArrayList<NhanVat> dsDT, BoiCanh bc) {
        int giaTriKiemTra = 0;
        switch (loaiDT) {
//            Nhân vật
            case "NV":
                int count = 0;
                for (NhanVat nv : dsDT) {
                    ThuocTinh tt = nv.getThuocTinh(this.maTT);
                    if (tt != null) {
                        if (tt instanceof ChiSo) {
                            giaTriKiemTra = ((ChiSo) tt).getGiaTri() + ((ChiSo) tt).getGiaTriTamThoi();
                        } else if (tt instanceof TinhCach) {
                            giaTriKiemTra = ((TinhCach) tt).getMucDo();
                        } else if (tt instanceof TrangThai) {
                            giaTriKiemTra = ((TrangThai) tt).getTinhTrang();
                        }
                        boolean KQKiemTra = soSanhGiaTri(giaTriKiemTra, this.giaTriSS);
                        if (KQKiemTra != this.isNot) {
                            count++;
                        }
                    }
                    if (count >= this.dungToiThieu) {
                        return true;
                    }
                }
                break;
//            Bối cảnh
            case "BC":
                ThuocTinh tt = bc.getThuocTinh(this.maTT);
                if (tt != null) {
                    if (tt instanceof ChiSo) {
                        giaTriKiemTra = ((ChiSo) tt).getGiaTri() + ((ChiSo) tt).getGiaTriTamThoi();
                    } else if (tt instanceof TinhCach) {
                        giaTriKiemTra = ((TinhCach) tt).getMucDo();
                    } else if (tt instanceof TrangThai) {
                        giaTriKiemTra = ((TrangThai) tt).getTinhTrang();
                    }
                    boolean KQKiemTra = soSanhGiaTri(giaTriKiemTra, this.giaTriSS);
                    if (KQKiemTra != this.isNot) {
                        return true;
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
    public String getMaTT() {
        return this.maTT;
    }

    /**
     * @return
     */
    public int getGiaTriSS() {
        return this.giaTriSS;
    }

    /**
     * @return
     */
    public String getLoaiDT() {
        return this.loaiDT;
    }

    /**
     * @param maTT
     */
    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    /**
     * @param giaTriSS
     */
    public void setGiaTriSS(int giaTriSS) {
        this.giaTriSS = giaTriSS;
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
    public DK_SoSanh cloneDK() {
        return new DK_SoSanh(
                this.maDK,
                this.isNot,
                this.dungToiThieu,
                this.moTa,
                this.maTT,
                this.giaTriSS,
                this.loaiDT,
                this.loaiSS);
    }

    /**
     * @return
     */
    @Override
    public String loaiDK() {
        return "DK_SS";
    }

}
