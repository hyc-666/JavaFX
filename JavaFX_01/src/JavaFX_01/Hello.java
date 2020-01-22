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
        primaryStage.setTitle("Hello world");
        primaryStage.show();
    }
}
