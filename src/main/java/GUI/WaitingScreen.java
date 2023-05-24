/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GameSystem.GeneratorSystem;
import static GameSystem.GeneratorSystem.taoTenNgauNghien;
import GameSystem.MainSystem;
import WorldBuilder.TheGioi;
import java.io.IOException;
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
}
