package JavaFX_05;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class JavaFX_05_1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start线程："+Thread.currentThread());
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("run线程："+ Thread.currentThread());
            }
        });
    }
}
