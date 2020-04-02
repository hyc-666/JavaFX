package javafx_57;

//绑定判断的简单应用
//需求：使用两个输入框和一个button
//比较两个而输入框中的数值大小，根据数值大小关系来跟更换背景颜色
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BindingJudge extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        SimpleIntegerProperty simpleIntegerProperty_a = new SimpleIntegerProperty(0);
        SimpleIntegerProperty simpleIntegerProperty_b = new SimpleIntegerProperty(0);

        //两个输入框和一个button
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        Button button = new Button("给我变色");
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(textField1,textField2,button);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox);
        AnchorPane.setLeftAnchor(hBox,50.0);
        AnchorPane.setTopAnchor(hBox,50.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    Integer value_a = Integer.parseInt(textField1.getText());
                    Integer value_b = Integer.parseInt(textField2.getText());
                    simpleIntegerProperty_a.set(value_a);
                    simpleIntegerProperty_b.set(value_b);

                    if (simpleIntegerProperty_a.greaterThan(simpleIntegerProperty_b).get()){
                        //如果a的值大于b那么设置背景为黄色
                        anchorPane.setStyle("-fx-background-color:yellow");
                    }else if (simpleIntegerProperty_a.lessThan(simpleIntegerProperty_b).get()){
                        //如果a的值大于b那么设置背景为红色
                        anchorPane.setStyle("-fx-background-color:red");
                    }else{
                        //相等就设置为粉色
                        anchorPane.setStyle("-fx-background-color:pink");
                    }

                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
