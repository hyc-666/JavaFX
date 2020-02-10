package JavaFX_24_Login;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.tools.Tool;

public class Login extends Application {
    //写一个简单的登陆窗口

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //两个标签
        Label l_name = new Label("账号:");
        Label l_password = new Label("密码:");
        //两个输入框
        TextField p_name = new TextField();
        PasswordField p_password = new PasswordField();
        //两个按钮
        Button clear = new Button("清除");
        Button login = new Button("登陆");

        p_name.setUserData("tom");//设置一个默认值作为默认的用户名
        p_password.setUserData("mima12345");//设置一个初始化的密码



        GridPane gr = new GridPane();//采用网格布局
        gr.setStyle("-fx-background-color:pink");
        Scene scene = new Scene(gr);
        gr.setAlignment(Pos.CENTER);

        gr.add(l_name,0,0);
        gr.add(p_name,1,0);
        gr.add(l_password,0,1);
        gr.add(p_password,1,1);
        gr.add(clear,0,2);
        gr.add(login,1,2);
        gr.setHgap(5);
        gr.setVgap(15);

        GridPane.setMargin(login,new Insets(0,0,0,150));
//        GridPane.setMargin(clear, new Insets(0, 0, 0, 30));


        primaryStage.setScene(scene);

        p_name.setTooltip(new Tooltip("请输入密码"));
        p_password.setTooltip(new Tooltip("请输入密码"));

        primaryStage.setHeight(300);
        primaryStage.setWidth(500);
        primaryStage.setTitle("登陆窗口");
        primaryStage.setResizable(false);
        primaryStage.show();

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                p_name.setText("");
                p_password.setText("");
            }
        });
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = p_name.getText();
                //System.out.println(name);
                String password = p_password.getText();
                //System.out.println(password);
                //System.out.println("预设的");
                //System.out.println(p_name.getUserData());
                //System.out.println(p_password.getUserData());
                DialogPane dialogPane = new DialogPane();


                Stage stage = new Stage();
                Text text = new Text();
                stage.setHeight(200);
                stage.setWidth(300);
                Scene sc = new Scene(dialogPane);


                stage.setScene(sc);
                stage.setResizable(false);
                stage.initOwner(primaryStage);
                stage.initModality(Modality.WINDOW_MODAL);
                dialogPane.getButtonTypes().add(ButtonType.CLOSE);
                Button close = (Button)dialogPane.lookupButton(ButtonType.CLOSE);

                if(name.equals(p_name.getUserData()) && password.equals(p_password.getUserData())){
                    System.out.println("登陆成功");
                    text.setText("登陆成功");
                    stage.setTitle("提示信息");
                    text.setText("欢迎使用");
                    dialogPane.setStyle("-fx-background-color:green");
                    dialogPane.setContentText(text.getText());
                    primaryStage.close();
                    stage.show();
                }else{
                    System.out.println("登陆失败");
                    text.setText("登陆失败");
                    stage.setTitle("警告");
                    text.setText("登陆失败，请重新登陆");
                    dialogPane.setStyle("-fx-background-color:red");
                    dialogPane.setContentText(text.getText());

                    FadeTransition fade = new FadeTransition( );
                    fade. setDuration(Duration. seconds(0.1));
                    fade. setNode(gr);
                    fade. setFromValue(0);
                    fade. setToValue(1);
                    fade.play();

                    stage.show();
                }
                close.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        stage.close();
                    }
                });

            }
        });
    }
}
