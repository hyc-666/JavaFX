package JavaFX_49;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX_49_ScrollPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

        VBox box = new VBox();

        VBox vBox = new VBox(10);
        for (int i = 0; i < 10; i++) {
            vBox.getChildren().add(new Button("button" + i));
        }
        HBox hBox = new HBox(10);
        for (int i = 0; i < 10; i++) {
            hBox.getChildren().add(new Button("button" + i));
        }

        ScrollPane scrollPane = new ScrollPane();//一个滚动面板，构造方法里可以直接放结点进去
        scrollPane.setContent(box);//也可以通过set方法放进去，但是只能放一个结点进去
        //把hbox和vbox放到一个vbox上然后再放到滚动面板上
        box.getChildren().addAll(hBox,vBox);
        //当宽度/高度不够显示所有的组件的时候才会有滚动效果


        scrollPane.setPrefWidth(300);
        scrollPane.setPrefHeight(200);

        an.getChildren().add(scrollPane);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("javafx49");
        primaryStage.show();

        //水平的值监听
        scrollPane.hvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });
        //垂直的值监听
        scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });
    }
}
