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
    private VBox identityPlanList;
    @FXML
    private Label characterNameLabel;
    @FXML
    private Label characterGenderLabel;
    @FXML
    private Label characterAgeLabel;
    @FXML
    private Label characterRaceLabel;
    @FXML
    private Label tinhNameLabel;
    @FXML
    private GridPane generalProfilePane;
    @FXML
    private TextFlow eventLog;
    @FXML
    private StackPane mainAreaStack;
    @FXML
    private Pane emptyPane;

    @FXML
    private ProgressBar STA_Value_Bar;

//    Button area
    @FXML
    private Button jobBtn;
    @FXML
    private Button entertainmentBtn;
    @FXML
    private Button worldNewsBtn;
    @FXML
    private Button nextYearBtn;
    @FXML
    private Button bagBtn;
    @FXML
    private Button relationshipBtn;
    @FXML
    private Button historyBtn;

//    Các màn hình chức năng
    private VBox worldMap;
    private MiniMapComponent worldMapController;

    private VBox relationship;
    private RelationshipComponent relationshipController;

    private VBox currentEvent;
    private CurrentEventComponent currentEventController;
    
    private VBox inventory;
    private InventoryComponent inventoryController;
    
    private VBox entertainment;
    private EntertainmentComponent entertainmentController;

    private String chucNangHienTai = "";

    public void initialize() throws IOException {
//        Init
        initStackPane();
//        Load data
        reloadProfile(MainSystem.getNguoiChoi());
        reloadButtonArea();
        MainSystem.suKienNamKeTiep();

        loadEvent();
    }

    private void initStackPane() throws IOException {
        FXMLLoader loader1 = new FXMLLoader(UI.class.getResource("MiniMapComponent.fxml"));
        worldMap = (VBox) loader1.load();
        
        FXMLLoader loader2 = new FXMLLoader(UI.class.getResource("RelationshipComponent.fxml"));
        relationship = (VBox) loader2.load();

        FXMLLoader loader3 = new FXMLLoader(UI.class.getResource("CurrentEventComponent.fxml"));
        currentEvent = loader3.load();
        
        FXMLLoader loader4 = new FXMLLoader(UI.class.getResource("InventoryComponent.fxml"));
        inventory = loader4.load();
        
        FXMLLoader loader5 = new FXMLLoader(UI.class.getResource("EntertainmentComponent.fxml"));
        entertainment = loader5.load();

        reloadStackPane();

        worldMapController = (MiniMapComponent) loader1.getController();
        relationshipController = (RelationshipComponent) loader2.getController();
        currentEventController = (CurrentEventComponent) loader3.getController();
        inventoryController = (InventoryComponent) loader4.getController();
        entertainmentController = (EntertainmentComponent) loader5.getController();
    }

    private void reloadStackPane() {
        mainAreaStack.getChildren().clear();
        mainAreaStack.getChildren().add(worldMap);
        mainAreaStack.getChildren().add(relationship);
        mainAreaStack.getChildren().add(inventory);
        mainAreaStack.getChildren().add(entertainment);
        mainAreaStack.getChildren().add(emptyPane);
        mainAreaStack.getChildren().add(eventLog);
        emptyPane.toFront();
        eventLog.toFront();
    }

    public void reloadProfile(NhanVat nv) throws IOException {

        ArrayList<ThuocTinh> dsTT = nv.getDSTT();

//        Tải dữ liệu chung
        characterNameLabel.textProperty().setValue(nv.getHoTen());
        if (nv.getGioiTinh() == 0) {
            characterGenderLabel.textProperty().setValue("Nam");
        } else {
            characterGenderLabel.textProperty().setValue("Nữ");
        }
        characterAgeLabel.textProperty().setValue(String.valueOf(nv.getTuoi()));
        characterRaceLabel.textProperty().setValue(nv.getChungToc());
        String viTri = nv.getViTri().getBoiCanh().getTenBC() + " - " + nv.getViTri().getTenBC();
        tinhNameLabel.textProperty().setValue(viTri);

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

        double STA_Value = ((ChiSo) nv.getThuocTinh("STA")).getGiaTri() / ((ChiSo) nv.getThuocTinh("PHY")).getGiaTri();
        STA_Value_Bar.setProgress(STA_Value);
    }

    public void reloadLongTermEvent() throws IOException {
        identityPlanList.getChildren().clear();
        for (SuKien sk : MainSystem.getDsSKLauDai()) {
            FXMLLoader loader = new FXMLLoader(UI.class.getResource("ProfileItemComponent.fxml"));
            identityPlanList.getChildren().add(loader.load());
            ((ProfileItemComponent) loader.getController()).loadData(sk);
        }
    }

    public void reloadButtonArea() {
        NhanVat mc = MainSystem.getNguoiChoi();
        if (mc.getTuoi() < 10) {
            jobBtn.setDisable(true);
        } else {
            jobBtn.setDisable(false);
        }
        
        if (mc.getTuoi() < 3) {
            entertainmentBtn.setDisable(true);
        } else {
            entertainmentBtn.setDisable(false);
        }
    }

    public void loadEvent() throws IOException {
        reloadStackPane();
        reloadLongTermEvent();
        SuKien sk = MainSystem.getSuKienHienTai();
        if (sk != null) {
            nextYearBtn.setDisable(true);
            currentEventController.loadData(sk, this);
            mainAreaStack.getChildren().add(currentEvent);
            MainSystem.kichHoatSuKienHienTai();
        } else {
            nextYearBtn.setDisable(false);
        }
        reloadProfile(MainSystem.getNguoiChoi());
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
        relationshipController.loadData(MainSystem.getNguoiChoi().getDSQH(), this);
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
        MainSystem.nhanVatPhatTrien();
        MainSystem.suKienNamKeTiep();
        loadEvent();
        reloadButtonArea();
    }
    
    @FXML
    private void openInventory() throws IOException {
        inventoryController.loadData(MainSystem.getNguoiChoi().getTuiDo());
        if (!"Inventory".equals(chucNangHienTai)) {
            emptyPane.toFront();
            inventory.toFront();
            chucNangHienTai = "Inventory";
        } else {
            inventory.toBack();
            currentEvent.toFront();
            chucNangHienTai = "";
        }
    }
    
    @FXML
    private void showEntertainmentPane() throws IOException {
        entertainmentController.loadData(MainSystem.getNguoiChoi().getViTri());
        if (!"Entertainment".equals(chucNangHienTai)) {
            emptyPane.toFront();
            entertainment.toFront();
            chucNangHienTai = "Entertainment";
        } else {
            entertainment.toBack();
            currentEvent.toFront();
            chucNangHienTai = "";
        }
    }

}
