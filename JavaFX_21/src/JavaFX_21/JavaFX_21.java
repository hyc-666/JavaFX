package JavaFX_21;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class JavaFX_21 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Button b5 = new Button("button5");
        Button b6 = new Button("button6");
        Button b7 = new Button("button7");
        Button b8 = new Button("button8");


        TilePane tilePane = new TilePane();//叫什么瓦片布局
        //类似前面的流式布局
        //只不过改变某个结点属性后其他结点会跟着一起中心对齐
        tilePane.setPadding(new Insets(20));//内边距
        tilePane.setStyle("-fx-background-color:#3366FF");
        AnchorPane.setBottomAnchor(b1,20.0);
        //行距和列间距
        tilePane.setVgap(10);
        tilePane.setHgap(10);

        tilePane.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8);

        Scene scene = new Scene(tilePane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
