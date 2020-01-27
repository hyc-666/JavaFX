package JavaFX04;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class JavaFX_04 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage){
        Stage s1 = new Stage();
        s1.setTitle("s1");

        Stage s2 = new Stage();
        s2.setTitle("s2");
        s2.initOwner(s1);//s1与s2关联
        s2.initModality(Modality.WINDOW_MODAL);//只能先操作s2

        Stage s3 = new Stage();
        s3.setTitle("s3");

        s1.show();
        s2.show();
        s3.show();
    }
}
