package JavaFX_34;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.function.Consumer;


public class JavaFX_34 extends Application {
    int end = 0;
    String subStr = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        AnchorPane an = new AnchorPane();

        TextField find_tf = new TextField();
        Button find_bu = new Button("搜索");
        Button sort_bu = new Button("排序");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(find_tf,find_bu,sort_bu);
        hBox.setAlignment(Pos.CENTER);

        TextArea find_ta = new TextArea();
        find_ta.setText("i like you and l love you");
        find_ta.setWrapText(true);//自动换行

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox,find_ta);



        an.getChildren().addAll(vBox);
        AnchorPane.setTopAnchor(vBox,10.0);
        AnchorPane.setLeftAnchor(vBox,10.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        find_bu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //获得段落，一个可观察的字符序列，不可改变
                find_ta.getParagraphs().forEach(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence charSequence) {
                        String find_value = find_tf.getText();
                        String value = charSequence.toString();
                        subStr = value.substring(end);
                        //拿到两个文本框里的文本做匹配
                        if(subStr.contains(find_value)){//如果匹配到
                            find_ta.requestFocus();//获得焦点
                            int start = subStr.indexOf(find_value);//确定开始选中位置
                            int temp = start + end;
                            end = temp + find_value.length();//确定结束位置
                            find_ta.selectRange(temp,end);//选中匹配到的内容
                        }else{
                            //如果到末尾查询不到就重新从开始查询，把end置0
                            end = 0;
                        }
                    }
                });
            }
        });
        sort_bu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                char[] arr = find_ta.getText().toCharArray();
                Arrays.sort(arr);
                find_ta.setText(new String(arr));
            }
        });
    }
}
