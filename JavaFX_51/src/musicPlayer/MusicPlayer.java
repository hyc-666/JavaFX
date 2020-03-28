package musicPlayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;

public class MusicPlayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Media media = new Media("file:/D:/Git/time.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        AnchorPane anchorPane = new AnchorPane();

        Button button = new Button("play");

        anchorPane.getChildren().addAll(button);

        AnchorPane.setTopAnchor(button,100.0);
        AnchorPane.setLeftAnchor(button,50.0);

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer.play();
            }
        });
    }
}
