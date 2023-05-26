/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import GameObject.VatPham;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

/**
 *
 * @author vuvuive
 */
public class InventoryComponent {
    @FXML
    private VBox inventoryPane;
    
    public void loadData(ArrayList<VatPham> dsVP) throws IOException {
        inventoryPane.getChildren().clear();
        for (VatPham vp : dsVP) {
            FXMLLoader loader = new FXMLLoader(UI.class.getResource("ProfileItemComponent.fxml"));
            VBox vatPham = loader.load();
            vatPham.setPrefWidth(300);
            inventoryPane.getChildren().add(vatPham);
            ((ProfileItemComponent) loader.getController()).loadData(vp);
        }
    }
}
