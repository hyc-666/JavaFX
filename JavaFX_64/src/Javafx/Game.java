package Javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author hyc
 * @date 2020/9/3
 */
public class Game extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox(5);
        Text text = new Text("输入你猜的数字");
        TextField textField = new TextField("在此输入猜的数字");
        vBox.getChildren().addAll(text,textField);
        AnchorPane anchorPane = new AnchorPane();

        AnchorPane.setTopAnchor(vBox,100.0);
        AnchorPane.setLeftAnchor(vBox,100.0);

        anchorPane.getChildren().add(vBox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);

        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
