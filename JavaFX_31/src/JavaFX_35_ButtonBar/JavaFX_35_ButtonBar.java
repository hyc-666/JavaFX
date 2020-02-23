package JavaFX_35_ButtonBar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_35_ButtonBar extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

        ButtonBar buttonBar = new ButtonBar();
        Button button = new Button("button");
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");

        ButtonBar.setButtonData(button, ButtonBar.ButtonData.APPLY);
        ButtonBar.setButtonData(button1, ButtonBar.ButtonData.FINISH);
        ButtonBar.setButtonData(button2, ButtonBar.ButtonData.NO);

        button.setPrefWidth(80.0);//其他组件会统一尺寸
//        ButtonBar.setButtonUniformSize(button1,false);//不统一尺寸

        buttonBar.getButtons().addAll(button,button1,button2);

        an.getChildren().add(buttonBar);
        buttonBar.setButtonOrder(ButtonBar.BUTTON_ORDER_NONE);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
