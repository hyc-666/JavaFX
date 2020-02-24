package JavaFX_36_ChoiceBox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class JavaFX_36 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Student s1 = new Student("A",18,90);
        Student s2 = new Student("B",12,100);
        Student s3 = new Student("C",40,50);
        Student s4 = new Student("D",20,60);
        Student s5 = new Student("E",70,250);

        AnchorPane an = new AnchorPane();

        ChoiceBox<Student> cb = new ChoiceBox<>();//下拉列表
        //通过重写Student的toString的方式可以显示信息
        cb.getItems().addAll(s1,s2,s3,s4,s5);
        an.getChildren().addAll(cb);

        //信息转化
        cb.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                //在这里转化也可以
                //虽然Student类里又重写的toString方法，但是这里获取以后再修改返回，
                //实际显示结果以这里写的为准
                String value = object.getName() + " - " + object.getAge() + " - " + object.getScore();
                return value;
            }

            //这个方法必须要重写和实现，但是用不到，闲置
            @Override
            public Student fromString(String string) {
                return null;
            }
        });

        AnchorPane.setLeftAnchor(cb,50.0);
        AnchorPane.setTopAnchor(cb,100.0);

        //单击事件
        cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                System.out.println(newValue.toString());
            }
        });

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("JavaFX_36");
        primaryStage.show();
    }
}
