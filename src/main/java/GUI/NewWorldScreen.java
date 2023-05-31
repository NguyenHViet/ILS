/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GameObject.NhanVat;
import SupportClass.ChiSo;
import SupportClass.ThuocTinh;
import GameSystem.GeneratorSystem;
import GameSystem.MainSystem;
import WorldBuilder.TheGioi;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *
 * @author vuvuive
 */
public class NewWorldScreen {

    @FXML
    private TextField worldNameTextField;
    @FXML
    private Slider SVV_Slider;
    @FXML
    private Slider RSC_Slider;
    @FXML
    private Slider CLM_Slider;
    @FXML
    private Slider CLS_Slider;
    @FXML
    private Slider CVL_Slider;
    @FXML
    private Slider SNT_Slider;
    @FXML
    private Slider MNA_Slider;
    @FXML
    private Slider MNE_Slider;
    @FXML
    private Slider EPM_Slider;
    @FXML
    private Label SVV_Label;
    @FXML
    private Label RSC_Label;
    @FXML
    private Label CLM_Label;
    @FXML
    private Label CLS_Label;
    @FXML
    private Label CVL_Label;
    @FXML
    private Label SNT_Label;
    @FXML
    private Label MNA_Label;
    @FXML
    private Label MNE_Label;
    @FXML
    private Label EPM_Label;

    public void initialize() {
        initScreen();
        loadDataIntoSlider();
    }

//    Giá trị của slider
    private int SVV_Value;
    private int RSC_Value;
    private int CLM_Value;
    private int CLS_Value;
    private int CVL_Value;
    private int SNT_Value;
    private int MNA_Value;
    private int MNE_Value;
    private int EPM_Value;

//    Tự động điều chỉnh giá trị slider
    private boolean SVV_Auto_Change;
    private boolean RSC_Auto_Change;
    private boolean CLM_Auto_Change;
    private boolean CLS_Auto_Change;
    private boolean CVL_Auto_Change;
    private boolean SNT_Auto_Change;
    private boolean MNA_Auto_Change;
    private boolean MNE_Auto_Change;
    private boolean EPM_Auto_Change;

    private void loadSliderValue() {
        RSC_Value = (int) RSC_Slider.getValue();
        CLM_Value = (int) CLM_Slider.getValue();
        CLS_Value = (int) CLS_Slider.getValue();
        SNT_Value = (int) SNT_Slider.getValue();
        MNA_Value = (int) MNA_Slider.getValue();
        MNE_Value = (int) MNE_Slider.getValue();
        EPM_Value = (int) EPM_Slider.getValue();
        CVL_Value = SNT_Value + MNA_Value + MNE_Value + EPM_Value;
        SVV_Value = 600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value;
        printSlideValue();
    }

    private void printSlideValue() {
        SVV_Label.textProperty().setValue(String.valueOf((int) SVV_Value));
        RSC_Label.textProperty().setValue(String.valueOf((int) RSC_Value));
        CLM_Label.textProperty().setValue(String.valueOf((int) CLM_Value));
        CLS_Label.textProperty().setValue(String.valueOf((int) CLS_Value));
        CVL_Label.textProperty().setValue(String.valueOf((int) CVL_Value));
        SNT_Label.textProperty().setValue(String.valueOf((int) SNT_Value));
        MNA_Label.textProperty().setValue(String.valueOf((int) MNA_Value));
        MNE_Label.textProperty().setValue(String.valueOf((int) MNE_Value));
        EPM_Label.textProperty().setValue(String.valueOf((int) EPM_Value));
    }

//    private void loadValueIntoSlider() {
//        RSC_Slider.setValue(RSC_Value);
//        CLM_Slider.setValue(CLM_Value);
//        CLS_Slider.setValue(CLS_Value);
//        CVL_Slider.setValue(CVL_Value);
//        SNT_Slider.setValue(SNT_Value);
//        MNA_Slider.setValue(MNA_Value);
//        MNE_Slider.setValue(MNE_Value);
//        EPM_Slider.setValue(EPM_Value);
//        SVV_Slider.setValue(SVV_Value);
//        printSlideValue();
//    }
    private void loadDataIntoSlider() {
        TheGioi tg = MainSystem.getTG();
        worldNameTextField.textProperty().setValue(tg.getTenBC());
//        Giá trị ban đầu
        int SNT = ((ChiSo) tg.getThuocTinh("SNT")).getGiaTri() / 10 * 10;
        int MNA = ((ChiSo) tg.getThuocTinh("MNA")).getGiaTri() / 10 * 10;
        int MNE = ((ChiSo) tg.getThuocTinh("MNE")).getGiaTri() / 10 * 10;
        int EPM = ((ChiSo) tg.getThuocTinh("EPM")).getGiaTri() / 10 * 10;
        int CVL = SNT + MNA + MNE + EPM;
        int RSC = ((ChiSo) tg.getThuocTinh("RSC")).getGiaTri() / 10 * 10;
        int CLM = ((ChiSo) tg.getThuocTinh("CLM")).getGiaTri() / 10 * 10;
        int CLS = ((ChiSo) tg.getThuocTinh("CLS")).getGiaTri() / 10 * 10;
        int SVV = 600 - (RSC + CLM + CVL) + CLS;
//        Hiển thị giá trị
        RSC_Slider.setValue(RSC);
        CLM_Slider.setValue(CLM);
        CLS_Slider.setValue(CLS);
        CVL_Slider.setValue(CVL);
        SNT_Slider.setValue(SNT);
        MNA_Slider.setValue(MNA);
        MNE_Slider.setValue(MNE);
        EPM_Slider.setValue(EPM);
        SVV_Slider.setValue(SVV);
//        Lưu lại giá trị tạm thời
        loadSliderValue();
    }

