package javafx_74;
//鼠标拖拽事件
/**
 * @author hyc
 * @date 2020/5/2
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FX_MouseDrag extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        HBox hBox = new HBox(40);
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        hBox.getChildren().addAll(button1,button2);
        hBox.setAlignment(Pos.CENTER);

        AnchorPane.setLeftAnchor(hBox,200.0);
        AnchorPane.setTopAnchor(hBox,200.0);
        anchorPane.getChildren().addAll(hBox);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        button1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            /**
             * 绑定鼠标拖拽事件，
             * 因为绑定在button1上，效果为鼠标指针要在button范围之内，
             * 按下鼠标左键进行拖拽即可触发事件，只要这个动作发生，即使此时将鼠标移出组件
             * 只要保持左键不释放，这个事件就会一致持续，知道释放鼠标左键
             * @param event 鼠标事件
             */
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouseDragged");
            }
        });
        //之前还要检测是否发生拖动事件
        button2.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //之后还有给一个完成的一套拖拽动作
                button2.startFullDrag();
                System.out.println("DragDetected");
                //这个动作执行一次
            }
        });

        button2.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                //说实话不清楚这两个拖拽事件有什么不一样，而且这个还很麻烦，这届这样写是什么效果都没有的
                //必须在这之前还要准备另外一些代码
                System.out.println("MouseDragEvent");
                //只在鼠标指针在组件区域内才有用，区别大概在这里吧
            }
        });
    }
}
