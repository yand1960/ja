package sample;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {

    private String greeting = "Click me!!!!";
    private ObjectProperty<String> greeting2;

    @FXML
    private Button btn1;

    public void doIt(ActionEvent e) {
        //btn1.setText("Hello!");
        greeting = "Hello!";
        greeting2().set("Hello!");
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
        greeting2().set(greeting);
    }

    public ObjectProperty<String> greeting2() {
        return greeting2;
    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
}