    private void initScreen() {

        SVV_Slider.valueProperty().addListener((obs, oldval, newVal) -> {
//                Điều chỉnh slider khác
            RSC_Auto_Change = true;
            CLM_Auto_Change = true;
            CLS_Auto_Change = true;
            CVL_Auto_Change = true;
            SNT_Auto_Change = true;
            MNA_Auto_Change = true;
            MNE_Auto_Change = true;
            EPM_Auto_Change = true;
            if (!SVV_Auto_Change) {
                if (newVal.intValue() < 70) {
                    RSC_Slider.setValue(100);
                    CLM_Slider.setValue(100);
                    CLS_Slider.setValue(0);
                    SNT_Slider.setValue(100);
                    MNA_Slider.setValue(100);
                    MNE_Slider.setValue(100);
                    EPM_Slider.setValue(100);
                    CVL_Slider.setValue(400);
                    SVV_Slider.setValue(0);
                } else if (newVal.intValue() > 630) {
                    RSC_Slider.setValue(0);
                    CLM_Slider.setValue(0);
                    CLS_Slider.setValue(100);
                    SNT_Slider.setValue(0);
                    MNA_Slider.setValue(0);
                    MNE_Slider.setValue(0);
                    EPM_Slider.setValue(0);
                    CVL_Slider.setValue(0);
                    SVV_Slider.setValue(700);
                } else {
                    int amount = (newVal.intValue() - SVV_Value) / 70;
                    RSC_Slider.setValue(RSC_Value - amount * 10);
                    CLM_Slider.setValue(CLM_Value - amount * 10);
                    CLS_Slider.setValue(CLS_Value + amount * 10);
                    SNT_Slider.setValue(SNT_Value - amount * 10);
                    MNA_Slider.setValue(MNA_Value - amount * 10);
                    MNE_Slider.setValue(MNE_Value - amount * 10);
                    EPM_Slider.setValue(EPM_Value - amount * 10);
                    CVL_Slider.setValue((SNT_Value + MNA_Value + MNE_Value + EPM_Value) - amount * 40);
                    SVV_Slider.setValue(600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value + amount * 50);
                }
//                Tải lại dữ liệu
                loadSliderValue();
            } else {
//                Làm mới trạng thái
                SVV_Auto_Change = false;
            }
        });

        RSC_Slider.valueProperty().addListener((obs, oldval, newVal) -> {
//                Điều chỉnh slider khác
            SVV_Auto_Change = true;
            if (!RSC_Auto_Change) {
                int amount = (newVal.intValue() - RSC_Value) / 10;
                RSC_Slider.setValue(RSC_Value + amount * 10);
                SVV_Slider.setValue(600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value - amount * 10);
//                Tải lại dữ liệu
                loadSliderValue();
            } else {
//                Làm mới trạng thái
                RSC_Auto_Change = false;
            }
        });

        CLM_Slider.valueProperty().addListener((obs, oldval, newVal) -> {
//                Điều chỉnh slider khác
            SVV_Auto_Change = true;
            if (!CLM_Auto_Change) {
                int amount = (newVal.intValue() - CLM_Value) / 10;
                CLM_Slider.setValue(CLM_Value + amount * 10);
                SVV_Slider.setValue(600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value - amount * 10);
//                Tải lại dữ liệu
                loadSliderValue();
            } else {
                CLM_Auto_Change = false;
            }
        });

        CLS_Slider.valueProperty().addListener((obs, oldval, newVal) -> {
//                Điều chỉnh slider khác
            SVV_Auto_Change = true;
            if (!CLS_Auto_Change) {
                int amount = (newVal.intValue() - CLS_Value) / 10;
                CLS_Slider.setValue(CLS_Value + amount * 10);
                SVV_Slider.setValue(600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value + amount * 10);
//                Tải lại dữ liệu
                loadSliderValue();
            } else {
                CLS_Auto_Change = false;
            }
        });

        CVL_Slider.valueProperty().addListener((obs, oldval, newVal) -> {
//                Điều chỉnh slider khác
            SVV_Auto_Change = true;
            SNT_Auto_Change = true;
            MNA_Auto_Change = true;
            MNE_Auto_Change = true;
            EPM_Auto_Change = true;
            if (!CVL_Auto_Change) {
                if (newVal.intValue() == 0) {
                    SNT_Slider.setValue(0);
                    MNA_Slider.setValue(0);
                    MNE_Slider.setValue(0);
                    EPM_Slider.setValue(0);
                    CVL_Slider.setValue(0);
                    SVV_Slider.setValue(600 - (RSC_Value + CLM_Value) + CLS_Value);
                } else if (newVal.intValue() == 400) {
                    SNT_Slider.setValue(100);
                    MNA_Slider.setValue(100);
                    MNE_Slider.setValue(100);
                    EPM_Slider.setValue(100);
                    CVL_Slider.setValue(400);
                    SVV_Slider.setValue(200 - (RSC_Value + CLM_Value) + CLS_Value);
                } else {
                    int amount = (newVal.intValue() - CVL_Value) / 40;
                    SNT_Slider.setValue(SNT_Value + amount * 10);
                    MNA_Slider.setValue(MNA_Value + amount * 10);
                    MNE_Slider.setValue(MNE_Value + amount * 10);
                    EPM_Slider.setValue(EPM_Value + amount * 10);
                    CVL_Slider.setValue(SNT_Value + MNA_Value + MNE_Value + EPM_Value + amount * 40);
                    SVV_Slider.setValue(600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value - amount * 40);
                }
//                Tải lại dữ liệu
                loadSliderValue();
            } else {
                CVL_Auto_Change = false;
            }
        });

        SNT_Slider.valueProperty().addListener((obs, oldval, newVal) -> {
//                Điều chỉnh slider khác
            SVV_Auto_Change = true;
            CVL_Auto_Change = true;
            if (!SNT_Auto_Change) {
                int amount = (newVal.intValue() - SNT_Value) / 10;
                SNT_Slider.setValue(SNT_Value + amount * 10);
                CVL_Slider.setValue(SNT_Value + MNA_Value + MNE_Value + EPM_Value + amount * 10);
                SVV_Slider.setValue(600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value - amount * 10);
//                Tải lại dữ liệu
                loadSliderValue();
            } else {
                SNT_Auto_Change = false;
            }
        }
        );

        MNA_Slider.valueProperty().addListener((obs, oldval, newVal) -> {
//                Điều chỉnh slider khác
            SVV_Auto_Change = true;
            CVL_Auto_Change = true;
            if (!MNA_Auto_Change) {
                int amount = (newVal.intValue() - MNA_Value) / 10;
                MNA_Slider.setValue(MNA_Value + amount * 10);
                CVL_Slider.setValue(SNT_Value + MNA_Value + MNE_Value + EPM_Value + amount * 10);
                SVV_Slider.setValue(600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value - amount * 10);
//                Tải lại dữ liệu
                loadSliderValue();
            } else {
                MNA_Auto_Change = false;
            }
        });

        MNE_Slider.valueProperty().addListener((obs, oldval, newVal) -> {
//                Điều chỉnh slider khác
            SVV_Auto_Change = true;
            CVL_Auto_Change = true;
            if (!MNE_Auto_Change) {
                int amount = (newVal.intValue() - MNE_Value) / 10;
                MNE_Slider.setValue(MNE_Value + amount * 10);
                CVL_Slider.setValue(SNT_Value + MNA_Value + MNE_Value + EPM_Value + amount * 10);
                SVV_Slider.setValue(600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value - amount * 10);
//                Tải lại dữ liệu
                loadSliderValue();
            } else {
                MNE_Auto_Change = false;
            }
        });

        EPM_Slider.valueProperty().addListener((obs, oldval, newVal) -> {
//                Điều chỉnh slider khác
            SVV_Auto_Change = true;
            CVL_Auto_Change = true;
            if (!EPM_Auto_Change) {
                int amount = (newVal.intValue() - EPM_Value) / 10;
                EPM_Slider.setValue(EPM_Value + amount * 10);
                CVL_Slider.setValue(SNT_Value + MNA_Value + MNE_Value + EPM_Value + amount * 10);
                SVV_Slider.setValue(600 - (RSC_Value + CLM_Value + CVL_Value) + CLS_Value - amount * 10);
//                Tải lại dữ liệu
                loadSliderValue();
            } else {
                EPM_Auto_Change = false;
            }
        });
    }

