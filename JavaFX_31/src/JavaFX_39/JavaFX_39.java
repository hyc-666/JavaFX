package JavaFX_39;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class JavaFX_39 extends Application {

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

        ComboBox<Student> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(s1,s2,s3,s4,s5);
        an.getChildren().addAll(comboBox);
//        comboBox.setValue(s1);//设置初值
//        comboBox.setVisibleRowCount(3);//设置显示多少行
//        comboBox.setPlaceholder(new TextField("占位符"));//在没有添加item的时候默认在列表里

        comboBox.setEditable(true);

        AnchorPane.setLeftAnchor(comboBox,50.0);
        AnchorPane.setTopAnchor(comboBox,100.0);


        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("JavaFX_36");
        primaryStage.show();

        //不知道为什么，下面这两个东西要放在show方法之后，否则就报异常了
        comboBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                if (object == null) {
                    return "";
                }
                String value = object.getName() + " - " + object.getAge() + " - " + object.getScore();

                if (comboBox.getItems().contains(object) == false){
                    comboBox.getItems().add(object);
                    System.out.println(value);
                }
                return value;
            }

            @Override
            public Student fromString(String string) {
                //设置这玩意之后就报异常
                //又为什么显示了两遍
                if (string.equals("")){
                    return null;
                }
                Student s = new Student(string,18,18);
                return s;
            }
        });

        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {

            }
        });

    }
}
