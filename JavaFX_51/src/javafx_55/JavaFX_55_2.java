package javafx_55;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class JavaFX_55_2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);

        HBox hBox = new HBox(100.0);
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        //现在有两个输入框，我们在一个输入框中输入，另一个输入框的内容跟着变化
        anchorPane.getChildren().addAll(hBox);
        AnchorPane.setTopAnchor(hBox,100.0);

        hBox.getChildren().addAll(textField1,textField2);

        primaryStage.setTitle("javafx_55");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setScene(scene);
        primaryStage.show();

        //方法一：使用监听器
//        textField1.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                textField2.setText(newValue);
//            }
//        });
//        textField2.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                textField1.setText(newValue);
//            }
//        });

        //方法二：现在使用双向绑定来完成
//        textField1.textProperty().bindBidirectional(textField2.textProperty());//一行完成
        //如果设置单向绑定则textField1是无法输入进去内容的，只有textField2改变textField1才会跟着改变
//        textField1.textProperty().bind(textField2.textProperty());
        //还有一个更骚气的操作
        textField1.textProperty().bindBidirectional(textField2.textProperty(), new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                String str = "";
                if (string.contains("5")){
                    str =  string.replace("5","我");
                }
                if (string.contains("2")){
                    str =  string.replace("2","爱");
                }
                if (string.contains("0")){
                    str =  string.replace("0","你");
                }
                return str;
            }
        });

    }
}
