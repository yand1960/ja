package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button btn1;

    //private String caption = "Click me!!!!!!";
    private final ObjectProperty<String> caption
                    = new SimpleObjectProperty<>("Click me");

    public ObjectProperty<String> captionProperty() {
        return caption;
    }

    public void btn1_click(ActionEvent e) {
        System.out.println("Clicked!");
        //btn1.setText("Hello");
        setCaption("hello!");
    }

    public final String getCaption() {
        return captionProperty().get();
    }

    public final void setCaption(String caption) {
        captionProperty().set(caption);
    }

//    public String getCaption() {
//        return caption;
//    }
//
//    public void setCaption(String caption) {
//        this.caption = caption;
//    }
}

//Сделайте калькулятор сообразно предложенному прототипу UI