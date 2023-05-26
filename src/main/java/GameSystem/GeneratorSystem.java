package GameSystem;

import GUI.UI;
import GameEvent.*;
import GameObject.*;
import WorldBuilder.*;
import SupportClass.*;
import Modal.*;
import java.util.*;
import javafx.concurrent.Task;
import javafx.concurrent.Service;

/**
 *
 */
public class GeneratorSystem {

//    Hệ thống tạo tên
    private static final char[][] alphabet = { // LOWERCASE, UPPERCASE, IS_VOWEL, IS_CONSONANT
        {'a', 'A', 'T', 'F'}, //
        {'b', 'B', 'F', 'T'},
        {'c', 'C', 'F', 'T'},
        {'d', 'D', 'F', 'T'},
        {'e', 'E', 'T', 'F'}, //
        {'f', 'F', 'F', 'T'},
        {'g', 'G', 'F', 'T'},
        {'h', 'H', 'F', 'T'},
        {'i', 'I', 'T', 'F'}, //
        {'j', 'J', 'F', 'T'},
        {'k', 'K', 'F', 'T'},
        {'l', 'L', 'F', 'T'},
        {'m', 'M', 'F', 'T'},
        {'n', 'N', 'F', 'T'},
        {'o', 'O', 'T', 'F'}, //
        {'p', 'P', 'F', 'T'},
        {'q', 'Q', 'F', 'T'},
        {'r', 'R', 'F', 'T'},
        {'s', 'S', 'F', 'T'},
        {'t', 'T', 'F', 'T'},
        {'u', 'U', 'T', 'F'}, //
        {'v', 'V', 'F', 'T'},
        {'w', 'W', 'F', 'T'},
        {'x', 'X', 'F', 'T'},
        {'y', 'Y', 'T', 'T'}, //
        {'z', 'Z', 'F', 'T'},};

//    Bảng thể hiện những ký tự có thể đi với nhau
    private static final int[][] prop = {
        //A B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // A +
        {1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0}, // B +
        {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0}, // C +
        {1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0}, // D +
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // E +
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // F
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // G
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // H
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // I +
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // J
        {1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0}, // K +
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // L
        {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1}, // M
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // N
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // O +
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // P
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, // Q
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // R
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // S
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // T
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // U +
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // V
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // W
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1}, // X
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // Y +
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1} //  Z
    };

    static public String taoTenNgauNghien(int soLuong) {
//        Tính độ dài tên
        Random myGenerator = new Random();
        int doDaiTen = myGenerator.nextInt(8) + 3;
//        Khởi tạo tên
        String ten = "";

        for (int j = 0; j < soLuong; j++) {
            String name_part = "";
//            Kiểm tra thuộc tính tên
            boolean prev_vowel = false;
            boolean prev2_vowel = false;
            boolean prev_consonant = true;
            boolean prev2_consonant = false;
            int prev_num = 0;
//            Tạo chữ ngẫu nhiên
            for (int i = 0; i < doDaiTen; i++) {
                boolean done = false;
                char[] letter = null;
                while (!done) {
                    int rand = myGenerator.nextInt(26);
                    if (prop[prev_num][rand] == 0) {
                        continue;
                    }
                    letter = alphabet[rand];
                    boolean isVowel = (letter[2] == 'T');
                    boolean isConsonant = (letter[3] == 'T');
                    prev_num = rand;
                    done = !((prev2_vowel && isVowel) || (prev2_consonant && isConsonant));
                }
                if (i == 0) {
                    name_part += letter[1];
                } else {
                    name_part += letter[0];
                }
                boolean isVowel = (letter[2] == 'T');
                boolean isConsonant = (letter[3] == 'T');
                prev2_vowel = (isVowel && prev_vowel);
                prev2_consonant = (isConsonant && prev_consonant);
                prev_vowel = isVowel;
                prev_consonant = isConsonant;
            }
            ten += name_part;
//            Cần thêm chữ cho tên
            if (j < soLuong - 1) {
                ten += " ";
            }
        }
        return ten;
    }

    private static final String[][] thuocTinhBoiCanhCoBan = {
        {"RSC", "Tài nguyên"},
        {"CLM", "Khí Hậu"},
        {"CLS", "Băng Hoại"},
        {"SNT", "Khoa Học - Kỹ Thuật"},
        {"MNA", "Ma Thuật - Giả Kim"},
        {"MNE", "Y Tế - Giáo Dục"},
        {"EPM", "Kinh Tế - Chính Trị - Quân Sự"}
    };

    static private ArrayList<ThuocTinh> taoThuocTinhBoiCanh() {
        Random myGenerator = new Random();
        ArrayList<ThuocTinh> dsTT = new ArrayList<ThuocTinh>();

        for (int i = 0; i < thuocTinhBoiCanhCoBan.length; i++) {
            int giaTri = myGenerator.nextInt(101);
            dsTT.add(new ChiSo(thuocTinhBoiCanhCoBan[i][0], thuocTinhBoiCanhCoBan[i][1], "", true, giaTri, 0, 0));
            UI.updateProgress(1);
        }

        return dsTT;
    }

    static private ArrayList<ThuocTinh> taoThuocTinhBoiCanh(BoiCanh bc, int khoangTangGiam) {
        Random myGenerator = new Random();
        ArrayList<ThuocTinh> dsTT = new ArrayList<>();

        for (String[] thuocTinh : thuocTinhBoiCanhCoBan) {
            int giaTriNgauNhien;
            giaTriNgauNhien = randomValue(2 * khoangTangGiam) + ((ChiSo) bc.getThuocTinh(thuocTinh[0])).getGiaTri() - khoangTangGiam;
            if (giaTriNgauNhien < 0) {
                giaTriNgauNhien = 0;
            } else if (giaTriNgauNhien > 100) {
                giaTriNgauNhien = 100;
            }
            ChiSo taiNguyen = new ChiSo(thuocTinh[0], thuocTinh[1], "", true, giaTriNgauNhien, 0, 0);
            dsTT.add(taiNguyen);
        }
        UI.updateProgress(1);

        return dsTT;
    }

