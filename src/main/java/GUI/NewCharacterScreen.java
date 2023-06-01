/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GameObject.NhanVat;
import Model.ModelNhanVat;
import SupportClass.ChiSo;
import GameSystem.GeneratorSystem;
import static GameSystem.GeneratorSystem.randomValue;
import GameSystem.MainSystem;
import WorldBuilder.QuocGia;
import WorldBuilder.TheGioi;
import WorldBuilder.Tinh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *
 * @author vuvuive
 */
public class NewCharacterScreen {

    @FXML
    private TextField STR_Natural_TF;
    @FXML
    private TextField PHY_Natural_TF;
    @FXML
    private TextField MNT_Natural_TF;
    @FXML
    private TextField INT_Natural_TF;
    @FXML
    private TextField STR_Potential_TF;
    @FXML
    private TextField PHY_Potential_TF;
    @FXML
    private TextField MNT_Potential_TF;
    @FXML
    private TextField INT_Potential_TF;
    @FXML
    private TextField characterNameTF;
    @FXML
    private Button STR_N_Dec_Btn;
    @FXML
    private Button STR_N_Inc_Btn;
    @FXML
    private Button STR_P_Dec_Btn;
    @FXML
    private Button STR_P_Inc_Btn;
    @FXML
    private Button PHY_N_Dec_Btn;
    @FXML
    private Button PHY_N_Inc_Btn;
    @FXML
    private Button PHY_P_Dec_Btn;
    @FXML
    private Button PHY_P_Inc_Btn;
    @FXML
    private Button MNT_N_Dec_Btn;
    @FXML
    private Button MNT_N_Inc_Btn;
    @FXML
    private Button MNT_P_Dec_Btn;
    @FXML
    private Button MNT_P_Inc_Btn;
    @FXML
    private Button INT_N_Dec_Btn;
    @FXML
    private Button INT_N_Inc_Btn;
    @FXML
    private Button INT_P_Dec_Btn;
    @FXML
    private Button INT_P_Inc_Btn;
    @FXML
    private Label SOG_Label;
    @FXML
    private ToggleGroup genderSelect;
    @FXML
    private ChoiceBox raceSelect;

    public void initialize() {
//        Init
        initScreen();
//        Load data
        loadDataFrom();
    }

    private int STR_N_Value;
    private int STR_P_Value;
    private int PHY_N_Value;
    private int PHY_P_Value;
    private int MNT_N_Value;
    private int MNT_P_Value;
    private int INT_N_Value;
    private int INT_P_Value;
    private int SOG_Value;

    private void loadTextFieldValue() {
        STR_N_Value = Integer.parseInt(STR_Natural_TF.textProperty().getValue());
        STR_P_Value = Integer.parseInt(STR_Potential_TF.textProperty().getValue());
        PHY_N_Value = Integer.parseInt(PHY_Natural_TF.textProperty().getValue());
        PHY_P_Value = Integer.parseInt(PHY_Potential_TF.textProperty().getValue());
        MNT_N_Value = Integer.parseInt(MNT_Natural_TF.textProperty().getValue());
        MNT_P_Value = Integer.parseInt(MNT_Potential_TF.textProperty().getValue());
        INT_N_Value = Integer.parseInt(INT_Natural_TF.textProperty().getValue());
        INT_P_Value = Integer.parseInt(INT_Potential_TF.textProperty().getValue());
        SOG_Value = Integer.parseInt(SOG_Label.textProperty().getValue());
    }

    private void loadValueIntoTextField() {
        STR_Natural_TF.textProperty().setValue(String.valueOf(STR_N_Value));
        STR_Potential_TF.textProperty().setValue(String.valueOf(STR_P_Value));
        PHY_Natural_TF.textProperty().setValue(String.valueOf(PHY_N_Value));
        PHY_Potential_TF.textProperty().setValue(String.valueOf(PHY_P_Value));
        MNT_Natural_TF.textProperty().setValue(String.valueOf(MNT_N_Value));
        MNT_Potential_TF.textProperty().setValue(String.valueOf(MNT_P_Value));
        INT_Natural_TF.textProperty().setValue(String.valueOf(INT_N_Value));
        INT_Potential_TF.textProperty().setValue(String.valueOf(INT_P_Value));
        SOG_Label.textProperty().setValue(String.valueOf(SOG_Value));
    }

