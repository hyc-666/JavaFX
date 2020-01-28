package JavaFX_06;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.lang.instrument.ClassDefinition;

public class JavaFX_06 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Screen screen = Screen.getPrimary();//获得主屏幕

        double dpi = screen.getDpi();
        System.out.println("当前屏幕的DPI:" + dpi);
        //dpi:像素每英寸

        Rectangle2D rec1 = screen.getBounds();//整个屏幕的边界
        Rectangle2D rec2 = screen.getVisualBounds();//获得可视化边界

        //获得屏幕数据
        //屏幕从左上角和右下角的坐标
        System.out.println("整个屏幕的数据");
        System.out.println("左上x："+ rec1.getMinX() + "    左上y：" + rec1.getMinY());
        System.out.println("右下x；"+ rec1.getMaxX() + "    右下y；"+ rec1.getMaxY());
        System.out.println("屏幕宽度："+ rec1.getWidth() + "    屏幕高度：" + rec1.getHeight());

        System.out.println("可视化的屏幕的数据");
        System.out.println("左上x："+ rec2.getMinX() + "    左上y：" + rec2.getMinY());
        System.out.println("右下x；"+ rec2.getMaxX() + "    右下y；"+ rec2.getMaxY());
        System.out.println("屏幕宽度："+ rec2.getWidth() + "    屏幕高度：" + rec2.getHeight());

    }
}
