package JavaFX_46_ProgressBar;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.NotActiveException;

public class JavaFX_46_ProgressBar extends Application {
    ScheduledService<Double> scheduledService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane an = new AnchorPane();

        //不可拖拽进度条
        ProgressBar progressBar = new ProgressBar(0.35);//给定初值
        //圆形的进度条，同样，不设置初值类似于一个等待的画面
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setPrefWidth(200);
        progressIndicator.setPrefHeight(200);

        /**
         * 注意：这个设置宽高的操作在jdk9（不含）以上会无效，具体是否bug有待查证
         * 需要设置最小最大宽高来限制
         */

        an.getChildren().addAll(progressBar,progressIndicator);
        AnchorPane.setLeftAnchor(progressBar,150.0);
        AnchorPane.setTopAnchor(progressBar,200.0);
        progressBar.setPrefWidth(350);
        progressBar.setPadding(new Insets(10));
        //如果没有给定初值进度条就会来回跑
//        progressBar.setProgress(ProgressBar.BASELINE_OFFSET_SAME_AS_HEIGHT);

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.show();

        scheduledService = new ScheduledService<Double>() {
            double step = 0;
            @Override
            protected Task<Double> createTask() {
                Task<Double> task = new Task<Double>() {
                    @Override
                    protected Double call() throws Exception {
                        return step = step + 0.002;
                    }

                    @Override
                    protected void updateValue(Double value) {
//                        super.updateValue(value);
                        if (value >= 1){
                            scheduledService.cancel();
                            System.out.println("完成");
                        }
                        progressIndicator.setProgress(value);
                        progressBar.setProgress(value);
                    }
                };

                return task;
            }
        };
        scheduledService.setDelay(Duration.millis(200));//200ms后开始运行
        scheduledService.setPeriod(Duration.millis(30));//100ms刷新一次
        scheduledService.start();

        progressBar.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                System.out.println(newValue);
            }
        });

    }
}
