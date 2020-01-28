package JavaFX_05;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class JavaFX_05_2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Platform.setImplicitExit(false);//关闭窗口后仍然再后台运行

        primaryStage.show();

        Platform.exit();//调用此方法关闭虚拟机
    }
}
