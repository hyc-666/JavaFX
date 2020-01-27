package JavaFX04;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class JavaFX_03 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX04");
        primaryStage.getIcons().add(new Image("/JavaFX04/icon.png"));//设置图标
        //相对路径是相对工程目录

        //primaryStage.setIconified(true);//设置最小化
        //primaryStage.setMaximized(true);//设置最大化

        primaryStage.setHeight(800);//设置初始窗口高度
        primaryStage.setWidth(800);//设置初始窗口宽度

//        primaryStage.setMinHeight(1000);//设置最大高度
//        primaryStage.setMinHeight(300);//设置最小高度
//        primaryStage.setMaxWidth(1200);//最大宽度
//        primaryStage.setMinWidth(300);//最小宽度

        //primaryStage.setResizable(false);//设置宽口不可变，默认是true

//        primaryStage.getWidth();//获得宽度
//        primaryStage.getHeight();//获得高度
//        System.out.println("宽度：" + primaryStage.getWidth());
//        System.out.println("高度："+ primaryStage.getHeight());

        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                //动态监听窗口宽度
                System.out.println("当前宽度："+ newValue.doubleValue());
            }
        });
        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                //动态监听窗口高度
                System.out.println("当前高度："+ newValue.doubleValue());
            }
        });

        primaryStage.setFullScreen(true);//设置全屏
        primaryStage.setScene(new Scene(new Group()));

        primaryStage.show();

    }
}
