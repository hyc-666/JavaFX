package JavaFX_33;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.function.UnaryOperator;

public class JavaFX_33 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();
        VBox vBox = new VBox(20);
        TextField textField = new TextField();
        TextArea textArea = new TextArea();
        vBox.getChildren().addAll(textField,textArea);
        an.getChildren().addAll(vBox);

        textField.setTextFormatter(new TextFormatter<Object>(new UnaryOperator<TextFormatter.Change>() {
            //UnaryOperator过滤器
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {//传进来的是文本的文本信息
                System.out.println(change.getText());//文本改变信息
                String value = change.getText();
                if(value.matches("[a-z]")){//保留字符a-z，过滤其他的
                    return change;
                }
                if(value.matches("[0-9]")){
                    //保留数组，限制用户输入
                }
                return null;//再原样返回
            }
        }));

        textArea.setText("hello world");
        textArea.setFocusTraversable(true);

        //不知道为什么，这段代码会抛异常，说是空指针异常，所以空指针在哪里？
        textArea.setTextFormatter(new TextFormatter<String>(new StringConverter<String>() {
            @Override
            public String fromString(String string) {
                //这个语句在关闭时执行，这里的String是文本框最后保留的文本
                System.out.println("str=" + string);
                return null;
            }
            @Override
            public String toString(String object) {
                //虽然这个文本框我已经预设过文本，但是传进来的仍然是一个空指针
                if(object == null){
                    //原来的文本会被下面的返回值覆盖
                    return "这个空指针我已经处理了";
                }
                System.out.println("obj=" + object);

                return null;
            }
        }));
        textArea.commitValue();

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        Button button = new Button("关闭窗口");
        an.getChildren().addAll(button);
        AnchorPane.setBottomAnchor(button,20.0);
        AnchorPane.setRightAnchor(button,20.0);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               if (event.getButton().name().equals(MouseButton.PRIMARY.name())){
                   System.out.println("鼠标左键单击关闭");
                   primaryStage.close();
               }
            }
        });
        //关于多行文本的替换直接弄个文文本监听器不就行了？
//        textArea.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                if(newValue.contains("5")){
//                    String value = newValue.replace("5","我");
//                    //原来是用错了，这个replace是有返回值的，并不直接是原来的字符串，不能这样写
//                    //newValue.replace("5","我");//这样写没有效果
//                    System.out.println(value);
//                    textArea.setText(value);
//                }
//            }
//        });
    }
}
