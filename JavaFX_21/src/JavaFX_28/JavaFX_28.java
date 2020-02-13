package JavaFX_28;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_28 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4");

        MenuItem menuItem1 = new MenuItem("item1");
        MenuItem menuItem2 = new MenuItem("item2");
        MenuItem menuItem3 = new MenuItem("item3");

        menu1.getItems().addAll(menuItem1,menuItem2,menuItem3);
        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4);

        //自定义的item，可以与其他组件绑定，如按钮，进度条，其他布局类等
        CustomMenuItem customMenuItem1 = new CustomMenuItem();
        //绑定进度条
        ProgressBar progressBar = new ProgressBar(0.39);
        menu1.getItems().add(customMenuItem1);

        customMenuItem1.setContent(progressBar);
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(menuBar);
        an.setPrefWidth(800);
        an.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
