package JavaFX_40;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class JavaFX_40 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("str1","str2","str3");

        AnchorPane.setLeftAnchor(comboBox,50.0);
        AnchorPane.setTopAnchor(comboBox,100.0);
        an.getChildren().addAll(comboBox);

        comboBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return null;
            }
        });

        comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                MyListCell<String> listCell = new MyListCell<String>();

                return listCell;
            }
        });

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class MyListCell<T> extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(empty == false) {
            System.out.println("item = " + item + "    empty = " + empty);
            HBox hBox1 = new HBox(10);
            hBox1.setAlignment(Pos.CENTER);
            hBox1.setStyle("-fx-background-color:green");

            hBox1.setMaxHeight(150);
            hBox1.setMaxWidth(150);
            hBox1.getChildren().addAll(new Button(item),new Button(item));

            this.setAlignment(Pos.CENTER);
            this.setContentDisplay(ContentDisplay.CENTER);
            this.setStyle("-fx-background-color:yellow");
            this.setGraphic(hBox1);


        }
    }
}