package JavaFX_43ColorPicker_DatePicker;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFX_43_ColorPicker extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();
        //颜色选择器
        ColorPicker colorPicker = new ColorPicker();
        an.getChildren().addAll(colorPicker);

        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("单击事件");
            }
        });

        colorPicker.valueProperty().addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                //颜色分量

                System.out.println("red = " + newValue.getRed());
                System.out.println("green = " + newValue.getGreen());
                System.out.println("blue = "+ newValue.getBlue());

                System.out.println("new Value = " + newValue.toString());
                String value = newValue.toString().substring(2);
                //颜色代码，前两位表示十六进制，后两位表示透明度
                an.setStyle("-fx-background-color:#" + value);
            }
        });

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX_43");
        primaryStage.show();


    }
}
