package JavaFX04;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.nio.file.StandardWatchEventKinds;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("s1");
        s1.initStyle(StageStyle.DECORATED);//默认的窗口模式
        s1.show();

//        Stage s2 = new Stage();
//        s2.setTitle("s2");
//        s2.initStyle(StageStyle.TRANSPARENT);//透明窗口
//        s2.show();
//
//        Stage s3 = new Stage();
//        s3.setTitle("s3");
//        s3.initStyle(StageStyle.UNDECORATED);//白色背景不带装饰（其实也是看不见的）
//        s3.show();

//        Stage s4 = new Stage();
//        s4.setTitle("s4");
//        s4.initStyle(StageStyle.UNIFIED);//好像跟第一个没有什么区别
//        s4.show();
//
//        Stage s5 = new Stage();
//        s5.setTitle("s5");
//        s5.initStyle(StageStyle.UTILITY);//只有关闭按钮，相当于一个对话框
//        s5.show();
//
//        Platform.exit();//可以关闭全部窗口
    }
}
