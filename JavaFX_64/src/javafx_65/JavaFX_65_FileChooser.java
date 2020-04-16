package javafx_65;
//文件和文件夹选择器
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;
import java.util.function.Consumer;

public class JavaFX_65_FileChooser extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();

        VBox vbox = new VBox(20);
        Button button1 = new Button("单选文件窗口");
        Button button2 = new Button("多选文件窗口");
        Button button3 = new Button("打开文本");
        Button button4 = new Button("保存文本");
        Button button5 = new Button("文件夹选择");
        //后面两个button需要完成的功能是打开一个文本文件，然后将文本文件的内容读取到一个TextArea里，
        //然后可以修改这里的内容，修改完毕之后将内容保存到另一个文件当中
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);//自动换行

        vbox.getChildren().addAll(button1,button2,button3,button4,textArea,button5);


        anchorPane.getChildren().addAll(vbox);
        AnchorPane.setTopAnchor(vbox,100.0);
        AnchorPane.setLeftAnchor(vbox,100.0);

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx_64");
        primaryStage.show();

        button1.setOnAction(new EventHandler<ActionEvent>() {//单选窗口
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                Stage stage = new Stage();
                //这个方法返回选择的文件路径，如果没有选择，则会返回一个null
//                File file = fileChooser.showOpenDialog(stage);//窗口好像可以任意添加
//                File file = fileChooser.showOpenDialog(primaryStage);
                // 如果添加为根窗口则新打开的窗口就会成为模态化，且父窗口是根窗口
                //不过修改标题就不能用setTitle
                fileChooser.setTitle("选择文件");
                fileChooser.setInitialDirectory(new File("D:\\下载\\桌面壁纸"));//设置默认打开路径
                //File.separator是根据平台生成对应的文件路径分隔符

                fileChooser.getExtensionFilters().addAll(//过滤器
                        new FileChooser.ExtensionFilter("图片类型","*.jpg","*.png"),
                        new FileChooser.ExtensionFilter("所有类型","*.*")
                );
                File file = fileChooser.showOpenDialog(stage);//窗口好像可以任意添加。这个方法最后调用

                if (file != null) {
                    //如果不为空打印获取到的文件路径
                    System.out.println(file.getAbsoluteFile());
                }
            }
        });

        //多选窗口
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //多选与单选类似，只不过区别就是返回的是一个List<File>
                FileChooser fileChooser = new FileChooser();
                Stage stage = new Stage();
                fileChooser.setTitle("选择文件");
                fileChooser.setInitialDirectory(new File("D:\\下载\\桌面壁纸"));//设置默认打开路径
                //File.separator是根据平台生成对应的文件路径分隔符

                fileChooser.getExtensionFilters().addAll(//过滤器
                        new FileChooser.ExtensionFilter("图片类型","*.jpg","*.png"),
                        new FileChooser.ExtensionFilter("所有类型","*.*")
                );
                //这里调用的方法不同，返回的也不同
                List<File> listFile = fileChooser.showOpenMultipleDialog(stage);
                if (listFile != null) {
                    listFile.forEach(new Consumer<File>() {
                        @Override
                        public void accept(File file) {
                            System.out.println(file.getAbsoluteFile());
                        }
                    });
                }
            }
        });

        //读取文本文件的内容分显示到TextArea上，可以进行修改，给button3绑定单击事件
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                Stage stage = new Stage();
                //大体操作类似，前面的代码仍然可以拿过来使用
                fileChooser.setTitle("选择文件");
                fileChooser.setInitialDirectory(new File("C:\\Users\\胡玉琛\\Desktop"));//设置默认打开路径
                //这里路径不能写错，否则直接报错
                //File.separator是根据平台生成对应的文件路径分隔符

                fileChooser.getExtensionFilters().addAll(//过滤器
                        new FileChooser.ExtensionFilter("图片类型","*.jpg","*.png"),
                        new FileChooser.ExtensionFilter("所有类型","*.*"),
                        new FileChooser.ExtensionFilter("文本类型","*.txt")
                );
                File file = fileChooser.showOpenDialog(stage);//窗口好像可以任意添加。这个方法最后调用
                if (file != null) {
                    try{
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String str = null;
                        while ( (str = bufferedReader.readLine()) != null){
                            textArea.appendText(str + "\n");//手动换行0.0
                        }
                        fileReader.close();
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                }//end if

            }
        });
        //把读取到的内容保存为另一个文件
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("另存为");
                fileChooser.setInitialDirectory(new File("C:\\Users\\胡玉琛\\Desktop"));
                fileChooser.setInitialFileName("文件名");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("文本类型","*.txt"));
                File file = fileChooser.showSaveDialog(stage);
                if (file != null) {
                    try{
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                        outputStreamWriter.write(textArea.getText());
                        //这里一定要注意流的关闭顺序
                        outputStreamWriter.close();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                DirectoryChooser directoryChooser = new DirectoryChooser();
                //操作基本类似，只不过返回的是一个文件夹的路径
                directoryChooser.setInitialDirectory(new File("D:\\下载\\桌面壁纸"));
                directoryChooser.setTitle("文件夹选择");
                File file = directoryChooser.showDialog(stage);//只会选择一个文件夹
                if (file != null) {
                    System.out.println(file.getAbsoluteFile());
                    File[] files = file.listFiles();//获得文件夹下的所有文件
                    for (File f : files) {
                        System.out.println(f.getAbsoluteFile());
                    }
                }
            }
        });
    }
}
