package JavaFX_13;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_13_1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("b1");
        Button b2 = new Button("b2");

        AnchorPane ap1 = new AnchorPane();
        AnchorPane ap2 = new AnchorPane();
        ap1.getChildren().add(b1);
        ap2.getChildren().add(b2);

        Scene scene = new Scene(ap1);
        primaryStage.setScene(scene);
        ap1.getChildren().addAll(ap2);

        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);
        primaryStage.show();

        ap1.setStyle("-fx-background-color:red");
        ap2.setStyle("-fx-background-color:blue");
        AnchorPane.setTopAnchor(ap2,0.0);
        AnchorPane.setLeftAnchor(ap2,0.0);

        AnchorPane.setBottomAnchor(b1,50.0);

        AnchorPane.setBottomAnchor(ap2,ap1.getHeight() / 2);
        AnchorPane.setRightAnchor(ap2,ap1.getWidth() / 2);
        AnchorPane.setBottomAnchor(b2,0.0);
        AnchorPane.setRightAnchor(b2,0.0);

        b1.setManaged(false);//组件解放，失去管理
        b1.setVisible(true);//按键是否可见
        b1.setOpacity(0.5);//组件透明度

        //设置监听器来绑定布局类之间的相对宽高
        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                AnchorPane.setBottomAnchor(ap2,ap1.getHeight() / 2);
            }
        });

        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                AnchorPane.setRightAnchor(ap2,ap1.getWidth() / 2);
            }
        });
    }
}
