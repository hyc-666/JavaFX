package javafx_67;
//图片类的的加载
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JavaFX_67_Image extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        AnchorPane anchorPane = new AnchorPane();

        //第一种，使用文件输入输出流来加载图片
        //Image用来加载图片，ImageView用来显示图片
        FileInputStream fileInputStream = new FileInputStream(
                new File("D:\\下载\\桌面壁纸\\{{F{6[TI}C[3}_VWM7WNDQM.png"));

//        Image image = new Image(fileInputStream);
        //加载时直接设定宽高和是否位置比例
//        Image image = new Image(fileInputStream,600,600,true,true);
        //也可以直接通过一个url来加载
        String path = "file:D:\\下载\\桌面壁纸\\{{F{6[TI}C[3}_VWM7WNDQM.png";//本地图片要加上file前缀
        Image image = new Image(path,
                600,600,true,true,true);
        //后面仍然可以设置宽高比,最后一个参数是是否选择后台加载，加载一些大图片或者是网络图片的时候可以使用
        //加载网络图片
        Image image1 = new Image("https://img.ivsky.com/img/bizhi/pre/201910/08/yinghua.jpg");

        ImageView imageView = new ImageView(image1);
        anchorPane.getChildren().addAll(imageView);

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
