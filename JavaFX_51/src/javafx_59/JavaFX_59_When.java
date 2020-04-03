package javafx_59;

import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.When;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class JavaFX_59_When {
    public static void main(String[] args) {
        //首先看一个三元运算符
        int a = 10;
        int b = 20;
        int c = a < b ? a :b;
        System.out.println(c);

        SimpleIntegerProperty simpleIntegerProperty_a = new SimpleIntegerProperty(10);
        SimpleIntegerProperty simpleIntegerProperty_b = new SimpleIntegerProperty(20);
        SimpleBooleanProperty simpleBooleanProperty = new SimpleBooleanProperty(true);

        //比三元运算符的强大之处在于这里这个前缀when的值是可变的
        When when = new When(simpleIntegerProperty_a.greaterThan(simpleIntegerProperty_b));

        //跟三元运算符是一样的，如果when为true取then之后的值，否则取otherwise之后的值
        NumberBinding numberBinding =  when.then(10).otherwise(20);
        System.out.println(numberBinding.intValue());

    }
}
