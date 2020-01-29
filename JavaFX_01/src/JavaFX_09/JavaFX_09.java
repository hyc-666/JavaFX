package JavaFX_09;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class JavaFX_09 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("button");
        button.setLayoutX(50);
        button.setLayoutY(50);
        button.setPrefWidth(200);
        button.setPrefHeight(120);

        button.setFont(Font.font(30));//设置按钮标题字号
        //button.setFont(Font.font("KaiTi"));
        button.setTextFill(Paint.valueOf("#8B475D"));//填充字体颜色

        //设置按钮背景填充，参数分别是颜色，角部弧度，按钮距离边框的距离
        BackgroundFill bkg2 = new BackgroundFill(Paint.valueOf("#00F5FF"),new CornerRadii(30),new Insets(2));
        //设置按钮背景
        Background bk1 = new Background(bkg2);
        button.setBackground(bk1);

        BorderStroke borderStroke = new BorderStroke(Paint.valueOf("#EE2C2C"), BorderStrokeStyle.DASHED,new CornerRadii(20),new BorderWidths(5));
        Border border = new Border(borderStroke);
        button.setBorder(border);
        //另外，按钮的背景属性也可以通过官方的CSS

//        button.setStyle(
//                "-fx-background-color:#EE2C2C;"+   //设置背景颜色
//                        "-fx-background-radius:20;"+  //设置角部弧度
//                        "-fx-text-fill:#00F5FF" //设置文本填充颜色
//        );

        button.setOnAction(new EventHandler<ActionEvent>() {//按钮单击事件
            @Override
            public void handle(ActionEvent event) {
                System.out.println("这是单击事件的响应");
            }
        });


        primaryStage.setTitle("这是窗口标题");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);

        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
