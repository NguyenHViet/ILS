/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *
 * @author vuvuive
 */
public class LoadingScreen {

    @FXML
    private ProgressBar loadingBar;
    @FXML
    private Label loadingContent;
    @FXML
    private Label loadingProgress;

    private double loadedContent;

    private double neededContent;

    private double progressValue;

    /**
     * Get the value of progressValue
     *
     * @return the value of progressValue
     */
    public double getProgressValue() {
        return progressValue;
    }

    /**
     * Set the value of progressValue
     *
     * @param progressValue new value of progressValue
     */
    public void setProgressValue(double progressValue) {
        this.progressValue = progressValue;
        setLoadingBarValue(this.progressValue);
    }

    /**
     * Get the value of neededContent
     *
     * @return the value of neededContent
     */
    public double getNeededContent() {
        return neededContent;
    }

    /**
     * Set the value of neededContent
     *
     * @param neededContent new value of neededContent
     */
    public void setNeededContent(double neededContent) {
        this.neededContent = neededContent;
        setLoadingProgress(String.format("%.2f%%", progressValue));
    }

    /**
     * Get the value of loadedContent
     *
     * @return the value of loadedContent
     */
    public double getLoadedContent() {
        return loadedContent;
    }

    /**
     * Set the value of loadedContent
     *
     * @param loadedContent new value of loadedContent
     */
    public void setLoadedContent(double loadedContent) {
        this.loadedContent = loadedContent;
        setProgressValue(this.loadedContent / this.neededContent);
        setLoadingProgress(String.format("%.2f%%", progressValue));
    }

    public void addNeededContent(double neededContent) {
        this.neededContent += neededContent;
        setLoadingProgress(String.format("%.2f%%", progressValue));
    }
    
    public void addLoadedContent(double loadedContent) {
        this.loadedContent += loadedContent;
        setProgressValue(this.loadedContent / this.neededContent);
        setLoadingProgress(String.format("%.2f%%", progressValue * 100));
    }

    public void initialize() {
//        loadingBar.progressProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> obs, Number oldval, Number newVal) {
//                if (newVal.doubleValue() >= 1.0) {
//                    UI.loadComplete();
//                }
//            }
//        });
    }

    public void setLoadingContent(String str) {
        loadingContent.textProperty().setValue(str);
    }

    public void setLoadingProgress(String str) {
        loadingProgress.textProperty().setValue(str);
    }

    public void setLoadingBarValue(double val) {
        loadingBar.setProgress(val);
    }
}
