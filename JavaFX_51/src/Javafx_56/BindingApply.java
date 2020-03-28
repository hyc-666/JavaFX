package Javafx_56;
//绑定计算的简单使用

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BindingApply extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        Button button = new Button("button");
        TextField textField = new TextField();
        button.setPrefWidth(200);
        button.setPrefHeight(200);

        anchorPane.getChildren().addAll(button,textField);
//        AnchorPane.setLeftAnchor(textField,200.0);

        primaryStage.show();

        SimpleIntegerProperty x = new SimpleIntegerProperty(2);
        DoubleBinding doubleBinding_w = anchorPane.widthProperty().divide(x);
        DoubleBinding doubleBinding_h = anchorPane.heightProperty().divide(x);
        button.prefWidthProperty().bind(doubleBinding_w);
        button.prefHeightProperty().bind(doubleBinding_h);


        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try{
                    int value = Integer.parseInt(newValue);
                    x.set(value);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
//                int value = Integer.parseInt(newValue);
//                x.set(value);
            }
        });

    }
}
