package javafx_51;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class JavaFX_51 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);

        Student s1 = new Student("student1",18);

        HBox hBox = new HBox(50);
        Button setName = new Button("修改名称");
        Button setAge = new Button("修改年龄");
        hBox.getChildren().addAll(setName,setAge);
        anchorPane.getChildren().addAll(hBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx_51");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        setName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                s1.setName("s1");
            }
        });
        setAge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                s1.setAge(20);
            }
        });

        //给Student s1设置监听
        s1.pcs.addPropertyChangeListener(new PropertyChangeListener() {
            //感觉上这个监听比较笼统，不能具体区分是那个值改变
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("oldValue = " + evt.getOldValue());
                System.out.println("newValue = " + evt.getNewValue());
            }
        });

        //这个监听就比较更精确
        s1.pcs.addPropertyChangeListener("name_changed", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("name oldValue = " + evt.getOldValue());
                System.out.println("name newValue = " + evt.getNewValue());
            }
        });
        s1.pcs.addPropertyChangeListener("age_changed", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("age oldValue = " + evt.getOldValue());
                System.out.println("age newValue = " + evt.getNewValue());
            }
        });
    }
}
