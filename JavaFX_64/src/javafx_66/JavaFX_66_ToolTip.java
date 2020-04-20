package javafx_66;
//提示框的使用
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class JavaFX_66_ToolTip extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();

        Button button = new Button("button");
        anchorPane.getChildren().addAll(button);
        AnchorPane.setTopAnchor(button,50.0);
        AnchorPane.setLeftAnchor(button,50.0);

        Tooltip tooltip = new Tooltip("这是提示框的提示信息");
        button.setTooltip(tooltip);
        tooltip.setWrapText(true);
        tooltip.setFont(new Font("#3366ff",12));
        tooltip.setStyle("-fx-background-color:pink");
        tooltip.setOpacity(0.8);//透明度，参数范围是0~1，


        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("javafx");
        primaryStage.show();
    }
}
