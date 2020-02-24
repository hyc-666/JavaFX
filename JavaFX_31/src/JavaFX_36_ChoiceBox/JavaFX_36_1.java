package JavaFX_36_ChoiceBox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Comparator;

public class JavaFX_36_1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();

        ObservableList<String> list1 = FXCollections.observableArrayList();
        list1.addAll("数字","字母");

        ObservableList<String> list2 = FXCollections.observableArrayList();
        //因为下边要转，所以直接写成字符串类型吧
        list2.addAll("1","2","3","4","5","6","7");

        ObservableList<String> list3 = FXCollections.observableArrayList();
        list3.addAll("a","b","c","d","e","f","g");

        ChoiceBox<String> cb1 = new ChoiceBox<>();//下拉列表
        cb1.getItems().addAll(list1);
        ChoiceBox<String> cb2 = new ChoiceBox<>();


        an.getChildren().addAll(cb1,cb2);

        AnchorPane.setLeftAnchor(cb1,50.0);
        AnchorPane.setTopAnchor(cb1,100.0);
        AnchorPane.setLeftAnchor(cb2,200.0);
        AnchorPane.setTopAnchor(cb2,100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("JavaFX_36");
        primaryStage.show();

        cb1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.equals(list1.get(0))){
                    //还要把数字类型转为字符串类型的
                    cb2.setItems(list2);
                    cb2.show();
                }else if(newValue.equals(list1.get(1))){
                    cb2.setItems((list3));
                    cb2.show();
                }
            }
        });

        Button button = new Button("排序");
        //鼠标单击排序
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                list2.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        //倒序的排序
                        return Integer.parseInt(o2) - Integer.parseInt(o1);
                    }
                });
                cb2.show();
            }
        });
        an.getChildren().addAll(button);
    }
}