    private void loadDataFrom() {
        NhanVat mc = MainSystem.getNguoiChoi();
        characterNameTF.textProperty().setValue(mc.getHoTen());
        genderSelect.getToggles().get(mc.getGioiTinh()).setSelected(true);
//        Sức khỏe
        ChiSo STR = (ChiSo) mc.getThuocTinh("STR");
        STR_Natural_TF.textProperty().setValue(String.valueOf(STR.getGiaTri()));
        STR_Potential_TF.textProperty().setValue(String.valueOf(STR.getTiemNang()));

        ChiSo PHY = (ChiSo) mc.getThuocTinh("PHY");
        PHY_Natural_TF.textProperty().setValue(String.valueOf(PHY.getGiaTri()));
        PHY_Potential_TF.textProperty().setValue(String.valueOf(PHY.getTiemNang()));

        ChiSo MNT = (ChiSo) mc.getThuocTinh("MNT");
        MNT_Natural_TF.textProperty().setValue(String.valueOf(MNT.getGiaTri()));
        MNT_Potential_TF.textProperty().setValue(String.valueOf(MNT.getTiemNang()));

        ChiSo INT = (ChiSo) mc.getThuocTinh("INT");
        INT_Natural_TF.textProperty().setValue(String.valueOf(INT.getGiaTri()));
        INT_Potential_TF.textProperty().setValue(String.valueOf(INT.getTiemNang()));

        SOG_Label.textProperty().setValue("0");

        loadTextFieldValue();
    }

    private void initScreen() {
        String st[] = {"Nhân loại"};
        raceSelect.setItems(FXCollections.observableArrayList(st));
        raceSelect.getSelectionModel().selectFirst();
    }

    @FXML
    private void decNaturalSTR() {
        if (STR_N_Value == 0) {
            return;
        }
        STR_N_Value--;
        SOG_Value++;
        loadValueIntoTextField();
    }

    @FXML
    private void incNaturalSTR() {
        if (SOG_Value == 0) {
            return;
        }
        STR_N_Value++;
        SOG_Value--;
        loadValueIntoTextField();
    }

    @FXML
    private void decNaturalPHY() {
        if (PHY_N_Value == 0) {
            return;
        }
        PHY_N_Value--;
        SOG_Value++;
        loadValueIntoTextField();
    }

    @FXML
    private void incNaturalPHY() {
        if (SOG_Value == 0) {
            return;
        }
        PHY_N_Value++;
        SOG_Value--;
        loadValueIntoTextField();
    }

    @FXML
    private void decNaturalMNT() {
        if (MNT_N_Value == 0) {
            return;
        }
        MNT_N_Value--;
        SOG_Value++;
        loadValueIntoTextField();
    }

    @FXML
    private void incNaturalMNT() {
        if (SOG_Value == 0) {
            return;
        }
        MNT_N_Value++;
        SOG_Value--;
        loadValueIntoTextField();
    }

    @FXML
    private void decNaturalINT() {
        if (INT_N_Value == 0) {
            return;
        }
        INT_N_Value--;
        SOG_Value++;
        loadValueIntoTextField();
    }

    @FXML
    private void incNaturalINT() {
        if (SOG_Value == 0) {
            return;
        }
        INT_N_Value++;
        SOG_Value--;
        loadValueIntoTextField();
    }

    @FXML
    private void decPotentialSTR() {
        if (STR_P_Value < -4) {
            return;
        }
        STR_P_Value--;
        SOG_Value += 5;
        loadValueIntoTextField();
    }

    @FXML
    private void incPotentialSTR() {
        if (SOG_Value < 5) {
            return;
        }
        STR_P_Value++;
        SOG_Value -= 5;
        loadValueIntoTextField();
    }

    @FXML
    private void decPotentialPHY() {
        if (PHY_P_Value < -4) {
            return;
        }
        PHY_P_Value--;
        SOG_Value += 5;
        loadValueIntoTextField();
    }

    @FXML
    private void incPotentialPHY() {
        if (SOG_Value < 5) {
            return;
        }
        PHY_P_Value++;
        SOG_Value -= 5;
        loadValueIntoTextField();
    }

    @FXML
    private void decPotentialMNT() {
        if (MNT_P_Value < -4) {
            return;
        }
        MNT_P_Value--;
        SOG_Value += 5;
        loadValueIntoTextField();
    }

    @FXML
    private void incPotentialMNT() {
        if (SOG_Value < 5) {
            return;
        }
        MNT_P_Value++;
        SOG_Value -= 5;
        loadValueIntoTextField();
    }

