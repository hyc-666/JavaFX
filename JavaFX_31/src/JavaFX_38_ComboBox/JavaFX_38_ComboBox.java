package JavaFX_38_ComboBox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class JavaFX_38_ComboBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();
        Button button = new Button("button");

        ComboBox<String> cbb = new ComboBox<>();
        //也是一个下拉列表基本用法与ChoiceBox相同
        //不过这个框框是允许编辑的
        cbb.setEditable(true);//用来干什么？
        cbb.setPromptText("这是提示信息");

        cbb.getItems().addAll("str1","str2","str3","str4","str5");
        //另外也可以指定item为其他的对象类

        an.getChildren().addAll(cbb,button);
        AnchorPane.setLeftAnchor(cbb,50.0);
        AnchorPane.setTopAnchor(cbb,100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("JavaFX_37");
        primaryStage.show();

        cbb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("选中状态监听");
            }
        });
        cbb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("单击事件");
            }
        });

        cbb.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return null;
            }

            @Override
            public String fromString(String string) {
                //其实上边如果设置为可编辑，那么编辑的文本就会传到这个地方来
                return null;
            }
        });
    }
}
