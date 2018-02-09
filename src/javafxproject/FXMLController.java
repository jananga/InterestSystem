/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxproject;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author rpa29
 */
public class FXMLController implements Initializable {

    @FXML
    private JFXButton btnCustomerManagement;
    @FXML
    private JFXButton btnInterestManagement;
    @FXML
    private JFXButton btnDailyInterest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCustomerManagement(ActionEvent event) {
    }

    @FXML
    private void btnInterestManagement(ActionEvent event) {
    }

    @FXML
    private void btnDailyInterest(ActionEvent event) {
    }
    
}
