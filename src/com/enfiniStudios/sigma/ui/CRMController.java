package com.enfiniStudios.sigma.ui;

/**
 *
 * @author "Enfini Studios"
 */

import com.jfoenix.controls.JFXProgressBar;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.MouseEvent;
import static javafx.application.Platform.exit;
import javafx.scene.layout.GridPane;

public class CRMController implements Initializable {
    @FXML
    private JFXProgressBar loadBar;    
    
//   @FXML
//    private JFXListView<String> contentList;
//    @FXML
//    private JFXButton backButton;
//    @FXML
//    private JFXScrollPane scroll;
//    
//    @FXML
//    private GridPane navBar;

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        loadBar.setPrefWidth(width);
        
        
//         for (int i = 0; i < 100; i++) {
//            contentList.getItems().add("Item " + i);
//        }
//        contentList.setMaxHeight(3400);
//
//        JFXScrollPane.smoothScrolling((ScrollPane) scroll.getChildren().get(0));
        
//        navBar.prefWidthProperty().bind(scroll.getBottomBar().widthProperty());
//        navBar.prefHeightProperty().bind(scroll.getBottomBar().heightProperty());
    }
    
    @FXML
    void exitbtn(MouseEvent event) {
        exit();

    }


  
}
