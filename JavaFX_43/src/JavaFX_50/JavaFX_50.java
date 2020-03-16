package JavaFX_50;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFX_50 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

        HBox hBox = new HBox();
        Button bUtton = new Button("button");
        //有些组件不给其设置宽高的时候其父组件会给其设置宽高
        //父组件是指其放置在那个Node上
        //但是又的组件不给其设置宽高的时候它的默认宽高会是0，也就是显示不出来
        //比如一些2D图形
        Rectangle rectangle = new Rectangle();

        hBox.getChildren().addAll(bUtton,rectangle);

        System.out.println(hBox.getChildren().size());//可以看到，这个hBox上其实是有2个node
        //但是其中一个2D图形却是显示不出来
        //必须给其设置宽高才能显示出来
        rectangle.setWidth(150);
        rectangle.setHeight(100);

        an.getChildren().addAll(hBox);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("javafx50");
        primaryStage.show();
    }
}
