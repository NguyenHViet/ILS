/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GameObject.NhanVat;
import Modal.ModalNhanVat;
import SupportClass.*;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author vuvuive
 */
public class ProfileItemComponent {

    @FXML
    private Label itemName;
    @FXML
    private GridPane profileItemContent;

    public void initialize() {
    }

    public void loadData(ThuocTinh thuocTinh) {
        itemName.textProperty().setValue(thuocTinh.getTenTT());
        if (thuocTinh instanceof ChiSo) {
            int giaTriHienTai = ((ChiSo) thuocTinh).getGiaTri() + ((ChiSo) thuocTinh).getGiaTriTamThoi();
            Label giaTriLabel = new Label("Giá trị:");
            Label giaTriValue = new Label(giaTriHienTai + " (" + ((ChiSo) thuocTinh).getGiaTriTamThoi() + ")");
            Label tiemNangLabel = new Label("Tiềm năng");
            Label tiemNangValue = new Label("" + ((ChiSo) thuocTinh).getTiemNang());
            profileItemContent.add(giaTriLabel, 0, 0);
            profileItemContent.add(giaTriValue, 1, 0);
            profileItemContent.add(tiemNangLabel, 0, 1);
            profileItemContent.add(tiemNangValue, 1, 1);
        }
    }

    public void loadData(MoiQuanHe mqh) {
        NhanVat nv = ModalNhanVat.getNhanVat(mqh.getMaNV());
        String gioiTinh;
        if (nv.getGioiTinh() == 0) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        itemName.textProperty().setValue(nv.getHoTen() + " - " + gioiTinh + " - " + nv.getTuoi() + " (" + mqh.getQuanHe() + ")");
        if (mqh instanceof MoiQuanHe) {
            Label thanThietLabel = new Label("Thân thiết:");
            Label thanThietValue = new Label(mqh.getThanThiet() + "");
            Label tinTuongLabel = new Label("Tin tưởng:");
            Label tinTuongValue = new Label(mqh.getTinTuong() + "");

            ProgressBar pbThanThiet = new ProgressBar();
            pbThanThiet.setProgress(mqh.getThanThiet() / 100.0);
            ProgressBar pbTinTuong = new ProgressBar();
            pbTinTuong.setProgress(mqh.getTinTuong() / 100.0);

            HBox thanThiet = new HBox();
            HBox tinTuong = new HBox();
            thanThiet.getChildren().add(thanThietValue);
            thanThiet.getChildren().add(pbThanThiet);
            tinTuong.getChildren().add(tinTuongValue);
            tinTuong.getChildren().add(pbTinTuong);
            HBox.setHgrow(pbThanThiet, Priority.ALWAYS);
            HBox.setHgrow(pbTinTuong, Priority.ALWAYS);
            thanThiet.setAlignment(Pos.CENTER);
            tinTuong.setAlignment(Pos.CENTER);

            thanThietValue.setMinWidth(43);
            tinTuongValue.setMinWidth(43);
            pbThanThiet.setMinWidth(110);
            pbTinTuong.setMinWidth(110);
            pbThanThiet.setMaxHeight(15);
            pbTinTuong.setMaxHeight(15);
            profileItemContent.setMinWidth(153);

            profileItemContent.add(thanThietLabel, 0, 0);
            profileItemContent.add(thanThiet, 1, 0);
            profileItemContent.add(tinTuongLabel, 0, 1);
            profileItemContent.add(tinTuong, 1, 1);
        }
    }

}
