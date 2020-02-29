package JavaFX_40;

import JavaFX_39.Student;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import javax.swing.text.html.ImageView;

public class JavaFX_40_1 extends Application {
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
        comboBox.setMaxWidth(150.0);
        an.getChildren().addAll(comboBox);


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

                if (comboBox.getItems().contains(object) == false){
                    comboBox.getItems().add(object);
                    System.out.println(value);
                }
                return value;
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });
        comboBox.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
            @Override
            public ListCell<Student> call(ListView<Student> param) {
                ListCell<Student> listCell = new ListCell<Student>(){
                    @Override
                    protected void updateItem(Student item, boolean empty) {
                        super.updateItem(item, empty);
                        //这里完成自定义单元格
                        if(empty == false){
//                            String string = comboBox.getConverter().toString(item);
//                            this.setText(string);

                            //拿个图标进来
//                            ImageView img = new ImageView("");
                            HBox hBox = new HBox();
                            hBox.setStyle("-fx-background-color:green");
                            Label name = new Label(item.getName() + " - ");
                            name.setStyle("-fx-background-color:red");
                            Label age = new Label(String.valueOf(item.getAge() + " - "));
                            Label score = new Label(String.valueOf(item.getScore()));
                            hBox.getChildren().addAll(name,age,score);
                            this.setGraphic(hBox);

                        }
                    }
                };
                return listCell;
            }
        });
    }
}