    @FXML
    private void decPotentialINT() {
        if (INT_P_Value < -4) {
            return;
        }
        INT_P_Value--;
        SOG_Value += 5;
        loadValueIntoTextField();
    }

    @FXML
    private void incPotentialINT() {
        if (SOG_Value < 5) {
            return;
        }
        INT_P_Value++;
        SOG_Value -= 5;
        loadValueIntoTextField();
    }

    private void saveNewCharacter() {
        NhanVat mc = MainSystem.getNguoiChoi();
//        Sức khỏe
        ((ChiSo) mc.getThuocTinh("STR")).setGiaTri(STR_N_Value);
        ((ChiSo) mc.getThuocTinh("STR")).setTiemNang(STR_P_Value);
//        Thể lực
        ((ChiSo) mc.getThuocTinh("PHY")).setGiaTri(PHY_N_Value);
        ((ChiSo) mc.getThuocTinh("PHY")).setTiemNang(PHY_P_Value);
        ((ChiSo) mc.getThuocTinh("STA")).setGiaTri(PHY_N_Value);
//        Tâm lý
        ((ChiSo) mc.getThuocTinh("MNT")).setGiaTri(MNT_N_Value);
        ((ChiSo) mc.getThuocTinh("MNT")).setTiemNang(MNT_P_Value);
//        Trí lực
        ((ChiSo) mc.getThuocTinh("INT")).setGiaTri(INT_N_Value);
        ((ChiSo) mc.getThuocTinh("INT")).setTiemNang(INT_P_Value);
//        Tổng điểm thiên phú
        ((ChiSo) mc.getThuocTinh("SOG")).setGiaTri(SOG_Value);

//        Giới tính
        int gender = 0;
        if (!genderSelect.getToggles().get(gender).isSelected()) {
            gender = 1;
        }
        mc.setGioiTinh(gender);
        ((ChiSo) mc.getThuocTinh("GDR")).setGiaTri(gender);

        ((ChiSo) mc.getThuocTinh("AGE")).setGiaTri(0);
//        Chủng tộc
        mc.setChungToc("Nhân tộc");
        mc.setHoTen(characterNameTF.getText());
        ModelNhanVat.themNhanVat(mc);
    }

    @FXML
    private void randomCharacterValue() {
//        Init
        MainSystem.setNguoiChoi(GeneratorSystem.taoNhanVat(MainSystem.getNguoiChoi().getMaNV(), MainSystem.getTG(), 0, new Random().nextInt(2), true, ""));
//        Load data
        loadDataFrom();
    }

    @FXML
    private void backToNewWorldScreen() throws IOException {
        UI.startLoad();
        UI.setMainFrame("NewWorldScreen");
        UI.setNeededContent(100);
        UI.setLoadedContent(0);
        UI.loadFill(5);
    }

    @FXML
    private void nextToBegin() throws IOException {
        UI.startLoad();
        UI.setLoadingContent("Bắt đầu khởi tạo những yếu tố khác ...");
        UI.setNeededContent(600);
        UI.setLoadedContent(0);
        saveNewCharacter();
//        Task
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                GeneratorSystem.khoiTaoCacVungDat(MainSystem.getTG());
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        UI.addLoadedContent(1);
                    }
                });
                return null;
            }
        };

        Task<Void> task2 = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                ArrayList<QuocGia> dsQG = MainSystem.getTG().getDSQG();
                QuocGia qg = dsQG.get(new Random().nextInt(dsQG.size()));
                ArrayList<Tinh> dsT = qg.getDST();
                Tinh vt = dsT.get(new Random().nextInt(dsT.size()));
                MainSystem.getNguoiChoi().setViTri(vt);
                GeneratorSystem.khoiTaoNguoiThan(MainSystem.getNguoiChoi());
                GeneratorSystem.khoiTaoXaHoi(MainSystem.getNguoiChoi());
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        UI.addLoadedContent(1);
                    }
                });
                return null;
            }
        };

        task2.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent arg0) {
                try {
                    UI.setMainFrame("MainScreen");
                } catch (IOException ex) {
                    Logger.getLogger(WaitingScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                UI.loadFill(5);
            }
        });

        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent arg0) {
                UI.addLoadedContent(1);
                new Thread(task2).start();
            }
        });

        new Thread(task).start();
    }

}
