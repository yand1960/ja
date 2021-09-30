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

    //Способ получить ссылку на компоненты страницы
    @FXML
    private Button btn1;

    //Альтернативный способ - связывание в духе MVVM
    // Но при этом observable свойства пишутся по-другому,
    // чем в класических бобах. Т.е. не так:
    //private String caption = "Click me!!!!!!";

    //а вот так:
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