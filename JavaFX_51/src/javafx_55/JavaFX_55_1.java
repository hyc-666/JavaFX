package javafx_55;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_55_1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.show();

        Button button = new Button("button");
        //让button随着窗口的大小改变而动态的随之增大变小
        an.getChildren().add(button);

        //理论上可以通过监听根节点的宽度来达到button宽度随着根节点宽度的变化而变化

//        an.prefWidthProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                System.out.println(newValue.doubleValue());
//            }
//        });
//
//        //两个监听的区别
//        an.widthProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
////                System.out.println(newValue.doubleValue());
//                button.setPrefWidth(newValue.doubleValue() / 5);
//            }
//
//        });

        //现在使用单向绑定来完成button的宽度跟随根节点的宽度变化
        button.prefWidthProperty().bind(an.widthProperty());//一行搞定
    }
}
