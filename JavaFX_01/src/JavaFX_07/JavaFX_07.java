package JavaFX_07;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;

public class JavaFX_07 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        //打开一个网页
        HostServices hostServices = getHostServices();
        hostServices.showDocument("www.qq.com");


        URL url = getClass().getClassLoader().getResource("JavaFX04/icon.png");//导入图片
        String path = url.toExternalForm();

        primaryStage.setTitle("javafx");

        Button button = new Button("点击这里");
        button.setPrefHeight(100);
        button.setPrefWidth(200);
        button.setCursor(Cursor.MOVE);//设置光标形状

        Group group = new Group();//添加桌面布局文件
        group.getChildren().add(button);

        Scene scene = new Scene(group);
//        scene.setCursor(Cursor.HAND);//设置光标图形
        scene.setCursor(Cursor.cursor(path));//把光标形状设置位指定图片样式
        primaryStage.setScene(scene);
        primaryStage.setHeight(500);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
