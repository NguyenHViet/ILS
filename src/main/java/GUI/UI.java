/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.IOException;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author vuvuive
 */
public class UI {

    private static Stage mainWindow;

    private static Scene scene;

    private static BorderPane mainStage;
    private static Pane gameScreen;

    private static VBox loadingScreen;
    private static LoadingScreen loaderController;

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

//    Loading Screen
    public static void startLoad() throws IOException {
        loadingScreen.setOpacity(1);
        loadingScreen.toFront();
        setLoadedContent(0);
    }

    public static void loadFill(int sleepDuration) {
        Service<Void> New_Service = new Service<>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<>() {
                    @Override
                    protected Void call() throws Exception {
                        while (loaderController.getLoadedContent() < loaderController.getNeededContent()) {

                            try {
                                Thread.sleep(sleepDuration);
                            } catch (InterruptedException ex) {
                            }

                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    addLoadedContent(1);
                                }
                            });
                        }
                        return null;
                    }
                };
            }
        };
        New_Service.start();
    }

    public static void loadFill() {
        Service<Void> New_Service = new Service<>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<>() {
                    @Override
                    protected Void call() throws Exception {
                        while (loaderController.getLoadedContent() < loaderController.getNeededContent()) {

                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException ex) {
                            }

                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    addLoadedContent(1);
                                }
                            });
                        }
                        return null;
                    }
                };
            }
        };
        New_Service.start();
    }

    public static void loadComplete() {
        loadingScreen.toBack();
        loadingScreen.setOpacity(0);
    }

    public static void setLoadingContent(String str) {
        loaderController.setLoadingContent(str);
    }

    public static void setLoadingBarValue(double val) {
        loaderController.setLoadingBarValue(val);
        if (loaderController.getLoadedContent() >= loaderController.getNeededContent()) {
            loadComplete();
        }
    }

    public static void setNeededContent(double neededContent) {
        loaderController.setNeededContent(neededContent);
    }

    public static void setLoadedContent(double loadedContent) {
        loaderController.setLoadedContent(loadedContent);
        if (loaderController.getLoadedContent() >= loaderController.getNeededContent()) {
            loadComplete();
        }
    }

    public static void addNeededContent(double neededContent) {
        loaderController.addNeededContent(neededContent);
    }

    public static void addLoadedContent(double loadedContent) {
        loaderController.addLoadedContent(loadedContent);
        if (loaderController.getLoadedContent() >= loaderController.getNeededContent()) {
            loadComplete();
        }
    }

    public static void updateProgress(int progress) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                addLoadedContent(progress);
            }
        });
    }

    public static void updateProgressContent(String content) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setLoadingContent(content);
            }
        });
    }

