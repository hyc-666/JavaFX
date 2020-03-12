package JavaFX_49;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX_49_ScrollBar extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();


        ScrollBar scrollBar = new ScrollBar();//一个滚动条
        scrollBar.setPrefWidth(20);
        scrollBar.setPrefHeight(400);
        scrollBar.setOrientation(Orientation.VERTICAL);//设置方向，默认水平
        VBox vBox = new VBox(10);
        for (int i = 0; i < 10; i++) {
            vBox.getChildren().add(new Button("button" + i));
        }
        //实际这个滚动条并不具备滚动的效果，
        // 而是通过监听器来设置需要与其相关的布局或者组件的布局位置来达到滚动的效果
        scrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                vBox.setLayoutY(-newValue.doubleValue());//这里也可以设置负数来向上滚动
                System.out.println(newValue.doubleValue());
            }
        });


        an.getChildren().addAll(scrollBar,vBox);
        AnchorPane.setLeftAnchor(scrollBar,100.0);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("javafx49");
        primaryStage.show();

        //scrollBar的高度默认从0到100，可以通过设置来更改
        scrollBar.setPrefHeight(vBox.getHeight());
        scrollBar.setMax(vBox.getHeight());

        scrollBar.setUnitIncrement(10);//设置每次滚动值
        scrollBar.setBlockIncrement(10);//点击滚动条空白区域的步进值

        Button button = new Button("下拉");
        Button button1 = new Button("上拉");

        an.getChildren().addAll(button,button1);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scrollBar.increment();//前进
//                scrollBar.setValue(20);//通过每次更新当前值也可以达到类似效果
                //但是有更方便的方法直接调用
            }
        });

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scrollBar.decrement();//后退
            }
        });

        AnchorPane.setTopAnchor(button,100.0);
        AnchorPane.setLeftAnchor(button,300.0);
        AnchorPane.setTopAnchor(button1,200.0);
        AnchorPane.setLeftAnchor(button1,300.0);
    }
}
