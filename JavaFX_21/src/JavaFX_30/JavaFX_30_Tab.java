package JavaFX_30;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JavaFX_30_Tab extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {



        AnchorPane anchorPane  = new AnchorPane();

        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("tab1");
        Tab tab2 = new Tab("tab2");
        Tab tab3 = new Tab("tab3");
        tabPane.getTabs().addAll(tab1,tab2,tab3);

        anchorPane.getChildren().add(tabPane);
        //当宽度不够组件会隐藏，有一个下拉的选择
        anchorPane.setStyle("-fx-background-color:red");
        tabPane.setPrefWidth(600);
//        tabPane.setPadding(new Insets(10));

        HBox box = new HBox();
        box.getChildren().addAll(new Button("b1"),new Button("b2"),new Button("b3"));
        tab1.setContent(box);//增加组件
        box.setStyle("-fx-background-color:pink");
        box.setSpacing(50.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        //如果想要图片不变方向，需要将这些属性设置放在show方法之前
        ImageView imageView = new ImageView("JavaFX_30/img.png");//引入图片
        //可以给图片设置宽高的
        imageView.setFitWidth(25);
        imageView.setFitHeight(25);
        tab1.setGraphic(imageView);
//        tabPane.setSide(Side.RIGHT);//设置朝向

        primaryStage.show();

        tab2.setClosable(false);//设置可关闭

        VBox vBox = new VBox();
        vBox.getChildren().addAll(new Button("b3"),new Button("b4"));
        tab2.setContent(vBox);
        AnchorPane.setLeftAnchor(tabPane,100.0);
        AnchorPane.setRightAnchor(tabPane,100.0);
        tabPane.setRotateGraphic(false);//然后将图片设置为不跟随旋转

//        tab3.setDisable(true);//设置禁用

        //设置选中状态监听器
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                System.out.println(newValue.getText());
            }
        });

        //监听选状态
        tab1.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Tab t = (Tab)event.getSource();
                System.out.println(t.getText() + "状态改变");
            }
        });

    }
}
