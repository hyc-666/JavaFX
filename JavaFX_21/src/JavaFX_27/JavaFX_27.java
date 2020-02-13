package JavaFX_27;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_27 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        MenuBar menuBar = new MenuBar();
        menuBar.setPrefWidth(800);
        Menu menu = new Menu("menu");//子菜单可以嵌套在菜单栏里
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4");

        MenuItem item1 = new MenuItem("item1");
        MenuItem item2 = new MenuItem("item2");
        MenuItem item3 = new MenuItem("item3");
        MenuItem item4 = new MenuItem("item4");
        MenuItem item5 = new MenuItem("item5");
        MenuItem item6 = new MenuItem("item6");
        menu.getItems().addAll(item5,item6);
        //菜单栏分隔符
        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();

        AnchorPane an = new AnchorPane();
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);

        an.getChildren().addAll(menuBar);
        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4);
        menu1.getItems().addAll(menu,item1,separatorMenuItem1,item2,separatorMenuItem2,item3,item4);

        ToggleGroup toggleGroup = new ToggleGroup();//单选框的组
        //单选的单选框的选项是要指定在一个组里
        //而且添加的时候要为选项指定组
        RadioMenuItem radioMenuItem1 = new RadioMenuItem("选项一");
        RadioMenuItem radioMenuItem2 = new RadioMenuItem("选项二");
        RadioMenuItem radioMenuItem3 = new RadioMenuItem("选项三");
        radioMenuItem1.setToggleGroup(toggleGroup);
        radioMenuItem2.setToggleGroup(toggleGroup);
        radioMenuItem3.setToggleGroup(toggleGroup);
        radioMenuItem2.setSelected(true);//设置初始选中状态
        menu2.getItems().addAll(radioMenuItem1,radioMenuItem2,radioMenuItem3);

        //复选框直接加，不用指定组
        CheckMenuItem checkMenuItem1 = new CheckMenuItem("复选项1");
        CheckMenuItem checkMenuItem2 = new CheckMenuItem("复选项2");
        CheckMenuItem checkMenuItem3 = new CheckMenuItem("复选项3");
        menu3.getItems().addAll(checkMenuItem1,checkMenuItem2,checkMenuItem3);

        //单选复选都可以设置添加单击事件
        //设置选中和显示状态
        System.out.println(checkMenuItem3.isSelected());

        item2.setDisable(true);//设置禁用

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
        an.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });
    }
}
