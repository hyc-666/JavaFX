package JavaFX_31;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFX_31_CheckBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();
        Scene scene = new Scene(an);

        //多选状态，用法基本与单选一致
        CheckBox cb1 = new CheckBox("cb1");
        CheckBox cb2 = new CheckBox("cb2");
        CheckBox cb3 = new CheckBox("cb3");
        CheckBox cb4 = new CheckBox("cb4");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(cb1,cb2,cb3,cb4);
        an.getChildren().addAll(hBox);
        //可以设置默认选中
        cb2.setSelected(true);
        //值得注意的是这个多选有不确定状态
        cb3.setIndeterminate(true);
        //可以三种状态切换
        cb3.setAllowIndeterminate(true);
        //设置监听器可以监听选中状态
        cb4.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }
        });

        AnchorPane.setLeftAnchor(hBox,200.0);
        AnchorPane.setTopAnchor(hBox,100.0);

        primaryStage.setTitle("这是标题");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setScene(scene);
        primaryStage.show();
        //设置鼠标单击事件
        an.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //for-each不能用于Object
            }
        });
    }
}
