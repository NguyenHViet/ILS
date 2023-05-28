/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import SupportClass.MoiQuanHe;
import GameSystem.MainSystem;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

/**
 *
 * @author vuvuive
 */
public class RelationshipComponent {

    @FXML
    private VBox familyRelationshipPane;
    @FXML
    private VBox socialRelationshipPane;

    public void initialize() throws IOException {
//        loadData(MainSystem.getNguoiChoi().getDSQH());
    }

    public void loadData(ArrayList<MoiQuanHe> MQH) throws IOException {
        ArrayList<MoiQuanHe> dsMQH = (ArrayList<MoiQuanHe>) MQH.clone();
        familyRelationshipPane.getChildren().clear();
        socialRelationshipPane.getChildren().clear();
        for (MoiQuanHe mqh : dsMQH) {
            FXMLLoader loader = new FXMLLoader(UI.class.getResource("ProfileItemComponent.fxml"));
            VBox quanHeItem = loader.load();
            quanHeItem.setPrefWidth(300);
            if ("GIADINH".equals(mqh.getVongQuanHe())) {
                familyRelationshipPane.getChildren().add(quanHeItem);
            } else if ("XAHOI".equals(mqh.getVongQuanHe())) {
                socialRelationshipPane.getChildren().add(quanHeItem);
            }
            ((ProfileItemComponent) loader.getController()).loadData(mqh);
        }
    }

}
