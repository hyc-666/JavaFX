package javafx_53;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class JavaFX_53_SimpleListProperty extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        //获得一个可观察的列表
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll("str1","A","B");
        //集合类的监听
        SimpleListProperty<String> simpleListProperty = new SimpleListProperty<>(observableList);

//        simpleListProperty.addListener(new ChangeListener<ObservableList<String>>() {
//            @Override
//            public void changed(ObservableValue<? extends ObservableList<String>> observable, ObservableList<String> oldValue, ObservableList<String> newValue) {
//                //这里是对整个列表的一个监听，但是会发现，两个列表一样的
//                oldValue.forEach(System.out :: println);
//                System.out.println("==============================");
//                newValue.forEach(System.out :: println);
//                //其实这里和上面的observableList是一样的
//                System.out.println("===============================");
//                observableList.forEach(System.out::println);
//                //而实际上，在simpleListProperty里的add操作其实就是做了一个在observableList上的add操作，没有区别的
//                //所以，这么搞是不行的的
//            }
//        });

        simpleListProperty.addListener(new ListChangeListener<String>() {//要用这个
            @Override
            public void onChanged(Change<? extends String> c) {
                System.out.println(c);
                //会标注出做出了一个怎样的操作
                c.getList().forEach(System.out :: println);//获得最新元素的列表
                while (c.next()){//这个c.next()方法必须在以下一些操作之前调用
                    System.out.println("wasAdded = " + c.wasAdded());//是否是添加操作
                    System.out.println("wasRemoved = " + c.wasRemoved());//是否移除操作
                    System.out.println("wasReplaced = " + c.wasReplaced());//是否替换操作
                    System.out.println("wasUpdated = " + c.wasUpdated());//是否更新操作
                    System.out.println("wasPermutated = " + c.wasPermutated());//是否重排序
                }
            }
        });

        simpleListProperty.add("C");











        Platform.exit();//由于没有窗口，所以程序无法关闭，调用这个方法在最后直接关闭虚拟机
    }
}
