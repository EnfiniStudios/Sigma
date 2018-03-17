package com.enfiniStudios.sigma.ui;

/**
 *
 * @author "Enfini Studios"
 */


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class TaskBarController implements Initializable{
    SimpleStringProperty currentWindow = new SimpleStringProperty("workspace");
    BorderPane workspace, mail, crm;
    private PseudoClass inWorkspace,inMail,inCrm;
    

    
    @FXML
    private HBox primaryElements,secondaryElements;
    
    @FXML
    private BorderPane taskbar;
    
    @FXML
    private JFXButton workspacebtn;

    @FXML
    private JFXButton crmbtn;

    @FXML
    private JFXButton mailbtn;
    
    private final Tooltip crmTip = new Tooltip();
    private final Tooltip wrkTip = new Tooltip();
    private final Tooltip mailTip = new Tooltip();
    private final Tooltip contactsTip = new Tooltip();
 
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inWorkspace = PseudoClass.getPseudoClass("inWorkSpace");
        inMail = PseudoClass.getPseudoClass("inMail");
        inCrm = PseudoClass.getPseudoClass("inCrm");
        try {
            workspace = (BorderPane) FXMLLoader.load(getClass().getResource("/fxml/Workspace.fxml"));
            mail = FXMLLoader.load(getClass().getResource("/fxml/mail.fxml"));
            crm = FXMLLoader.load(getClass().getResource("/fxml/crm.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(TaskBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        taskbar.pseudoClassStateChanged(inWorkspace,isInWorkspace());

        
        currentWindow.addListener(e -> taskbar.pseudoClassStateChanged(inWorkspace, isInWorkspace()));
        currentWindow.addListener(e -> taskbar.pseudoClassStateChanged(inMail, isInCrm()));
        currentWindow.addListener(e -> taskbar.pseudoClassStateChanged(inCrm, isInMail()));
        

       
        
        wrkTip.setText("Opens Workspace Window");
        Tooltip.install(workspacebtn, wrkTip);
        
        crmTip.setText("Opens CRM Window");
        Tooltip.install(crmbtn, crmTip);
        
        mailTip.setText("Opens Mail Window");
        Tooltip.install(mailbtn, mailTip);
        
        contactsTip.setText("Pinned Contacts");
        Tooltip.install(secondaryElements, contactsTip);
        
        

    }
    
    private boolean isInWorkspace(){
        if(currentWindow.getValue().equals("workspace")){
            return true;
        }
        else{
            return false;
        }
        
    }
    private boolean isInCrm(){
        if(currentWindow.getValue().equals("crm")){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isInMail(){
        if(currentWindow.getValue().equals("mail")){
            return true;
        }else{
        return false;
        }
    }
    
    
    @FXML
    void switchCrm(MouseEvent event) {
        Scene scene = crmbtn.getScene();
        BorderPane pane = (BorderPane) scene.lookup("#space");
        pane.setCenter(crm);
        currentWindow.setValue("crm");
        taskbar.pseudoClassStateChanged(inMail,isInCrm());

    }

    @FXML
    void switchMail(MouseEvent event) {
        Scene scene = mailbtn.getScene();
        BorderPane pane = (BorderPane) scene.lookup("#space");
        pane.setCenter(mail);
        currentWindow.setValue("mail");
        taskbar.pseudoClassStateChanged(inCrm,isInMail());


    }

    @FXML
    void switchSpace(MouseEvent event) {
        Scene scene = workspacebtn.getScene();
        BorderPane pane = (BorderPane) scene.lookup("#space");
        pane.setCenter(workspace);
        currentWindow.setValue("workspace");
        taskbar.pseudoClassStateChanged(inWorkspace,isInWorkspace());
        
        

    }
   

}
