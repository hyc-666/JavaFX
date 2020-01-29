package JavaFX_10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFX_10 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("button");
        button.setLayoutX(50);
        button.setLayoutY(50);
        button.setPrefWidth(200);
        button.setPrefHeight(120);
        button.setFont(Font.font(30));

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("这是按钮单击事件");
            }
        });

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getButton().name());//鼠标按键的单击
                //主键的双击，注意最后的.不能丢弃
                if(event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())){
                    System.out.println("通过鼠标单击次数来确定多击事件");
                }
            }
        });
        //按键事件
        button.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("按下：" + event.getCode().getName());//按下某个按键
                if(event.getCode().getName().equals(KeyCode.S.getName())){//按键过滤
                    System.out.println("你按下了S键");
                }
            }
        });

        button.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("释放：" + event.getCode().getName());//释放按键
            }
        });

        primaryStage.setTitle("这是窗口标题");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);

        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
