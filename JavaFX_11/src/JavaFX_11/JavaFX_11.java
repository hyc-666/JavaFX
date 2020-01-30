package JavaFX_11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.stage.Stage;


public class JavaFX_11 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("button");
        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);
        button.setLayoutX(80);
        button.setLayoutY(80);
        button.setPrefHeight(100);
        button.setPrefWidth(150);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("这是按键单击事件");
                //可以把按键种的代码写成一个方法在run方法中调用
            }
        });
        //设置快捷键
        KeyCodeCombination kc1 = new KeyCodeCombination(KeyCode.K, KeyCombination.ALT_DOWN,KeyCodeCombination.CONTROL_DOWN);
        Mnemonic mnemonic = new Mnemonic(button,kc1);//把按键和按钮关联
        scene.addMnemonic(mnemonic);//放入场景

        //方法2
        KeyCodeCombination kc2 = new KeyCodeCombination(KeyCode.Y,KeyCombination.ALT_DOWN,KeyCodeCombination.CONTROL_DOWN);
        scene.getAccelerators().put(kc2, new Runnable() {
            @Override
            public void run() {
                System.out.println("run方法");
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setX(80);
        primaryStage.setY(80);
        primaryStage.setHeight(500);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
