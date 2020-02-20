package JavaFX_32_TexaArea;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFX_32_TextArea extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

        an.setStyle("-fx-background-color:#3366ff");
        TextArea textArea = new TextArea();
        //多行文本，永福基本与单行文本类似
        an.getChildren().addAll(textArea);
        textArea.setText("hello word");
        textArea.setFont(Font.font(20));
//        textArea.setWrapText(true);//自动换行
        //设置初始行列
//        textArea.setPrefRowCount(4);
//        textArea.setPrefColumnCount(4);
        //设置宽高等,设置宽高会覆盖行列使其失效
        textArea.setPrefWidth(400);
        textArea.setPrefHeight(200);
        textArea.appendText("dasd");//追加文本
        textArea.deleteText(0,6);//指定删除位置
        textArea.insertText(2,"453");//指定插入位置
        textArea.replaceText(0,2,"dasuid");//替换
        textArea.selectAll();//全选
        textArea.selectPositionCaret(6);//从开始选中到指定位置
        textArea.selectRange(3,9);//指定开始和结束选中位置
        textArea.home();//光标回到最开始
//        textArea.setEditable(false);//设置是否可以被编辑
//        textArea.clear();//清除
//        //或者
//        textArea.setText("");



        Scene scene = new Scene(an);
        primaryStage.setTitle("这是标题");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setScene(scene);
        primaryStage.show();

        //监听文本
        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.length() > 10){
                    textArea.setText(oldValue);
                }
            }
        });
        //选中状态监听
        textArea.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });
        //左右滚动监听
        textArea.scrollLeftProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });
        //上下滚动监听
        textArea.scrollTopProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });
    }
}
