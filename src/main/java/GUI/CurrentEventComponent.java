/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GameEvent.LuaChon;
import GameEvent.SuKien;
import GameSystem.MainSystem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author vuvuive
 */
public class CurrentEventComponent {

    @FXML
    private Label eventNameLabel;
    @FXML
    private TextFlow eventDescribe;
    @FXML
    private VBox eventSelection;

    @FXML
    private ScrollPane scrollPaneDescribe;
    @FXML
    private ScrollPane scrollPaneSelection;

    public void initialize() {
        scrollPaneDescribe.setStyle("-fx-background: rgb(255,255,255); -fx-background-color: rgb(255,255,255)");
        scrollPaneSelection.setStyle("-fx-background: rgb(255,255,255); -fx-background-color: rgb(255,255,255)");
    }

    public void loadData(SuKien sk, MainScreen mainScreenController) {
        eventSelection.getChildren().clear();
        eventDescribe.getChildren().clear();
        
        eventNameLabel.setText(sk.getTenSK());
        Text eventDescribeContent = new Text(sk.getMoTa());
        eventDescribe.getChildren().add(eventDescribeContent);
        
        ArrayList<LuaChon> dsLC = new ArrayList<LuaChon>();
        dsLC.addAll(sk.layLCPhuHop());
        for (LuaChon lc : dsLC) {
            Button luaChon = new Button(lc.getMoTa());
            luaChon.setMinWidth(280);
            luaChon.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    MainSystem.xuLySuKienHienTai(lc);
                    try {
                        mainScreenController.loadEvent();
                    } catch (IOException ex) {
                        Logger.getLogger(CurrentEventComponent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            eventSelection.getChildren().add(luaChon);
        }
    }

}
