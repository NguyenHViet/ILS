package GameObject;

import GameEvent.*;
import SupportClass.*;
import WorldBuilder.*;
import java.util.*;

/**
 *
 */
public class NhanVat {

    /**
     * Default constructor
     */
    public NhanVat() {
        this.maNV = "";
        this.hoTen = "";
        this.gioiTinh = 0;
        this.dsTT = new ArrayList<ThuocTinh>();
        this.dsQH = new ArrayList<MoiQuanHe>();
        this.tuiDo = new ArrayList<VatPham>();
        this.viTri = new Tinh();
        this.ngheNghiep = new NgheNghiep();
        this.dsKyNang = new ArrayList<KyNang>();
        this.playable = true;
    }

    /**
     *
     */
    private String maNV;

    /**
     *
     */
    private String hoTen;

    /**
     *
     */
    private int gioiTinh;

    /**
     *
     */
    private ArrayList<ThuocTinh> dsTT;

    /**
     *
     */
    private ArrayList<MoiQuanHe> dsQH;

    /**
     *
     */
    private ArrayList<VatPham> tuiDo;

    /**
     *
     */
    private Tinh viTri;

    /**
     *
     */
    private NgheNghiep ngheNghiep;

    /**
     *
     */
    private ArrayList<KyNang> dsKyNang;

    private String chungToc;

    private boolean playable;

    /**
     * Get the value of playable
     *
     * @return the value of playable
     */
    public boolean isPlayable() {
        return playable;
    }

    /**
     * Set the value of playable
     *
     * @param playable new value of playable
     */
    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public int getTuoi() {
        return ((ChiSo) getThuocTinh("AGE")).getGiaTri();
    }

    public void setTuoi(int tuoi) {
        ((ChiSo) getThuocTinh("AGE")).setGiaTri(tuoi);
    }

    /**
     * Get the value of chungToc
     *
     * @return the value of chungToc
     */
    public String getChungToc() {
        return chungToc;
    }

    /**
     * Set the value of chungToc
     *
     * @param chungToc new value of chungToc
     */
    public void setChungToc(String chungToc) {
        this.chungToc = chungToc;
    }

