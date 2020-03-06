package JavaFX_47_SplitPane;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFX_47_SplitPane extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();


        SplitPane splitPane = new SplitPane();//一个界面的分屏
        //其上要放置其他布局类，单纯的结点组件放上去是无效的
        splitPane.setPrefWidth(800);

//        splitPane.setPrefHeight(800);
//        splitPane.setOrientation(Orientation.VERTICAL);//设置方向，默认水平
        //另外：设置方向以后宽度或者高度一定要够，不然不够拖拽

        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().addAll(new Button("button1"));

        StackPane stackPane2 = new StackPane();
        stackPane2.getChildren().addAll(new Button("button2"));

        StackPane stackPane3 = new StackPane();
        stackPane3.getChildren().addAll(new Button("button3"));

        StackPane stackPane4 = new StackPane();
        stackPane4.getChildren().addAll(new Button("button4"));

        splitPane.getItems().addAll(stackPane1,stackPane2,stackPane3,stackPane4);
        an.getChildren().addAll(splitPane);

        //还可以给其上的布局设置最大最小宽度和高度来限制拖拽范围
        stackPane1.setMinWidth(100);
        stackPane2.setMinWidth(100);
        stackPane3.setMinWidth(100);
        stackPane4.setMinWidth(100);

        //设置组件占比
        splitPane.setDividerPosition(0,0.25);
        splitPane.setDividerPosition(1,0.5);
        splitPane.setDividerPosition(2,0.75);
        splitPane.setDividerPosition(3,1.0);

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
