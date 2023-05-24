/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GameEvent.SuKien;
import GameObject.NhanVat;
import SupportClass.*;
import GameSystem.MainSystem;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

/**
 *
 * @author vuvuive
 */
public class MainScreen {

    @FXML
    private VBox profileStack;
    @FXML
    private VBox statusPane;
    @FXML
    private VBox personalityPane;
    @FXML
    private VBox conditionPane;
    @FXML
    private Label characterNameLabel;
    @FXML
    private Label characterGenderLabel;
    @FXML
    private Label characterAgeLabel;
    @FXML
    private Label characterRaceLabel;
    @FXML
    private GridPane generalProfilePane;
    @FXML
    private TextFlow eventLog;
    @FXML
    private StackPane mainAreaStack;
    @FXML
    private Pane emptyPane;

//    Các màn hình chức năng
    private VBox worldMap;
    private MiniMapComponent worldMapController;

    private VBox relationship;
    private RelationshipComponent relationshipController;

    private VBox currentEvent;
    private CurrentEventComponent currentEventController;

    private String chucNangHienTai = "";

    public void initialize() throws IOException {
//        Init
        initStackPane();
//        Load data
        reloadProfile();

        MainSystem.suKienNamKeTiep();

        loadEvent();
    }

    private void initStackPane() throws IOException {
        FXMLLoader loader1 = new FXMLLoader(UI.class.getResource("MiniMapComponent.fxml"));
        worldMap = (VBox) loader1.load();
        FXMLLoader loader2 = new FXMLLoader(UI.class.getResource("RelationshipComponent.fxml"));
        relationship = (VBox) loader2.load();

        FXMLLoader loader = new FXMLLoader(UI.class.getResource("CurrentEventComponent.fxml"));
        currentEvent = loader.load();

        mainAreaStack.getChildren().add(worldMap);
        mainAreaStack.getChildren().add(relationship);

        worldMapController = (MiniMapComponent) loader1.getController();
        relationshipController = (RelationshipComponent) loader2.getController();
        currentEventController = loader.getController();
    }

    private void reloadStackPane() {
        mainAreaStack.getChildren().clear();
        mainAreaStack.getChildren().add(worldMap);
        mainAreaStack.getChildren().add(relationship);
        mainAreaStack.getChildren().add(emptyPane);
        mainAreaStack.getChildren().add(eventLog);
        emptyPane.toFront();
        eventLog.toFront();
    }

    private void reloadProfile() throws IOException {
        NhanVat mc = MainSystem.getNguoiChoi();

        ArrayList<ThuocTinh> dsTT = mc.getDSTT();

//        Tải dữ liệu chung
        characterNameLabel.textProperty().setValue(mc.getHoTen());
        if (mc.getGioiTinh() == 0) {
            characterGenderLabel.textProperty().setValue("Nam");
        } else {
            characterGenderLabel.textProperty().setValue("Nữ");
        }
        characterAgeLabel.textProperty().setValue(String.valueOf(mc.getTuoi()));
        characterRaceLabel.textProperty().setValue(mc.getChungToc());

//        Tải lại chỉ số nhân vật
        statusPane.getChildren().clear();
//        Tải lại tính cách nhân vật
        personalityPane.getChildren().clear();
//        Tải lại trạng thái nhân vật
        conditionPane.getChildren().clear();

        for (ThuocTinh tt : dsTT) {
            if (!tt.isHienThi()) {
                continue;
            }
            FXMLLoader loader = new FXMLLoader(UI.class.getResource("ProfileItemComponent.fxml"));
            if (tt instanceof ChiSo) {
                statusPane.getChildren().add(loader.load());
            } else if (tt instanceof TinhCach) {
                personalityPane.getChildren().add(loader.load());
            } else if (tt instanceof TrangThai) {
                conditionPane.getChildren().add(loader.load());
            }
            ((ProfileItemComponent) loader.getController()).loadData(tt);
        }
    }

    public void loadEvent() throws IOException {
        reloadStackPane();
        SuKien sk = MainSystem.getSuKienHienTai();
        if (sk != null) {
            currentEventController.loadData(sk, this);
            mainAreaStack.getChildren().add(currentEvent);
        }
    }

    @FXML
    private void showWorldNews() {
        worldMapController.loadData(MainSystem.getTG());
        if (!"WorldMap".equals(chucNangHienTai)) {
            emptyPane.toFront();
            worldMap.toFront();
            chucNangHienTai = "WorldMap";
        } else {
            worldMap.toBack();
            currentEvent.toFront();
            chucNangHienTai = "";
        }
    }

    @FXML
    private void showRelationship() throws IOException {
        relationshipController.loadData(MainSystem.getNguoiChoi().getDSQH());
        if (!"Relationship".equals(chucNangHienTai)) {
            emptyPane.toFront();
            relationship.toFront();
            chucNangHienTai = "Relationship";
        } else {
            relationship.toBack();
            currentEvent.toFront();
            chucNangHienTai = "";
        }
    }

    @FXML
    private void namKeTiep() throws IOException {
        mainAreaStack.getChildren().clear();
        MainSystem.suKienNamKeTiep();
        loadEvent();
    }

}
