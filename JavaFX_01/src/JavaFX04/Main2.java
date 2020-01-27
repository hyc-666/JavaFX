package JavaFX04;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("s1");

        Stage s2 = new Stage();
        s2.setTitle("s2");
        s2.initOwner(s1);//给s2设置属主，使s1与s2相关联
        s2.initModality(Modality.WINDOW_MODAL);//只能先操作s2,再能操作s1

        Stage s3 = new Stage();
        s3.initModality(Modality.APPLICATION_MODAL);//单窗口模态化
        s3.setTitle("s3");

        s1.show();
        s2.show();
        s3.show();
    }
}
