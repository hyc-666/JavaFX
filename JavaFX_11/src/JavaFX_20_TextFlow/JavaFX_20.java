package JavaFX_20_TextFlow;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class JavaFX_20 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Text text1 = new Text("wen文本一ben1");
        Text text2 = new Text("wen文本2ben2");
        Text text3 = new Text("wenb文本3en3");
        Text text4 = new Text("we文本4nben4");

        TextFlow textFlow = new TextFlow();//文本的流式布局
        textFlow.setStyle("-fx-background-color:pink");
        textFlow.getChildren().addAll(text1,text2);
        text1.setFont(Font.font(20));
        textFlow.setPadding(new Insets(20));//内边距
        text2.setFill(Paint.valueOf("blue"));//设置字体颜色

        TextFlow textFlow1 = new TextFlow();
        textFlow1.getChildren().addAll(text3,text4);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(textFlow,textFlow1);

        textFlow.setLineSpacing(20);//行距
        //将两个文本布局放到一个布局中会发现文本的布局宽度不会随着窗口宽度变化
        //可以设置监听器来查看这两个值得变化
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("这是窗口宽度："+ primaryStage.getWidth());
                System.out.println("这是anchorPanede的宽度： " + anchorPane.getWidth());
                System.out.println("这是文本布局的宽度:" + textFlow.getWidth());
            }
        });

        //那么可以通过监听anchorPanede的宽度来改变文本布局的宽度
        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                textFlow.setPrefWidth(newValue.doubleValue());
            }
        });

        primaryStage.setHeight(800);
        primaryStage.setTitle("这是窗口标题");
        primaryStage.setWidth(800);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
