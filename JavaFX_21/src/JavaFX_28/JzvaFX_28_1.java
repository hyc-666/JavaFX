package JavaFX_28;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JzvaFX_28_1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //menuButton类似menu，但是是把menu单独拿出来的，不放在menuBar布局里
        //与menu用法相同，可以加载item
        MenuItem menuItem1 = new MenuItem("menuItem1");
        MenuItem menuItem2 = new MenuItem("menuItem2");
        MenuItem menuItem3 = new MenuItem("menuItem3");
        MenuItem menuItem4 = new MenuItem("menuItem4");

        MenuButton menuButton = new MenuButton("menuButton");
        //还有这个
        SplitMenuButton splitMenuButton = new SplitMenuButton();
        //与menuButton差不多几乎一样，只是长得不一样，用法是一样的
        Button button = new Button("button");
        ContextMenu contextMenu = new ContextMenu();//按钮触发一个菜单
        contextMenu.getItems().addAll(menuItem1,menuItem2,menuItem3);

        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(button);
        button.setContextMenu(contextMenu);//把菜单绑定到一个按钮
        //但是不知道为什么，这个单击事件是鼠标右键触发的而不是左键0.0

        button.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                System.out.println("gfuaksdhaksd");
            }
        });
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
