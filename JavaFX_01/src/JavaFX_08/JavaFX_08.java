package JavaFX_08;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JavaFX_08 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");

        b1.setLayoutX(0);//设置按钮位置
        b1.setLayoutY(100);
        b1.setPrefWidth(80);
        b1.setPrefHeight(50);

        b2.setLayoutX(200);
        b2.setLayoutY(100);

        b3.setLayoutX(400);
        b3.setLayoutY(100);

        Group group = new Group();
//        group.getChildren().add(b1);
        group.getChildren().addAll(b1,b2,b3);
//        group.getChildren().remove(b1);//移除一个按钮，参数可以是下标或者名称
//        group.getChildren().clear();//清除所有组件

        group.getChildren().addListener(new ListChangeListener<Node>() {//添加组件监听器
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("当前组件数量：" + c.getList().size());
            }
        });

        Object[] obj = group.getChildren().toArray();//将所有组件拿到对象数组里
        for(Object ob : obj){
            Button but = (Button)ob;//将所有组件强转为button
            but.setPrefWidth(50);
            but.setPrefHeight(50);
        }

        b1.setOnAction(new EventHandler<ActionEvent>() {//添加单击事件
            @Override
            public void handle(ActionEvent event) {
                Button b4 = new Button("b4");
                b4.setLayoutX(500);
                b4.setLayoutY(500);
                group.getChildren().add(b4);
            }
        });

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);

        primaryStage.show();
    }
}
