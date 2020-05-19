package javafx_75;
//单击事件
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 * @author hyc
 * @date 2020/5/19
 */
public class JavaFX_75_Event extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        HBox hBox = new HBox(30);
        hBox.setStyle("-fx-background-color:#ffff55");
        Button button = new Button("button1");
        Button button2 = new Button("button2");
        Circle circle = new Circle(100);
        hBox.getChildren().addAll(button,button2,circle);
        circle.setFill(Paint.valueOf("green"));

        anchorPane.getChildren().add(hBox);
        AnchorPane.setLeftAnchor(hBox,100.0);
        AnchorPane.setTopAnchor(hBox,100.0);

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("circle.setOnMouseClicked");
            }
        });
        /**
         * 在 hBox 的布局上绑定了鼠标单击事件，而 circle 是hBox的子组件，
         * circle 上也有鼠标单击事件，可以看到，在 circle 上触发单击事件的时候，
         * 在 hBox 上也会同时触发单击事件，这里有一个事件的传递
         */
        hBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("hBox.mouseClicked");
            }
        });
    }
}
