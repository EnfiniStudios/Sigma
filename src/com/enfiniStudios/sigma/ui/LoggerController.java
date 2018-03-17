package com.enfiniStudios.sigma.ui;

/**
 *
 * @author "Enfini Studios"
 */

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class LoggerController implements Initializable{
    private double xOffset;
    private double yOffset;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

    }

    @FXML
    private JFXButton btnlogin;

    @FXML
    void exitButton(MouseEvent event) {
        exit();
    }

    @FXML
    void loginInitiate(MouseEvent event) {
        btnlogin.getScene().getWindow().hide();
        try {
            Stage wspaceStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneHandler.fxml"));
            wspaceStage.initStyle(StageStyle.TRANSPARENT);
            wspaceStage.setMaximized(true);

            Scene scene = new Scene(root);
            wspaceStage.setScene(scene);
            wspaceStage.show();
        }
        catch (IOException e){
            System.out.println("SceneHandler not Loaded...");
            e.printStackTrace();
        }
    }
}
