package JavaFX_12;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class JavaFX_12 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);

        Group group = new Group();
        Scene scene = new Scene(group);

        TextField textField = new TextField();//输入文本框
        textField.setLayoutX(100);
        textField.setLayoutY(100);
        textField.setPrefHeight(50);
        textField.setPrefWidth(200);
        textField.setFont(Font.font(20));//调整文本框字体大小和样式

        Tooltip tooltip = new Tooltip();
        tooltip.setText("这是文本框的输入提示");
        textField.setTooltip(tooltip);

//        textField.setText("这是文本框");
        textField.setPromptText("最多输入7个字符");
        textField.setFocusTraversable(false);

        //输入框的文本监听
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.length() > 7){
                    textField.setText(oldValue);
                }
            }
        });

        //输入框的选择的文本监听
        textField.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });
        //密码输入框
        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(200);
        passwordField.setLayoutY(200);
        passwordField.setFocusTraversable(false);
        passwordField.setPromptText("密码长度小于16");//灰字提示
        passwordField.setPrefWidth(400);
        Tooltip tooltip1 = new Tooltip();
        tooltip1.setText("此处输入密码");
        passwordField.setTooltip(tooltip1);
        //密码框的输入也可以监听
        passwordField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.length() > 16){
                    passwordField.setText(oldValue);
                }
                System.out.println(newValue);
            }
        });

        Label label = new Label();
        label.setText("这是一个标签");
        label.setLayoutX(300);
        label.setLayoutY(300);

        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("这是文本框的单击事件");//输入文本后按回车触发
            }
        });
        //那么密码确认也可使使用密码框的单击事件
        passwordField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("这是密码框的单击事件");//可以用于确认密码的输入
            }
        });

        //也可以设置鼠标的单击事件
        textField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("这是鼠标点击文本框的单击事件");
            }
        });
        //Lable没有setONAction的单击事件
        //所以标签可以设置成鼠标的点击事件
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //同样这里可以过滤鼠标的按键
                //只有左键单击有效

                if(event.getButton().name() == MouseButton.PRIMARY.name()){
                    System.out.println("这是鼠标左键单击标签的单击事件");
                }
            }
        });
        label.setTextFill(Paint.valueOf("red"));//设置标签文本填充颜色
        //这里red可以直接读取

        group.getChildren().add(textField);
        group.getChildren().add(passwordField);
        group.getChildren().add(label);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
