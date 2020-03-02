package JavaFX_43ColorPicker_DatePicker;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class JavaFX_43_DatePicker extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane an = new AnchorPane();

        DatePicker dataPicker = new DatePicker(LocalDate.now());
        //日期选择器
        dataPicker.setEditable(false);//不可编辑，只能选中
//        dataPicker.setPrefWidth(400);
        an.getChildren().addAll(dataPicker);

        dataPicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                int year = newValue.getYear();
                int month = newValue.getMonthValue();
                int day = newValue.getDayOfMonth();
                int week = newValue.getDayOfWeek().getValue();
                int day_ = newValue.getDayOfYear();
                System.out.println(year + "年" + month + "月" + day + "日 " + "星期" + week);
                System.out.println(year + "年的第" + day_ + "天");

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
