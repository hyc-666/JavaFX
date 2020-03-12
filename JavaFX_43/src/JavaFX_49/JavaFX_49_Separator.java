package JavaFX_49;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFX_49_Separator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

        HBox hBox = new HBox();
        Button button = new Button("button1");
        Button button1 = new Button("button2");

        Separator separator = new Separator();//分割线
        separator.setOrientation(Orientation.VERTICAL);//让它竖起来
        separator.setPrefWidth(100);
        separator.setHalignment(HPos.CENTER);//位置， 默认就是居中
        //垂直和水平的位置只能生效一个


        hBox.getChildren().addAll(button,separator,button1);


        an.getChildren().addAll(hBox);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("javafx49");
        primaryStage.show();
    }
}
