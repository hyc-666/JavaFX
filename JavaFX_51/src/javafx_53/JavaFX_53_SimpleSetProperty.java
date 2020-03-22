package javafx_53;

import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

public class JavaFX_53_SimpleSetProperty {
    public static void main(String[] args) {
        //同样还是要先获得一个ObservableSet
        ObservableSet<String> set = FXCollections.observableSet("A","B","C");
        SimpleSetProperty<String> simpleSetProperty = new SimpleSetProperty<>(set);
        //方法参考之前SimpleListProperty，大体类似
        simpleSetProperty.addListener(new SetChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> change) {
                //这个就不用先调用next方法了，也没有，方法大体类似，要少一些
                System.out.println(change.wasAdded());
            }
        });
        set.add("D");
    }
}
