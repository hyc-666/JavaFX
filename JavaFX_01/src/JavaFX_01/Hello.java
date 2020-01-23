package JavaFX_01;

import javafx.application.Application;
import javafx.stage.Stage;

public class Hello extends Application{
    public static void main(String[] args) {
        System.out.println("hello word");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world");//设置标题

        primaryStage.show();//让窗口显示出来
        primaryStage.setMaxWidth(800);//设置最大宽度
        primaryStage.setMaxHeight(800);//设置最大高度

        primaryStage.setMinWidth(300);//设置窗口最小宽度
        primaryStage.setMinHeight(300);//设置窗口最小高度

        primaryStage.setWidth(500);//设置默认宽度
        primaryStage.setHeight(500);//设置默认的高度

        primaryStage.setFullScreen(true);//全屏
        //primaryStage.setIconified(true);//最小化
    }
}
