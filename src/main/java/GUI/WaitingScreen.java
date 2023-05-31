/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GameObject.NhanVat;
import GameSystem.GeneratorSystem;
import static GameSystem.GeneratorSystem.taoTenNgauNghien;
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
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

/**
 *
 * @author vuvuive
 */
public class WaitingScreen {

    @FXML
    private void newGame() throws IOException {
        UI.startLoad();
        UI.setNeededContent(10);
        UI.setLoadedContent(0);
        UI.setLoadingContent("Bắt đầu khởi tạo thế giới ...");
        Task<TheGioi> khoiTao = new Task<TheGioi>() {
            @Override
            protected TheGioi call() throws Exception {
                TheGioi newWorld = GeneratorSystem.taoTheGioi("0000");
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        UI.addLoadedContent(1);
                    }
                });
                return newWorld;
            }
        };
        new Thread(khoiTao).start();
        khoiTao.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent arg0) {
                MainSystem.setTG((TheGioi) khoiTao.getValue());
                try {
                    UI.setMainFrame("NewWorldScreen");
                } catch (IOException ex) {
                    Logger.getLogger(WaitingScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                UI.loadFill(10);
            }
        });
    }

    @FXML
    private void fastPlay() throws IOException {
        UI.startLoad();
        UI.setNeededContent(700);
        UI.setLoadedContent(0);
        UI.setLoadingContent("Bắt đầu khởi tạo thế giới ...");

        Task<TheGioi> khoiTaoTG = new Task<TheGioi>() {
            @Override
            protected TheGioi call() throws Exception {
                TheGioi newWorld = GeneratorSystem.taoTheGioi("0000");
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        UI.addLoadedContent(1);
                    }
                });
                return newWorld;
            }
        };

        Task<NhanVat> khoiTaoNV = new Task<NhanVat>() {
            @Override
            protected NhanVat call() throws Exception {
                NhanVat mc = GeneratorSystem.taoNhanVat("0000", MainSystem.getTG(), 0, 0, true, "");
                System.out.println(2.5);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        UI.addLoadedContent(1);
                    }
                });
                return mc;
            }
        };

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

        khoiTaoTG.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent arg0) {
                MainSystem.setTG((TheGioi) khoiTaoTG.getValue());
                new Thread(khoiTaoNV).start();
            }
        });

        khoiTaoNV.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent arg0) {
                MainSystem.setNguoiChoi((NhanVat) khoiTaoNV.getValue());
                new Thread(task).start();
            }
        });

        new Thread(khoiTaoTG).start();
    }

    @FXML
    private void quit() {
        Platform.exit();
    }
}