    private void saveNewWorld() {
        TheGioi tg = MainSystem.getTG();
        UI.updateProgress(1);
//        Tài nguyên
        ((ChiSo) tg.getThuocTinh("RSC")).setGiaTri(RSC_Value);
        UI.updateProgress(1);
//        Khí Hậu
        ((ChiSo) tg.getThuocTinh("CLM")).setGiaTri(CLM_Value);
        UI.updateProgress(1);
//        Băng Hoại
        ((ChiSo) tg.getThuocTinh("CLS")).setGiaTri(CLS_Value);
        UI.updateProgress(1);
//        Khoa Học - Kỹ Thuật
        ((ChiSo) tg.getThuocTinh("SNT")).setGiaTri(SNT_Value);
        UI.updateProgress(1);
//        Ma Thuật - Giả Kim
        ((ChiSo) tg.getThuocTinh("MNA")).setGiaTri(MNA_Value);
        UI.updateProgress(1);
//        Y Tế - Giáo Dục
        ((ChiSo) tg.getThuocTinh("MNE")).setGiaTri(MNE_Value);
        UI.updateProgress(1);
//        Kinh Tế - Chính Trị - Quân Sự
        ((ChiSo) tg.getThuocTinh("EPM")).setGiaTri(EPM_Value);
        UI.updateProgress(1);
//        Độ khó sinh tồn
        tg.getDSTT().add(new ChiSo("SVV", "Độ khó sinh tồn", "", true, SVV_Value, 0, 0));
        UI.updateProgress(1);
//        Trình độ văn minh
        tg.getDSTT().add(new ChiSo("CVL", "Trình độ văn minh", "", true, CVL_Value, 0, 0));
        UI.updateProgress(1);
    }

