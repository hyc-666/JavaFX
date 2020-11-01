package javafx_76;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 鼠标单击事件Event.fireEvent()
 * @author hyc
 * @date 2020/11/1
 */
public class Mouse_Event extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(800);
        primaryStage.setWidth(1000);
        primaryStage.show();
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        HBox hBox = new HBox();
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        hBox.getChildren().addAll(button1,button2);
        hBox.setSpacing(20.0);
        anchorPane.getChildren().addAll(hBox);

        AnchorPane.setLeftAnchor(hBox,100.0);
        AnchorPane.setRightAnchor(hBox,100.0);
        AnchorPane.setTopAnchor(hBox,100.0);

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getEventType());//获得时间类型
                Event.fireEvent(button2,event);//在button1的单击事件里面调用这个方法
                //可以用来触发button2的单击事件,并且事件类型和参数event的参数类型一致才能起作用
                //这里参数button2是没有什么局限性的,使用EventTarget接口的子类均可
                //而大部分Node均实现了EventTarget接口
            }
        });

        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("button2");
                System.out.println(event.getEventType());
            }
        });
    }
}
