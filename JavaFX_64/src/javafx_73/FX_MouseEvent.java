package javafx_73;
/**
 * @author hyc
 * @date 2020/5/1
 */
//鼠标事件
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FX_MouseEvent extends Application {

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

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                System.out.println("eventSource = " + event.getSource());//获得事件源

                /**
                 * 这里 getTarget 获得的是一个 EventTarget，这是一个接口
                 * 而 button 和 Text 都实现了这个接口，
                 * 输出的时候就会输出各自实现的一个 toString 方法
                 */
//                System.out.println("eventTarget = " + event.getTarget());//获得事件目标
                /**
                 * 当鼠标直接点击 button 的时候，事件源与事件目标基本是一致的
                 * 当 button 上有文本的时候，鼠标放在文本上点击
                 * 此时的事件目标就会发生变化，事件目标变为 button 上的文本
                 * 而这个事件目标会输出文本的相关信息，包括字体，位置，坐标等
                 */

                //说实话这个设计有点鸡肋
//                System.out.println("eventType = " + event.getEventType());//获得事件类型

//                System.out.println("mouseButton = " + event.getButton());//判断是那个键
                /**
                 * 鼠标上也有好几个键的，这个处理只是监听了鼠标的按键，
                 * 无论按下鼠标的哪个键都会触发这个鼠标按键事件
                 * 具体按下哪个键以及之后的动作还要具体细分
                 */
                //判断在鼠标单击事件的同时是否按下其他键
                //比如Ctrl，Alt，Shift等
//                System.out.println("isCtrlDown = " + event.isControlDown());

                System.out.println("clickedCount = " + event.getClickCount());//统计点击次数
                //这个动作每点击一次就会触发一次，统计是累加上去的，并不是连续点击好几次才会输出点击次数
                //而是点一次输出一次，点两次输出两次，只不过第一次输出是1，第二次输出是2
                //而不是直接输出一次2
                //有时候有一些功能可以设计双击或者三击等

            }
        });

        //可以检测鼠标是否在button的范围之内,不需要点击就可以触发
        button1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouseEnter");
            }
        });
        button1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouseExit");
            }
        });

        //还有鼠标移动事件
        //只要鼠标在button的范围内移动就会触发
        button2.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouseMove");
            }
        });
    }
}
