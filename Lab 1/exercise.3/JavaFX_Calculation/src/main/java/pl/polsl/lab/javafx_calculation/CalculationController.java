/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lab.javafx_calculation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Gall Anonim
 */
public class CalculationController implements Initializable {


    @FXML
    private Button buttonCalculate;
    @FXML
    private TextField textFieldA;
    @FXML
    private TextField textFieldB;
    @FXML
    private Label labelResult;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void makeCalculation(ActionEvent event) {
        int a = Integer.parseInt(textFieldA.getText());
        int b = Integer.parseInt(textFieldB.getText());        
        int result = a+b;
        labelResult.setText(""+result);
    }

}
