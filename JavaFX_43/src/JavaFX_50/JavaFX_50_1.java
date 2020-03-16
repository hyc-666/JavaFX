package JavaFX_50;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFX_50_1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();
        HBox hBox = new HBox();
        Button button = new Button("button");

        hBox.setPrefWidth(200);
        hBox.setPrefHeight(200);

        hBox.getChildren().addAll(button);
        hBox.setAlignment(Pos.CENTER);
        an.getChildren().addAll(hBox);
        hBox.setStyle("-fx-background-color:ffff55");
        AnchorPane.setLeftAnchor(hBox,100.0);
        AnchorPane.setTopAnchor(hBox,100.0);

        Scene scene = new Scene(an);

        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("javafx50");
        primaryStage.show();

        //屏幕的坐标是从左上角计算起，往右是+x，往下是+y
        System.out.println(button.getLayoutX());
        //这里所获得的x和y坐标是指其在父组件上的坐标位置
        System.out.println(button.getLayoutY());

        //不过有方法直接计算组件的宽高和位置坐标等属性属性

        Bounds bounds = button.getLayoutBounds();
        System.out.println("左上角x：" + bounds.getMinX());
        System.out.println("左上角y：" + bounds.getMinY());

        System.out.println("右下角x： " + bounds.getMaxX());
        System.out.println("右下角y： " + bounds.getMaxY());

        System.out.println("宽度： " + bounds.getWidth());
        System.out.println("高度： " + bounds.getHeight());

        //实际上，组件自己本身有一个local的坐标系，就是其本身有一个坐标系，就是组件本身的宽高，也是从左上角开始算的
        //上面的转化其实是传入的组件本身的坐标系，如果hbox设置位置以后会发现直接使用getLayoutX/getLayoutY获得的
        //坐标与使用Bounds类获得的坐标不一致，原因就在于组件获得的是本身的坐标系
        //下面这个方法可以使得让组件的坐标转为相对父组件的坐标
        Point2D point = button.localToParent(bounds.getMinX(),bounds.getMinY());
        System.out.println("button相对父组件的坐标位置：" + "x = " + point.getX() + ",y = " + point.getY());

        //也可以获得组件（button）在整个场景图（Scene）中的坐标位置
        Point2D point1 = button.localToScene(bounds.getMinX(),bounds.getMinY());
        System.out.println("button在Scene中的坐标：" + "x = " + point1.getX() + ",y = " + point1.getY());

        //还可以得到组件（button）在整个屏幕上的坐标位置
        Point2D point2 = button.localToScreen(bounds.getMinX(),bounds.getMinY());
        System.out.println("button在Screen中的坐标：" + "x = " + point2.getX() + ",y = " + point2.getY());

    }
}
