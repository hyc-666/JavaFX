package JavaFX_37;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class JavaFX_37 extends Application {
    Student student = null;

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
        student = s1;



        AnchorPane an = new AnchorPane();
        HBox hBox = new HBox(30);
        VBox vBox = new VBox(30);
        TextField textField = new TextField();
//        textField.setPrefWidth();
        Button button = new Button("修改");

        ChoiceBox<Student> cb = new ChoiceBox<>();//下拉列表
        //通过重写Student的toString的方式可以显示信息
        cb.getItems().addAll(s1,s2,s3,s4,s5);
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

        hBox.getChildren().addAll(textField,button);
        vBox.getChildren().addAll(hBox,cb);
        AnchorPane.setTopAnchor(vBox,50.0);
        AnchorPane.setLeftAnchor(vBox,20.0);



        an.getChildren().addAll(vBox);
        AnchorPane.setLeftAnchor(cb,50.0);
        AnchorPane.setTopAnchor(cb,100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("JavaFX_36");
        primaryStage.show();

        cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                student = newValue;
                student.getNameSimpleStringProperty().addListener(new ChangeListener<String>() {
                    //靠，搞半天包引错了，代码Student是粘过来的，而后它被修改了，结果给我自动导的是上一个包的student类
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        int index = cb.getItems().indexOf(student);//获得数据源列表的选中数据的下标
                        cb.getItems().remove(student);//将这个项移除
                        cb.getItems().add(index,student);
                    }
                });
            }
        });

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
//                    int index = cb.getItems().indexOf(student);//获得数据源列表的选中数据的下标
//                    String name = textField.getText();//获得文本框内容
//                    cb.getItems().remove(student);//将这个项移除
//                    //移除不是删除，然后对其修改
//                    student.setName(name);
//                    //然后再加回去
//                    cb.getItems().add(index,student);
                    String name = textField.getText();//获得文本框内容
                    student.setName(name);

                }
            }
        });
        //这样做虽然可以达到修改效果，但是每次触发单击事件都要重新加载列表
        //如果列表较长，那么会很浪费资源。而且效率也不高
        //改进方法是在Student类里面，把这个类包装一下



    }
}
