package javafx_68;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class JavaFX_68_ImageView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();

        Image image = new Image("file:D:\\下载\\桌面壁纸\\{{F{6[TI}C[3}_VWM7WNDQM.png");

        ImageView imageView = new ImageView(image);//这里也可以直接指定路径

        //可能默认的比例是以宽度作为标准的
        imageView.setFitWidth(600);
        imageView.setFitHeight(600);

        imageView.setPreserveRatio(true);//保持图片宽高比
        imageView.setSmooth(true);//压缩质量

        anchorPane.getChildren().addAll(imageView);

        //保持图片原来的比例之后，实际显示宽高肯定会跟上面设置的有所不同，这里实际显示宽高要通过一些方法获取
//        System.out.println(imageView.getFitHeight());
//        //实际上这里 这样得到的宽高肯定是错的
//        System.out.println(imageView.getFitWidth());

        //这个 -1 怎么来的我也不是很清楚
        System.out.println(imageView.prefHeight(-1));
        System.out.println(imageView.prefWidth(-1));

        //关于设置图形剪切的
        Rectangle rectangle = new Rectangle(600,337.5);//矩形
        //图形可以选择
        //甚至是圆形
//        Circle circle = new Circle(200);
        rectangle.setArcHeight(50);//给图形设置圆角等
        rectangle.setArcWidth(50);
        imageView.setClip(rectangle);//将图片剪切到这个图形上

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
//
//        //show之后是不是对了呢
//        System.out.println();
//        System.out.println(imageView.getFitHeight());
//        //就算是stage显示以后这样得到的实际宽高仍然是错的
//        System.out.println(imageView.getFitWidth());
    }
}
