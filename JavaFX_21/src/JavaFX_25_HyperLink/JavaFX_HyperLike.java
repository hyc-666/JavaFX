package JavaFX_25_HyperLink;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX_HyperLike extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox box = new VBox();
        Hyperlink link = new Hyperlink("www.baidu.com");
        //提供一个可点击的超链接的文本标签，并不会打开一个网页
        //具体打开网页的操作还要后续处理

        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HostServices host = JavaFX_HyperLike.this.getHostServices();
                host.showDocument(link.getText());
            }
        });
        box.getChildren().add(link);
        link.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
