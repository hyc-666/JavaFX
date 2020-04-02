package javafx_57;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;

//误差判断
public class JavaFX_57 {
    public static void main(String[] args) {
        SimpleIntegerProperty simpleIntegerProperty_a = new SimpleIntegerProperty(10);
        SimpleIntegerProperty simpleIntegerProperty_b = new SimpleIntegerProperty(20);
        //绑定计算可以链式调用
        //这个方法判断simpleIntegerProperty_b是否和8相等，而第二个参数是误差，表示在一定误差范围内是否相等
        BooleanBinding equals = simpleIntegerProperty_a.isEqualTo(8,2);
        System.out.println(equals.get());
    }
}
