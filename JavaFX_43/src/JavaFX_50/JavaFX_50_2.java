package JavaFX_50;
//设置两个button，让其中一个动起来，检测是否有碰撞到
//通过键盘按键使其动起来

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_50_2 extends Application {
    double x = 0;//用来设置button1的坐标
    double y = 0;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        Button button1 = new Button("button1");
        Button button2 = new Button("button2");

        anchorPane.getChildren().addAll(button2,button1);
        AnchorPane.setTopAnchor(button2,100.0);
        AnchorPane.setLeftAnchor(button2,100.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("javafx_50_1");
        primaryStage.setScene(scene);
        primaryStage.show();

        Bounds bounds2 = button2.getLayoutBounds();
        Point2D point2D1 = button2.localToParent(bounds2.getMinX(),bounds2.getMinY());
        Point2D point2D2 = button2.localToParent(bounds2.getMaxX(),bounds2.getMaxY());
        //这段代码要放在show方法之后，不然主stage没有宽高，只有在显示之后才会有默认的宽高
        //因此在这之前也就无法确定组件的坐标
        System.out.println(point2D1);
        System.out.println(point2D2);

        //场景图键盘按键检测
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            Bounds bounds1 = button1.getLayoutBounds();
            Point2D point1 = null;
            Point2D point2 = null;
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().getName().equals(KeyCode.W.getName())){//向上移动
                    y -= 5.0;
                    button1.setLayoutY(y);
                }
                if(event.getCode().getName().equals(KeyCode.A.getName())){//向左移动
                    x -= 5.0;
                    button1.setLayoutX(x);
                }
                if(event.getCode().getName().equals(KeyCode.S.getName())){//向下移动
                    y += 5.0;
                    button1.setLayoutY(y);
                }
                if(event.getCode().getName().equals(KeyCode.D.getName())){//向右移动
                    x += 5.0;
                    button1.setLayoutX(x);
                }
                //检测button1的右下角是否进入到button1之中
                //先拿到移动过后的button1的坐标
                //不过，我不知道这么写为什么不行，一按键就直接true了
                point1 = button1.localToParent(bounds1.getMaxX(),bounds1.getMaxY());
//                if(bounds2.contains(point1)){
//                    System.out.println("true");
//                }
                if(point1.getX() >= point2D1.getX() && point1.getY() >= point2D1.getY() &&
                    point1.getX() <= point2D2.getX() && point1.getY() <= point2D2.getY()){
                    System.out.println("true");
                }else{
                    System.out.println("false");
                }
            }
        });


    }
}