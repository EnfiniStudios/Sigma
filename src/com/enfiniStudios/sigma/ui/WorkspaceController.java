package com.enfiniStudios.sigma.ui;

import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.awt.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;
import javafx.scene.control.ProgressBar;

public class WorkspaceController implements Initializable {
    @FXML
    private BorderPane spaceParent;

    @FXML
    private JFXButton notificationPops;

    @FXML
    private ImageView workspace;

    @FXML
    private ImageView crmbtn;
    
    @FXML
    private ImageView mail;

    @FXML
    private AnchorPane overlayPane;

    @FXML
    private javafx.scene.control.Label hrlabel;

    @FXML
    private javafx.scene.control.Label minlabel;

    @FXML
    private javafx.scene.control.Label setNotation;

    @FXML
    private javafx.scene.control.Label datelabel;

    @FXML
    private StackPane workspaceContainer;
    
    @FXML
    private JFXProgressBar loader;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setFull(spaceParent,true);
        setFull(overlayPane, false);
        loader.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        notificationPops.setText("10");



//        Clock Updation Handler

        LocalDateTime clock = LocalDateTime.now();
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        actionEvent -> {
                            minlabel.setText(String.format("%02d",clock.getMinute()));
                            String date = String.format("%s | %02d %s %d",clock.getDayOfWeek(),
                                    clock.getDayOfMonth(),clock.getMonth(),clock.getYear());

                            datelabel.setText(date);

                            if (clock.getHour() > 12) {
                                hrlabel.setText(String.format("%02d",clock.getHour() - 12));
                                setNotation.setText("PM");
                            }
                            else {
                                hrlabel.setText(String.format("%02d",clock.getHour()));
                                setNotation.setText("AM");
                            }
                        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void setFull(Pane pane, boolean bothLengths){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        if(bothLengths) {
            pane.setPrefWidth(width);
            pane.setPrefHeight(height);
        }
        else {
            pane.setPrefWidth(width);
        }



    }

    @FXML
    void exitbtn(MouseEvent event) {
        exit();

    }

}
