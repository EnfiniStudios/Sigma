/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enfiniStudios.sigma.ui;

import com.jfoenix.controls.JFXSnackbar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author "Enfini Studios"
 */
public class SceneController implements Initializable  {
    @FXML
     private StackPane parent;
    
    BorderPane workspace, mail, crm;
   
    
    @FXML
    private BorderPane space = new BorderPane();
    
    private BorderPane bar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        JFXSnackbar notification = new JFXSnackbar(parent);
//        notification
        
        try {
            workspace = (BorderPane) FXMLLoader.load(getClass().getResource("/fxml/Workspace.fxml"));
            space.setCenter(workspace);
        } catch (IOException ex) {
            Logger.getLogger(TaskBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            bar = fxmlLoader.load(getClass().getResource("/fxml/TaskBar.fxml"));
            
            space.setBottom(bar);
            
        }catch (IOException e){
            System.out.println("TaskBar Not Loaded");
            e.printStackTrace();
        }
        
    } 

}
