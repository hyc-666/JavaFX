package JavaFX_36_ChoiceBox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_36_ChoiceBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

        ChoiceBox<String> cb = new ChoiceBox<>();//下拉列表
        cb.getItems().addAll("str1","str2","str3");
        an.getChildren().addAll(cb);
        cb.setValue("str2");//设置默认选中

        AnchorPane.setLeftAnchor(cb,50.0);
        AnchorPane.setTopAnchor(cb,100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("JavaFX_36");
        primaryStage.show();
//        显示或者隐藏
//        cb.show();
//        cb.hide();

        //选择模型监听（选中状态监听）
        cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //可以在这里监听选中状态做一些其他操作
                System.out.println(newValue);
            }
        });
    }
}
