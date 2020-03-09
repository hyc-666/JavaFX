package JavaFX_48_Spinner;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class JavaFX_48_Spinner extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
/**
 * 构造方法里的参数说明，第一个起始值，也是最小值，第二个最大值，第三个是初始值，
 * 另外还可以增加一个参数，表示一次的递增/递减数，不加默认是1
 */
//        Spinner spinner = new Spinner();//构造器什么都不写默认为空
//        Spinner spinner = new Spinner<Integer>(0,10,2);
        //另外，构造器里还可以指定一个可观察的列表
//        ObservableList<String> list =FXCollections.observableArrayList();
//        list.addAll("str1","str2","str3");
//        Spinner spinner = new Spinner(list);
//        spinner.setEditable(true);//也可以设置是否可编辑
//        spinner.getStyleClass().addAll(Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL);//设置样式
        //值监听
//        spinner.valueProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                System.out.println(newValue);
//            }
//        });

        //实际开发中，其中的数据来源的数据类型并不是简单的基本数据类型，而是一些复杂的对象
        //于是这个可观察的列表也可以用来转化数据来源的数据
//        Spinner<Student> spinner = new Spinner<Student>();
        //另外，这个组件本身也含有工厂方法用来组织数据
        Spinner<Student> spinner = new Spinner<Student>();
        Student s1 = new Student("A",18);
        Student s2 = new Student("B",20);
        Student s3 = new Student("B",23);

        ObservableList<Student> list =FXCollections.observableArrayList();//把对象放到这个列表里
        list.addAll(s1,s2,s3);
        //设置了 SpinnerValueFactory以后再在构造器里添加list是无效的
//        MySpinnerValueFactory mySpinnerValueFactory= new MySpinnerValueFactory();
        //不过我觉得这种方很麻烦，感觉也用不到
        //直接放一个list进去然后再list上操作不好吗
        //大不了每操作一次书信一下列表
        //以后真的如果需要这种大批量得数据时再回过头再来学习吧
//        spinner.setValueFactory(mySpinnerValueFactory);
//        //给mySpinnerValueFactory设置setConverter和StringConverter
//        mySpinnerValueFactory.setConverter(new StringConverter<Student>() {
//            @Override
//            public String toString(Student object) {
//                return null;
//            }
//
//            @Override
//            public Student fromString(String string) {
//                return null;
//            }
//        });

        //这里可以写一个匿名内部类并且就地实例化，但是一般分离开来，把这个类写到外面去
//        spinner.setValueFactory(new SpinnerValueFactory<Student>() {
//            @Override
//            public void decrement(int steps) {
//
//            }
//
//            @Override
//            public void increment(int steps) {
//
//            }
//        });

        an.getChildren().addAll(spinner);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
//把内部类写到外面
class MySpinnerValueFactory extends SpinnerValueFactory{

    @Override
    public void decrement(int steps) {

    }

    @Override
    public void increment(int steps) {

    }
}