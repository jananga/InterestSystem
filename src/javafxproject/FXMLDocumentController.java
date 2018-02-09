/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxproject;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author rpa29
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lable1;
    @FXML
    private Label lable2;
    @FXML
    private JFXButton btncustomer;
    @FXML
    private JFXDatePicker date;
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void customermansgehandlebtn(ActionEvent event) {
    }
    
}
