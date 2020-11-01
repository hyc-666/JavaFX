package javafx_71;
//将照片转为字符画
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.sql.Struct;

public class CharacterPicture extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        String path = "file:D:\\Git\\pictures\\car.jpg";
        Image image = new Image(path,300,200,false, true);
//        Image image = new Image(path);
        ImageView imageView = new ImageView(image);
        PixelReader pixelReader = image.getPixelReader();
        int height = (int) image.getHeight();
        int width = (int) image.getWidth();
        System.out.println(height);
        System.out.println(width);
        StringBuffer stringBuffer = new StringBuffer("");
        //拿到颜色
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                Color color = pixelReader.getColor(j,i);
                int value = (int) (color.getRed() * 255);
                char data = print(value);
//                System.out.print(data);
                stringBuffer.append(data);
            }
//            System.out.println();
            stringBuffer.append("\r\n");
        }
        output(stringBuffer);

        anchorPane.getChildren().addAll(imageView);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
//
    }

    public static void output(StringBuffer stringBuffer) throws Exception {
        File file = new File("test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(stringBuffer.toString());
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    public char print(int value) {
        value = value / 10;
        switch (value){
            case 0:
                return '@';
            case 1:
                return '#';
            case 2:
                return '%';
            case 3:
                return 'W';
            case 4:
                return 'w';
            case 5:
                return 'B';
            case 6:
                return '$';
            case 7:
                return '=';
            case 8:
                return 's';
            case 9:
                return 'd';
            case 10:
                return 'k';
            case 11:
                return 'p';
            case 12:
                return 'u';
            case 13:
                return 'f';
            case 14:
                return 'x';
            case 15:
                return 'y';
            case 16:
                return 'i';
            case 17:
                return 'j';
            case 18:
                return '1';
            case 19:
                return 'l';
            case 20:
                return '!';
            case 21:
                return 'i';
            case 22:
                return ';';
            case 23:
                return ',';
            case 24:
                return '.';
            case 25:
                return ' ';
            case 26:
                return ' ';
            default:
                break;
        }
        return ' ';
    }
}
