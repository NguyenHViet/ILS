/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import SupportClass.ChiSo;
import GameSystem.MainSystem;
import WorldBuilder.QuocGia;
import WorldBuilder.TheGioi;
import WorldBuilder.Tinh;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author vuvuive
 */
public class MiniMapComponent {

    @FXML
    private GridPane worldMap;
    @FXML
    private Label tenTinhLabel;
    @FXML
    private Label tenQuocGiaLabel;
    @FXML
    private Label SVV_Label;
    @FXML
    private Label CVL_Label;
    @FXML
    private Label SLDD_Label;

    final String nomarlLandStyle = "-fx-background-color: #9ACD32; -fx-text-fill: transparent;";
    final String chosingLandStyle = "-fx-background-color: #32CD32; -fx-text-fill: transparent;";
    final String chosingCellStyle = "-fx-background-color: #006400; -fx-text-fill: transparent;";

    private ArrayList<ArrayList<Button>> dsButton = new ArrayList<ArrayList<Button>>();

    public void initialize() {
        TheGioi tg = MainSystem.getTG();
        loadData(tg);
        tenQuocGiaLabel.setText("Thế giới " + tg.getTenBC());
        tenTinhLabel.setText("");
        int SVV = ((ChiSo) tg.getThuocTinh("SVV")).getGiaTri();
        int CVL = ((ChiSo) tg.getThuocTinh("CVL")).getGiaTri();
        SVV_Label.setText(String.valueOf(SVV));
        CVL_Label.setText(String.valueOf(CVL));
    }

    public void loadData(TheGioi tg) {
        int cellSize = 25;
        dsButton.clear();
        worldMap.getChildren().clear();
        ArrayList<QuocGia> dsQG = tg.getDSQG();
        for (int i = 0; i < dsQG.size(); i++) {
            ArrayList<Button> dsBtn = new ArrayList<Button>();
            dsButton.add(dsBtn);
            QuocGia qg = dsQG.get(i);
            for (Tinh t : qg.getDST()) {
//                for (DiaDanh dd : t.getDSDD()) {
                Button btn = new Button();
                btn.setPrefHeight(cellSize);
                btn.setPrefWidth(cellSize);
//                    btn.setMaxHeight(cellSize);
//                    btn.setMaxWidth(cellSize);
                btn.setMinHeight(cellSize);
                btn.setMinWidth(cellSize);
                btn.setStyle(nomarlLandStyle);
                btn.setTooltip(new Tooltip(t.getTenBC()));
                btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        for (Button button : dsBtn) {
                            button.setStyle(chosingLandStyle);
                        }
                        btn.setStyle(chosingCellStyle);
                        tenQuocGiaLabel.setText("Quốc gia: " + qg.getTenBC());
                        tenTinhLabel.setText("Tỉnh: " + t.getTenBC());
                        int SVV = ((ChiSo) t.getThuocTinh("SVV")).getGiaTri();
                        int CVL = ((ChiSo) t.getThuocTinh("CVL")).getGiaTri();
                        SVV_Label.setText(String.valueOf(SVV));
                        CVL_Label.setText(String.valueOf(CVL));
                        SLDD_Label.setText(String.valueOf(t.getDSDD().size()));
                    }
                });
                btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        for (Button button : dsBtn) {
                            button.setStyle(nomarlLandStyle);
                        }
                        tenQuocGiaLabel.setText("Thế giới " + tg.getTenBC());
                        tenTinhLabel.setText("");
                        int SVV = ((ChiSo) tg.getThuocTinh("SVV")).getGiaTri();
                        int CVL = ((ChiSo) tg.getThuocTinh("CVL")).getGiaTri();
                        SVV_Label.setText(String.valueOf(SVV));
                        CVL_Label.setText(String.valueOf(CVL));
                    }
                });
                dsBtn.add(btn);
                worldMap.add(btn, t.getHoanhDo(), t.getTungDo());
//                }
            }
        }
    }
}