    @FXML
    private void randomWorldValue() {
        TheGioi tg = MainSystem.getTG();
        MainSystem.setTG(GeneratorSystem.taoTheGioi(tg.getMaBC()));
        loadDataIntoSlider();
    }

    @FXML
    private void backToWaitingScreen() throws IOException {
        UI.setMainFrame("WaitingScreen");
        UI.loadComplete();
    }

    @FXML
    private void nextToCreateCharacter() throws IOException {
        UI.startLoad();
        UI.setLoadingContent("Bắt đầu khởi tạo người chơi ...");
        UI.setNeededContent(12);
        UI.setLoadedContent(0);
        saveNewWorld();
        Task<NhanVat> task = new Task<NhanVat>() {
            @Override
            protected NhanVat call() throws Exception {
                NhanVat mc = GeneratorSystem.taoNhanVat("0000", MainSystem.getTG(), 0, 0, true, "");
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        UI.addLoadedContent(1);
                    }
                });
                return mc;
            }
        };
        new Thread(task).start();
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent arg0) {
                MainSystem.setNguoiChoi((NhanVat) task.getValue());
                try {
                    UI.setMainFrame("NewCharacterScreen");
                } catch (IOException ex) {
                    Logger.getLogger(WaitingScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                UI.loadFill(10);
            }
        });
    }
}
