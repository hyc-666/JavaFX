package JavaFX_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFX_16 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        AnchorPane anchorPane1 = new AnchorPane();

        AnchorPane anchorPane2 = new AnchorPane();
        AnchorPane anchorPane3 = new AnchorPane();
        AnchorPane anchorPane4 = new AnchorPane();
        AnchorPane anchorPane5 = new AnchorPane();

        anchorPane1.setStyle("-fx-background-color:red");
        anchorPane2.setStyle("-fx-background-color:green");
        anchorPane3.setStyle("-fx-background-color:yellow");
        anchorPane4.setStyle("-fx-background-color:blue");
        anchorPane5.setStyle("-fx-background-color:purple");

        anchorPane1.setPrefHeight(100);
        anchorPane1.setPrefWidth(100);
        anchorPane2.setPrefHeight(100);
        anchorPane2.setPrefWidth(100);
        anchorPane3.setPrefHeight(100);
        anchorPane3.setPrefWidth(100);
        anchorPane4.setPrefHeight(100);
        anchorPane4.setPrefWidth(100);
        anchorPane5.setPrefHeight(100);
        anchorPane5.setPrefWidth(100);

        BorderPane borderPane = new BorderPane();//方位布局
        borderPane.setStyle("-fx-background-color:pink");
        //周围没有组件时别的组件会挤占这个空间
        borderPane.setBottom(anchorPane1);
        borderPane.setCenter(anchorPane2);
        borderPane.setLeft(anchorPane3);
        borderPane.setRight(anchorPane4);
        borderPane.setTop(anchorPane5);

        borderPane.setPadding(new Insets(30));//内边距
        BorderPane.setMargin(anchorPane1,new Insets(20));//给子组件设置外边距



        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