//    Khởi tạo các đối tượng
    /**
     * @param maTG
     * @return
     */
    static public TheGioi taoTheGioi(String maTG) {
        String tenTG = taoTenNgauNghien(1);
        ArrayList<QuocGia> dsQG = new ArrayList<>();
//        Tạo thuộc tính ban đầu cho thế giới
        ArrayList<ThuocTinh> dsTT = taoThuocTinhBoiCanh();
        return new TheGioi(maTG, tenTG, dsTT, dsQG);
    }

    /**
     * @param maQG
     * @param bc
     * @return
     */
    static public QuocGia taoQuocGia(String maQG, BoiCanh bc) {
        String tenQG = taoTenNgauNghien(1);
        ArrayList<Tinh> dsT = new ArrayList<>();
//        Tạo thuộc tính ban đầu cho quốc gia
        ArrayList<ThuocTinh> dsTT = taoThuocTinhBoiCanh(bc, 10);
        QuocGia result = new QuocGia(maQG, tenQG, dsTT, bc, dsT);
        int SNT = ((ChiSo) result.getThuocTinh("SNT")).getGiaTri();
        int MNA = ((ChiSo) result.getThuocTinh("MNA")).getGiaTri();
        int MNE = ((ChiSo) result.getThuocTinh("MNE")).getGiaTri();
        int EPM = ((ChiSo) result.getThuocTinh("EPM")).getGiaTri();
        int CVL = SNT + MNA + MNE + EPM;
        int RSC = ((ChiSo) result.getThuocTinh("RSC")).getGiaTri();
        int CLM = ((ChiSo) result.getThuocTinh("CLM")).getGiaTri();
        int CLS = ((ChiSo) result.getThuocTinh("CLS")).getGiaTri();
        int SVV = 600 - (RSC + CLM + CVL) + CLS;
        result.getDSTT().add(new ChiSo("CVL", "Trình độ văn minh", "", true, CVL, 0, 0));
        result.getDSTT().add(new ChiSo("SVV", "Độ khó sinh tồn", "", true, SVV, 0, 0));
        return result;
    }

    /**
     * @param maT
     * @param bc
     * @return
     */
    static public Tinh taoTinh(String maT, BoiCanh bc) {
        String tenT = taoTenNgauNghien(1);
        ArrayList<DiaDanh> dsDD = new ArrayList<>();
//        Tạo thuộc tính ban đầu cho tỉnh
        ArrayList<ThuocTinh> dsTT = taoThuocTinhBoiCanh(bc, 10);
        Tinh result = new Tinh(maT, tenT, dsTT, bc, dsDD);
        int SNT = ((ChiSo) result.getThuocTinh("SNT")).getGiaTri();
        int MNA = ((ChiSo) result.getThuocTinh("MNA")).getGiaTri();
        int MNE = ((ChiSo) result.getThuocTinh("MNE")).getGiaTri();
        int EPM = ((ChiSo) result.getThuocTinh("EPM")).getGiaTri();
        int CVL = SNT + MNA + MNE + EPM;
        int RSC = ((ChiSo) result.getThuocTinh("RSC")).getGiaTri();
        int CLM = ((ChiSo) result.getThuocTinh("CLM")).getGiaTri();
        int CLS = ((ChiSo) result.getThuocTinh("CLS")).getGiaTri();
        int SVV = 600 - (RSC + CLM + CVL) + CLS;
        result.getDSTT().add(new ChiSo("CVL", "Trình độ văn minh", "", true, CVL, 0, 0));
        result.getDSTT().add(new ChiSo("SVV", "Độ khó sinh tồn", "", true, SVV, 0, 0));
        return result;
    }

    /**
     * @param maDD
     * @param bc
     * @param loaiDD
     * @return
     */
    static public DiaDanh taoDiaDanh(String maDD, BoiCanh bc, int loaiDD) {
        String tenDD = taoTenNgauNghien(1);
        ArrayList<VatPham> dsTN = new ArrayList<>();
        ArrayList<ThuocTinh> dsTT = taoThuocTinhBoiCanh(bc, 10);
        ArrayList<LuaChon> dsLC = new ArrayList<>();
        String loaiDiaDanh = "";
        DiaDanh result = new DiaDanh(maDD, tenDD, dsTT, bc, loaiDiaDanh, dsTN, dsLC);
//        Lấy thuộc tính ban đầu của địa danh
        int SNT = ((ChiSo) result.getThuocTinh("SNT")).getGiaTri();
        int MNA = ((ChiSo) result.getThuocTinh("MNA")).getGiaTri();
        int MNE = ((ChiSo) result.getThuocTinh("MNE")).getGiaTri();
        int EPM = ((ChiSo) result.getThuocTinh("EPM")).getGiaTri();
        int CVL = SNT + MNA + MNE + EPM;
        int RSC = ((ChiSo) result.getThuocTinh("RSC")).getGiaTri();
        int CLM = ((ChiSo) result.getThuocTinh("CLM")).getGiaTri();
        int CLS = ((ChiSo) result.getThuocTinh("CLS")).getGiaTri();
        int SVV = 600 - (RSC + CLM + CVL) + CLS;
        result.getDSTT().add(new ChiSo("CVL", "Trình độ văn minh", "", true, CVL, 0, 0));
        result.getDSTT().add(new ChiSo("SVV", "Độ khó sinh tồn", "", true, SVV, 0, 0));
        
        switch (loaiDD) {
            case 0:
                if (EPM > 80) {
                    loaiDiaDanh = "Trung tâm thương mại";
                } else if (EPM > 60) {
                    loaiDiaDanh = "Khu chợ lớn";
                } else if (EPM > 40) {
                    loaiDiaDanh = "Chợ";
                } else if (EPM > 20) {
                    loaiDiaDanh = "Cửa hàng";
                } else {
                    loaiDiaDanh = "Quầy hàng rong";
                }
                break;
            case 1:
                if (MNE > 80) {
                    loaiDiaDanh = "Trung tâm y tế";
                } else if (MNE > 60) {
                    loaiDiaDanh = "Bệnh viện";
                } else if (MNE > 40) {
                    loaiDiaDanh = "Trạm y tế";
                } else if (MNE > 20) {
                    loaiDiaDanh = "Quầy thuốc";
                } else {
                    loaiDiaDanh = "Nhà thầy thuốc";
                }
                break;
            case 2:
                if (MNE > 80) {
                    loaiDiaDanh = "Đại học viện";
                } else if (MNE > 60) {
                    loaiDiaDanh = "Học viện";
                } else if (MNE > 40) {
                    loaiDiaDanh = "Trường chuyên";
                } else if (MNE > 20) {
                    loaiDiaDanh = "Trường";
                } else {
                    loaiDiaDanh = "Trường làng";
                }
                break;
            default:
                break;
        }

        result.setLoaiDD(loaiDiaDanh);
        return result;
    }

    static public int randomValue(int bound) {
        Random myGenerator = new Random();
        if (bound <= 0) {
            return 0;
        } else {
            return myGenerator.nextInt(bound);
        }
    }

    /**
     * @param maNV
     * @param bc
     * @param tuoi
     * @param gioiTinh
     * @param playable
     * @return
     */
    static public NhanVat taoNhanVat(String maNV, BoiCanh bc, int tuoi, int gioiTinh, boolean playable) {
        Random myGenerator = new Random();
        int bound;
        String tenNV = taoTenNgauNghien(2);
//        Thuộc tính
        int giaTri;
        int tiemNang;
        int gift = (700 - ((ChiSo) bc.getThuocTinh("SVV")).getGiaTri()) / 70 + 1;
        int basic = gift * 2;
        int bonus = tuoi * gift * 4;

        ArrayList<ThuocTinh> dsTT = new ArrayList<>();
        int tongDiemTP_Val = ((ChiSo) bc.getThuocTinh("SVV")).getGiaTri() / 10 + bonus;
//        Tổng điểm thiên phú
        ChiSo tongDiemTP = new ChiSo("SOG", "Tổng điểm thiên phú", "", false, tongDiemTP_Val, 0, 0);
        dsTT.add(tongDiemTP);

//        Sức khỏe
//            Thiên bẩm
        bound = tongDiemTP_Val / 3;
        giaTri = randomValue(bound);
        tongDiemTP_Val -= giaTri;
//        Lão hóa
        if (tuoi > (50 - gift)) {
            giaTri -= (tuoi - gift) / 10;
        }
//            Tiềm năng
        bound = tongDiemTP_Val / 15;
        tiemNang = randomValue(bound);
        tongDiemTP_Val -= tiemNang * 5;
        ChiSo sucKhoe = new ChiSo("STR", "Sức khỏe", "", true, giaTri + basic, tiemNang, 0);
        dsTT.add(sucKhoe);

//        Thể lực
//            Thiên bẩm
        bound = tongDiemTP_Val / 2;
        giaTri = randomValue(bound);
        tongDiemTP_Val -= giaTri;
//            Tiềm năng
        bound = tongDiemTP_Val / 10;
        tiemNang = randomValue(bound);
        tongDiemTP_Val -= tiemNang * 5;
        ChiSo theLuc = new ChiSo("PHY", "Thể lực", "", true, giaTri + basic, tiemNang, 0);
        dsTT.add(theLuc);
        ChiSo sucBen = new ChiSo("STA", "Sức bền", "", false, giaTri + basic, 0, 0);
        dsTT.add(sucBen);

//        Tâm lý
//            Thiên bẩm
        giaTri = myGenerator.nextInt(tongDiemTP_Val);
        tongDiemTP_Val -= giaTri;
//            Tiềm năng
        bound = tongDiemTP_Val / 5;
        tiemNang = randomValue(bound);
        tongDiemTP_Val -= tiemNang * 5;
        ChiSo tamLy = new ChiSo("MNT", "Tâm lý", "", true, giaTri + basic, tiemNang, 0);
        dsTT.add(tamLy);

//        Trí lực
//            Tiềm năng
        bound = tongDiemTP_Val / 5;
        tiemNang = randomValue(bound);
//            Thiên bẩm
        tongDiemTP_Val -= tiemNang * 5;
        ChiSo triLuc = new ChiSo("INT", "Trí lực", "", true, tongDiemTP_Val + basic, tiemNang, 0);
        dsTT.add(triLuc);

        ChiSo csTuoi = new ChiSo("AGE", "Tuổi", "", false, tuoi, 1, 0);
        dsTT.add(csTuoi);

        ChiSo csGioiTinh = new ChiSo("GDR", "Giới tính", "", false, gioiTinh, 0, 0);
        dsTT.add(csGioiTinh);

//        Mối quan hệ
        ArrayList<MoiQuanHe> dsMQH = new ArrayList<>();

//        Túi đồ
        ArrayList<VatPham> tuiDo = new ArrayList<>();

//        Vị trí
        Tinh vt = new Tinh();

//        Nghề nghiệp
        NgheNghiep nn = new NgheNghiep();

//        Kỹ năng
        ArrayList<KyNang> dsKN = new ArrayList<>();

        return new NhanVat(maNV, tenNV, "Nhân loại", dsTT, dsMQH, tuiDo, vt, nn, dsKN, playable);
    }

    /**
     * @param maVP
     * @return
     */
    static public VatPham taoVatPham(String maVP) {
        // TODO implement here
        return null;
    }

    static private ArrayList<NhanVat> taoDSDTTG(String loaiDTTG, ArrayList<NhanVat> dsNV, int soLuong) {
        ArrayList<NhanVat> dsDTTG = (ArrayList<NhanVat>) dsNV.clone();
        ArrayList<NhanVat> result = new ArrayList<>();

        String[] dsLoaiDTTG = loaiDTTG.split("_");

        int index;
        NhanVat mc = MainSystem.getNguoiChoi();
        NhanVat npc = null;
        for (String type : dsLoaiDTTG) {
            switch (type) {
                case "MC":
                    for (NhanVat nv : dsDTTG) {
                        if (nv.isPlayable()) {
                            npc = nv;
                            result.add(npc);
                            dsDTTG.remove(npc);
                            break;
                        }
                    }
                    break;
                case "FAMILY":
                    for (MoiQuanHe mqh : mc.getVongQuanHe("GIADINH")) {
                        npc = MainSystem.getNhanVat(mqh.getMaNV());
                        result.add(npc);
                        dsDTTG.remove(npc);
                    }
                    break;
                case "RANDOMNPC":
                    while (!dsDTTG.isEmpty()) {
                        index = new Random().nextInt(dsDTTG.size());
                        npc = dsDTTG.get(index);
                        if (!npc.isPlayable()) {
                            result.add(npc);
                            dsDTTG.remove(npc);
                        }
                    }
                    break;
                case "RANDOMMNPC":
                    while (!dsDTTG.isEmpty()) {
                        index = new Random().nextInt(dsDTTG.size());
                        npc = dsDTTG.get(index);
                        if (!npc.isPlayable() && npc.getGioiTinh() == 0) {
                            result.add(npc);
                            dsDTTG.remove(npc);
                        }
                    }
                    break;
                case "RANDOMFNPC":
                    while (!dsDTTG.isEmpty()) {
                        index = new Random().nextInt(dsDTTG.size());
                        npc = dsDTTG.get(index);
                        if (!npc.isPlayable() && npc.getGioiTinh() == 1) {
                            result.add(npc);
                            dsDTTG.remove(npc);
                            break;
                        }
                    }
                    break;
                case "RANDOMNPCS":
                    while (result.size() < soLuong && !dsDTTG.isEmpty()) {
                        index = new Random().nextInt(dsDTTG.size());
                        npc = dsDTTG.get(index);
                        if (!npc.isPlayable()) {
                            result.add(npc);
                            dsDTTG.remove(npc);
                        }
                    }
                    break;
                case "RANDOMMNPCS":
                    while (result.size() < soLuong && !dsDTTG.isEmpty()) {
                        index = new Random().nextInt(dsDTTG.size());
                        npc = dsDTTG.get(index);
                        if (!npc.isPlayable() && npc.getGioiTinh() == 0) {
                            result.add(npc);
                            dsDTTG.remove(npc);
                        }
                    }
                    break;
                case "RANDOMFNPCS":
                    while (result.size() < soLuong && !dsDTTG.isEmpty()) {
                        index = new Random().nextInt(dsDTTG.size());
                        npc = dsDTTG.get(index);
                        if (!npc.isPlayable() && npc.getGioiTinh() == 1) {
                            result.add(npc);
                            dsDTTG.remove(npc);
                        }
                    }
                    break;
                case "NONE":
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    /**
     * @param maSK
     * @return
     */
    static public SuKien taoSuKien(SuKien mauSK, NhanVat mc, ArrayList<NhanVat> dsDTTG, BoiCanh bc) {
        SuKien sk = mauSK.cloneSK();

        ArrayList<NhanVat> dsNV = (ArrayList<NhanVat>) dsDTTG.clone();
        dsNV.add(mc);
        sk.setBoiCanh(bc);
        sk.setDSDTTG(taoDSDTTG(sk.getLoaiDTTG(), dsNV, sk.getSoLuongDTTG()));

        ArrayList<LuaChon> dsMauLC = mauSK.getDSLC();
        ArrayList<LuaChon> dsLC = new ArrayList<>();
        if (dsMauLC == null) {
            dsLC.add(new LuaChon(
                    "00000",
                    "Đóng",
                    null,
                    null,
                    "NONE",
                    0,
                    null,
                    null
            ));
        } else {
            for (int i = 0; i < dsMauLC.size(); i++) {
                LuaChon mauLC = dsMauLC.get(i);
                LuaChon lc = taoLuaChon(mauLC, sk.getDSDTTG(), bc);
                dsLC.add(lc);
            }
        }
        sk.setDSLC(dsLC);

        ArrayList<DieuKien> dsMauDK = mauSK.getDSDK();
        ArrayList<DieuKien> dsDK = new ArrayList<>();
        if (dsMauDK != null) {
            for (DieuKien mauDK : dsMauDK) {
                dsDK.add(taoDieuKien(mauDK, mc));
            }
        }
        sk.setDSDK(dsDK);

        ArrayList<HieuUng> dsMauHU = mauSK.getDSHU();
        ArrayList<HieuUng> dsHU = new ArrayList<>();
        if (dsMauHU != null) {
            for (HieuUng mauHU : dsMauHU) {
                dsHU.add(taoHieuUng(mauHU, mc));
            }
        }
        sk.setDSHU(dsHU);

        return sk;
    }

    /**
     * @param mauDK
     * @param mcSK
     * @return
     */
    static public DieuKien taoDieuKien(DieuKien mauDK, NhanVat mcSK) {
        DieuKien dk = mauDK.cloneDK();
        if (dk instanceof DK_SoSanh) {
            return dk;
        } else if (dk instanceof DK_ThanThiet) {
            ((DK_ThanThiet) dk).setMaNV(mcSK.getMaNV());
        }
        return dk;
    }

    /**
     * @param mauLC
     * @param dsDTTG
     * @param bc
     * @return
     */
    static public LuaChon taoLuaChon(LuaChon mauLC, ArrayList<NhanVat> dsDTTG, BoiCanh bc) {
        LuaChon lc = mauLC.cloneLC();

        ArrayList<NhanVat> dsNV = (ArrayList<NhanVat>) dsDTTG.clone();

        lc.setBoiCanh(bc);
        lc.setDSDTTG(taoDSDTTG(lc.getLoaiDTTG(), dsDTTG, lc.getSoLuongDTTG()));

        return lc;
    }

    /**
     * @param mauHU
     * @param mcSK
     * @return
     */
    static public HieuUng taoHieuUng(HieuUng mauHU, NhanVat mcSK) {
        HieuUng hu = mauHU.cloneHU();
        if (hu instanceof HU_ThuocTinh) {
            return hu;
        } else if (hu instanceof HU_QuanHe) {
            ((HU_QuanHe) hu).setMaNV(mcSK.getMaNV());
        }
        return hu;
    }

    /**
     * @param maNN
     * @return
     */
    static public NgheNghiep taoNgheNghiep(String maNN) {
        // TODO implement here
        return null;
    }

    /**
     * @param maKN
     * @return
     */
    static public KyNang taoKyNang(String maKN) {
        // TODO implement here
        return null;
    }

    /**
     * -------------------------------------------------------------------------
     * Tạo thế giới trong game
     */
    /**
     *
     * @param land
     * @param count
     * @return
     */
    static private int[] splitMapInto(int land, int count, int minValue, int maxValue, int heSoPhanBo) {
        int[] result = new int[count];
        for (int i = 0; i < count - 1; i++) {
            result[i] = randomValue((land - count + i) / heSoPhanBo) + minValue;
            if (result[i] > maxValue) {
                result[i] = maxValue;
            }
            land -= result[i];
        }
        result[count - 1] = land;
        return result;
    }

    /**
     *
     * @return
     */
    static private int[][] taoBanDo(int landCount, int width, int height) {
        Random myGenerator = new Random();
        int[][] map = new int[height][width];
        int land = landCount;
        while (land > 0) {
            int offsetX = height / 10 * 8;
            int offsetY = (int) (width * 0.8);
            int x = myGenerator.nextInt(offsetX) + (int) (height / 10);
            int y = myGenerator.nextInt(offsetY) + (int) (width / 10);
            if (map[x][y] == 0) {
                map[x][y] = 1;
                land--;
            }
        }

        return map;
    }

    static private ArrayList<int[]> layBienGioi(int[][] map, int currentCountryIndex) {
        ArrayList<int[]> bienGioi = new ArrayList<>();
        int[] lastCell;
        for (int row = 0; row < map.length; row++) {
            lastCell = null;
            for (int col = 0; col < map[row].length; col++) {
                if (lastCell == null && map[row][col] == currentCountryIndex) {
                    lastCell = new int[]{row, col};
                    bienGioi.add(lastCell);
                } else if (lastCell != null && map[row][col] == currentCountryIndex) {
                    lastCell = new int[]{row, col};
                } else if (lastCell != null && map[row][col] != currentCountryIndex) {
                    bienGioi.add(lastCell);
                    lastCell = null;
                }
            }
        }
        return bienGioi;
    }

    static private int[] manhDatDauTien(int[][] map, int currentCountryIndex) {
        int[] result = new int[2];
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 1) {
                    result[0] = row;
                    result[1] = col;
                    map[row][col] = currentCountryIndex;
                    return result;
                }
            }
        }
        return result;
    }

    static private int[] banhTruong(int[][] map, int currentCountryIndex) {
        int[] result = new int[2];
        ArrayList<int[]> bienGioi = layBienGioi(map, currentCountryIndex);
        for (int[] cell : bienGioi) {
            ArrayList<String> dir = new ArrayList<String>();
            dir.add("TL");
            dir.add("T");
            dir.add("TR");
            dir.add("L");
            dir.add("R");
            dir.add("BL");
            dir.add("B");
            dir.add("BR");
            while (!dir.isEmpty()) {
                switch (dir.get(randomValue(dir.size()))) {
                    case "TL":
//                        Top Left
                        if (map[cell[0] - 1][cell[1] - 1] == 1) {
                            result[0] = cell[0] - 1;
                            result[1] = cell[1] - 1;
                            map[result[0]][result[1]] = currentCountryIndex;
                            return result;
                        } else {
                            dir.remove("TL");
                        }
                    case "T":
//                        Top
                        if (map[cell[0] - 1][cell[1]] == 1) {
                            result[0] = cell[0] - 1;
                            result[1] = cell[1];
                            map[result[0]][result[1]] = currentCountryIndex;
                            return result;
                        } else {
                            dir.remove("T");
                        }
                    case "TR":
//                        Top Right
                        if (map[cell[0] - 1][cell[1] + 1] == 1) {
                            result[0] = cell[0] - 1;
                            result[1] = cell[1] + 1;
                            map[result[0]][result[1]] = currentCountryIndex;
                            return result;
                        } else {
                            dir.remove("TR");
                        }
                    case "L":
//                        Left
                        if (map[cell[0]][cell[1] - 1] == 1) {
                            result[0] = cell[0];
                            result[1] = cell[1] - 1;
                            map[result[0]][result[1]] = currentCountryIndex;
                            return result;
                        } else {
                            dir.remove("L");
                        }
                    case "R":
//                        Right
                        if (map[cell[0]][cell[1] + 1] == 1) {
                            result[0] = cell[0];
                            result[1] = cell[1] + 1;
                            map[result[0]][result[1]] = currentCountryIndex;
                            return result;
                        } else {
                            dir.remove("R");
                        }
                    case "BL":
//                        Bottom Left
                        if (map[cell[0] + 1][cell[1] - 1] == 1) {
                            result[0] = cell[0] + 1;
                            result[1] = cell[1] - 1;
                            map[result[0]][result[1]] = currentCountryIndex;
                            return result;
                        } else {
                            dir.remove("BL");
                        }
                    case "B":
//                        Bottom
                        if (map[cell[0] + 1][cell[1]] == 1) {
                            result[0] = cell[0] + 1;
                            result[1] = cell[1];
                            map[result[0]][result[1]] = currentCountryIndex;
                            return result;
                        } else {
                            dir.remove("B");
                        }
                    case "BR":
//                        Bottom Right
                        if (map[cell[0] + 1][cell[1] + 1] == 1) {
                            result[0] = cell[0] + 1;
                            result[1] = cell[1] + 1;
                            map[result[0]][result[1]] = currentCountryIndex;
                            return result;
                        } else {
                            dir.remove("BR");
                        }
                }
            }
        }
        result = manhDatDauTien(map, currentCountryIndex);
        return result;
    }

    /**
     * @param tg
     */
    static public void khoiTaoCacVungDat(TheGioi tg) {
        int landCount = 40;
        Random myGenerator = new Random();
        ArrayList<QuocGia> dsQG = tg.getDSQG();
        int[][] map = taoBanDo(landCount, 15, 10);
        int soLuongQuocGia = myGenerator.nextInt(2) + 3;
        int[] phanBoTinh = splitMapInto(landCount, soLuongQuocGia, 5, 20, 2);
//                        Tạo quốc gia
        for (int i = 0; i < soLuongQuocGia; i++) {
            QuocGia qg = taoQuocGia("0000", tg);
            ArrayList<Tinh> dsT = qg.getDST();
            int soLuongTinh = phanBoTinh[i];
//                            Tạo tỉnh
            for (int j = 0; j < soLuongTinh; j++) {
                Tinh t = taoTinh("0000", qg);
                int[] pos;
                if (j == 0) {
                    pos = manhDatDauTien(map, i + 2);
                } else {
                    pos = banhTruong(map, i + 2);
                }
                ArrayList<DiaDanh> dsDD = t.getDSDD();
                int soLuongDiaDanh = myGenerator.nextInt(3) + 3;
//                                Tạo địa danh
                for (int k = 0; k < soLuongDiaDanh; k++) {
                    int loaiDD;
                    if (k < 3) {
                        loaiDD = k;
                    } else {
                        loaiDD = myGenerator.nextInt(10);
                    }
                    DiaDanh dd = taoDiaDanh("0000", t, loaiDD);
                    dd.setToaDo(pos);
                    UI.updateProgressContent("Đang tạo địa danh " + dd.getTenBC() + ", tỉnh " + t.getTenBC() + ", quốc gia " + qg.getTenBC());
                    dsDD.add(dd);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                    }
                    UI.updateProgress(1);
                }
//                Đặt tỉnh vào tọa độ pos
                t.setToaDo(pos);
                dsT.add(t);
            }
            dsQG.add(qg);
        }

        UI.updateProgressContent("Hoàn tất khởi tạo các vùng đất!");

    }

    /**
     * -------------------------------------------------------------------------
     * Khởi tạo NPC
     */
    /**
     *
     * @param nv
     */
    static public void khoiTaoNguoiThan(NhanVat nv) {
        Random myGenerator = new Random();
        ArrayList<MoiQuanHe> dsMQH = nv.getDSQH();
        int tuoi = nv.getTuoi();
        int gioiTinh = nv.getGioiTinh();
        TheGioi tg = MainSystem.getTG();
        ArrayList<NhanVat> dsNV = MainSystem.getDSNV();

//        Cha
        NhanVat father;
        if (nv.getQuanHe("Cha").size() < 1) {
            int thanThiet = myGenerator.nextInt(100);
            int tinTuong = myGenerator.nextInt(100);
            father = taoNhanVat(ModalNhanVat.maNhanVatMoi(), tg, myGenerator.nextInt(20) + 20, 0, false);
            dsMQH.add(new MoiQuanHe("Cha", "GIADINH", father.getMaNV(), thanThiet, tinTuong));
            father.getDSQH().add(new MoiQuanHe("Con", "GIADINH", nv.getMaNV(), thanThiet, tinTuong));
            ModalNhanVat.themNhanVat(father);
            dsNV.add(father);
        } else {
            father = MainSystem.getNhanVat(nv.getQuanHe("Cha").get(0).getMaNV());
        }
//        Mẹ
        NhanVat mother;
        if (nv.getQuanHe("Mẹ").size() < 1) {
            int thanThiet = myGenerator.nextInt(100);
            int tinTuong = myGenerator.nextInt(100);
            mother = taoNhanVat(ModalNhanVat.maNhanVatMoi(), tg, myGenerator.nextInt(20) + 20, 1, false);
            dsMQH.add(new MoiQuanHe("Mẹ", "GIADINH", mother.getMaNV(), thanThiet, tinTuong));
            mother.getDSQH().add(new MoiQuanHe("Con", "GIADINH", nv.getMaNV(), thanThiet, tinTuong));
            ModalNhanVat.themNhanVat(mother);
            dsNV.add(mother);
        } else {
            mother = MainSystem.getNhanVat(nv.getQuanHe("Mẹ").get(0).getMaNV());
        }
//        Anh, chị, em
        int hopPhap;
        if (father.getTuoi() > mother.getTuoi()) {
            hopPhap = mother.getTuoi() - 18;
        } else {
            hopPhap = father.getTuoi() - 18;
        }
        int ACECount = myGenerator.nextInt(3);
        ArrayList<MoiQuanHe> dsACE = new ArrayList<MoiQuanHe>();
        dsACE.addAll(nv.getQuanHe("Anh"));
        dsACE.addAll(nv.getQuanHe("Chị"));
        dsACE.addAll(nv.getQuanHe("Em trai"));
        dsACE.addAll(nv.getQuanHe("Em gái"));
        while (dsACE.size() < ACECount) {
            int randomACE;
            if (nv.getTuoi() > 0) {
                randomACE = myGenerator.nextInt(4);
            } else {
                randomACE = myGenerator.nextInt(2);
            }
            NhanVat ACE = taoNhanVat(ModalNhanVat.maNhanVatMoi(), tg, myGenerator.nextInt(hopPhap) + tuoi, randomACE % 2, false);
            int thanThiet = myGenerator.nextInt(100);
            int tinTuong = myGenerator.nextInt(100);
            switch (randomACE) {
                case 0:
                    dsMQH.add(new MoiQuanHe("Anh", "GIADINH", ACE.getMaNV(), thanThiet, tinTuong));
                    if (gioiTinh == 0) {
                        MoiQuanHe mqh = new MoiQuanHe("Em gái", "GIADINH", nv.getMaNV(), thanThiet, tinTuong);
                        ACE.getDSQH().add(mqh);
                        dsACE.add(mqh);
                    } else {
                        MoiQuanHe mqh = new MoiQuanHe("Em trai", "GIADINH", nv.getMaNV(), thanThiet, tinTuong);
                        ACE.getDSQH().add(mqh);
                        dsACE.add(mqh);
                    }
                    break;
                case 1:
                    dsMQH.add(new MoiQuanHe("Chị", "GIADINH", ACE.getMaNV(), thanThiet, tinTuong));
                    if (gioiTinh == 0) {
                        MoiQuanHe mqh = new MoiQuanHe("Em gái", "GIADINH", nv.getMaNV(), thanThiet, tinTuong);
                        ACE.getDSQH().add(mqh);
                        dsACE.add(mqh);
                    } else {
                        MoiQuanHe mqh = new MoiQuanHe("Em trai", "GIADINH", nv.getMaNV(), thanThiet, tinTuong);
                        ACE.getDSQH().add(mqh);
                        dsACE.add(mqh);
                    }
                    break;
                case 2:
                    dsMQH.add(new MoiQuanHe("Em trai", "GIADINH", ACE.getMaNV(), thanThiet, tinTuong));
                    if (gioiTinh == 0) {
                        MoiQuanHe mqh = new MoiQuanHe("Anh", "GIADINH", nv.getMaNV(), thanThiet, tinTuong);
                        ACE.getDSQH().add(mqh);
                        dsACE.add(mqh);
                    } else {
                        MoiQuanHe mqh = new MoiQuanHe("Chị", "GIADINH", nv.getMaNV(), thanThiet, tinTuong);
                        ACE.getDSQH().add(mqh);
                        dsACE.add(mqh);
                    }
                    break;
                case 3:
                    dsMQH.add(new MoiQuanHe("Em gái", "GIADINH", ACE.getMaNV(), thanThiet, tinTuong));
                    if (gioiTinh == 0) {
                        MoiQuanHe mqh = new MoiQuanHe("Anh", "GIADINH", nv.getMaNV(), thanThiet, tinTuong);
                        ACE.getDSQH().add(mqh);
                        dsACE.add(mqh);
                    } else {
                        MoiQuanHe mqh = new MoiQuanHe("Chị", "GIADINH", nv.getMaNV(), thanThiet, tinTuong);
                        ACE.getDSQH().add(mqh);
                        dsACE.add(mqh);
                    }
                    break;
            }
            ModalNhanVat.themNhanVat(ACE);
            dsNV.add(ACE);
        }

//          Dành cho update
////        Gia đình riêng
//        ArrayList<MoiQuanHe> dsQH = new ArrayList<MoiQuanHe>();
//        if (tuoi >= 18) {
//            boolean married = myGenerator.nextBoolean();
//            boolean rBreak = myGenerator.nextBoolean();
////            Đã kết hôn
//            if (!married) {
//                if (!rBreak) {
//                    dsQH.addAll(nv.getQuanHe("Vợ"));
//                    dsQH.addAll(nv.getQuanHe("Chồng"));
//                    if (dsQH.size() < 1) {
//                        NhanVat lover = taoNhanVat(ModalNhanVat.maNhanVatMoi(), tg, myGenerator.nextInt(10) + (tuoi - 5), (tuoi + 1) % 2, false);
//                        if (gioiTinh == 0) {
//                            dsQH.add(new MoiQuanHe("Vợ", lover.getMaNV(), myGenerator.nextInt(100), myGenerator.nextInt(100)));
//                        } else {
//                            dsQH.add(new MoiQuanHe("Chồng", lover.getMaNV(), myGenerator.nextInt(100), myGenerator.nextInt(100)));
//                        }
//                    }
//                }
////                Con cái
//                dsQH.clear();
//                dsQH.addAll(nv.getQuanHe("Con"));
//                if (dsQH.size() < myGenerator.nextInt(4)) {
//                    
//                }
//            }
//        }
    }

}
