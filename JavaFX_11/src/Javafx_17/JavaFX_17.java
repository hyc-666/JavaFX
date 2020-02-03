package Javafx_17;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class JavaFX_17 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//        Button button = new Button("b1");
        Button button1 = new Button("b1");
        Button button2 = new Button("b2");
        Button button3 = new Button("b3");
        Button button4 = new Button("b4");
        Button button5 = new Button("b5");
        Button button6 = new Button("b6");
        Button button7 = new Button("b7");
        Button button8 = new Button("b8");

        FlowPane flowPane = new FlowPane();//流布局
        flowPane.getChildren().addAll(button1,button2,button3,button4,button5,button6,button7,button8);
        flowPane.setStyle("-fx-background-color:pink");
        flowPane.setPadding(new Insets(30));//设置内边距
        flowPane.setHgap(20);//设置水平间距
        flowPane.setVgap(20);//设置垂直间距
        FlowPane.setMargin(button4,new Insets(10));//设置外边距
        flowPane.setAlignment(Pos.CENTER);//设置居中
        flowPane.setOrientation(Orientation.VERTICAL);//设置默认布局方向

        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);

        Scene scene = new Scene(flowPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