    /**
     * @param maNV
     * @param hoTen
     * @param gioiTinh
     * @param chungToc
     * @param dsTT
     * @param tuoi
     * @param dsQH
     * @param tuiDo
     * @param viTri
     * @param congViec
     * @param dsKN
     * @param playable
     */
    public NhanVat(String maNV,
            String hoTen,
            String chungToc,
            ArrayList<ThuocTinh> dsTT,
            ArrayList<MoiQuanHe> dsQH,
            ArrayList<VatPham> tuiDo,
            Tinh viTri,
            NgheNghiep congViec,
            ArrayList<KyNang> dsKN,
            boolean playable) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.chungToc = chungToc;
        this.dsTT = dsTT;
        this.dsQH = dsQH;
        this.tuiDo = tuiDo;
        this.viTri = viTri;
        this.ngheNghiep = congViec;
        this.dsKyNang = dsKN;
        this.playable = playable;
    }

    /**
     * @return
     */
    public String getMaNV() {
        return this.maNV;
    }

    /**
     * @return
     */
    public String getHoTen() {
        return this.hoTen;
    }

    /**
     * @return
     */
    public ArrayList<ThuocTinh> getDSTT() {
        return this.dsTT;
    }

    /**
     * @param maTT
     * @return
     */
    public ThuocTinh getThuocTinh(String maTT) {
        ThuocTinh tt_info = null;
        for (ThuocTinh tt : this.dsTT) {
            if (tt.getMaTT().equals(maTT)) {
                tt_info = tt;
                break;
            }
        }
        return tt_info;
    }

    /**
     * @return
     */
    public ArrayList<MoiQuanHe> getDSQH() {
        return this.dsQH;
    }

    /**
     * @param quanHe
     * @return
     */
    public ArrayList<MoiQuanHe> getQuanHe(String quanHe) {
        ArrayList<MoiQuanHe> result = new ArrayList<MoiQuanHe>();
        for (MoiQuanHe qh : this.dsQH) {
            if (qh.getQuanHe().equals(quanHe)) {
                result.add(qh);
            }
        }
        return result;
    }

    public ArrayList<MoiQuanHe> getVongQuanHe(String vongQuanHe) {
        ArrayList<MoiQuanHe> result = new ArrayList<MoiQuanHe>();
        for (MoiQuanHe qh : this.dsQH) {
            if (qh.getVongQuanHe().equals(vongQuanHe)) {
                result.add(qh);
            }
        }
        return result;
    }

    /**
     * @param maNV
     * @return
     */
    public MoiQuanHe getMoiQuanHe(String maNV) {
        MoiQuanHe mqh_info = null;
        for (MoiQuanHe mqh : this.dsQH) {
            if (mqh.getMaNV().equals(maNV)) {
                mqh_info = mqh;
                break;
            }
        }
        return mqh_info;
    }

    /**
     * @return
     */
    public ArrayList<VatPham> getTuiDo() {
        return this.tuiDo;
    }

    /**
     * @param maVP
     * @return
     */
    public VatPham getVatPham(String maVP) {
        VatPham vp_info = null;
        for (VatPham vp : this.tuiDo) {
            if (vp.getMaVP().equals(maVP)) {
                vp_info = vp;
                break;
            }
        }
        return vp_info;
    }

    /**
     * @return
     */
    public NgheNghiep getNgheNghiep() {
        return this.ngheNghiep;
    }

    /**
     * @return
     */
    public ArrayList<KyNang> getDSKyNang() {
        return this.dsKyNang;
    }

    /**
     * @param maKN
     * @return
     */
    public KyNang getKyNang(String maKN) {
        KyNang kn_info = null;
        for (KyNang kn : this.dsKyNang) {
            if (kn.getMaKN().equals(maKN)) {
                kn_info = kn;
                break;
            }
        }
        return kn_info;
    }

    /**
     * @return
     */
    public Tinh getViTri() {
        return this.viTri;
    }

    public int getGioiTinh() {
        return ((ChiSo) getThuocTinh("GDR")).getGiaTri();
    }

    /**
     * @param hoTen
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @param maGT
     */
    public void setGioiTinh(int maGT) {
        ((ChiSo) getThuocTinh("GDR")).setGiaTri(maGT);
    }

    /**
     * @param dsTT
     */
    public void setDSTT(ArrayList<ThuocTinh> dsTT) {
        this.dsTT = dsTT;
    }

    /**
     * @param dsQH
     */
    public void setDSQH(ArrayList<MoiQuanHe> dsQH) {
        this.dsQH = dsQH;
    }

    /**
     * @param tuiDo
     */
    public void setTuiDo(ArrayList<VatPham> tuiDo) {
        this.tuiDo = tuiDo;
    }

    /**
     * @param ngheNghiep
     */
    public void setNgheNghiep(NgheNghiep ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    /**
     * @param dsKyNang
     */
    public void setDSKyNang(ArrayList<KyNang> dsKyNang) {
        this.dsKyNang = dsKyNang;
    }

    /**
     * @param tinh
     */
    public void diChuyen(Tinh tinh) {
        this.viTri = tinh;
    }

    /**
     * @param hu
     */
    public void chiuTacDong(HieuUng hu) {
        if (hu instanceof HU_ThuocTinh) {
            ThuocTinh tt = this.getThuocTinh(((HU_ThuocTinh) hu).getMaTT());
            if (tt != null) {
                if (tt instanceof ChiSo) {
                    int giaTri = ((ChiSo) tt).getGiaTri();
                    int tamThoi = ((ChiSo) tt).getGiaTriTamThoi();
                    int tiemNang = ((ChiSo) tt).getTiemNang();

                    ((ChiSo) tt).setGiaTri(giaTri + ((HU_ThuocTinh) hu).getTangGiaTri());
                    ((ChiSo) tt).setGiaTriTamThoi(tamThoi + ((HU_ThuocTinh) hu).getTangTamThoi());
                    ((ChiSo) tt).setTiemNang(tiemNang + ((HU_ThuocTinh) hu).getTangTiemNang());
                }
            } else {
                if (tt instanceof ChiSo) {
                    this.dsTT.add(new ChiSo(
                            ((HU_ThuocTinh) hu).getMaTT(),
                            "",
                            "",
                            false,
                            ((HU_ThuocTinh) hu).getTangGiaTri(),
                            ((HU_ThuocTinh) hu).getTangTiemNang(),
                            ((HU_ThuocTinh) hu).getTangTamThoi()
                    ));
                }
            }
        } else if (hu instanceof HU_QuanHe) {
            MoiQuanHe mqh1 = this.getMoiQuanHe(((HU_QuanHe) hu).getMaNV());

            NhanVat nv = GameSystem.MainSystem.getNhanVat(((HU_QuanHe) hu).getMaNV());
            MoiQuanHe mqh2 = nv.getMoiQuanHe(this.maNV);

            if (mqh1 != null && mqh2 != null) {
                if (mqh2.getQuanHe().equals(((HU_QuanHe) hu).getLoaiQuanHe())) {
                    int thanThiet = mqh1.getThanThiet() + ((HU_QuanHe) hu).getThanThiet();
                    int tinTuong = mqh1.getTinTuong() + ((HU_QuanHe) hu).getTinTuong();
                    
                    if (thanThiet <= 0) {
                        thanThiet = 0;
                    }
                    if (tinTuong <= 0) {
                        tinTuong = 0;
                    }

                    mqh1.setThanThiet(thanThiet);
                    mqh1.setTinTuong(tinTuong);
                    mqh2.setThanThiet(thanThiet);
                    mqh2.setTinTuong(tinTuong);

                    if (!((HU_QuanHe) hu).getMQHMoiTuNV().isBlank()
                            || !((HU_QuanHe) hu).getMQHMoiTuNV().isEmpty()) {
                        mqh1.setQuanHe(((HU_QuanHe) hu).getMQHMoiTuNV());
                    }

                    if (!((HU_QuanHe) hu).getMQHMoiDenNV().isBlank()
                            || !((HU_QuanHe) hu).getMQHMoiDenNV().isEmpty()) {
                        mqh2.setQuanHe(((HU_QuanHe) hu).getMQHMoiDenNV());
                    }
                }
            }
        }

        this.capNhapThuocTinh();
    }

    /**
     */
    public void phatTrien() {
        for (ThuocTinh tt : this.dsTT) {
            if (tt instanceof ChiSo) {
                int chiSoMoi = ((ChiSo) tt).getGiaTri() + ((ChiSo) tt).getTiemNang();
                ((ChiSo) tt).setGiaTri(chiSoMoi);
            } else if (tt instanceof TrangThai) {
                int thoiHanMoi = ((TrangThai) tt).getThoiHan() - 1;
                ((TrangThai) tt).setThoiHan(thoiHanMoi);
            }
        }
    }

    /**
     */
    public void capNhapThuocTinh() {
        for (ThuocTinh tt : this.dsTT) {
            if (tt instanceof ChiSo) {
                int chiSoMoi = ((ChiSo) tt).getGiaTri() + ((ChiSo) tt).getGiaTriTamThoi();
                ((ChiSo) tt).setGiaTri(chiSoMoi);
            }
        }
    }

    /**
     * @return
     */
    public NhanVat cloneNV() {
        return new NhanVat(
                this.maNV,
                this.hoTen,
                this.chungToc,
                this.dsTT,
                this.dsQH,
                this.tuiDo,
                this.viTri,
                this.ngheNghiep,
                this.dsKyNang,
                this.playable);
    }

    public void print() {
        System.out.println("Thong tin nhan vat");
        System.out.println("\t+ Ma nhan vat: " + this.maNV);
        System.out.println("\t+ Ten nhan vat: " + this.hoTen);
        System.out.println("\t+ Gioi tinh: " + this.getGioiTinh());
        System.out.println("\t+ Chung toc: " + this.chungToc);
        System.out.println("\t+ Tuoi: " + this.getTuoi());
        System.out.println();
    }

}
