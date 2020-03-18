package JavaFX_50;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_50_3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();

        Button button = new Button("button");


        anchorPane.getChildren().addAll(button);
        AnchorPane.setTopAnchor(button,100.0);
        AnchorPane.setLeftAnchor(button,100.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("javafx_50_3");
        primaryStage.setScene(scene);
        primaryStage.show();

        button.setEffect(new DropShadow());//增加阴影
        button.setRotate(45);

        System.out.println(button.getLayoutBounds());//获得button本身的边界
        System.out.println(button.getBoundsInLocal());//获得button加了效果以后的边界
        System.out.println(button.getBoundsInParent());//获得加了所有效果的边界（比如加旋转）
    }
}
