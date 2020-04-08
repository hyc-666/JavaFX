package javafx_61;
//绑定valueAt的用法
import javafx.application.Application;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFX_61_valueAt extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();//作为根节点
        Scene scene = new Scene(anchorPane);//场景图

        ObservableList<String> observableList = FXCollections.observableArrayList();
        SimpleListProperty<String> simpleListProperty = new SimpleListProperty<>(observableList);
//        observableList.addAll("A","B","C","D","E");
        //列表的绑定，并添加元素
        simpleListProperty.add("A");
        simpleListProperty.add("B");
        simpleListProperty.add("C");
        simpleListProperty.add("D");
        simpleListProperty.add("E");

        VBox vBox = new VBox(20);//根节点的总体布局是一个垂直布局
        HBox hBox = new HBox(10);//一个水平布局上放两个输入框
        VBox list = new VBox(3);//数据列表放在一个垂直布局上，每条数据是一个label标签
        TextField textField1 = new TextField();//输入框
        TextField textField2 = new TextField();
//        System.out.println(simpleListProperty.size());

        for (int i = 0; i < simpleListProperty.size(); i++) {
            //循环把每条数据源写在label上
            Label label = new Label();
            //给标签设置样式
//            label.setText(simpleListProperty.get(i));
            //现在使用valueAt和单向绑定来完成
            ObjectBinding<String> objectBinding = simpleListProperty.valueAt(i);
            label.textProperty().bind(objectBinding);
            label.setFont(new Font(20));
            label.setTextFill(Paint.valueOf("red"));

            list.getChildren().add(label);//设置好以后添加在布局上
        }
        hBox.getChildren().addAll(textField1,textField2);
        vBox.getChildren().addAll(hBox,list);

        anchorPane.getChildren().addAll(vBox);
        AnchorPane.setTopAnchor(vBox,50.0);
        AnchorPane.setLeftAnchor(vBox,50.0);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        textField2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                try{
                    //拿到输入框1的索引
                    String value = textField1.getText();
                    int index = Integer.parseInt(value);
                    //拿到输入框2的值
                    String string = textField2.getText();
                    simpleListProperty.set(index,string);
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
