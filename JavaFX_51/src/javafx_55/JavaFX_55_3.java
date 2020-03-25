package javafx_55;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFX_55_3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);

        Button button = new Button("button");
        Slider slider = new Slider(0,500,0);
        slider.setPrefWidth(500);
        anchorPane.getChildren().addAll(button,slider);
        AnchorPane.setTopAnchor(slider,100.0);
        //让button的x坐标随着拖动条的拖动位置变化

        primaryStage.setTitle("javafx_55");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setScene(scene);
        primaryStage.show();

        //同样的，使用监听可以完成
//        slider.valueProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                button.setTranslateX(newValue.doubleValue());
//            }
//        });
        //现在使用单向绑定完成
        button.translateXProperty().bind(slider.valueProperty());//一行搞定
        //这里不能用layoutX
    }
}
