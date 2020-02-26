package JavaFX_39;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.function.Predicate;

public class JavaFX_39_1 extends Application {
    ObservableList<Student> src;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Student s1 = new Student("A",18,90);
        Student s2 = new Student("B",12,100);
        Student s3 = new Student("C",40,50);
        Student s4 = new Student("D",20,60);
        Student s5 = new Student("E",70,250);

        AnchorPane an = new AnchorPane();

        ComboBox<Student> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(s1,s2,s3,s4,s5);
        an.getChildren().addAll(comboBox);
        //这里得到原来的数据列表src
        src = comboBox.getItems();
        comboBox.setEditable(true);

        AnchorPane.setLeftAnchor(comboBox,50.0);
        AnchorPane.setTopAnchor(comboBox,100.0);

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.show();

        comboBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                if (object == null) {
                    return "";
                }
                String value = object.getName() + " - " + object.getAge() + " - " + object.getScore();
                return value;
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });

        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {

            }
        });

        //把上面的输入的文本的引用得到
        TextField textField = comboBox.editorProperty().get();
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue == null) {
                    comboBox.setItems(null);
                    comboBox.setPlaceholder(new Label("没有找到"));
                    return;
                }
                //这里直接从src获得
                FilteredList<Student> list = src.filtered(new Predicate<Student>() {
                    //信息过滤
                    @Override
                    public boolean test(Student student) {
                        //如果搜索框包含列表中的关键字，那么就会匹配到的结果（可能不止一条）传递给上面list
                        //然后，把comboBox原来的元素替换为list，并显示
                        //但是这样会对原来的数据进行替换，于是，原来的列表就需要保存，
                        //搜索之后再换成原来的列表数据
                        return student.toString().contains(newValue);
                    }
                });

                if (list == null) {
                    comboBox.setItems(null);
                    comboBox.setPlaceholder(new Label("没有找到"));
                }else{
                    comboBox.setItems(list);
                    comboBox.hide();
                    comboBox.show();
                }
            }
        });

    }
}
