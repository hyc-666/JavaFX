package JavaFX_26_Menu;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX_26_Menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color:pink");

        MenuBar menuBar = new MenuBar();//菜单栏
        Menu menu = new Menu("menu");
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4");

        MenuItem item1 = new MenuItem("item1",new ImageView("JavaFX_26_Menu/item.png"));
        //给item设置快捷键
        //但是这个快捷键只是显示在了item上面，并没有真的生效
        //想让它生效要放在setOnaction的前面
        item1.setAccelerator(KeyCombination.valueOf("ctrl+i"));

        MenuItem item2 = new MenuItem("item2");
        MenuItem item3 = new MenuItem("item3");
        MenuItem item4 = new MenuItem("item4");
        MenuItem item5 = new MenuItem("item5");
        MenuItem item6 = new MenuItem("item6");

        menu1.getItems().addAll(item1,item2,item3);
        menu2.getItems().addAll(item4);
        menu3.getItems().addAll(item5,item6);

        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4);

        an.getChildren().add(menuBar);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        menuBar.setPrefWidth(an.getWidth());
//        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                menuBar.setPrefWidth(newValue.doubleValue());
//            }
//        });
        //设置监听器改变菜单栏宽度
        an.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });
        /**
         * 每个menu都有setOnaction和setOnshowing还有setOnhidden
         * 当menu下面有item是单击item才会触发menu的setOnaction
         * 没有item时没有反应的
         */
        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("item1的单击事件");
            }
        });

    }
}
