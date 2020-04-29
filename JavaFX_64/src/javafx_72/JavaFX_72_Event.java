package javafx_72;
//事件（键盘按键检测事件）
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFX_72_Event extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        HBox hBox = new HBox(40);
        Button button = new Button("按键事件");
        Button button1 = new Button("button1");
        TextField textField = new TextField();
        hBox.getChildren().addAll(button,button1,textField);

        //这种给button绑定按键事件的时候必须焦点在这个button上，否则不生效
        button.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCharacter());//这个方法在这里调用基本是无效的
                System.out.println("事件类型 = " + event.getEventType());
                System.out.println("事件源 = " + event.getSource());
                System.out.println("时间目标 = " + event.getTarget());
                System.out.println("键值 = " + event.getCode());//就是会检查到底按下了哪个键
                System.out.println("文本 = " + event.getText());//实际输入的内容，区分大小写
            }
        });
        button.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //按键释放处理
            }
        });

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCharacter());//这时候这个方法就有用了
                //它能够监听输入的字符内容，当然只会打印能输进输入框的内容
                //输入法会影响监听的，上面的也是
            }
        });

        anchorPane.getChildren().addAll(hBox);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
