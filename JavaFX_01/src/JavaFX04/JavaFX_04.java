package JavaFX04;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JavaFX_04 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(500);
        primaryStage.setWidth(800);

        //primaryStage.setAlwaysOnTop(true);//设置窗口置顶
        //primaryStage.setOpacity(0.5);//窗口透明度

        primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("窗口X坐标位置："+ newValue);
            }
        });
        primaryStage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("窗口Y坐标位置：" + newValue);
            }
        });


        primaryStage.show();
    }
}