//    Main Frame
    public static void setMainFrame(String fxml) throws IOException {
        gameScreen.getChildren().clear();
        gameScreen.getChildren().add(loadFXML(fxml));
        gameScreen.getChildren().add(loadingScreen);
    }

    public static void initUI(Stage stage) throws IOException {
        mainWindow = stage;

        mainStage = new BorderPane(loadFXML("MainStage"));
        gameScreen = (Pane) ((Pane) mainStage.getChildren().get(0)).getChildren().get(1);

        gameScreen.getChildren().add(loadFXML("WaitingScreen"));

        FXMLLoader loader = new FXMLLoader(UI.class.getResource("LoadingScreen.fxml"));
        loadingScreen = loader.load();

        gameScreen.getChildren().add(loadingScreen);
        loaderController = (LoadingScreen) loader.getController();

        scene = new Scene(mainStage, 1000, 625);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.W && event.isControlDown()) {
                Alert alert = new Alert(AlertType.CONFIRMATION,
                        "Tiến trình chơi của bạn sẽ không được lưu. Xác nhận thoát trò chơi?",
                        ButtonType.YES,
                        ButtonType.NO);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {
                    Platform.exit();
                }
            }
            event.consume();
        });

        mainWindow.setOnCloseRequest(event -> {
            Alert alert = new Alert(AlertType.CONFIRMATION,
                    "Tiến trình chơi của bạn sẽ không được lưu. Xác nhận thoát trò chơi?",
                    ButtonType.YES,
                    ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                Platform.exit();
            }
        });

        mainWindow.setScene(scene);
        mainWindow.show();
        mainWindow.sizeToScene();
        mainWindow.setResizable(false);
    }

    static <T> T getChildByID(Parent parent, String id) {
        String nodeId = null;

        if (parent instanceof TitledPane) {
            TitledPane titledPane = (TitledPane) parent;
            Node content = titledPane.getContent();
            nodeId = content.idProperty().get();
            if (nodeId != null && nodeId.equals(id)) {
                return (T) content;
            }

            if (content instanceof Parent) {
                T child = getChildByID((Parent) content, id);

                if (child != null) {
                    return child;
                }
            }
        }

        if (parent instanceof ScrollPane) {
            ScrollPane scrollPane = (ScrollPane) parent;
            Node content = scrollPane.getContent();
            nodeId = content.idProperty().get();

            if (nodeId != null && nodeId.equals(id)) {
                return (T) content;
            }

            if (content instanceof Parent) {
                T child = getChildByID((Parent) content, id);

                if (child != null) {
                    return child;
                }
            }
        }

        for (Node node : parent.getChildrenUnmodifiable()) {
            nodeId = node.idProperty().get();
            if (nodeId != null && nodeId.equals(id)) {
                return (T) node;
            }

            if (node instanceof SplitPane) {
                SplitPane splitPane = (SplitPane) node;
                for (Node itemNode : splitPane.getItems()) {
                    nodeId = itemNode.idProperty().get();

                    if (nodeId != null && nodeId.equals(id)) {
                        return (T) itemNode;
                    }

                    if (itemNode instanceof Parent) {
                        T child = getChildByID((Parent) itemNode, id);

                        if (child != null) {
                            return child;
                        }
                    }
                }
            } else if (node instanceof Accordion) {
                Accordion accordion = (Accordion) node;
                for (TitledPane titledPane : accordion.getPanes()) {
                    nodeId = titledPane.idProperty().get();

                    if (nodeId != null && nodeId.equals(id)) {
                        return (T) titledPane;
                    }

                    T child = getChildByID(titledPane, id);

                    if (child != null) {
                        return child;
                    }
                }
            } else if (node instanceof Parent) {
                T child = getChildByID((Parent) node, id);

                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }

    public static <T> T getChildByID(String id) {
        return getChildByID(mainStage, id);
    }

    public static void getStruct(Parent parent, String tab) {
        tab += "\t";

        if (parent instanceof TitledPane) {
            TitledPane titledPane = (TitledPane) parent;
            Node content = titledPane.getContent();
            System.out.print(tab + "+ " + content.getClass());
            System.out.println(", ID: " + content.idProperty().get());

            if (content instanceof Parent) {
                getStruct((Parent) content, tab);
            }
        }

        if (parent instanceof ScrollPane) {
            ScrollPane scrollPane = (ScrollPane) parent;
            Node content = scrollPane.getContent();
            System.out.print(tab + "+ " + content.getClass());
            System.out.println(", ID: " + content.idProperty().get());

            if (content instanceof Parent) {
                getStruct((Parent) content, tab);
            }
        }

        for (Node node : parent.getChildrenUnmodifiable()) {
            System.out.print(tab + "+ " + node.getClass());
            System.out.println(", ID: " + node.idProperty().get());

            if (node instanceof SplitPane) {
                SplitPane splitPane = (SplitPane) node;
                for (Node itemNode : splitPane.getItems()) {
                    System.out.print(tab + "+ " + itemNode.getClass());
                    System.out.println(", ID: " + itemNode.idProperty().get());

                    if (itemNode instanceof Parent) {
                        getStruct((Parent) itemNode, tab);
                    }
                }
            } else if (node instanceof Accordion) {
                Accordion accordion = (Accordion) node;
                for (TitledPane titledPane : accordion.getPanes()) {
                    System.out.print(tab + "+ " + titledPane.getClass());
                    System.out.println(", ID: " + titledPane.idProperty().get());

                    getStruct(titledPane, tab);
                }
            } else if (node instanceof Parent) {
                getStruct((Parent) node, tab);
            }
        }
    }

    public static Scene getScene() {
        return scene;
    }
}
