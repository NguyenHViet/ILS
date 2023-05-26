/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import WorldBuilder.DiaDanh;
import WorldBuilder.Tinh;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

/**
 *
 * @author vuvuive
 */
public class EntertainmentComponent {

    @FXML
    private VBox locationListPane;

    public void loadData(Tinh viTri) throws IOException {
        ArrayList<DiaDanh> dsDD = (ArrayList<DiaDanh>) viTri.getDSDD().clone();
        System.out.println(viTri.getDSDD().size());
        locationListPane.getChildren().clear();
        for (DiaDanh dd : dsDD) {
            FXMLLoader loader = new FXMLLoader(UI.class.getResource("ProfileItemComponent.fxml"));
            VBox DiaDanhItem = loader.load();
            DiaDanhItem.setPrefWidth(300);
            locationListPane.getChildren().add(DiaDanhItem);
            ((ProfileItemComponent) loader.getController()).loadData(dd);
        }
    }

}
