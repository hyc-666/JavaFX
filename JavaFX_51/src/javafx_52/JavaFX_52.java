package javafx_52;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.text.resources.fi.CollationData_fi;

public class JavaFX_52 extends Application {
    public static void main(String[] args) {
        ;launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        SimpleIntegerProperty simpleIntegerProperty = new SimpleIntegerProperty(10);
        simpleIntegerProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                System.out.println("oldValue = " + oldValue);
//                System.out.println("newValue = " + newValue);
            }
        });
        simpleIntegerProperty.set(20);

        Data data = new Data("Tom",18);
        data.nameProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("oldValue = " + oldValue);
                System.out.println("newValue = " + newValue);
            }
        });

        Button button = new Button("修改数据");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (data.getName().equals("Tom")) {
                    data.setName("Jerry");
                }else{
                    data.setName("Tom");
                }
            }
        });

        anchorPane.getChildren().addAll(button);


        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx_52");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }
}
