/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GameEvent.SuKien;
import GameObject.*;
import Modal.ModalNhanVat;
import SupportClass.*;
import WorldBuilder.DiaDanh;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
            Label tiemNangLabel = new Label("Tiềm năng:");
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
        itemName.textProperty().setValue(nv.getHoTen() + " - " + gioiTinh + " - " + nv.getTuoi() + " tuổi (" + mqh.getQuanHe() + ")");
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

            thanThietValue.setMinWidth(38);
            tinTuongValue.setMinWidth(38);
            pbThanThiet.setMinWidth(105);
            pbTinTuong.setMinWidth(105);
            pbThanThiet.setMaxHeight(15);
            pbTinTuong.setMaxHeight(15);
            profileItemContent.setMinWidth(153);

            profileItemContent.add(thanThietLabel, 0, 0);
            profileItemContent.add(thanThiet, 1, 0);
            profileItemContent.add(tinTuongLabel, 0, 1);
            profileItemContent.add(tinTuong, 1, 1);
        }
    }

    public void loadData(VatPham vp) {
        itemName.textProperty().setValue(vp.getTenVP());
        if (vp instanceof VPTieuHao) {
            Label describeLabel = new Label("Mô tả:");
            ScrollPane descirbeBox = new ScrollPane();
            TextFlow descirbeTF = new TextFlow();
            Text descirbeValue = new Text(vp.getMoTa());
            Label amountLabel = new Label("Số lượng:");
            Label amountValue = new Label("" + ((VPTieuHao) vp).getSoLuong());

            descirbeTF.getChildren().add(descirbeValue);
            descirbeTF.setMaxWidth(135);
            descirbeBox.setContent(descirbeTF);
            descirbeBox.setStyle("-fx-padding: 5px");
            descirbeBox.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

            profileItemContent.getColumnConstraints().get(0).setPercentWidth(25);
            profileItemContent.getColumnConstraints().get(1).setPercentWidth(75);
            profileItemContent.getRowConstraints().get(0).setMinHeight(75);
            profileItemContent.getColumnConstraints().get(1).setHgrow(Priority.ALWAYS);

            profileItemContent.add(describeLabel, 0, 0);
            profileItemContent.add(descirbeBox, 1, 0);
            profileItemContent.add(amountLabel, 0, 1);
            profileItemContent.add(amountValue, 1, 1);

            GridPane.setHgrow(descirbeBox, Priority.ALWAYS);
            GridPane.setVgrow(descirbeBox, Priority.ALWAYS);
        }
    }

    public void loadData(DiaDanh dd) {
        itemName.textProperty().setValue(dd.getTenBC());
        Label typeLabel = new Label(dd.getLoaiDD());

        profileItemContent.getColumnConstraints().get(1).setHgrow(Priority.ALWAYS);

        profileItemContent.add(typeLabel, 0, 0, 2, 1);
    }

    public void loadData(SuKien sk) {
        itemName.textProperty().setValue(sk.getTenSK());
        Label typeLabel = new Label(sk.getMoTa());
        Label timerLabel = new Label("Thời hạn:");
        Label timerValue = new Label("" + sk.getThoiHan());

        profileItemContent.getColumnConstraints().get(0).setPercentWidth(30);
        profileItemContent.setHgap(10);
        profileItemContent.getColumnConstraints().get(1).setPercentWidth(65);
        profileItemContent.getColumnConstraints().get(1).setHgrow(Priority.ALWAYS);

        profileItemContent.add(typeLabel, 0, 0, 2, 1);
        profileItemContent.add(timerLabel, 0, 1);
        profileItemContent.add(timerValue, 1, 1);
    }

}
