package JavaFX_15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX_15 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    static boolean isManaged = false;
    static boolean isVisible = false;
    static double opacity = 0;

    @Override
    public void start(Stage primaryStage) {

        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");

        Button b5 = new Button("b3.setManaged");
        Button b6 = new Button("b3.setVisible");
        Button b7 = new Button("b3.setOpacity");

        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);

        AnchorPane anchorPane = new AnchorPane();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(b1,b2,b3,b4);
        anchorPane.getChildren().addAll(hBox);
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(30));
        anchorPane.setStyle("-fx-background-color:green");

        b3.setOnAction(new EventHandler<ActionEvent>() {//好像这个单击事件没有起作用
            @Override
            public void handle(ActionEvent event) {
                System.out.println("这是b3的单击事件");
            }
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(b5,b6,b7);
        anchorPane.getChildren().addAll(vBox);
        vBox.setPadding(new Insets(100));
        vBox.setSpacing(30);

        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isManaged){
                    b5.setText("b3.setManaged(" + isManaged + ")");
                    isManaged = false;
                    b3.setManaged(isManaged);
                }
                else{
                    b5.setText("b3.setManaged(" + isManaged + ")");
                    isManaged = true;
                    b3.setManaged(isManaged);
                }
            }
        });

        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isVisible){
                    b6.setText("b3.setVisible(" + isVisible + ")");

                    b3.setVisible(isVisible);
                    isVisible = false;
                }
                else {
                    b6.setText("b3.setVisible(" + isVisible + ")");

                    b3.setVisible(isVisible);
                    isVisible = true;

                }
            }
        });
        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(opacity > 0){
                    b7.setText("b3.setOpacity(" + opacity + ")");

                    b3.setOpacity(opacity);
                    opacity = 0;
                }
                else {
                    b7.setText("b3.setOpacity(" + opacity + ")");
                    b3.setOpacity(opacity);
                    opacity = 1;


                }
            }
        });

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
