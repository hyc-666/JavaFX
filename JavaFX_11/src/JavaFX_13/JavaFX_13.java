package JavaFX_13;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_13 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane anchorPane = new AnchorPane();//引入布局
        anchorPane.setStyle("-fx-background-color:red");//设置风格

        Button b1 = new Button("button1");
        Button b2 = new Button("button2");

        anchorPane.getChildren().addAll(b1,b2);
        AnchorPane.setTopAnchor(b1,20.0);
        AnchorPane.setLeftAnchor(b1,20.0);
        AnchorPane.setRightAnchor(b2,20.0);
        AnchorPane.setTopAnchor(b2,20.0);
        //使用布局类管理组件时组件的自己设置的宽高就会无效


        anchorPane.setOnMouseClicked(new EventHandler<MouseEvent>() {//同样可以给布局设置鼠标单击事件
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getButton().name());
                if(event.getButton().name() == MouseButton.PRIMARY.name()){
                    System.out.println("这是布局的鼠标左键单击事件");
                }
            }
        });


        Group group = new Group();//Group只是一个盛放组件的容器
        Scene scene = new Scene(anchorPane);
        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
