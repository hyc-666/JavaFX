package JavaFX_29;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_29 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Accordion accordion = new Accordion();//把所有的TitledPane放到一起

//        AnchorPane an = new AnchorPane();
        TitledPane titledPane = new TitledPane("titledpane",new Button("button1"));
        TitledPane titledPane1 = new TitledPane();
        TitledPane titledPane2 = new TitledPane();
        titledPane2.setText("titledPane2");
        //这个东西最好不要设置宽高

        titledPane1.setText("titledpane1");
        //这个上面也可以加载结点或者其他布局类
        titledPane1.setContent(new Button("button2"));//设置结点
        //也有设置图片的方法

//        titledPane.setAnimated(false);//关闭舒展的动画
//        titledPane1.setCollapsible(false);//折叠禁用
//        titledPane.setExpanded(true);//设置默认张开或者折叠
        titledPane2.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);//箭头方向


//        an.getChildren().addAll(titledPane,titledPane1);
//        AnchorPane.setTopAnchor(titledPane1,200.0);
        //也可以设置展开和折叠的监听器
        accordion.getPanes().addAll(titledPane,titledPane1,titledPane2);
        accordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue, TitledPane newValue) {
                //注意，这里折叠的时候会有可能报空指针异常,要进行处理
                if (newValue == null) {
                    System.out.println(oldValue.getText() + "折叠");
                    return;
                }
                System.out.println(newValue.getText() + "展开");
            }
        });


        Scene scene = new Scene(accordion);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        //监听折叠和展开
        titledPane.expandedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });
    }
}
