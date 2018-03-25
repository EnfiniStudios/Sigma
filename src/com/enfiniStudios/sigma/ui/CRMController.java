package com.enfiniStudios.sigma.ui;

/**
 *
 * @author "Enfini Studios"
 */

import com.jfoenix.controls.JFXProgressBar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class CRMController implements Initializable {
    @FXML
    private JFXProgressBar loadBar;    
    

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        loadBar.setPrefWidth(width);
        
    }
    
    @FXML
    void exitbtn(MouseEvent event) {
        exit();

    }


  
}
