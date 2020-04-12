package javafx_63;

import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

public class JavaFX_63 {
    public static void main(String[] args) {
        SimpleStringProperty s1 = new SimpleStringProperty("a");
        SimpleStringProperty s2 = new SimpleStringProperty("b");

        ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(
                new Callback<SimpleStringProperty, Observable[]>() {
            @Override
            public Observable[] call(SimpleStringProperty param) {
                //列表元素改变的时候会有一个通知
                System.out.println("call = " + param);
                Observable[] observables = new Observable[]{param};
                return observables;
            }
        });



//        list.add(s1);
//        list.add(s2);
//        System.out.println(list.get(0).get());

        SimpleStringProperty s3 = new SimpleStringProperty("c");
        ObservableList<SimpleStringProperty> list1 = FXCollections.observableArrayList(
                new Callback<SimpleStringProperty, Observable[]>() {
            @Override
            public Observable[] call(SimpleStringProperty param) {
                Observable[] observables = new Observable[]{param};
                return observables;
            }
        });
        SimpleListProperty<SimpleStringProperty> slp = new SimpleListProperty<>(list1);
        slp.add(s3);
        slp.addListener(new ListChangeListener<SimpleStringProperty>() {
            @Override
            public void onChanged(Change<? extends SimpleStringProperty> c) {
                while (c.next()) {
                    System.out.println(c.wasUpdated());
                    //要想是这个update方法生效还必须使用callback创建list
                }
            }
        });
        s3.set("d");


    }
}
