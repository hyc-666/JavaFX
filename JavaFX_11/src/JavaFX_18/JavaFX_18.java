package JavaFX_18;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFX_18 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        Button button4 = new Button("button4");
        Button button5 = new Button("button5");
        Button button6 = new Button("button6");
        Button button7 = new Button("button7");
        Button button8 = new Button("button8");

        GridPane gridPane = new GridPane();//网格布局
        gridPane.setStyle("-fx-background-color:pink");
        gridPane.add(button1,0,0);
        gridPane.add(button2,0,1);
        gridPane.add(button3,0,2);
        gridPane.add(button4,0,3);
        gridPane.add(button5,1,0);
        gridPane.add(button6,1,1);
        gridPane.add(button7,1,2);
        gridPane.add(button8,1,3);

        gridPane.setHgap(20);//设置水平间距
        gridPane.setVgap(20);//垂直间距
        gridPane.setAlignment(Pos.CENTER);//设置居中
        gridPane.setPadding(new Insets(20));//内边距


        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
