package JavaFX_40;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFX_40_Label extends Application {
//标签的妙用
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

//        Label label = new Label();
//        //label可以作为一个容器组织其他结点
//        label.setPrefWidth(200);
//        label.setPrefHeight(200);
//        HBox hBox = new HBox();
//        label.setGraphic(hBox);
//        hBox.setMaxHeight(150);
//        hBox.setMaxWidth(150);
//
//        hBox.setAlignment(Pos.CENTER);
//        label.setStyle("-fx-background-color:pink");
//        hBox.setStyle("-fx-background-color:blue");
//        Button button = new Button("bu1");
//        Button button1 = new Button("bu2");
//        hBox.getChildren().addAll(button,button1);
//
//        AnchorPane.setLeftAnchor(label,100.0);
//        AnchorPane.setTopAnchor(label,100.0);

        //使用ListCell有相同效果
        //但是不知道为什么会有异常，且不能运行
        ListCell<String> listCell = new ListCell<>();
        listCell.setPrefWidth(200);
        listCell.setPrefHeight(200);
        HBox hBox1 = new HBox();
        listCell.setGraphic(hBox1);
        hBox1.setMaxHeight(150);
        hBox1.setMaxWidth(150);

        listCell.setAlignment(Pos.CENTER);
        listCell.setContentDisplay(ContentDisplay.CENTER);
        listCell.setStyle("-fx-background-color:yellow");
        hBox1.setStyle("-fx-background-color:green");
        Button button2 = new Button("bu1");
        Button button3 = new Button("bu2");
        hBox1.getChildren().addAll(button2,button3);

        AnchorPane.setLeftAnchor(listCell,300.0);
        AnchorPane.setTopAnchor(listCell,100.0);

        an.getChildren().addAll(listCell);



        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
