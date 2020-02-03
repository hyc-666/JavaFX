package JavaFX_19;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class JavaFX_19 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /*
        * 所有组件一层一层的盖在上面
        * 最后添加的盖在最上面
        * */
        StackPane stackPane = new StackPane();//叠加布局

        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Button b5 = new Button("button5");
        Button b6 = new Button("button6");
        Button b7 = new Button("button7");
        Button b8 = new Button("button8");

        stackPane.getChildren().addAll(b1,b2,b3,b4,b5);//默认是居中的位置
        //方法与其他布局类差不多
        stackPane.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node node) {

            }
        });

        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);

        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
