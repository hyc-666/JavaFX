package javafx_54;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class JavaFX_54 {
    public static void main(String[] args) {
        SimpleIntegerProperty simpleIntegerProperty = new SimpleIntegerProperty(2);
//        simpleIntegerProperty.addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                //这是个立即监听，就是一旦值发生改变就会立即报告
//            }
//        });

        //延迟监听，也就是说，在值改变时不会立即报告，而是保留最后一次修改的最终值，需要用到的时候才会拿到最终值
        simpleIntegerProperty.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                //也就是说当修改值以后，无论修改多少次，只要不对其值进行提取，那么这里就只会执行一次
                //当需要对值进行提取或者用到的时候（如get方法），这里才会去计算和报告最后一次修改的信息
                //当然，前提是没有添加ChangeListener，否则就会变为立即计算
                System.out.println("值修改");
            }
        });

        simpleIntegerProperty.set(5);
        simpleIntegerProperty.set(7);
        simpleIntegerProperty.get();//需要用到时，报告最后一次修改后的状态
    }
}
