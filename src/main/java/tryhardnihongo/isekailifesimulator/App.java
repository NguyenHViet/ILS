package tryhardnihongo.isekailifesimulator;

import GUI.UI;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage mainWindow;

    @Override
    public void start(Stage stage) throws IOException {
        UI.initUI(stage);
        UI.setLoadingContent("Đang tải dữ liệu từ database ...");
        UI.setNeededContent(100);
        
        Model.GameDatabase.connectDatabase("jdbc:mysql://localhost:3306/game_db","root","password");
        Model.ModelDieuKien.taiDieuKien();
        Model.ModelLuaChon.taiLuaChon();
        Model.ModelHieuUng.taiHieuUng();
        Model.ModelVatPham.taiVatPham();
        
        Model.ModelMauSuKien.taiMauSuKien();

        UI.loadFill(10);
    }

    public static void main(String[] args) {
        launch();
    }

}
