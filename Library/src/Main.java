import User.Root;
import User.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class Main extends Application {
    //把超级用户在程序启动时先创建出来
    static Root root = Root.getRoot();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        User identity = login(root.getUsers());
        int id = identity.getIdentity();

        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);
        primaryStage.setWidth(1200);
        primaryStage.setHeight(800);
        primaryStage.setTitle("图书馆管理系统");
        primaryStage.setScene(scene);
    }
    private User login(ArrayList<User> users){
        final User[] identity = {null};
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);

        gridPane.setStyle("-fx-background-color:pink");
        gridPane.setAlignment(Pos.CENTER);

        //两个标签
        Label l_name = new Label("用户名:");
        Label l_password = new Label("密码:");
        //两个输入框
        TextField p_name = new TextField();
        PasswordField p_password = new PasswordField();
        //两个按钮
        Button clear = new Button("清除");
        Button login = new Button("登陆");

        gridPane.add(l_name,0,0);
        gridPane.add(p_name,1,0);
        gridPane.add(l_password,0,1);
        gridPane.add(p_password,1,1);
        gridPane.add(clear,0,2);
        gridPane.add(login,1,2);
        gridPane.setHgap(5);
        gridPane.setVgap(15);
        GridPane.setMargin(login,new Insets(0,0,0,150));

        stage.setHeight(300);
        stage.setWidth(500);
        stage.setTitle("欢迎登陆图书馆管理平台");
        stage.setResizable(false);
        stage.show();

        login.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String userName = p_name.getText();
                String password = p_password.getText();
                boolean succeed = false;//登陆成功标志
                if (event.getButton().equals(MouseButton.PRIMARY)){
                    //获得用户输入的用户名和密码

                    //匹配用户名
                    for (int i = 0; i < users.size(); i++) {
                        if(userName.equals(users.get(i).getName())){
                            //再匹配密码
                            if (users.get(i).getPassword().equals(password)){
                                //确认身份
                               identity[0] = users.get(i);
                                succeed = true;
                                stage.close();
                            }
                        }
                    }
                }
                if (!succeed){//如果没有登陆成功
                    DialogPane dialogPane = new DialogPane();
                    dialogPane.setStyle("-fx-background-color:green");
                    dialogPane.setContentText("警告信息");
//                    dialogPane.getButtonTypes().add(ButtonType.APPLY);
                    //这个对话框结果会根据平台翻译成相应的语言
                    dialogPane.getButtonTypes().add(ButtonType.CLOSE);

                    Button close = (Button)dialogPane.lookupButton(ButtonType.CLOSE);
                    dialogPane.setExpandableContent(new Text("用户名或密码错误"));//有一个点击显示详情

                    Scene sc = new Scene(dialogPane);
                    Stage error = new Stage();
                    error.setScene(sc);
                    error.initStyle(StageStyle.UTILITY);
                    error.initOwner(stage);
                    error.initModality(Modality.WINDOW_MODAL);

                    close.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            error.close();
                        }
                    });
                    error.setTitle("错误信息");
                    //stage.setHeight(300);
                    //stage.setWidth(500);
                    error.setResizable(false);//设置不可拉伸
                    error.show();

                }
            }
        });
        return identity[0];
    }
}
