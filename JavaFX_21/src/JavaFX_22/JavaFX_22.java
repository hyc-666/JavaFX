package JavaFX_22;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class JavaFX_22 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("点击显示对话框");
        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color:#FFCCCC");
        an.getChildren().addAll(button);
        AnchorPane.setTopAnchor(button,100.0);
        AnchorPane.setLeftAnchor(button,100.0);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                System.out.println("这是单击事件");
                DialogPane dialogPane = new DialogPane();
                dialogPane.setStyle("-fx-background-color:green");
                dialogPane.setContentText("这是对话框上的文字");

                Button b1 = new Button("button");
                //按钮好像加不上去
                //dialogPane.getChildren().add(b1);
                //button直接这样添加
                dialogPane.getButtonTypes().add(ButtonType.APPLY);
                //这个对话框结果会根据平台翻译成相应的语言
                dialogPane.getButtonTypes().add(ButtonType.CLOSE);

                Button close = (Button)dialogPane.lookupButton(ButtonType.CLOSE);

                ImageView img = new ImageView("JavaFX_22/flag.png");
                //图片有点太大了
                //dialogPane.setGraphic(img);
                dialogPane.setExpandableContent(new Text("隐藏内容"));//有一个点击显示详情


                Scene sc = new Scene(dialogPane);
                Stage stage = new Stage();
                stage.setScene(sc);
                stage.initStyle(StageStyle.UTILITY);
                stage.initOwner(primaryStage);
                stage.initModality(Modality.WINDOW_MODAL);

                close.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        stage.close();
                    }
                });

                MyScheduService my = new MyScheduService(dialogPane,stage);
                my.setDelay(Duration.millis(0));
                my.setPeriod(Duration.millis(1000));//设置更新间隔
                my.start();

                stage.setTitle("这是弹出的对话框");
                //stage.setHeight(300);
                //stage.setWidth(500);
                stage.setResizable(false);//设置不可拉伸
                stage.show();
            }
        });

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
