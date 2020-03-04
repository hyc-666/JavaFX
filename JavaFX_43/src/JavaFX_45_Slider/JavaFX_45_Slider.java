package JavaFX_45_Slider;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

public class JavaFX_45_Slider extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color:#ffffff");//背景颜色白色

        Slider slider = new Slider(0,100,50);//可拖动的进度条
        //如果value的值大于max，则会默认显示到max值上
        an.getChildren().addAll(slider);
        AnchorPane.setTopAnchor(slider,200.0);
        AnchorPane.setLeftAnchor(slider,100.0);
        slider.setPrefWidth(300);
//        slider.setPrefHeight(200);//一般不给进度条设置宽度，会自动到底部，直接指定位置或者是布局类
        slider.setShowTickLabels(true);//显示数字刻度
//        slider.setSnapToTicks(true);
        slider.setShowTickMarks(true);//会有一个显示的刻度
        slider.setMajorTickUnit(25);//刻度间距
//        slider.setOrientation(Orientation.VERTICAL);//设置方向

        //有些组件没有单击事件，可以通过鼠标单击事件来设置
        slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY)){
                    System.out.println("鼠标单击事件");
                }
            }
        });

        //设置标签刻度的显示文本
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if (object.doubleValue() == 0){
                    return "开始";
                }else if(object.doubleValue() == 100){
                    return "结束";
                }
                return object.toString();
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.show();

        //值监听
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                System.out.println(newValue.doubleValue());
            }
        });

        /**
         //* 虽然这么做可以完成进度条的更新，但是不能这么做
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    slider.setValue(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
         */
        MyTask task = new MyTask(slider);
        task.setDelay(Duration.millis(0));//0ms后开始运行
        task.setPeriod(Duration.millis(1000));//1000ms更新一次
        task.start();

    }
}
//定时任务
class MyTask extends ScheduledService<Integer>{
    int i = 0;
    Slider slider;

    public MyTask(Slider slider) {
        this.slider = slider;
    }

    @Override
    protected Task<Integer> createTask() {
        Task task = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                return ++i;
            }

            @Override
            protected void updateValue(Integer value) {
//                super.updateValue(value);
                slider.setValue(value);
            }
        };
        return task;
    }
}