package JavaFX_14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX_14 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        Button b6 = new Button("b6");
        primaryStage.getIcons().add(new Image("JavaFX_14/icon.png"));

        AnchorPane ap1 = new AnchorPane();
//        AnchorPane ap2 = new AnchorPane();
//        ap1.getChildren().add(b1);
//        ap2.getChildren().add(b2);

        Scene scene = new Scene(ap1);
        primaryStage.setScene(scene);
//        ap1.getChildren().addAll(ap2);

        HBox hBox = new HBox();//水平布局
        hBox.getChildren().addAll(b1,b2,b3);
        hBox.setPadding(new Insets(10));//边距
        hBox.setSpacing(10);//控件间距
        hBox.setAlignment(Pos.TOP_CENTER);//设置居中

        VBox vBox = new VBox();//垂直布局
        vBox.getChildren().addAll(b4,b5,b6);
        vBox.setSpacing(20);


        ap1.getChildren().add(hBox);
        ap1.getChildren().add(vBox);

        hBox.setPrefHeight(400);
        hBox.setPrefWidth(400);
        hBox.setStyle("-fx-background-color:blue");

        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);
        primaryStage.show();

        //这里会固定宽高
//        ap2.setPrefHeight(200);
//        ap2.setPrefWidth(200);

        ap1.setStyle("-fx-background-color:red");
//        ap2.setStyle("-fx-background-color:blue");
    }
}
