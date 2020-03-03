package JavaFX_43_Pagination;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class JavaFX_43_Pagination extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Pagination pagination = new Pagination();//类似于一个分页
        group.getChildren().addAll(pagination);
        pagination.setLayoutX(100);
        pagination.setLayoutY(100);
        pagination.setStyle("-fx-background-color:pink");
        pagination.setPrefWidth(500);
        pagination.setPrefHeight(500);

        pagination.setMaxPageIndicatorCount(5);//设置可显示页数
        pagination.setPageCount(Pagination.INDETERMINATE);//设置不确定页数
        pagination.setCurrentPageIndex(2);//设置当前页
        pagination.getStyleClass().addAll(Pagination.STYLE_CLASS_BULLET);//更改样式

        pagination.setPageCount(10);//设置默认页数，不然后面是不确定的


        pagination.setPageFactory(new Callback<Integer, Node>() {
            //不知道为什么，这个工厂方法如果没有对其中页面进行编辑的话，底部的选中栏则不会切换为选中状态
            //也就是说如果当前的页面没有内容那么这个页面就不会选中。
            @Override
            public Node call(Integer param) {
                //自定义页面内容
                //param是传入的选中页面，根据页面的参数选择在当前页面布置内容
                //里面页可以放其他布局类
                Text text = new Text("假如这个页面没有被自定义编辑就会显示这个");
                if (param == 3){
                    HBox hBox = new HBox();
                    hBox.getChildren().addAll(new Label("比如这里是一首歌"),new Button("button"));
                    hBox.setSpacing(20);
                    hBox.setAlignment(Pos.BOTTOM_CENTER);
                    return hBox;
                }else if(param == 1){
                    return new Label("这是标签页");
                }else if(param == 0){
                    return new Text("这是编辑文本");
                }
                return text;
            }
        });

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX_43");
        primaryStage.show();
//
//        pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                //监听当前的选中页
//            }
//        });

    }
}
