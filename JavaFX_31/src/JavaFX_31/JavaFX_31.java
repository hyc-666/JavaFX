package JavaFX_31;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFX_31 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        RadioButton rb1 = new RadioButton("rb1");
        RadioButton rb2 = new RadioButton("rb2");
        RadioButton rb3 = new RadioButton("rb3");
        RadioButton rb4 = new RadioButton("rb4");

        //单选一般放在一个组里，这个组不会影响布局
        ToggleGroup tg = new ToggleGroup();
        //然后指定组
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        rb4.setToggleGroup(tg);

        //可以设置默认选择
        rb2.setSelected(true);

        AnchorPane an = new AnchorPane();
        Scene scene = new Scene(an);

        an.setStyle("-fx-background-color:#ffffff");

        HBox hBox = new HBox(10);//创建时直接指定间距
        hBox.getChildren().addAll(rb1,rb2,rb3,rb4);
        an.getChildren().addAll(hBox);
//        hBox.setSpacing(20.0);
        AnchorPane.setLeftAnchor(hBox,200.0);
        AnchorPane.setTopAnchor(hBox,100.0);

        primaryStage.setTitle("这是标题");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setScene(scene);
        primaryStage.show();

        //设置水平布局宽度跟随失败
        an.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                hBox.setPrefWidth(newValue.doubleValue());
            }
        });
        //可能水平布局宽度比较死脑筋吧，不会跟随窗口变化
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                an.setPrefWidth(newValue.doubleValue());
            }
        });
        //监听选中状态
        rb1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }
        });
        //组可以监听成员的选中状态
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton rb = (RadioButton)newValue;
                System.out.println(rb.getText());
            }
        });
    }
}
