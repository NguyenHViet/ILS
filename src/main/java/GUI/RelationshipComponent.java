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

    public void initialize() throws IOException {
//        loadData(MainSystem.getNguoiChoi().getDSQH());
    }

    public void loadData(ArrayList<MoiQuanHe> moiQH) throws IOException {
        familyRelationshipPane.getChildren().clear();
        for (MoiQuanHe mqh : moiQH) {
            FXMLLoader loader = new FXMLLoader(UI.class.getResource("ProfileItemComponent.fxml"));
            VBox quanHeItem = loader.load();
            quanHeItem.setPrefWidth(300);
            familyRelationshipPane.getChildren().add(quanHeItem);
            ((ProfileItemComponent) loader.getController()).loadData(mqh);
        }
    }

}
