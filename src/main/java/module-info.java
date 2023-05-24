module tryhardnihongo.isekailifesimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens tryhardnihongo.isekailifesimulator to javafx.fxml;
    exports tryhardnihongo.isekailifesimulator;
    
    opens GUI to javafx.fxml;
}
